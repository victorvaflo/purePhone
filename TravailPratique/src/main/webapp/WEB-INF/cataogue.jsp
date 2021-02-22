<%--
    Document   : cataogue
    Created on : May 18, 2020, 10:44:47 a.m.
    Author     : vvargasf
--%>
<%@page import="actions.ProduitAction"%>
<%@page import="entities.Produit"%>

<%
    ArrayList<Produit> produits = (ArrayList<Produit>) request.getAttribute(ProduitAction.listeDeProduit);
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Catalogue</title>
        <link rel="stylesheet" href="css/catalogue.css">
        <%@include file="includes/head.jsp" %> 
    </head>
    <body>
        <%@include file="includes/header.jsp" %>
        <div class="allProducts">
            <%for (Produit produit : produits) {%>
            <div class="product">
                <div class="pop_img">
                    <a href="images/<%=produit.getImgUrl()%>"><img src="images/<%=produit.getImgUrl()%>" title="<%=produit.getTitre()%>"></a>
                </div>
                <div class="produc_name">
                    <b><%=produit.getTitre()%></b>
                </div>
                <div class="description">
                    <hr>
                    <%=produit.getDescription()%>
                    <ul>
                        <li><a href="produitControler?idProduit=<%=produit.getIdProduit()%>"><b>View details</b></a></li>
                    </ul>
                </div>
            </div>

            <%}%>
        </div>
        <%@include file="includes/footer.jsp" %>
    </body>
</html>
