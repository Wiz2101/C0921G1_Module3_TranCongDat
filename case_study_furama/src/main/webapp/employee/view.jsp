<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Homepage</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="assets/bootstrap413/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="assets/datatables/css/dataTables.bootstrap4.min.css"/>
    <link rel="stylesheet" href="../assets/style.css">
    <link rel="stylesheet" href="../assets/fontawesome-free-5.15.4-web/css/all.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-fluid">
    <header class="d-flex flex-wrap justify-content-center py-1 mb-1 border-bottom">
        <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
            <img style="height: 32px; width: auto"
                 src="https://inekescheffers.files.wordpress.com/2016/05/1-logo_bovenaan_achtergrond-1.png?w=584&h=234"
                 alt="">
        </a>

        <span class="badge rounded-pill bg-danger"><a href="#" class="nav-link active text-white" aria-current="page">Dat Tran</a></span>
    </header>
    <nav class="navbar navbar-expand-lg navbar-light" style="background-color: #f1f1f1">
        <div class="container-fluid">
            <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
                <ul class="sidebar navbar-nav me-auto mb-2 mb-lg-0 flex-grow-1 d-flex justify-content-center">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="#">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/employee">Employee</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/employee">Customer</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/service">Service</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Contract</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</div>
<div class="container-fluid">
    <nav class="navbar navbar-light bg-light">
        <form class="form-inline" action="/employee">
            <input name="keyword" class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button name="action" value="search" class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </nav>

</div>
<div class="container-fluid">
    <div class="container-fluid">
        <div class="table-responsive">
            <div style="padding: 40px 25px" class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-xs-6">
                            <h2>Manage <b>Employees</b></h2>
                        </div>
                        <div class="col-xs-6">
                            <a href="/employee?action=create" class="btn btn-success"><i class="far fa-plus-square"></i><span>Add New Employee</span></a>
                            <%--                            <a href="#deleteEmployeeModal" class="btn btn-danger" data-toggle="modal"><i class="fas fa-trash"></i><span>Delete</span></a>--%>
                        </div>
                    </div>
                </div>
                <table id="employeeTable" class="table table-striped table-hover">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Date of birth</th>
                        <th>ID Card</th>
                        <th>Salary</th>
                        <th>Phone</th>
                        <th>Address</th>
                        <th>Position</th>
                        <th>Education Degree</th>
                        <th>Division</th>
                        <th>User</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>

                    <c:forEach var="employeeList" items="${employeeList}">
                        <tr>
                            <td><c:out value="${employeeList.employeeId}"></c:out></td>
                            <td><c:out value="${employeeList.employeeName}"></c:out></td>
                            <td><c:out value="${employeeList.employeeBirthday}"></c:out></td>
                            <td><c:out value="${employeeList.employeeIdCard}"></c:out></td>
                            <td><c:out value="${employeeList.employeeSalary}"></c:out></td>
                            <td><c:out value="${employeeList.employeePhone}"></c:out></td>
                            <td><c:out value="${employeeList.employeeEmail}"></c:out></td>
                            <td><c:out value="${employeeList.employeeAddress}"></c:out></td>
                            <td><c:out value="${employeeList.position.positionName}"></c:out></td>
                            <td><c:out value="${employeeList.educationDegree.educationDegreeName}"></c:out></td>
                            <td><c:out value="${employeeList.division.divisionName}"></c:out></td>
                            <td><c:out value="${employeeList.user.username}"></c:out></td>
                            <td>
                                <a href="/employee?action=edit&id=${employeeList.employeeId}" class="btn btn-success btn-edit"><i class="btn fas fa-edit"></i></a>

                                <!-- Button trigger modal -->
                                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#deleteModal-${employeeList.employeeId}">
                                    <i class="fas fa-trash"></i>
                                </button>

                            </td>
                        </tr>


                        <!-- Modal -->
                        <div class="modal fade" id="deleteModal-${employeeList.employeeId}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        Are you sure to remove the employee with ID: ${employeeList.employeeId} & Name: ${employeeList.employeeName}?
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                                        <a href="/employee?action=delete&id=${employeeList.employeeId}" class="delete"><button type="button" class="btn btn-primary">Delete Now</button></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <script src="assets/jquery/jquery-3.5.1.min.js"></script>
    <script src="assets/datatables/js/jquery.dataTables.min.js"></script>
    <script src="assets/datatables/js/dataTables.bootstrap4.min.js"></script>
    <script>
        $(document).ready(function () {
            $('#employeeTable').dataTable({
                "dom": 'lrtip',
                "lengthChange": false,
                "pageLength": 5
            });
        });
    </script>
</div>
</body>
</html>
