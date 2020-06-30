<%@page contentType="text/html" language="java"%>
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
	String user = "";
	if(request.getUserPrincipal()!=null)
	{
		user = request.getUserPrincipal().getName();
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
		
		
		<a href="/test/index.jsp">Home</a>&nbsp;&nbsp;		
	</body>
</html>