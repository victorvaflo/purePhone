<%-- 
    Document   : commandes
    Created on : May 22, 2020, 12:06:06 AM
    Author     : aouattar
--%>

<%@page import="actions.ClientAction"%>
<%@page import="entities.Client"%>
<%@page import="entities.Commande"%>
<%@page import="actions.CommandeAction"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% ArrayList<Commande> listeCommandeClient = (ArrayList<Commande>) request.getAttribute(CommandeAction.listeCommandeClientAttr);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste des commandes</title>
        <%@include file="includes/head.jsp" %>
        <link rel="stylesheet" href="css/commandes.css">
    </head>
    <body>
        <%@include file="includes/header.jsp" %>
        <h1>Vos commandes</h1>
        <table>
            <tr>
                <th>Numero de la commande</th>
                <th>Date de la commande</th>
                <th>Prix total de la commande</th>
            </tr>
            <% if (listeCommandeClient != null) {
                    for (Commande c : listeCommandeClient) {%>
            <tr>
                <td><a href="ligneCommandeControler?detailCmd=<%=c.getId_commande()%>"><%=c.getId_commande()%></a></td>
                <td><%=c.getDate_commande()%></td>
                <td><%=c.getPrix_total_commande()%></td>
            </tr>
            <% }
                   }%>
        </table>

        <%@include file="includes/footer.jsp" %>
    </body>
</html>
