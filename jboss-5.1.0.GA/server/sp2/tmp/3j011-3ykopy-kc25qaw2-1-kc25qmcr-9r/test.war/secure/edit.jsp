<%@page contentType="text/html" language="java"%>
<%@page import="org.jboss.security.idm.*" %>
<%@page import="org.jboss.security.idm.ldap.*" %>
<%
	response.setHeader("Cache-Control", "no-cache, must-revalidate");
	response.setHeader("Pragma","no-cache");
%>

<%
	String serverName = request.getServerName();

	String indomainPartner = null;
	if(request.getServerName().indexOf("node1")!=-1)
	{
		indomainPartner = request.getServerName().replace("node1","node2");
	}
	else
	{
		indomainPartner = request.getServerName().replace("node2","node1");
	}
	LoginProvider provider = IdentityManager.findLoginProvider();

%>

<% 

	out.print(request.getParameter("send") + "sadfsa");
	if(request.getParameter("send") != null && request.getParameter("send").equals("send")){
		
		String user = (String)request.getParameter("user");
		String paswd = (String)request.getParameter("passwd");
		String activate = (String)request.getParameter("activate");
		out.print(user + paswd);
		RFC2798IdentityProvider rfcProvider = (RFC2798IdentityProvider) provider;
		rfcProvider.resetPassword(user, paswd.getBytes());
		
		if(activate != null && activate.equals("true") )
			rfcProvider.activate(user);
		else
			rfcProvider.deactivate(user);
	}
	else if(request.getParameter("send") != null && request.getParameter("send").equals("delete")){		

		RFC2798IdentityProvider rfcProvider = (RFC2798IdentityProvider) provider;
		rfcProvider.remove("amontenegro");
	}
	
	RFC2798Identity id = (RFC2798Identity)provider.read(request.getUserPrincipal().getName());
%>

<html>
	<head><title>Welcome to SSO Tester</title></head>
	<body>
		<span>Logged In User.....<%if(request.getUserPrincipal()!=null){%><%=request.getUserPrincipal().getName()%><%}%></span>
		<br/>
		
		<form action="/test/secure/edit.jsp" method="post">
		Display Name: <input type="text" name="user" value="<%= request.getUserPrincipal().getName() %>"/><br/>
		Password: <input type="text" name="passwd" value="<%= new String(id.getPassword()).toString() %>"/><br/>
		<% 
			if(id.isActive()){
		%>
			activate: <input type="checkbox" name="activate" value="true" checked/><br/>
		<%
			}else{
		%>
			activate: <input type="checkbox" name="activate" value="true"/><br/>
		<%} %>
		
		<input type="hidden" name="send" value="send"/> 
		<input type="submit" name="submit" value="submit">
		</form>
		<br>
		
		
		
		<a href="/test/logout.jsp">Logout</a>
		
		<br/><br/>
		
		<!-- Cross Domain Post Test -->
		<a href="/test/secure/post/form.jsp">Cross Domain Post Tester</a>
		
		<!-- Same Domain Post Test -->
		&nbsp;&nbsp;<a href="/test/secure/post/inDomainForm.jsp">Same Domain Post Tester</a>
		
		<br/><br/>
		
		<!-- Cross Domain Get Test -->
		<a href="http://<%=serverName%>:8080/test/secure/get/result.jsp">Cross Domain Get Tester</a>
		
		<!-- Same Domain Get Test -->
		&nbsp;&nbsp;<a href="http://<%=indomainPartner%>:8080/test/secure/get/result.jsp">Same Domain Get Tester</a>
	</body>
</html>