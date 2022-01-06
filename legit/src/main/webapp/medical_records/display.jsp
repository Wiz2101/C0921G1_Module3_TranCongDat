<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Medical Records</title>
    <%--    DataTables 1.10.21 support bootstrap <= 4.1.3--%>
    <link rel="stylesheet" href="bootstrap413/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap4.min.css"/>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js">
    <link rel="stylesheet" href="../assets/css/myself.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-md navbar-light bg-dark">

    <a class="navbar-brand" href="/medical_records?action=home">

        <h1 style="font-size: 20px; color: white"><img src="../assets/images/logo/LOGO%20Killer%201.png" alt="LOGO"
                                                       style="width:50px; margin-top: 8px"
                                                       class="bounce-in no-display animated bounceIn appear">DAT TRAN
        </h1></a>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav ml-auto py-4 py-md-0">
            <li class="nav-item pl-4 pl-md-0 ml-0 ml-md-4 active">
                <a class="nav-link text-white" href="/home" role="button">Home</a>
            </li>
            <li class="nav-item pl-4 pl-md-0 ml-0 ml-md-4">
                <a class="nav-link text-white" href="/medical_records">Medical Records</a>
            </li>
            <li class="nav-item pl-4 pl-md-0 ml-0 ml-md-4">
                <a class="nav-link text-white" href="#">Agency</a>
            </li>
            <li class="nav-item pl-4 pl-md-0 ml-0 ml-md-4">
                <a class="nav-link text-white" href="#" role="button">Services</a>
            </li>
            <li class="nav-item pl-4 pl-md-0 ml-0 ml-md-4">
                <a class="nav-link text-white" href="#">Journal</a>
            </li>
            <li class="nav-item pl-4 pl-md-0 ml-0 ml-md-4">
                <a class="nav-link text-white" href="#">Contact</a>
            </li>
        </ul>
    </div>

</nav>
<div class="container-fluid mt-4">
    <div class="row">
        <div class="table-title col-lg-12">
            <div class="row col-lg-12">
                <div class="col-lg-6">
                    <h2>Manage <b>Medical Records</b></h2>
                </div>
                <div class="col-lg-6">
                    <a href="/medical_records?action=create" class="btn btn-success"><i
                            class="material-icons"></i> <span>Add New Employee</span></a>
                    <a href="#deleteEmployeeModal" class="btn btn-danger" data-toggle="modal"><i
                            class="material-icons"></i> <span>Delete</span></a>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="container-fluid">
    <table id="tableMedicalRecord" class="table table-striped table-bordered" style="width:100%">
        <thead>
        <tr>
            <th>ID</th>
            <th>Medical Record Code</th>
            <th>Patient Name</th>
            <th>Start Date</th>
            <th>End Date</th>
            <th>Reason</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="medicalRecordslList" items="${medicalRecordslList}">
            <tr>
                <td><c:out value="${medicalRecordslList.medicalRecordId}"></c:out></td>
                <td><c:out value="${medicalRecordslList.medicalRecordCode}"></c:out></td>
                <td><c:out value="${medicalRecordslList.patient.patientName}"></c:out></td>
                <td><c:out value="${medicalRecordslList.startDate}"></c:out></td>
                <td><c:out value="${medicalRecordslList.endDate}"></c:out></td>
                <td><c:out value="${medicalRecordslList.reason}"></c:out></td>
                <td>
                    <a href="/medical_records?action=edit&id=${medicalRecordslList.medicalRecordId}" class="edit"><i class="material-icons"
                                                                                     data-toggle="tooltip"
                                                                                     title=""
                                                                                     data-original-title="Edit"></i></a>
                    <a href="/medical_records?action=delete&id=${medicalRecordslList.medicalRecordId}" class="delete" data-toggle="modal" data-target="#deleteModal-${medicalRecordslList.medicalRecordId}"><i class="material-icons"
                                                                                         data-toggle="tooltip"
                                                                                         title=""
                                                                                         data-original-title="Delete"></i></a>
                </td>
            </tr>
            <!-- Modal -->
            <div class="modal fade" id="deleteModal-${medicalRecordslList.medicalRecordId}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">DELETE WARNING</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            Are you sure to remove the customer with ID: ${medicalRecordslList.medicalRecordId} & Name: ${medicalRecordslList.medicalRecordCode}?
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                            <a href="/medical_records?action=delete&id=${medicalRecordslList.medicalRecordId}" class="delete"><button type="button" class="btn btn-primary">Delete Now</button></a>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
        </tbody>
    </table>
</div>

<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap4.min.js"></script>
<script>
    $(document).ready(function () {
        $('#tableMedicalRecord').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });
</script>
<script>
    (function ($) {
        "use strict";

        $(function () {
            var header = $(".start-style");
            $(window).scroll(function () {
                var scroll = $(window).scrollTop();

                if (scroll >= 10) {
                    header.removeClass('start-style').addClass("scroll-on");
                } else {
                    header.removeClass("scroll-on").addClass('start-style');
                }
            });
        });

        //Animation

        $(document).ready(function () {
            $('body.hero-anime').removeClass('hero-anime');
        });

        //Menu On Hover

        $('body').on('mouseenter mouseleave', '.nav-item', function (e) {
            if ($(window).width() > 750) {
                var _d = $(e.target).closest('.nav-item');
                _d.addClass('show');
                setTimeout(function () {
                    _d[_d.is(':hover') ? 'addClass' : 'removeClass']('show');
                }, 1);
            }
        });

        //Switch light/dark

        $("#switch").on('click', function () {
            if ($("body").hasClass("dark")) {
                $("body").removeClass("dark");
                $("#switch").removeClass("switched");
            } else {
                $("body").addClass("dark");
                $("#switch").addClass("switched");
            }
        });

    })(jQuery);
</script>
</body>
</html>
