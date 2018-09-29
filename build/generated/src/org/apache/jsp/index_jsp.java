package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import db.common.DI;
import util.StudentUtil;
import db.student.StudentDB;
import bean.Student;
import java.util.List;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>School Managmant System</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("            function setIDDelete(id) {\n");
      out.write("                document.getElementById(\"studentDelete\").value = id;\n");
      out.write("            }\n");
      out.write("            function setIDUpdate(id) {\n");
      out.write("                document.getElementById(\"studentUpdate\").value = id;\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        ");

            StudentDB studentDb = new StudentDB();
            String action = request.getParameter("action");

            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String ageStr = request.getParameter("age");
            Integer age = null;
            if (ageStr != null && !ageStr.isEmpty()) {
                age = Integer.parseInt(ageStr);
            }
            if (action != null && !action.isEmpty()) {
                String studentID = request.getParameter("studentID");
                if (studentID != null && !studentID.isEmpty()) {
                    if (action.equalsIgnoreCase("delete")) {
                        studentDb.delete(Integer.parseInt(studentID));
                    } else if (action.equalsIgnoreCase("update")) {
                        studentDb.update(new Student(Integer.parseInt(studentID), name, surname, age));
                        response.sendRedirect("index.jsp");
                    }
                }
                if (action.equalsIgnoreCase("add")) {
                    studentDb.insert(new Student(null, name, surname, age));
                    response.sendRedirect("index.jsp");
                }
                if (action.equalsIgnoreCase("search")) {
                    name = "";
                    surname = "";
                    ageStr = "";
                    age = null;
                    response.sendRedirect("index.jsp");
                }
            }
            out.print("id=" + request.getParameter("studentID"));
            List<Student> students = studentDb.getAll(name, surname, age);
        
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"container\">           \n");
      out.write("            <div class=\"modal fade\" id=\"ModalDelete\" role=\"dialog\">\n");
      out.write("                <div class=\"modal-dialog\">\n");
      out.write("                    <!-- Modal content-->\n");
      out.write("                    <div class=\"modal-content\">\n");
      out.write("                        <form action=\"index.jsp\">\n");
      out.write("                            <div class=\"modal-header\">\n");
      out.write("                                <h5 class=\"modal-title\">Delete student</h5>\n");
      out.write("                                <button  type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"modal-body\">\n");
      out.write("                                <p>Are you sure?</p>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"modal-footer\">\n");
      out.write("                                <input type=\"hidden\" name=\"studentID\" id=\"studentDelete\"/>\n");
      out.write("                                <input type=\"hidden\" name=\"action\" value=\"delete\"/> \n");
      out.write("                                <input type=\"submit\" class=\"btn btn-default\" value=\"Yes\"/>\n");
      out.write("                                <input type=\"submit\" class=\"btn btn-danger\" data-dismiss=\"modal\" value=\"Cancel\"/>\n");
      out.write("                            </div>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"container\">           \n");
      out.write("            <div class=\"modal fade\" id=\"ModalUpdate\" role=\"dialog\">\n");
      out.write("                <div class=\"modal-dialog\">\n");
      out.write("                    <!-- Modal content-->\n");
      out.write("                    <div class=\"modal-content\">\n");
      out.write("                        <form action=\"index.jsp\">\n");
      out.write("                            <div class=\"modal-header\">\n");
      out.write("                                <h5 class=\"modal-title\">Update student</h5>\n");
      out.write("                                <button  type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"modal-body\">\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label for=\"name\">Name</label>\n");
      out.write("                                    <input type=\"text\" name=\"name\" class=\"form-control\" placeholder=\"Name\">    \n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label for=\"surname\">Surname</label>\n");
      out.write("                                    <input type=\"text\" name=\"surname\" class=\"form-control\" placeholder=\"Surname\">\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label for=\"age\">Age</label>\n");
      out.write("                                    <input type=\"number\" name=\"age\" class=\"form-control\" placeholder=\"Age\">\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                <div class=\"modal-footer\">\n");
      out.write("                                    <input type=\"hidden\" name=\"studentID\" id=\"studentUpdate\"/>\n");
      out.write("                                    <input type=\"hidden\" name=\"action\" value=\"update\"/> \n");
      out.write("                                    <input type=\"submit\" class=\"btn btn-default\" value=\"OK\"/>\n");
      out.write("                                    <input type=\"submit\" class=\"btn btn-danger\" data-dismiss=\"modal\" value=\"Cancel\"/>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div style=\"margin-bottom: 30px\">\n");
      out.write("            <form class=\"col-md-3\" action=\"index.jsp\" action=\"add\">\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"name\">Name</label>\n");
      out.write("                    <input type=\"text\" name=\"name\" class=\"form-control\" placeholder=\"Name\">    \n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"surname\">Surname</label>\n");
      out.write("                    <input type=\"text\" name=\"surname\" class=\"form-control\" placeholder=\"Surname\">\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"age\">Age</label>\n");
      out.write("                    <input type=\"number\" name=\"age\" class=\"form-control\" placeholder=\"Age\">\n");
      out.write("                </div>\n");
      out.write("                <input type=\"hidden\" name=\"action\" value=\"add\"/>\n");
      out.write("                <button type=\"submit\" class=\"btn btn-primary\">Add</button>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        <table class=\"table\" style=\"width:100%\" >\n");
      out.write("            <thead class=\"thead-dark\" style=\"width:100%\">\n");
      out.write("                <tr>\n");
      out.write("                    <th scope=\"col\">#</th>\n");
      out.write("                    <th scope=\"col\">Name</th>\n");
      out.write("                    <th scope=\"col\">Surname</th>\n");
      out.write("                    <th scope=\"col\">Age</th>\n");
      out.write("                    <th scope=\"col\">Actions</th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("\n");
      out.write("            <tbody>\n");
      out.write("                ");
                    for (int i = 0;
                            i < students.size();
                            i++) {
                        Student s = students.get(i);
                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>  ");
      out.print(i + 1);
      out.write("\n");
      out.write("                    </td>\n");
      out.write("\n");
      out.write("                    <td>  ");
      out.print(s.getName());
      out.write("\n");
      out.write("                    </td>\n");
      out.write("\n");
      out.write("                    <td>  ");
      out.print(s.getSurname());
      out.write("\n");
      out.write("                    </td>\n");
      out.write("\n");
      out.write("                    <td>  ");
      out.print(s.getAge());
      out.write("\n");
      out.write("                    </td>\n");
      out.write("\n");
      out.write("                    <td><button class=\"btn btn-warning\" data-toggle=\"modal\" data-target=\"#ModalUpdate\" onclick=\"setIDUpdate('");
      out.print(s.getId());
      out.write("')\"><i class=\"fa fa-pencil-square-o\" aria-hidden=\"true\"></i></button>\n");
      out.write("                        <button class=\"btn btn-danger\"  data-toggle=\"modal\" data-target=\"#ModalDelete\" onclick=\"setIDDelete('");
      out.print(s.getId());
      out.write("')\" ><i class=\"fa fa-times\" aria-hidden=\"true\"></i></button></td>\n");
      out.write("                </tr>\n");
      out.write("                ");
 }
      out.write("\n");
      out.write("            </tbody>\n");
      out.write("\n");
      out.write("        </table>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
