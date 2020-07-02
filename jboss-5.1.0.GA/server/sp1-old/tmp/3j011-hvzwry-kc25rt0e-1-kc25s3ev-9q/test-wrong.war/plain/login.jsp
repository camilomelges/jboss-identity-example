<%@page contentType="text/html" language="java"%>
<%
	response.setHeader("Cache-Control", "no-cache, must-revalidate");
	response.setHeader("Pragma","no-cache");
%>

<html>

<head><title>Login</title></head>

<body>
	
	<form method="POST" action="performLogin.jsp" name="loginform" id="loginForm">

	<table width="100%" height="100%" cellpadding="0" cellspacing="1">
		<tr>
			<td valign="middle" align="center">JBoss Portal Login</td>
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
				Username:&nbsp;
			</td>
			<td align="left">
				<input type="text" name="j_username" id="username" value=""/>
			</td>
		
			</tr>
			<tr>
			<td align="right" width="100">
				Password:&nbsp;
			</td>
			<td align="left">
				<input type="password" name="j_password" id="password" value=""/>
			</td>
		
			</tr>
			<tr>
			<td colspan="2" align="center">
				<input type="submit" id="loginButton" name="login" value="Login"/>
			</td>
			</tr>	
		</table>
		</td>
		</tr>	
	</table>
	</form>

</body>

</html>
