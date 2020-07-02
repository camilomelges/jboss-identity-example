<%@page contentType="text/html" language="java"%>
<%
	response.setHeader("Cache-Control", "no-cache, must-revalidate");
	response.setHeader("Pragma","no-cache");
%>

<%
	String username = request.getParameter("j_username");
	String password = request.getParameter("j_password");

	//perform login
	org.jboss.security.idm.LoginProvider loginProvider = org.jboss.security.idm.IdentityManager.findLoginProvider();
	boolean success = loginProvider.login(username,password.getBytes());

	if(success)
	{
		org.jboss.security.saml.SSOUser user = new org.jboss.security.saml.SSOUser(username,
		null);
		request.getSession().setAttribute(org.jboss.security.saml.SingleSignOn.SSO_USER,user);
		response.sendRedirect("/test/plain/index.jsp");
	}
	else
	{
		response.sendRedirect("/test/plain/loginError.jsp");
	}
%>
