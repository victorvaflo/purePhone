<%-- 
    Document   : detailCommande
    Created on : May 22, 2020, 9:47:37 AM
    Author     : aouattar
--%>

<%@page import="managers.ProduitManager"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.LigneComande"%>
<%@page import="actions.LigneCommandeAction"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% ArrayList<LigneComande> ligneCommande = (ArrayList<LigneComande>) request.getAttribute(LigneCommandeAction.detailCmdAttribut);
   %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page detail Commande</title>
        <%@include file="includes/head.jsp" %>
        <link rel="stylesheet" href="css/commandes.css">
    </head>
    <body>
        <%@include file="includes/header.jsp" %>
        <h1>Detail de votre commande</h1>
        <table>
            <tr>
                <th>Produits</th>
                <th>Quantitee</th>
                <th>Prix Unitaire</th>
            </tr>

            <% for (LigneComande l : ligneCommande) {%>
            <tr>
                <td><%=ProduitManager.getProduitById(l.getId_produit()).getTitre()%></td>
                <td><%=l.getQte_produit()%></td>
                <td><%=ProduitManager.getProduitById(l.getId_produit()).getPrix()%></td>
            </tr>
            <%}%>
        </table>


        <%@include file="includes/footer.jsp" %>
    </body>
</html>
