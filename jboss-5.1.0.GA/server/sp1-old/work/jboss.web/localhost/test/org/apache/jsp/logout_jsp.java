package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class logout_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.InstanceManager _jsp_instancemanager;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');

	response.setHeader("Cache-Control", "no-cache, must-revalidate");
	response.setHeader("Pragma","no-cache");

      out.write("\r\n");
      out.write("\r\n");

	request.getSession().invalidate();
	String target = request.getParameter("target");

      out.write("\r\n");
      out.write("\r\n");
if(target!=null && target.trim().length()>0){
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head></head>\r\n");
      out.write("\r\n");
      out.write("<body onload=\"setTimeout('document.form1.submit()',1000);\">\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t<form name=\"form1\" action=\"");
      out.print(target);
      out.write("\" method=\"post\">\t\t\r\n");
      out.write("\t\t<!-- send it all the parameters that were received. this will take care of\r\n");
      out.write("\t\tthe BROWSER-POST as well \r\n");
      out.write("\t\t-->\r\n");
      out.write("\t\t");

			java.util.Enumeration parameterNames = request.getParameterNames();
			while(parameterNames.hasMoreElements()){
			String name = (String)parameterNames.nextElement();
			String value = request.getParameter(name);
		
      out.write("\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"");
      out.print(name);
      out.write("\" value=\"");
      out.print(value);
      out.write("\">\t\t\t\r\n");
      out.write("\t\t");
}
      out.write("\r\n");
      out.write("\t</form>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
}else{
      out.write('\r');
      out.write('\n');
      out.write('	');

		response.sendRedirect("/test/index.jsp");
	
      out.write('\r');
      out.write('\n');
}
      out.write('\r');
      out.write('\n');
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
