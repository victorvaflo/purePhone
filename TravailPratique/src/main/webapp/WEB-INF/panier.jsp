<%-- 
    Document   : panier
    Created on : May 19, 2020, 10:17:59 PM
    Author     : aouattar
--%>

<%@page import="utils.Validation"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.Produit"%>
<%@page import="managers.ProduitManager"%>
<%@page import="actions.PanierAction"%>
<%@page import="java.util.Map"%>
<%@page import="entities.LigneComande"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    HashMap<Integer, LigneComande> listeProduitPanier = (HashMap<Integer, LigneComande>) session.getAttribute("panier");
    int nbArticle = 0;
    if (request.getAttribute(PanierAction.nbProduit) != null) {
        nbArticle = (int) request.getAttribute(PanierAction.nbProduit);
    }
    ArrayList<Produit> produitsPanier = new ArrayList<>();

    double prixTotal = 0;

    String infoCommande = (String) request.getAttribute(Validation.msgInfoCommande);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Affichage du panier</title>
        <link rel="stylesheet" href="css/panier.css">
        <%@include file="includes/head.jsp" %>
    </head>
    <body>
        <%@include file="includes/header.jsp"%>
        <h1>Vos produits ajoutes au panier</h1>

        <table>
            <%
                if (listeProduitPanier != null) {
                    for (Map.Entry<Integer, LigneComande> p : listeProduitPanier.entrySet()) {
                        int key = p.getKey();
                        LigneComande ligne = p.getValue();

                        Produit produit = ProduitManager.getProduitById(ligne.getId_produit());
                        int qteProduit = ligne.getQte_produit();

                        prixTotal += (produit.getPrix() * qteProduit);
                        request.setAttribute("prixTotal", prixTotal);
            %>


            <tr>
                <td><img src="images/<%=produit.getImgUrl()%>"/></td>
                <td><%=produit.getTitre()%></td>
                <td><%=produit.getPrix()%> $ </td>

                <td>
                    <form action="panierControler" method="post">
                        <div class="btnPlusMoins">
                            <input type="hidden" name="idProduitp" value="<%=produit.getIdProduit()%>"/>
                            <input type="submit" value="+" name="actionPanier"/>
                            <p><%=qteProduit%></p>
                            <input type="submit" value="-" name="actionPanier"/>
                        </div>
                    </form>
                </td>
            </tr>
            <% }
                } else {
                    out.print("Votre panier est vide ! ");
                }
            %>

        </table>

        <h2>Prix total : <%=prixTotal%> $</h2>

        <form action="commandeControler" method="post">
            <input type="hidden" name="prixTotal" value="<%=prixTotal%>">
            <input class="btnPasserCmd" type="submit" value="Passer la commande"/>
        </form>

        <% out.println((infoCommande == null) ? "<p></p>" : "<p>" + infoCommande + "</p>");%>

        <%@include file="includes/footer.jsp"%>
    </body>
</html>
