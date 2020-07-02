<%@page contentType="text/html" language="java"%>
<%@page import="org.jboss.security.idm.*" %>
<%@page import="org.jboss.security.idm.ldap.*" %>
<%
	response.setHeader("Cache-Control", "no-cache, must-revalidate");
	response.setHeader("Pragma","no-cache");
%>

<%
	String serverName = request.getServerName();
	if(serverName.indexOf("jboss.com")!=-1)
	{
		serverName = serverName.replace("jboss.com","jboss.com");
	}
	else
	{
		serverName = serverName.replace("jboss.com","jboss.com");
	}
	
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
		String sn = (String) request.getParameter("sn");
		String cn = (String) request.getParameter("cn");
		
		RFC2798Identity id = new RFC2798Identity();
		id.setActive(new Boolean(activate));
		id.setUserName(user);
		id.setPassword(paswd.getBytes());
		id.setSn(sn);
		id.setCn(cn);
		
		RFC2798IdentityProvider rfcProvider = (RFC2798IdentityProvider) provider;
		rfcProvider.register(id);
		
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
		
		<form action="/test/secure/add.jsp" method="post">
		Display Name: <input type="text" name="user" value=""/><br/>
		Password: <input type="text" name="passwd" value=""/><br/>
		Sur Name: <input type="text" name="sn" value=""/><br/>
		Common Name: <input type="text" name="cn" value=""/><br/>
		activate: <input type="checkbox" name="activate" value="true"/><br/>
		
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