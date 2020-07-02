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
	String user = "";
	org.jboss.security.saml.SSOUser ssoUser = (org.jboss.security.saml.SSOUser)request.getSession().getAttribute("jboss_sso_user");
	if(ssoUser!=null && ssoUser.getUserName()!=null)
	{
		user = ssoUser.getUserName();
	}
%>

<html>
	<head><title>Welcome to SSO Tester</title></head>
	<body>	    
		<span>SSO <b>GET</b> was finished - <%=user%></span>
		<br/><br/>
		<img src="/test/img/bg.gif" width="100" height="25"/>		
		<br/><br/>
		<img src="/test/img/bg2.gif" width="100" height="25"/>		
		<br/><br/>
		<img src="/test/img/bg3.gif" width="100" height="25"/>		
		<br/><br/>
		
		<%
			java.util.Enumeration parameterNames = request.getParameterNames();
			while(parameterNames.hasMoreElements()){
			String name = (String)parameterNames.nextElement();
			String value = request.getParameter(name);
		%>
			<span><%=name%>=<%=value%></span><br/>
		<%}%>
		
		<br/><br/>
		
		
		<a href="/test/plain/index.jsp">Home</a>&nbsp;&nbsp;		
	</body>
</html>