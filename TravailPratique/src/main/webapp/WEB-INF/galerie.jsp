<%-- 
    Document   : galerie
    Created on : May 16, 2020, 10:09:37 PM
    Author     : aouattar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Galeries</title>
        <link rel="stylesheet" href="css/gallerie.css">
        <%@include file="includes/head.jsp" %>   
    </head>
    <body>
        <%@include file="includes/header.jsp" %>
        <div>
            <fieldset>
                <div class="h1_gal">
                    <h1>our workers doing what they love</h1>
                </div>

                <a href="images/download.jpg"><img class="img_gal" src="images/download.jpg" alt="costumer service"
                                                   title="costumer service"></a>
                <a href="images/images.jpg"> <img class="img_gal" src="images/images.jpg" alt="reparation center"
                                                  title="reparation center"></a>
                <a href="images/images (1).jpg"><img class="img_gal" src="images/images (1).jpg" alt="costumer service"
                                                     title="costumer service"></a>
                <a href="images/East Islip-phone repair.jpg"><img class="img_gal" src="images/East Islip-phone repair.jpg"
                                                                  alt="reparation center" title="reparation center"></a>
            </fieldset>
            <fieldset>
                <div class="h1_gal">
                    <h1>we have store in different locations</h1>
                </div>
                <a href="images/fixt_location_page_images_HBC_YongeBloor_1152x736_v01_01.jpg"><img class="img_gal"
                                                                                                   src="images/fixt_location_page_images_HBC_YongeBloor_1152x736_v01_01.jpg" alt="store"
                                                                                                   title="store"></a>
                <a href="images/012-elegant-mobile-phone-accessories-store-design-1.jpg"><img class="img_gal"
                                                                                              src="images/012-elegant-mobile-phone-accessories-store-design-1.jpg" alt="store" title="store"></a>
                <a href="images/phone-shops.jpg"><img class="img_gal" src="images/phone-shops.jpg" alt="store"
                                                      title="store"></a>
                <a href="images/Telus_Headquarters.jpg"><img id="headqua" src="images/Telus_Headquarters.jpg"
                                                             title="headquaters" alt="headquaters"></a>
            </fieldset>
            <fieldset>
                <div class="h1_gal">
                    <h1>upcoming releases</h1>
                </div>
                <a href="images/VR_4_Angled_Front_View_Low.jpg"> <img class="img_gal"
                                                                      src="images/VR_4_Angled_Front_View_Low.jpg" alt="vrss" title="vr for samsong"></a>
                <a href="images/NTOY1065_-_Angled_Jimu_UnicornBot_edited-1.jpg"> <img class="img_gal"
                                                                                      src="images/NTOY1065_-_Angled_Jimu_UnicornBot_edited-1.jpg" alt="unicorn" title="unicorn"></a>
                <a href="images/Contents_of_Kano_Harry_Potter_Wand_Kit_edited-1.jpg"> <img class="img_gal"
                                                                                           src="images/Contents_of_Kano_Harry_Potter_Wand_Kit_edited-1.jpg" alt="harry_kit"
                                                                                           title="harry potter kit"></a>
                <a href="images/grayGoggles01_copy.jpg"><img class="img_gal" src="images/grayGoggles01_copy.jpg"
                                                             alt="googleVr" title="google Vr"></a>
            </fieldset>
        </div>
        <%@include file="includes/footer.jsp" %>
    </body>
</html>
