<%-- 
    Document   : detail_produit
    Created on : May 19, 2020, 10:43:44 AM
    Author     : aouattar
--%>

<%@page import="managers.CategorieManager"%>
<%@page import="actions.ProduitAction"%>
<%@page import="entities.Produit"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Produit produit = (Produit) request.getAttribute(ProduitAction.produitAttribut);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detail du produit</title>
        <link rel="stylesheet" href="css/produit.css">
        <%@include file="includes/head.jsp" %> 
    </head>
    <body>
        <%@include file="includes/header.jsp" %>

        <div class="product_box">
            <h1><b><%=produit.getTitre()%></b></h1>
            <div class="phone_display">
                <a href="images/<%=produit.getImgUrl()%>"><img src="images/<%=produit.getImgUrl()%>" alt="image de <%=produit.getTitre()%>" width="100%"></a>
            </div>
            <div class="phone_options">
                <div class="color_options">
                    <h2><b>Couleur :</b><%=produit.getCouleur()%></h2>
                    <div class="checkmark"></div>
                </div>
                <hr>
                <div class="color_options">
                    <h2><b>Stockage :</b> &nbsp; <%= produit.getStokage()%> GB</h2>
                    <div class="storage"> <b><%=produit.getStokage()%> GB </b></div>
                </div>
                <hr>
                <div class="color_options">
                    <div class="price_full">
                        Prix <br>
                        <div class="price_txt1">
                            <%=produit.getPrix()%><sup>$</sup>
                        </div>
                    </div>
                    <div class="price_plan">
                        <b> Marque </b><br>
                        <div class="price_txt2">
                            <%=CategorieManager.getCategorieName(produit.getIdCategorie()) %>
                        </div>
                    </div>
                </div>
                <hr>
                <div class="color_options">
                    <h2><b>Description </b></h2>
                </div>
                <p class="inclu">
                    <%=produit.getDescription()%>
                </p>
                
                <a class="btnAjouter" href="panierControler?idProduit=<%=produit.getIdProduit()%>"><button>Ajouter au panier</button></a>    
            </div>
            
        </div>
                
        

        <%@include file="includes/footer.jsp" %>
    </body>
</html>
