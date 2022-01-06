<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../assets/style.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.0/css/bootstrapValidator.min.css">
    <style>
        #success_message {
            display: none;
        }

        .gender_option {
            margin: 0 20px;
        }
    </style>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"
            type="text/javascript"></script>


</head>
<body>
<div class="container">

    <form class="well form-horizontal" method="post" id="contact_form">
        <fieldset>

            <!-- Form Name -->
            <legend>
                <center><h2><b>Edit Form</b></h2></center>
            </legend>
            <br>

            <%--Update ID--%>
            <div class="form-group">
                <label class="col-md-4 control-label">Customer ID</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input readonly name="id" value="${customerById.customerId}" class="form-control" type="text">
                    </div>
                </div>
            </div>

            <!-- Input ID Name-->

            <div class="form-group">
                <label class="col-md-4 control-label">ID Name</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input name="customerIdName" value="${customerById.customerIdName}" placeholder="KH-XXXXX [X:0-9]" class="form-control" type="text">
                        <span style="color: darkred">${customerIdName}</span>
                    </div>
                </div>
            </div>

            <!-- Input Name-->

            <div class="form-group">
                <label class="col-md-4 control-label">Full Name</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input name="fullName" value="${customerById.customerName}" placeholder="Full Name"
                               class="form-control" type="text">
                    </div>
                </div>
            </div>

            <!-- Input Date of Birth-->

            <div class="form-group">
                <label class="col-md-4 control-label">Date of Birth</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                        <input name="dateOfBirth" value="${customerById.customerBirthday}" class="form-control"
                               type="date">
                    </div>
                </div>
            </div>

            <%--Input Gender--%>

            <div class="form-group">
                <label class="col-md-4 control-label">Gender</label>
                <div class="col-md-4 selectContainer">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
                        <c:if test="${customerById.customerGender == 0}">
                            <input type="radio" name="gender" value="1" style="margin: 20px" class="gender_option">Male
                            <input type="radio" name="gender" value="0" style="margin: 20px" class="gender_option" checked>Female
                        </c:if>
                        <c:if test="${customerById.customerGender == 1}">
                            <input type="radio" name="gender" value="1" style="margin: 20px" class="gender_option" checked>Male
                            <input type="radio" name="gender" value="0" style="margin: 20px" class="gender_option">Female
                        </c:if>
                    </div>
                </div>
            </div>

            <!-- Input Customer Type-->

            <div class="form-group">
                <label class="col-md-4 control-label">Customer Types</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-barcode"></i></span>
                        <select name="customerType" class="form-control">
                            <option selected value="${customerById.customerType.customerTypeId}">${customerById.customerType.customerTypeName}</option>
                            <c:forEach var="customerTypeList" items="${customerTypeList}">
                                <option value="${customerTypeList.customerTypeId}">${customerTypeList.customerTypeName}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            </div>

            <%--Input idCard--%>

            <div class="form-group">
                <label class="col-md-4 control-label">ID Card Number</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-barcode"></i></span>
                        <input name="idCard" value="${customerById.customerIdCard}" placeholder="ID Card No." class="form-control" type="text">
                    </div>
                </div>
            </div>

            <!-- Input Phone Number-->

            <div class="form-group">
                <label class="col-md-4 control-label">Phone Number</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-earphone"></i></span>
                        <input name="phoneNum" value="${customerById.customerPhone}" placeholder="Phone No." class="form-control" type="text">
                    </div>
                </div>
            </div>

            <!-- Input Email-->

            <div class="form-group">
                <label class="col-md-4 control-label">Email Address</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
                        <input name="email" value="${customerById.customerEmail}" placeholder="Email Address" class="form-control"
                               type="text">
                    </div>
                </div>
            </div>

            <!-- Input Address-->
            <div class="form-group">
                <label class="col-md-4 control-label">Address</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
                        <input name="address" value="${customerById.customerAddress}" placeholder="Address" class="form-control" type="text">
                    </div>
                </div>
            </div>

            <!-- Select Basic -->

            <!-- Success message -->
            <div class="alert alert-success" role="alert" id="success_message">Success <i
                    class="glyphicon glyphicon-thumbs-up"></i> Success!.
            </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label"></label>
                <div class="col-md-4"><br>
                    &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                    <button type="submit" class="btn btn-warning">SUBMIT <span
                            class="glyphicon glyphicon-send"></span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                    </button>
                </div>
            </div>

        </fieldset>
    </form>
</div>
<script>
    $(document).ready(function () {
        $('#contact_form').bootstrapValidator({
            // To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                first_name: {
                    validators: {
                        stringLength: {
                            min: 2,
                        },
                        notEmpty: {
                            message: 'Please enter your First Name'
                        }
                    }
                },
                last_name: {
                    validators: {
                        stringLength: {
                            min: 2,
                        },
                        notEmpty: {
                            message: 'Please enter your Last Name'
                        }
                    }
                },
                user_name: {
                    validators: {
                        stringLength: {
                            min: 8,
                        },
                        notEmpty: {
                            message: 'Please enter your Username'
                        }
                    }
                },
                user_password: {
                    validators: {
                        stringLength: {
                            min: 8,
                        },
                        notEmpty: {
                            message: 'Please enter your Password'
                        }
                    }
                },
                confirm_password: {
                    validators: {
                        stringLength: {
                            min: 8,
                        },
                        notEmpty: {
                            message: 'Please confirm your Password'
                        }
                    }
                },
                email: {
                    validators: {
                        notEmpty: {
                            message: 'Please enter your Email Address'
                        },
                        emailAddress: {
                            message: 'Please enter a valid Email Address'
                        }
                    }
                },
                contact_no: {
                    validators: {
                        stringLength: {
                            min: 12,
                            max: 12,
                            notEmpty: {
                                message: 'Please enter your Contact No.'
                            }
                        }
                    },
                    department: {
                        validators: {
                            notEmpty: {
                                message: 'Please select your Department/Office'
                            }
                        }
                    },
                }
            }
        })
            .on('success.form.bv', function (e) {
                $('#success_message').slideDown({opacity: "show"}, "slow") // Do something ...
                $('#contact_form').data('bootstrapValidator').resetForm();

                // Prevent form submission
                e.preventDefault();

                // Get the form instance
                var $form = $(e.target);

                // Get the BootstrapValidator instance
                var bv = $form.data('bootstrapValidator');

                // Use Ajax to submit form data
                $.post($form.attr('action'), $form.serialize(), function (result) {
                    console.log(result);
                }, 'json');
            });
    });
</script>
</body>
</html>
