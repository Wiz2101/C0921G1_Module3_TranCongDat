<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../assets/css/myself.css">
</head>
<body>
<div class="container-fluid">
    <div class="background"
         style="background-image: url('https://www.teahub.io/photos/full/26-266228_wallpaper-sunset-forest-minimal-4k-8k-nature-minimalist.jpg')">
        <div class="main-w3layouts wrapper">
            <h1>Create Medical Record Form</h1>
            <div class="main-agileinfo">
                <div class="agileits-top">
                    <form method="post">
                        <label style="color: white; margin: 0 1em">Medical Record Code</label><input class="text" type="text" name="medicalRecordCode" placeholder="Medical Record Code" required="">
                        <label style="color: white; margin: 0 1em">Patient Name</label><input class="text" type="text" name="patientName" placeholder="Patient Name" required="">
                        <label style="color: white; margin: 0 1em">Patient Code</label><input class="text" type="text" name="patientCode" placeholder="Patient Code" required="">
                        <label style="color: white; margin: 0 1em">Start Date</label><input class="text form-control" type="date" name="startDate" placeholder="Start Date" required="">
                        <br>
                        <label style="color: white; margin: 0 1em">End Date</label><input class="text form-control" type="date" name="endDate" placeholder="End Date" required="">
                        <input class="text" type="text" name="reason" placeholder="Reason"
                               required="">
                        <input type="submit" value="SUBMIT">
                    </form>
                </div>
            </div>
            <!-- copyright -->
            <div class="colorlibcopy-agile">
                <p>© 2021 Dat Tran | CodeGym </p>
            </div>
        </div>
    </div>
</div>
<script type="application/x-javascript">
    addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);

    function hideURLbar() {
        window.scrollTo(0, 1);
    }
</script>
</body>
</html>
