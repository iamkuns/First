/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.86
 * Generated at: 2024-06-17 06:21:45 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ManageSlots_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(3);
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("  <meta charset=\"utf-8\">\r\n");
      out.write("  <meta content=\"width=device-width, initial-scale=1.0\" name=\"viewport\">\r\n");
      out.write("\r\n");
      out.write("  <title>SMEVCS</title>\r\n");
      out.write("  <meta content=\"\" name=\"description\">\r\n");
      out.write("  <meta content=\"\" name=\"keywords\">\r\n");
      out.write("\r\n");
      out.write("  <!-- Favicons -->\r\n");
      out.write("  <link href=\"assets/img/apple-touch-icon.png\" rel=\"icon\">\r\n");
      out.write("  <link href=\"assets/img/apple-touch-icon.png\" rel=\"apple-touch-icon\">\r\n");
      out.write("\r\n");
      out.write("  <!-- Google Fonts -->\r\n");
      out.write("  <link href=\"https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Montserrat:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("  <!-- Vendor CSS Files -->\r\n");
      out.write("  <link href=\"assets/vendor/aos/aos.css\" rel=\"stylesheet\">\r\n");
      out.write("  <link href=\"assets/vendor/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("  <link href=\"assets/vendor/bootstrap-icons/bootstrap-icons.css\" rel=\"stylesheet\">\r\n");
      out.write("  <link href=\"assets/vendor/boxicons/css/boxicons.min.css\" rel=\"stylesheet\">\r\n");
      out.write("  <link href=\"assets/vendor/glightbox/css/glightbox.min.css\" rel=\"stylesheet\">\r\n");
      out.write("  <link href=\"assets/vendor/remixicon/remixicon.css\" rel=\"stylesheet\">\r\n");
      out.write("  <link href=\"assets/vendor/swiper/swiper-bundle.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("  <!-- Template Main CSS File -->\r\n");
      out.write("  <link href=\"assets/css/style.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("  <!-- =======================================================\r\n");
      out.write("  * Template Name: Bootslander - v4.7.0\r\n");
      out.write("  * Template URL: https://bootstrapmade.com/bootslander-free-bootstrap-landing-page-template/\r\n");
      out.write("  * Author: BootstrapMade.com\r\n");
      out.write("  * License: https://bootstrapmade.com/license/\r\n");
      out.write("  ======================================================== -->\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("  <!-- ======= Header ======= -->\r\n");
      out.write("  <header id=\"header\" class=\"fixed-top d-flex align-items-center header-transparent\">\r\n");
      out.write("    <div class=\"container d-flex align-items-center justify-content-between\">\r\n");
      out.write("\r\n");
      out.write("      <div class=\"logo\">\r\n");
      out.write("        <h1><a href=\"index.jsp\"><span>TATA Power</span></a></h1>\r\n");
      out.write("      </div>\r\n");
      out.write("\r\n");
      out.write("      <nav id=\"navbar\" class=\"navbar\">\r\n");
      out.write("        <ul>\r\n");
      out.write("         <li><a class=\"nav-link scrollto active\" href=\"AdminHome.jsp\">Home</a></li>        \r\n");
      out.write("          <li><a class=\"nav-link scrollto\" href=\"ManageSlots.jsp\">Manage Charging Slots</a></li>\r\n");
      out.write("           <li><a class=\"nav-link scrollto\" href=\"ViewSlots.jsp\">View Slots</a></li>\r\n");
      out.write("           <li><a class=\"nav-link scrollto\" href=\"BookingHistory.jsp\">View Booking History</a></li>\r\n");
      out.write("           \r\n");
      out.write("             <li><a class=\"nav-link scrollto\" href=\"LogoutController\">Logout</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("        <i class=\"bi bi-list mobile-nav-toggle\"></i>\r\n");
      out.write("      </nav>\r\n");
      out.write("      <!-- .navbar -->\r\n");
      out.write("    </div>\r\n");
      out.write("  </header><!-- End Header -->\r\n");
      out.write("\r\n");
      out.write("  <!-- ======= Hero Section ======= -->\r\n");
      out.write("  <section id=\"hero\">\r\n");
      out.write("\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("     \r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <svg class=\"hero-waves\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" viewBox=\"0 24 150 28 \" preserveAspectRatio=\"none\">\r\n");
      out.write("      <defs>\r\n");
      out.write("        <path id=\"wave-path\" d=\"M-160 44c30 0 58-18 88-18s 58 18 88 18 58-18 88-18 58 18 88 18 v44h-352z\">\r\n");
      out.write("      </defs>\r\n");
      out.write("      <g class=\"wave1\">\r\n");
      out.write("        <use xlink:href=\"#wave-path\" x=\"50\" y=\"3\" fill=\"rgba(255,255,255, .1)\">\r\n");
      out.write("      </g>\r\n");
      out.write("      <g class=\"wave2\">\r\n");
      out.write("        <use xlink:href=\"#wave-path\" x=\"50\" y=\"0\" fill=\"rgba(255,255,255, .2)\">\r\n");
      out.write("      </g>\r\n");
      out.write("      <g class=\"wave3\">\r\n");
      out.write("        <use xlink:href=\"#wave-path\" x=\"50\" y=\"9\" fill=\"#fff\">\r\n");
      out.write("      </g>\r\n");
      out.write("    </svg>\r\n");
      out.write("\r\n");
      out.write("  </section><!-- End Hero -->\r\n");
      out.write("\r\n");
      out.write("  <main id=\"main\">\r\n");
      out.write("\r\n");
      out.write("    <!-- ======= Contact Section ======= -->\r\n");
      out.write("    <section id=\"contact\" class=\"contact\">\r\n");
      out.write("      <div class=\"container\">\r\n");
      out.write("\r\n");
      out.write("        <div class=\"section-title\" data-aos=\"fade-up\">\r\n");
      out.write("          <h2>Slots</h2>\r\n");
      out.write("          <p>Add Charging Slots</p>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("          <div class=\"col-lg-8 mt-5 mt-lg-0\" data-aos=\"fade-left\" data-aos-delay=\"200\">\r\n");
      out.write("\r\n");
      out.write("            <form action=\"ManageSlotsController\" method=\"post\" role=\"form\" class=\"email-form\">\r\n");
      out.write("             \r\n");
      out.write("              <div class=\"form-group mt-3\">\r\n");
      out.write("                <input type=\"text\" class=\"form-control\" name=\"slotname\" id=\"subject\" placeholder=\"Slot Name\" required>\r\n");
      out.write("              </div>\r\n");
      out.write("              \r\n");
      out.write("              <div class=\"form-group mt-3\">\r\n");
      out.write("                <input type=\"text\" class=\"form-control\" name=\"slotaddress\" id=\"subject\" placeholder=\"Slot Address\" required>\r\n");
      out.write("              </div>\r\n");
      out.write("              \r\n");
      out.write("               <div class=\"form-group mt-3\">\r\n");
      out.write("                <input type=\"text\" class=\"form-control\" name=\"slotarea\" id=\"subject\" placeholder=\"Slot Area\" required>\r\n");
      out.write("              </div>\r\n");
      out.write("              \r\n");
      out.write("               <div class=\"form-group mt-3\">\r\n");
      out.write("                <input type=\"text\" class=\"form-control\" name=\"city\" id=\"subject\" placeholder=\"City\" required>\r\n");
      out.write("              </div>\r\n");
      out.write("              \r\n");
      out.write("               <div class=\"form-group mt-3\">\r\n");
      out.write("                <input type=\"text\" class=\"form-control\" name=\"state\" id=\"subject\" placeholder=\"State\" required>\r\n");
      out.write("              </div>\r\n");
      out.write("               \r\n");
      out.write("               <div class=\"form-group mt-3\">\r\n");
      out.write("                <input type=\"text\" class=\"form-control\" name=\"country\" id=\"subject\" placeholder=\"Country\" required>\r\n");
      out.write("              </div>\r\n");
      out.write("             <br><br>\r\n");
      out.write("             <div class=\"text-center\"><button type=\"submit\">Add Slots</button></div>\r\n");
      out.write("            </form>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("      </div>\r\n");
      out.write("    </section>\r\n");
      out.write("    \r\n");
      out.write("    <!-- End Section -->\r\n");
      out.write("\r\n");
      out.write("  </main>\r\n");
      out.write("  <!-- End #main -->\r\n");
      out.write("\r\n");
      out.write("  <!-- ======= Footer ======= -->\r\n");
      out.write("  <footer id=\"footer\">\r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("      <div class=\"copyright\">\r\n");
      out.write("        &copy; Copyright <strong><span>TATA Power 2021</span></strong>. All Rights Reserved\r\n");
      out.write("      </div>\r\n");
      out.write("      \r\n");
      out.write("    </div>\r\n");
      out.write("  </footer>\r\n");
      out.write("  <!-- End Footer -->\r\n");
      out.write("\r\n");
      out.write("  <a href=\"#\" class=\"back-to-top d-flex align-items-center justify-content-center\"><i class=\"bi bi-arrow-up-short\"></i></a>\r\n");
      out.write("  <div id=\"preloader\"></div>\r\n");
      out.write("\r\n");
      out.write("  <!-- Vendor JS Files -->\r\n");
      out.write("  <script src=\"assets/vendor/purecounter/purecounter.js\"></script>\r\n");
      out.write("  <script src=\"assets/vendor/aos/aos.js\"></script>\r\n");
      out.write("  <script src=\"assets/vendor/bootstrap/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("  <script src=\"assets/vendor/glightbox/js/glightbox.min.js\"></script>\r\n");
      out.write("  <script src=\"assets/vendor/swiper/swiper-bundle.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("  <!-- self Main JS File -->\r\n");
      out.write("  <script src=\"assets/js/main.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
