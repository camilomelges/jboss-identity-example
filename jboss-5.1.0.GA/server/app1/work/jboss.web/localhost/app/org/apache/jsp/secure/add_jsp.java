package org.apache.jsp.secure;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.jboss.security.idm.*;
import org.jboss.security.idm.ldap.*;

public final class add_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');
      out.write('\n');
      out.write('\n');

	response.setHeader("Cache-Control", "no-cache, must-revalidate");
	response.setHeader("Pragma","no-cache");

      out.write('\n');
      out.write('\n');

	String serverName = request.getServerName();
	
	String indomainPartner = null;
	if(request.getServerName().indexOf("node1")!=-1) {
		indomainPartner = request.getServerName().replace("node1","node2");
	} else {
		indomainPartner = request.getServerName().replace("node2","node1");
	}
	

      out.write('\n');
      out.write('\n');
 

	out.print(request.getParameter("send") + "sadfsa");
	if(request.getParameter("send") != null && request.getParameter("send").equals("send")){
		
		String user = (String)request.getParameter("user");
		String paswd = (String)request.getParameter("passwd");
		String activate = (String)request.getParameter("activate");
		String sn = (String) request.getParameter("sn");
		String cn = (String) request.getParameter("cn");
		
		RFC2798Identity id = new RFC2798Identity();
		id.setActive(new Boolean(activate));
		id.setUserName(user);
		id.setPassword(paswd.getBytes());
		id.setSn(sn);
		id.setCn(cn);
		
		RFC2798IdentityProvider rfcProvider = (RFC2798IdentityProvider) provider;
		rfcProvider.register(id);
		
	}
	else if(request.getParameter("send") != null && request.getParameter("send").equals("delete")){		

		RFC2798IdentityProvider rfcProvider = (RFC2798IdentityProvider) provider;
		rfcProvider.remove("amontenegro");
	}
	
	RFC2798Identity id = (RFC2798Identity)provider.read(request.getUserPrincipal().getName());

      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("\t<head><title>Welcome to SSO Tester</title></head>\n");
      out.write("\t<body>\n");
      out.write("\t\t<span>Logged In User.....");
if(request.getUserPrincipal()!=null){
      out.print(request.getUserPrincipal().getName());
}
      out.write("</span>\n");
      out.write("\t\t<br/>\n");
      out.write("\t\t\n");
      out.write("\t\t<form action=\"/app/secure/add.jsp\" method=\"post\">\n");
      out.write("\t\tDisplay Name: <input type=\"text\" name=\"user\" value=\"\"/><br/>\n");
      out.write("\t\tPassword: <input type=\"text\" name=\"passwd\" value=\"\"/><br/>\n");
      out.write("\t\tSur Name: <input type=\"text\" name=\"sn\" value=\"\"/><br/>\n");
      out.write("\t\tCommon Name: <input type=\"text\" name=\"cn\" value=\"\"/><br/>\n");
      out.write("\t\tactivate: <input type=\"checkbox\" name=\"activate\" value=\"true\"/><br/>\n");
      out.write("\t\t\n");
      out.write("\t\t<input type=\"hidden\" name=\"send\" value=\"send\"/> \n");
      out.write("\t\t<input type=\"submit\" name=\"submit\" value=\"submit\">\n");
      out.write("\t\t</form>\n");
      out.write("\t\t<br>\n");
      out.write("\t\t\n");
      out.write("\t\t\n");
      out.write("\t\t\n");
      out.write("\t\t<a href=\"/app/logout.jsp\">Logout</a>\n");
      out.write("\t\t\n");
      out.write("\t\t<br/><br/>\n");
      out.write("\t\t\n");
      out.write("\t\t<!-- Cross Domain Post Test -->\n");
      out.write("\t\t<a href=\"/app/secure/post/form.jsp\">Cross Domain Post Tester</a>\n");
      out.write("\t\t\n");
      out.write("\t\t<!-- Same Domain Post Test -->\n");
      out.write("\t\t&nbsp;&nbsp;<a href=\"/app/secure/post/inDomainForm.jsp\">Same Domain Post Tester</a>\n");
      out.write("\t\t\n");
      out.write("\t\t<br/><br/>\n");
      out.write("\t\t\n");
      out.write("\t\t<!-- Cross Domain Get Test -->\n");
      out.write("\t\t<a href=\"http://");
      out.print(serverName);
      out.write(":8080/app/secure/get/result.jsp\">Cross Domain Get Tester</a>\n");
      out.write("\t\t\n");
      out.write("\t\t<!-- Same Domain Get Test -->\n");
      out.write("\t\t&nbsp;&nbsp;<a href=\"http://");
      out.print(indomainPartner);
      out.write(":8080/app/secure/get/result.jsp\">Same Domain Get Tester</a>\n");
      out.write("\t</body>\n");
      out.write("</html>\n");
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
