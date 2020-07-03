package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("\t<head><title>Welcome to SSO Tester</title></head>\r\n");
      out.write("\t<body>\r\n");
      out.write("\t\t<span>Logged In User.....");
if(request.getUserPrincipal()!=null){
      out.print(request.getUserPrincipal().getName());
}
      out.write("</span>\r\n");
      out.write("\t\t<br/><br/>\r\n");
      out.write("\t\t<img src=\"/test/img/bg.gif\" width=\"100\" height=\"25\"/>\t\t\r\n");
      out.write("\t\t<br/><br/>\r\n");
      out.write("\t\t<img src=\"/test/img/bg2.gif\" width=\"100\" height=\"25\"/>\t\t\r\n");
      out.write("\t\t<br/><br/>\r\n");
      out.write("\t\t<img src=\"/test/img/bg3.gif\" width=\"100\" height=\"25\"/>\t\t\r\n");
      out.write("\t\t<br/><br/>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<a href=\"/test/secure/index.jsp\">Login</a>&nbsp;&nbsp;<a href=\"/test/logout.jsp\">Logout</a>\r\n");
      out.write("\t\t<br/><br/>\r\n");
      out.write("\t\t<a href=\"/test/secure/edit.jsp\">Edit User</a>\r\n");
      out.write("\t\t<br/><br/>\r\n");
      out.write("\t\t<a href=\"/test/secure/add.jsp\">Add User</a>\r\n");
      out.write("\t\t<br/><br/>\r\n");
      out.write("\t\t<!-- Cross Domain Post Test -->\r\n");
      out.write("\t\t<a href=\"/test/secure/post/form.jsp\">Cross Domain Post Tester</a>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<!-- Same Domain Post Test -->\r\n");
      out.write("\t\t&nbsp;&nbsp;<a href=\"/test/secure/post/inDomainForm.jsp\">Same Domain Post Tester</a>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<br/><br/>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<!-- Cross Domain Get Test -->\r\n");
      out.write("\t\t<a href=\"http://");
      out.print(serverName);
      out.write(":8080/test/secure/get/result.jsp\">Cross Domain Get Tester</a>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<!-- Same Domain Get Test -->\r\n");
      out.write("\t\t&nbsp;&nbsp;<a href=\"http://");
      out.print(indomainPartner);
      out.write(":8080/test/secure/get/result.jsp\">Same Domain Get Tester</a>\r\n");
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
