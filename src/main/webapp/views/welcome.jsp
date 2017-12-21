<%@ page import="kz.iitu.StudentsDataApp.model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="kz.iitu.StudentsDataApp.model.Faculty" %>
<%@ page import="kz.iitu.StudentsDataApp.model.Specialty" %>
<%@ page import="kz.iitu.StudentsDataApp.model.EducationHistory" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Sign in</title>

    <!-- Bootstrap core CSS -->
    <link href="${contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="${contextPath}/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template -->
    <link href="${contextPath}/resources/css/freelancer.min.css" rel="stylesheet">

</head>


    <%
        User user = (User)session.getAttribute("userData");
        List <EducationHistory> ehs = (List <EducationHistory>)request.getAttribute("education_histories");
    %>

<body id="page-top">

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
    <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="#page-top">WELCOME PAGE</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            Menu
            <i class="fa fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item" style="color:white;">
                    <% out.print(user.getUsername());%>
                </li>
                <li class="nav-item">
                    <a class="nav-link js-scroll-trigger" href="/logout">Logout</a>
                </li>
            </ul>
        </div>
    </div>
</nav>




<!-- Contact Section -->
<section id="contact">
    <div class="container">
        <h2 class="text-center">Student Information</h2>
        <hr class="star-primary">
        <div class="row">
            <div class="col-lg-8 mx-auto">
                <!-- To configure the contact form email address, go to mail/contact_me.php and update the email address in the PHP file on line 19. -->
                <!-- The form should work on most web servers, but if the form is not working you may need to configure your web server differently. -->



                <form action="/adduser" method="post">
                    <table>
                        <div class="control-group">
                            <div class="form-group floating-label-form-group controls">
                                <tr>
                                    <td>USERNAME : </td>
                                    <td><%out.print(user.getUsername());%></td>
                                </tr>
                            </div>
                        </div>
                        <div class="control-group">
                            <div class="form-group floating-label-form-group controls">
                                <tr>
                                    <td>PASSWORD : </td>
                                    <td><%out.print(user.getPassword());%></td>
                                </tr>
                            </div>
                        </div>
                        <div class="control-group">
                            <div class="form-group floating-label-form-group controls">
                                <tr>
                                    <td>FIRST NAME : </td>
                                    <td><%out.print(user.getFname());%></td>
                                </tr>
                            </div>
                        </div>
                        <div class="control-group">
                            <div class="form-group floating-label-form-group controls">
                                <tr>
                                    <td>LAST NAME : </td>
                                    <td><%out.print(user.getLname());%></td>
                                </tr>
                            </div>
                        </div>
                        <div class="control-group">
                            <div class="form-group floating-label-form-group controls">
                                <tr>
                                    <td>Specialty name: </td>
                                    <td><%out.print(user.getSpecialty().getName());%></td>
                                </tr>
                            </div>
                        </div>
                        <div class="control-group">
                            <div class="form-group floating-label-form-group controls">
                                <tr>
                                    <td><a href="/update?student_username=<%out.print(user.getUsername());%>">update</a> </td>
                                </tr>
                                <tr>
                                    <td><a href="/delete?student_username=<%out.print(user.getUsername());%>">delete</a> </td>
                                </tr>
                            </div>
                        </div>

                    </table>

                    <br>

                    <div id="success"></div>

                </form>
            </div>
        </div>
    </div>

    <h2 class="text-center">Education History</h2>
    <div align="center">
        <table style="border-style:solid;border-width: 1px;border-color:black;">

            <tr>
                <th style="border-style:solid;border-width: 1px;border-color:black;">
                    Education Place
                </th>
                <th style="border-style:solid;border-width: 1px;border-color:black;">
                    During Tinme
                </th>
                <th style="border-style:solid;border-width: 1px;border-color:black;">
                    Address
                </th>
                <th style="border-style:solid;border-width: 1px;border-color:black;">
                    Student Username
                </th>
                <th style="border-style:solid;border-width: 1px;border-color:black;">
                    To Delete
                </th>
            </tr>
            <%



                if(ehs!=null){

                    for (EducationHistory eh : ehs){

            %>
            <tr>
                <td style="border-style:solid;border-width: 1px;border-color:black;">
                    <% out.print(eh.getEducationPlace());%>
                </td>
                <td style="border-style:solid;border-width: 1px;border-color:black;">
                    <% out.print(eh.getDuringTime());%>
                </td>
                <td style="border-style:solid;border-width: 1px;border-color:black;">
                    <% out.print(eh.getAddress());%>
                </td>
                <td style="border-style:solid;border-width: 1px;border-color:black;">
                    <% out.print(eh.getStudent().getUsername());%>
                </td>
                <td style="border-style:solid;border-width: 1px;border-color:black;">
                    <a href="/deleteEh?eh_id=<%out.print(eh.getId());%>">delete</a>
                </td>

            </tr>

            <%
                    }

                }

            %>

        </table>
    </div>
    <br><br><br><br>

    <div class="container">
        <h2 class="text-center">Add Education History</h2>
        <hr class="star-primary">
        <div class="row">
            <div class="col-lg-8 mx-auto">
                <!-- To configure the contact form email address, go to mail/contact_me.php and update the email address in the PHP file on line 19. -->
                <!-- The form should work on most web servers, but if the form is not working you may need to configure your web server differently. -->



                <form action="/addeh" method="post">
                    <table>
                        <div class="control-group">
                            <div class="form-group floating-label-form-group controls">
                                <tr>
                                    <td>Educated Place Name : </td>
                                    <td><input type="text" name="educated_place_name"></td>
                                </tr>
                            </div>
                        </div>
                        <div class="control-group">
                            <div class="form-group floating-label-form-group controls">
                                <tr>
                                    <td>Duration of education : </td>
                                    <td><input type="text" name="durating_time"></td>
                                </tr>
                            </div>
                        </div>
                        <div class="control-group">
                            <div class="form-group floating-label-form-group controls">
                                <tr>
                                    <td>Address : </td>
                                    <td><input type="text" name="address"></td>
                                </tr>
                            </div>
                        </div>



                    </table>

                    <br>


                    <div class="form-group">
                        <input type="submit" class="btn btn-success btn-lg" id="sendMessageButton" value="Submit">
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>




<!-- Footer -->
<footer class="text-center">
    <div class="footer-above">
        <div class="container">
            <div class="row">
                <div class="footer-col col-md-4">
                    <h3>Location</h3>
                    <p>3481 Melrose Place
                        <br>Beverly Hills, CA 90210</p>
                </div>
                <div class="footer-col col-md-4">
                    <h3>Around the Web</h3>
                    <ul class="list-inline">
                        <li class="list-inline-item">
                            <a class="btn-social btn-outline" href="#">
                                <i class="fa fa-fw fa-facebook"></i>
                            </a>
                        </li>
                        <li class="list-inline-item">
                            <a class="btn-social btn-outline" href="#">
                                <i class="fa fa-fw fa-google-plus"></i>
                            </a>
                        </li>
                        <li class="list-inline-item">
                            <a class="btn-social btn-outline" href="#">
                                <i class="fa fa-fw fa-twitter"></i>
                            </a>
                        </li>
                        <li class="list-inline-item">
                            <a class="btn-social btn-outline" href="#">
                                <i class="fa fa-fw fa-linkedin"></i>
                            </a>
                        </li>
                        <li class="list-inline-item">
                            <a class="btn-social btn-outline" href="#">
                                <i class="fa fa-fw fa-dribbble"></i>
                            </a>
                        </li>
                    </ul>
                </div>
                <div class="footer-col col-md-4">
                    <h3>About Freelancer</h3>
                    <p>Freelance is a free to use, open source Bootstrap theme created by
                        <a href="http://startbootstrap.com">Start Bootstrap</a>.</p>
                </div>
            </div>
        </div>
    </div>
    <div class="footer-below">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    Copyright &copy; Your Website 2017
                </div>
            </div>
        </div>
    </div>
</footer>

<!-- Scroll to Top Button (Only visible on small and extra-small screen sizes) -->
<div class="scroll-top d-lg-none">
    <a class="btn btn-primary js-scroll-trigger" href="#page-top">
        <i class="fa fa-chevron-up"></i>
    </a>
</div>

<!-- Portfolio Modals -->
<div class="portfolio-modal modal fade" id="portfolioModal1" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="close-modal" data-dismiss="modal">
                <div class="lr">
                    <div class="rl"></div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 mx-auto">
                        <div class="modal-body">
                            <h2>Project Title</h2>
                            <hr class="star-primary">
                            <img class="img-fluid img-centered" src="img/portfolio/cabin.png" alt="">
                            <p>Use this area of the page to describe your project. The icon above is part of a free icon set by
                                <a href="https://sellfy.com/p/8Q9P/jV3VZ/">Flat Icons</a>. On their website, you can download their free set with 16 icons, or you can purchase the entire set with 146 icons for only $12!</p>
                            <ul class="list-inline item-details">
                                <li>Client:
                                    <strong>
                                        <a href="http://startbootstrap.com">Start Bootstrap</a>
                                    </strong>
                                </li>
                                <li>Date:
                                    <strong>
                                        <a href="http://startbootstrap.com">April 2014</a>
                                    </strong>
                                </li>
                                <li>Service:
                                    <strong>
                                        <a href="http://startbootstrap.com">Web Development</a>
                                    </strong>
                                </li>
                            </ul>
                            <button class="btn btn-success" type="button" data-dismiss="modal">
                                <i class="fa fa-times"></i>
                                Close</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="portfolio-modal modal fade" id="portfolioModal2" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="close-modal" data-dismiss="modal">
                <div class="lr">
                    <div class="rl"></div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 mx-auto">
                        <div class="modal-body">
                            <h2>Project Title</h2>
                            <hr class="star-primary">
                            <img class="img-fluid img-centered" src="img/portfolio/cake.png" alt="">
                            <p>Use this area of the page to describe your project. The icon above is part of a free icon set by
                                <a href="https://sellfy.com/p/8Q9P/jV3VZ/">Flat Icons</a>. On their website, you can download their free set with 16 icons, or you can purchase the entire set with 146 icons for only $12!</p>
                            <ul class="list-inline item-details">
                                <li>Client:
                                    <strong>
                                        <a href="http://startbootstrap.com">Start Bootstrap</a>
                                    </strong>
                                </li>
                                <li>Date:
                                    <strong>
                                        <a href="http://startbootstrap.com">April 2014</a>
                                    </strong>
                                </li>
                                <li>Service:
                                    <strong>
                                        <a href="http://startbootstrap.com">Web Development</a>
                                    </strong>
                                </li>
                            </ul>
                            <button class="btn btn-success" type="button" data-dismiss="modal">
                                <i class="fa fa-times"></i>
                                Close</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="portfolio-modal modal fade" id="portfolioModal3" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="close-modal" data-dismiss="modal">
                <div class="lr">
                    <div class="rl"></div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 mx-auto">
                        <div class="modal-body">
                            <h2>Project Title</h2>
                            <hr class="star-primary">
                            <img class="img-fluid img-centered" src="img/portfolio/circus.png" alt="">
                            <p>Use this area of the page to describe your project. The icon above is part of a free icon set by
                                <a href="https://sellfy.com/p/8Q9P/jV3VZ/">Flat Icons</a>. On their website, you can download their free set with 16 icons, or you can purchase the entire set with 146 icons for only $12!</p>
                            <ul class="list-inline item-details">
                                <li>Client:
                                    <strong>
                                        <a href="http://startbootstrap.com">Start Bootstrap</a>
                                    </strong>
                                </li>
                                <li>Date:
                                    <strong>
                                        <a href="http://startbootstrap.com">April 2014</a>
                                    </strong>
                                </li>
                                <li>Service:
                                    <strong>
                                        <a href="http://startbootstrap.com">Web Development</a>
                                    </strong>
                                </li>
                            </ul>
                            <button class="btn btn-success" type="button" data-dismiss="modal">
                                <i class="fa fa-times"></i>
                                Close</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="portfolio-modal modal fade" id="portfolioModal4" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="close-modal" data-dismiss="modal">
                <div class="lr">
                    <div class="rl"></div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 mx-auto">
                        <div class="modal-body">
                            <h2>Project Title</h2>
                            <hr class="star-primary">
                            <img class="img-fluid img-centered" src="img/portfolio/game.png" alt="">
                            <p>Use this area of the page to describe your project. The icon above is part of a free icon set by
                                <a href="https://sellfy.com/p/8Q9P/jV3VZ/">Flat Icons</a>. On their website, you can download their free set with 16 icons, or you can purchase the entire set with 146 icons for only $12!</p>
                            <ul class="list-inline item-details">
                                <li>Client:
                                    <strong>
                                        <a href="http://startbootstrap.com">Start Bootstrap</a>
                                    </strong>
                                </li>
                                <li>Date:
                                    <strong>
                                        <a href="http://startbootstrap.com">April 2014</a>
                                    </strong>
                                </li>
                                <li>Service:
                                    <strong>
                                        <a href="http://startbootstrap.com">Web Development</a>
                                    </strong>
                                </li>
                            </ul>
                            <button class="btn btn-success" type="button" data-dismiss="modal">
                                <i class="fa fa-times"></i>
                                Close</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="portfolio-modal modal fade" id="portfolioModal5" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="close-modal" data-dismiss="modal">
                <div class="lr">
                    <div class="rl"></div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 mx-auto">
                        <div class="modal-body">
                            <h2>Project Title</h2>
                            <hr class="star-primary">
                            <img class="img-fluid img-centered" src="img/portfolio/safe.png" alt="">
                            <p>Use this area of the page to describe your project. The icon above is part of a free icon set by
                                <a href="https://sellfy.com/p/8Q9P/jV3VZ/">Flat Icons</a>. On their website, you can download their free set with 16 icons, or you can purchase the entire set with 146 icons for only $12!</p>
                            <ul class="list-inline item-details">
                                <li>Client:
                                    <strong>
                                        <a href="http://startbootstrap.com">Start Bootstrap</a>
                                    </strong>
                                </li>
                                <li>Date:
                                    <strong>
                                        <a href="http://startbootstrap.com">April 2014</a>
                                    </strong>
                                </li>
                                <li>Service:
                                    <strong>
                                        <a href="http://startbootstrap.com">Web Development</a>
                                    </strong>
                                </li>
                            </ul>
                            <button class="btn btn-success" type="button" data-dismiss="modal">
                                <i class="fa fa-times"></i>
                                Close</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="portfolio-modal modal fade" id="portfolioModal6" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="close-modal" data-dismiss="modal">
                <div class="lr">
                    <div class="rl"></div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 mx-auto">
                        <div class="modal-body">
                            <h2>Project Title</h2>
                            <hr class="star-primary">
                            <img class="img-fluid img-centered" src="img/portfolio/submarine.png" alt="">
                            <p>Use this area of the page to describe your project. The icon above is part of a free icon set by
                                <a href="https://sellfy.com/p/8Q9P/jV3VZ/">Flat Icons</a>. On their website, you can download their free set with 16 icons, or you can purchase the entire set with 146 icons for only $12!</p>
                            <ul class="list-inline item-details">
                                <li>Client:
                                    <strong>
                                        <a href="http://startbootstrap.com">Start Bootstrap</a>
                                    </strong>
                                </li>
                                <li>Date:
                                    <strong>
                                        <a href="http://startbootstrap.com">April 2014</a>
                                    </strong>
                                </li>
                                <li>Service:
                                    <strong>
                                        <a href="http://startbootstrap.com">Web Development</a>
                                    </strong>
                                </li>
                            </ul>
                            <button class="btn btn-success" type="button" data-dismiss="modal">
                                <i class="fa fa-times"></i>
                                Close</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap core JavaScript -->
<script src="${contextPath}/resources/vendor/jquery/jquery.min.js"></script>
<script src="${contextPath}/resources/vendor/popper/popper.min.js"></script>
<script src="${contextPath}/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

<!-- Plugin JavaScript -->
<script src="${contextPath}/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Contact Form JavaScript -->
<script src="${contextPath}/resources/js/jqBootstrapValidation.js"></script>
<script src="${contextPath}/resources/js/contact_me.js"></script>

<!-- Custom scripts for this template -->
<script src="${contextPath}/resources/js/freelancer.min.js"></script>

</body>

</html>


