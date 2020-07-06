<%@page contentType="text/html" language="java"%>
<%
	response.setHeader("Cache-Control", "no-cache, must-revalidate");
	response.setHeader("Pragma","no-cache");
%>

<%
	String serverName = request.getServerName();
	if(serverName.indexOf("jboss.org")!=-1)
	{
		serverName = serverName.replace("jboss.org","jboss.com");
	}
	else
	{
		serverName = serverName.replace("jboss.com","jboss.org");
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
%>

<html>
	<head><title>Welcome to SSO Tester</title></head>
	<body>
		<span>Logged In User.....<%if(request.getUserPrincipal()!=null){%><%=request.getUserPrincipal().getName()%><%}%></span>
		<br/><br/>
		<img src="/test/img/bg.gif" width="100" height="25"/>		
		<br/><br/>
		<img src="/test/img/bg2.gif" width="100" height="25"/>		
		<br/><br/>
		<img src="/test/img/bg3.gif" width="100" height="25"/>		
		<br/><br/>
		
		
		<a href="/test/secure/index.jsp">Login</a>&nbsp;&nbsp;<a href="/test/logout.jsp">Logout</a>
		<br/><br/>
		<a href="/test/secure/edit.jsp">Edit User</a>
		<br/><br/>
		<a href="/test/secure/add.jsp">Add User</a>
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