<%@page contentType="text/html" language="java"%>
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
	
	String user = "";
	org.jboss.security.saml.SSOUser ssoUser = (org.jboss.security.saml.SSOUser)request.getSession().getAttribute("jboss_sso_user");
	if(ssoUser!=null && ssoUser.getUserName()!=null)
	{
		user = ssoUser.getUserName();
	}
	
%>

<html>
	<head><title>Welcome to Non-JAAS SSO Tester</title></head>
	<body>
		<span>Logged In User.....<%=user%></span>
		<br/><br/>
		<img src="/test/img/bg.gif" width="100" height="25"/>		
		<br/><br/>
		<img src="/test/img/bg2.gif" width="100" height="25"/>		
		<br/><br/>
		<img src="/test/img/bg3.gif" width="100" height="25"/>		
		<br/><br/>
		
		<a href="/test/plain/login.jsp">Login</a>&nbsp;&nbsp;<a href="/test/plain/logout.jsp">Logout</a>
		
		<br/><br/>
		
		<!-- Cross Domain Post Test -->
		<a href="/test/plain/post/form.jsp">Cross Domain Post Tester</a>
		
		<!-- Same Domain Post Test -->
		&nbsp;&nbsp;<a href="/test/plain/post/inDomainForm.jsp">Same Domain Post Tester</a>
		
		<br/><br/>
		
		<!-- Cross Domain Get Test -->
		<a href="http://<%=serverName%>:8080/test/plain/get/result.jsp">Cross Domain Get Tester</a>
		
		<!-- Same Domain Get Test -->
		&nbsp;&nbsp;<a href="http://<%=indomainPartner%>:8080/test/plain/get/result.jsp">Same Domain Get Tester</a>
	</body>
</html>