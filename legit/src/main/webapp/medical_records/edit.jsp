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
            <h1>Edit Medical Record Form</h1>
            <div class="main-agileinfo">
                <div class="agileits-top">
                    <form method="post">
                        <input readonly class="text" type="hidden" name="medicalRecordId"
                               value="${medicalRecord.medicalRecordId}" required="">
                        <label style="color: white; margin: 0 1em">Medical Record Code</label><input readonly
                                                                                                     class="text"
                                                                                                     type="text"
                                                                                                     name="medicalRecordId"
                                                                                                     value="${medicalRecord.medicalRecordCode}"
                                                                                                     placeholder="Medical Record Code"
                                                                                                     required="">
                        <input readonly class="text" type="hidden" name="patientId"
                               value="${medicalRecord.patient.patientId}" required="">
                        <label style="color: white; margin: 0 1em">Patient Code</label><input readonly class="text"
                                                                                              type="text"
                                                                                              name="patientCode"
                                                                                              value="${medicalRecord.patient.patientCode}"
                                                                                              placeholder="Medical Record Code"
                                                                                              required="">
                        <label style="color: white; margin: 0 1em">Patient Name</label><input class="text" type="text"
                                                                                              name="patientName"
                                                                                              value="${medicalRecord.patient.patientName}"
                                                                                              placeholder="Patient Name"
                                                                                              required="">
                        <label style="color: white; margin: 0 1em">Start Date</label><input class="text" type="date"
                                                                                            name="startDate"
                                                                                            value="${medicalRecord.startDate}"
                                                                                            placeholder="Start Date"
                                                                                            required="">
                        <br>
                        <label style="color: white; margin: 0 1em">End Date</label><input class="text" type="date"
                                                                                          name="endDate"
                                                                                          value="${medicalRecord.endDate}"
                                                                                          placeholder="End Date"
                                                                                          required="">
                        <input class="text" type="text" name="reason" value="${medicalRecord.reason}"
                               placeholder="Reason"
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
