<%-- 
    Document   : acceuil
    Created on : May 16, 2020, 6:14:16 PM
    Author     : aouattar
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Acceuil</title> 
        <link rel="stylesheet" href="css/home.css">
        <%@include file="includes/head.jsp" %>
    </head>
    <body>
        <%@include file="includes/header.jsp" %>
        <div class="wel_int">
            <h1 id="welcome"> <b>Tired of having the same old phone ?</b></h1>
            <div id="intro_txt">
                <p><b>all of our
                        selection of phones
                        are now starting at <span>0 $ </span> <br>
                        incliding Samsung and Apple,
                        if you change your plan we give you
                        <span>25 %</span> off on any accesoiries</b>
                </p>
                <div id="but_view"><a href="produitControler">View products</a></div>
            </div>
            <div id="intro_img"><a href="images/lg-g8x-ss-black-back2back-min.png"><img
                        src="images/lg-g8x-ss-black-back2back-min.png" alt="selection" width="100%"></a></div>
        </div>

        <div id="div-vid">
            <div id="txt_vid">
                <h1>Good qualities service</h1>
                <p><b>For more information you can always contact
                        us by leaving a message or visiting in stores</b></p>
            </div>
            <div id="vid">
                <video class="video" autoplay muted loop>
                    <source src="images/telus-store.mp4" type="video/mp4">
                </video>
            </div>
        </div>
        <%@include file="includes/footer.jsp" %>
    </body>
</html>
