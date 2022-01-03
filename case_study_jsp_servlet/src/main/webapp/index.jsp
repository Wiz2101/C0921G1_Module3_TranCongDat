<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>$Title$</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="assets/css/style.css">
    <style>
        .sidebar li a {
            margin: 0 20px;
        }
    </style>
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
                        <a class="nav-link" href="#">Employee</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/customer">Customer</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Service</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Contract</a>
                    </li>
                </ul>
                <form class="d-flex mb-0">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                    <button hidden class="btn btn-outline-success" type="submit">Search</button>
                </form>
            </div>
        </div>
    </nav>
</div>
<div class="container-fluid">
    <div class="row col-12">
        <div class="col-3">
            <div class="d-flex flex-column flex-shrink-0 p-3 bg-light mt-2"
                 style="width: 100%; border-radius: 5px; box-shadow: 0 0 1px 1px lightgray inset">
                <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-dark text-decoration-none">
                    <svg class="bi me-2" width="40" height="32">
                        <use xlink:href="#bootstrap"></use>
                    </svg>
                    <span class="fs-4">Sidebar</span>
                </a>
                <hr>
                <ul class="nav nav-pills flex-column mb-auto">
                    <li class="nav-item">
                        <a href="#" class="nav-link active" aria-current="page">
                            <svg class="bi me-2" width="16" height="16">
                                <use xlink:href="#home"></use>
                            </svg>
                            Home
                        </a>
                    </li>
                    <li>
                        <a href="#" class="nav-link link-dark">
                            <svg class="bi me-2" width="16" height="16">
                                <use xlink:href="#speedometer2"></use>
                            </svg>
                            Dashboard
                        </a>
                    </li>
                    <li>
                        <a href="#" class="nav-link link-dark">
                            <svg class="bi me-2" width="16" height="16">
                                <use xlink:href="#table"></use>
                            </svg>
                            Orders
                        </a>
                    </li>
                    <li>
                        <a href="#" class="nav-link link-dark">
                            <svg class="bi me-2" width="16" height="16">
                                <use xlink:href="#grid"></use>
                            </svg>
                            Products
                        </a>
                    </li>
                    <li>
                        <a href="#" class="nav-link link-dark">
                            <svg class="bi me-2" width="16" height="16">
                                <use xlink:href="#people-circle"></use>
                            </svg>
                            Customers
                        </a>
                    </li>
                </ul>
                <hr>
                <div class="dropdown">
                    <a href="#" class="d-flex align-items-center link-dark text-decoration-none dropdown-toggle"
                       id="dropdownUser2" data-bs-toggle="dropdown" aria-expanded="false">
                        <img src="https://github.com/mdo.png" alt="" width="32" height="32" class="rounded-circle me-2">
                        <strong>Dat Tran</strong>
                    </a>
                    <ul class="dropdown-menu text-small shadow" aria-labelledby="dropdownUser2">
                        <li><a class="dropdown-item" href="#">New project...</a></li>
                        <li><a class="dropdown-item" href="#">Settings</a></li>
                        <li><a class="dropdown-item" href="#">Profile</a></li>
                        <li>
                            <hr class="dropdown-divider">
                        </li>
                        <li><a class="dropdown-item" href="#">Sign out</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <%--        Show Table--%>
        <div class="col-9">
            ``<form class="mt-5" action="/customer">``
                <div class="container-xl">
                    <div class="table-responsive">
                        <div class="table-wrapper">
                            <div class="table-title">
                                <div class="row">
                                    <div class="col-sm-6">
                                        <h2>Manage <b>Customers</b></h2>
                                    </div>
                                    <div class="col-sm-6">
                                        <a href="/customer?action=create" class="btn btn-success float-right mx-2"><i
                                                class="material-icons">&#xE147;</i> <span>Add New Employee</span></a>
                                        <a href="#deleteEmployeeModal" class="btn btn-danger float-right mx-2"
                                           data-toggle="modal"><i
                                                class="material-icons">&#xE15C;</i> <span>Delete</span></a>
                                    </div>
                                </div>
                            </div>
                            <table id="tableStudent" class="table table-striped table-bordered" style="width:100%">
                                <thead>
                                <tr>
                                    <th style="padding: 10px 20px">ID</th>
                                    <th style="padding: 10px 30px">Customer Type</th>
                                    <th style="padding: 10px 50px">Customer Name</th>
                                    <th style="padding: 10px 30px">Birthday</th>
                                    <th style="padding: 10px 20px">Gender</th>
                                    <th style="padding: 10px 50px">ID Card</th>
                                    <th style="padding: 10px 50px">Phone</th>
                                    <th style="padding: 10px 50px">Email</th>
                                    <th style="padding: 10px 50px">Address</th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="customerObj" items="${listCustomer}">
                                    <tr>
                                        <td><c:out value="${customerObj.customerId}"></c:out></td>
                                        <td><c:out value="${customerObj.customerTypeId}"></c:out></td>
                                        <td><c:out value="${customerObj.customerName}"></c:out></td>
                                        <td><c:out value="${customerObj.customerBirthday}"></c:out></td>
                                        <td><c:out value="${customerObj.customerGender}"></c:out></td>
                                        <td><c:out value="${customerObj.customerIdCard}"></c:out></td>
                                        <td><c:out value="${customerObj.customerPhone}"></c:out></td>
                                        <td><c:out value="${customerObj.customerEmail}"></c:out></td>
                                        <td><c:out value="${customerObj.customerAddress}"></c:out></td>
                                        <td>
                                            <a href="customer?action=edit&id=${customerObj.customerId}" class="edit"><i
                                                    class="material-icons" title="Edit"
                                                    style="color:#FFC107">&#xE254;</i></a>
                                            <a href="#deleteEmployeeModal" class="delete"><i class="material-icons"
                                                                                             title="Delete"
                                                                                             style="color: #F44336">&#xE872;</i></a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="assets/jquery/jquery-3.5.1.min.js"></script>
<script src="assets/datatables/js/jquery.dataTables.min.js"></script>
<script src="assets/datatables/js/dataTables.bootstrap4.min.js"></script>
<script>
    $(document).ready(function () {
        $('#tableStudent').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });
</script>
<footer class="d-flex flex-wrap justify-content-between align-items-center py-3 my-4 border-top">
    <div class="col-md-4 d-flex align-items-center">
        <a href="/" class="mb-3 me-2 mb-md-0 text-muted text-decoration-none lh-1">
            <svg class="bi" width="30" height="24">
                <use xlink:href="#bootstrap"></use>
            </svg>
        </a>
        <span class="text-muted">© 2021 Company, Inc</span>
    </div>

    <ul class="nav col-md-4 justify-content-end list-unstyled d-flex">
        <li class="ms-3"><a class="text-muted" href="#">
            <svg class="bi" width="24" height="24">
                <use xlink:href="#twitter"></use>
            </svg>
        </a></li>
        <li class="ms-3"><a class="text-muted" href="#">
            <svg class="bi" width="24" height="24">
                <use xlink:href="#instagram"></use>
            </svg>
        </a></li>
        <li class="ms-3"><a class="text-muted" href="#">
            <svg class="bi" width="24" height="24">
                <use xlink:href="#facebook"></use>
            </svg>
        </a></li>
    </ul>
</footer>
</body>
</html>
