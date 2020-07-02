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
%>

<html>
	<head><title>Welcome to SSO Tester</title></head>
	<body>
		<br/><br/>
		<img src="/test/img/bg.gif" width="100" height="25"/>		
		<br/><br/>
		<img src="/test/img/bg2.gif" width="100" height="25"/>		
		<br/><br/>
		<img src="/test/img/bg3.gif" width="100" height="25"/>		
		<br/><br/>
		<span>Action=http://<%=indomainPartner%>:8080/test/secure/post/result.jsp?param3=param3val</span>
		<form method="post" action="http://<%=indomainPartner%>:8080/test/secure/post/result.jsp?param3=param3val" name="crossDomainForm">		
		<table width="100%" height="100%" cellpadding="0" cellspacing="1">
		<tr>
			<td valign="middle" align="center">SSO Browser Post Test</td>
		</tr>
		<tr>
			<td valign="middle" align="center">&nbsp;</td>
		</tr>
		
		<tr>
		<td valign="middle" align="center">
		<table width="350" height="200" cellpadding="0" cellspacing="0" class="form">
			<tr><td colspan="2" align="center">&nbsp;</td></tr>
			<tr>
			<td align="right" width="100">
				Param1:&nbsp;
			</td>
			<td align="left">
				<input type="text" name="param1" value=""/>
			</td>
		
			</tr>
			<tr>
			<td align="right" width="100">
				Param2:&nbsp;
			</td>
			<td align="left">
				<input type="text" name="param2" value=""/>
			</td>
		
			</tr>
			<tr>
			<td colspan="2" align="center">
				<input type="submit" id="button" name="" value="Submit"/>
			</td>
			</tr>	
		</table>
		</td>
		</tr>	
	</table>
	</form>
	</body>
</html>