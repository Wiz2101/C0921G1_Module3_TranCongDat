<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>.gm-err-container {
        height: 100%;
        width: 100%;
        display: table;
        background-color: #e8eaed;
        position: relative;
        left: 0;
        top: 0
    }

    .gm-err-content {
        border-radius: 1px;
        padding-top: 0;
        padding-left: 10%;
        padding-right: 10%;
        position: static;
        vertical-align: middle;
        display: table-cell
    }

    .gm-err-content a {
        color: #3c4043
    }

    .gm-err-icon {
        text-align: center
    }

    .gm-err-title {
        margin: 5px;
        margin-bottom: 20px;
        color: #3c4043;
        font-family: Roboto, Arial, sans-serif;
        text-align: center;
        font-size: 24px
    }

    .gm-err-message {
        margin: 5px;
        color: #3c4043;
        font-family: Roboto, Arial, sans-serif;
        text-align: center;
        font-size: 12px
    }

    .gm-err-autocomplete {
        padding-left: 20px;
        background-repeat: no-repeat;
        background-size: 15px 15px
    }
    </style>
    <style>.gm-style-moc {
        background-color: rgba(0, 0, 0, 0.45);
        pointer-events: none;
        text-align: center;
        transition: opacity ease-in-out
    }

    .gm-style-mot {
        color: white;
        font-family: Roboto, Arial, sans-serif;
        font-size: 22px;
        margin: 0;
        position: relative;
        top: 50%;
        transform: translateY(-50%);
        -webkit-transform: translateY(-50%);
        -ms-transform: translateY(-50%)
    }
    </style>
    <style>.gm-style img {
        max-width: none;
    }

    .gm-style {
        font: 400 11px Roboto, Arial, sans-serif;
        text-decoration: none;
    }</style>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Home | Impact By Distinctive Themes</title>
    <link href="/assets/css/bootstrap.min.css" rel="stylesheet">
    <link href="/assets/css/font-awesome.min.css" rel="stylesheet">
    <link href="/assets/css/pe-icons.css" rel="stylesheet">
    <link href="/assets/css/prettyPhoto.css" rel="stylesheet">
    <link href="/assets/css/animate.css" rel="stylesheet">
    <link href="/assets/css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="/assets/css/myself.css">
    <script src="/assets/js/jquery.js"></script>
    <!--[if lt IE 9]>
    <script src="/assets/js/html5shiv.js"></script>
    <script src="/assets/js/respond.min.js"></script>
    <![endif]-->
    <link rel="shortcut icon" href="images/ico/favicon.ico">
    <link rel="apple-touch-icon" sizes="144x144" href="images/ico/apple-touch-icon-144x144.png">
    <link rel="apple-touch-icon" sizes="114x114" href="images/ico/apple-touch-icon-114x114.png">
    <link rel="apple-touch-icon" sizes="72x72" href="images/ico/apple-touch-icon-72x72.png">
    <link rel="apple-touch-icon" href="images/ico/apple-touch-icon-57x57.png">

    <script type="text/javascript">
        jQuery(document).ready(function ($) {
            'use strict';
            jQuery('body').backstretch([
                "images/bg/bg1.jpg",
                "images/bg/bg2.jpg",
                "images/bg/bg3.jpg"
            ], {duration: 5000, fade: 500, centeredY: true});

            $("#mapwrapper").gMap({
                controls: false,
                scrollwheel: false,
                markers: [{
                    latitude: 40.7566,
                    longitude: -73.9863,
                    icon: {
                        image: "images/marker.png",
                        iconsize: [44, 44],
                        iconanchor: [12, 46],
                        infowindowanchor: [12, 0]
                    }
                }],
                icon: {
                    image: "images/marker.png",
                    iconsize: [26, 46],
                    iconanchor: [12, 46],
                    infowindowanchor: [12, 0]
                },
                latitude: 40.7566,
                longitude: -73.9863,
                zoom: 14
            });
        });
    </script>
    <script type="text/javascript" charset="UTF-8"
            src="https://maps.googleapis.com/maps-api-v3/api/js/47/3/common.js"></script>
    <script type="text/javascript" charset="UTF-8"
            src="https://maps.googleapis.com/maps-api-v3/api/js/47/3/util.js"></script>
    <script type="text/javascript" charset="UTF-8"
            src="https://maps.googleapis.com/maps-api-v3/api/js/47/3/map.js"></script>
    <script type="text/javascript" charset="UTF-8"
            src="https://maps.googleapis.com/maps-api-v3/api/js/47/3/geocoder.js"></script>
    <script type="text/javascript" charset="UTF-8"
            src="https://maps.googleapis.com/maps-api-v3/api/js/47/3/marker.js"></script>
    <script type="text/javascript" charset="UTF-8"
            src="https://maps.googleapis.com/maps-api-v3/api/js/47/3/onion.js"></script>
    <script type="text/javascript" charset="UTF-8"
            src="https://maps.googleapis.com/maps-api-v3/api/js/47/3/controls.js"></script>
</head>
<body>
<header class="navbar navbar-inverse navbar-fixed-top  opaqued" role="banner">
    <div class="container">
        <div class="navbar-header nav_logo">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <i class="fa fa-bars"></i>
            </button>
            <a class="navbar-brand" href="index.html">
                <img src="assets/images/logo/LOGO%20Killer%201.png" alt="LOGO" style="width: 45px; height: auto; filter: brightness(100%); display: inline-block"
                     class="bounce-in no-display animated bounceIn appear"><h1 style="display: inline-block">DAT TRAN</h1></a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="index.html">Home</a></li>
                <li><a href="/medical_records">Medical Records</a></li>
                <li><a href="#">Services</a></li>
                <li><a href="#">Blog</a></li>
                <li><a href="#">About Us</a></li>
                <li><a href="#">Contact</a></li>
                <li><span class="search-trigger"><i class="fa fa-search"></i></span></li>
            </ul>
        </div>
    </div>
</header>
<section id="main-slider" class="no-margin" style="height: 680px;">
    <div class="carousel slide" data-ride="carousel">
        <div class="carousel-inner">
            <div class="item active" style="background-image: url(/assets/images/hero.jpg)">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="carousel-content center centered" style="padding-top: 165px;">
                                <img src="assets/images/logo/LOGO%20Killer%201.png" alt="LOGO" width="150px" class="bounce-in no-display animated bounceIn appear"></img>
                                <br>
                                <h2 class="boxed animation animated-item-1 fade-down no-display animated fadeInDown appear">
                                    IMPOSIBLE FAIL!</h2>
                                <br>
                                <a class="btn btn-md animation bounce-in no-display animated bounceIn appear"
                                   href="#">DAT TRAN - C0921G1</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--/.item-->
        </div><!--/.carousel-inner-->
    </div><!--/.carousel-->
</section>
</body>
</html>
