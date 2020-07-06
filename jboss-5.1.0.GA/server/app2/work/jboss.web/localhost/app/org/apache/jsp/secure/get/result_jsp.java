package org.apache.jsp.secure.get;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class result_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\r');
      out.write('\n');

	String indomainPartner = null;
	String serverName = request.getServerName();
	if(request.getServerName().indexOf("app1")!=-1)
	{
		indomainPartner = request.getServerName().replace("app1","app2");
	} else {
		indomainPartner = request.getServerName().replace("app2","app1");
	}
	String user = "";
	if(request.getUserPrincipal()!=null)
	{
		user = request.getUserPrincipal().getName();
	}

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("\t<head><title>Welcome to SSO Tester</title></head>\r\n");
      out.write("\t<body>\t    \r\n");
      out.write("\t\t<span>SSO <b>GET</b> was finished - ");
      out.print(user);
      out.write("</span>\r\n");
      out.write("\t\t<br/><br/>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t");

			java.util.Enumeration parameterNames = request.getParameterNames();
			while(parameterNames.hasMoreElements()){
			String name = (String)parameterNames.nextElement();
			String value = request.getParameter(name);
		
      out.write("\r\n");
      out.write("\t\t\t<span>");
      out.print(name);
      out.write('=');
      out.print(value);
      out.write("</span><br/>\r\n");
      out.write("\t\t");
}
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<br/><br/>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<a href=\"/app/index.jsp\">Home</a>&nbsp;&nbsp;\t\t\r\n");
      out.write("\t</body>\r\n");
      out.write("</html>");
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
