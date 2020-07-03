package org.apache.jsp.plain;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
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
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("<head><title>Login</title></head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t\r\n");
      out.write("\t<form method=\"POST\" action=\"performLogin.jsp\" name=\"loginform\" id=\"loginForm\">\r\n");
      out.write("\r\n");
      out.write("\t<table width=\"100%\" height=\"100%\" cellpadding=\"0\" cellspacing=\"1\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td valign=\"middle\" align=\"center\">JBoss Portal Login</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td valign=\"middle\" align=\"center\">&nbsp;</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t<td valign=\"middle\" align=\"center\">\r\n");
      out.write("\t\t<table width=\"350\" height=\"200\" cellpadding=\"0\" cellspacing=\"0\" class=\"form\">\r\n");
      out.write("\t\t\t<tr><td colspan=\"2\" align=\"center\">&nbsp;</td></tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t<td align=\"right\" width=\"100\">\r\n");
      out.write("\t\t\t\tUsername:&nbsp;\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td align=\"left\">\r\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"j_username\" id=\"username\" value=\"\"/>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t<td align=\"right\" width=\"100\">\r\n");
      out.write("\t\t\t\tPassword:&nbsp;\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td align=\"left\">\r\n");
      out.write("\t\t\t\t<input type=\"password\" name=\"j_password\" id=\"password\" value=\"\"/>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t<td colspan=\"2\" align=\"center\">\r\n");
      out.write("\t\t\t\t<input type=\"submit\" id=\"loginButton\" name=\"login\" value=\"Login\"/>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\t\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t</tr>\t\r\n");
      out.write("\t</table>\r\n");
      out.write("\t</form>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
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
