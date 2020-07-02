<%@page contentType="text/html" language="java"%>
<%
	response.setHeader("Cache-Control", "no-cache, must-revalidate");
	response.setHeader("Pragma","no-cache");
%>

<%
	request.getSession().invalidate();
	String target = request.getParameter("target");
%>

<%if(target!=null && target.trim().length()>0){%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head></head>

<body onload="setTimeout('document.form1.submit()',1000);">
						
	<form name="form1" action="<%=target%>" method="post">		
		<!-- send it all the parameters that were received. this will take care of
		the BROWSER-POST as well 
		-->
		<%
			java.util.Enumeration parameterNames = request.getParameterNames();
			while(parameterNames.hasMoreElements()){
			String name = (String)parameterNames.nextElement();
			String value = request.getParameter(name);
		%>
			<input type="hidden" name="<%=name%>" value="<%=value%>">			
		<%}%>
	</form>
	
	
</body>
</html>
<%}else{%>
	<%
		response.sendRedirect("/test/index.jsp");
	%>
<%}%>
