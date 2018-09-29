<%-- 
    Document   : index
    Created on : Sep 2, 2018, 6:57:38 PM
    Author     : RafaelAhmedov
--%>

<%@page import="db.common.DI"%>
<%@page import="util.StudentUtil"%>
<%@page import="db.student.StudentDB"%>
<%@page import="bean.Student"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>School Managmant System</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

        <script>
            function setIDDelete(id) {
                document.getElementById("studentDelete").value = id;
            }
            function setIDUpdate(id) {
                document.getElementById("studentUpdate").value = id;
            }
        </script>

    </head>
    <body>

        <%
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
        %>

        <div class="container">           
            <div class="modal fade" id="ModalDelete" role="dialog">
                <div class="modal-dialog">
                    <!-- Modal content-->
                    <div class="modal-content">
                        <form action="index.jsp">
                            <div class="modal-header">
                                <h5 class="modal-title">Delete student</h5>
                                <button  type="button" class="close" data-dismiss="modal">&times;</button>

                            </div>
                            <div class="modal-body">
                                <p>Are you sure?</p>
                            </div>
                            <div class="modal-footer">
                                <input type="hidden" name="studentID" id="studentDelete"/>
                                <input type="hidden" name="action" value="delete"/> 
                                <input type="submit" class="btn btn-default" value="Yes"/>
                                <input type="submit" class="btn btn-danger" data-dismiss="modal" value="Cancel"/>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <div class="container">           
            <div class="modal fade" id="ModalUpdate" role="dialog">
                <div class="modal-dialog">
                    <!-- Modal content-->
                    <div class="modal-content">
                        <form action="index.jsp">
                            <div class="modal-header">
                                <h5 class="modal-title">Update student</h5>
                                <button  type="button" class="close" data-dismiss="modal">&times;</button>
                            </div>
                            <div class="modal-body">
                                <div class="form-group">
                                    <label for="name">Name</label>
                                    <input type="text" name="name" class="form-control" placeholder="Name">    
                                </div>
                                <div class="form-group">
                                    <label for="surname">Surname</label>
                                    <input type="text" name="surname" class="form-control" placeholder="Surname">
                                </div>

                                <div class="form-group">
                                    <label for="age">Age</label>
                                    <input type="number" name="age" class="form-control" placeholder="Age">
                                </div>

                                <div class="modal-footer">
                                    <input type="hidden" name="studentID" id="studentUpdate"/>
                                    <input type="hidden" name="action" value="update"/> 
                                    <input type="submit" class="btn btn-default" value="OK"/>
                                    <input type="submit" class="btn btn-danger" data-dismiss="modal" value="Cancel"/>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>

            </div>
        </div>


        <div style="margin-bottom: 30px">
            <form class="col-md-3" action="index.jsp" action="add">
                <div class="form-group">
                    <label for="name">Name</label>
                    <input type="text" name="name" class="form-control" placeholder="Name">    
                </div>
                <div class="form-group">
                    <label for="surname">Surname</label>
                    <input type="text" name="surname" class="form-control" placeholder="Surname">
                </div>

                <div class="form-group">
                    <label for="age">Age</label>
                    <input type="number" name="age" class="form-control" placeholder="Age">
                </div>
                <input type="hidden" name="action" value="add"/>
                <button type="submit" class="btn btn-primary">Add</button>
            </form>
        </div>
        <table class="table" style="width:100%" >
            <thead class="thead-dark" style="width:100%">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Name</th>
                    <th scope="col">Surname</th>
                    <th scope="col">Age</th>
                    <th scope="col">Actions</th>
                </tr>
            </thead>

            <tbody>
                <%                    for (int i = 0;
                            i < students.size();
                            i++) {
                        Student s = students.get(i);
                %>
                <tr>
                    <td>  <%=i + 1%>
                    </td>

                    <td>  <%=s.getName()%>
                    </td>

                    <td>  <%=s.getSurname()%>
                    </td>

                    <td>  <%=s.getAge()%>
                    </td>

                    <td><button class="btn btn-warning" data-toggle="modal" data-target="#ModalUpdate" onclick="setIDUpdate('<%=s.getId()%>')"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></button>
                        <button class="btn btn-danger"  data-toggle="modal" data-target="#ModalDelete" onclick="setIDDelete('<%=s.getId()%>')" ><i class="fa fa-times" aria-hidden="true"></i></button></td>
                </tr>
                <% }%>
            </tbody>

        </table>
    </body>
</html>
