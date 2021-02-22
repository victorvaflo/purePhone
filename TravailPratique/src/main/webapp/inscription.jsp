<%-- 
    Document   : inscription
    Created on : May 17, 2020, 9:19:55 AM
    Author     : aouattar
--%>

<%@page import="utils.Validation"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String msgErrorNom = (String) request.getAttribute(Validation.errorNomAttribut);
    String msgErrorPrenom = (String) request.getAttribute(Validation.errorPrenomAttribut);
    String msgErrorEmail = (String) request.getAttribute(Validation.errorEmailAttribute);
    String msgErrorMdp = (String) request.getAttribute(Validation.errorMdpAttribut);
    String msgInscriptionOk = (String) request.getAttribute(Validation.inscriptionReussie);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page d'inscription</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/inscription.css">

    </head>
    <body>
        <form action="insciptionControler" method="get">
            <h2>Formulaire d'inscription</h2>

            <div class="input-container">
                <i class="fa fa-user icon"></i>
                <input class="input-field" type="text" placeholder="Nom" name="nom"><br>
                <% out.println((msgErrorNom == null) ? "<p></p>" : "<p>" + msgErrorNom + "</p>"); %>
            </div>

            <div class="input-container">
                <i class="fa fa-user icon"></i>
                <input class="input-field" type="text" placeholder="Prenom" name="prenom"><br>
                <% out.println((msgErrorPrenom == null) ? "<p></p>" : "<p>" + msgErrorPrenom + "</p>"); %>
            </div>

            <div class="input-container">
                <i class="fa fa-envelope icon"></i>
                <input class="input-field" type="email" placeholder="Email" name="email"><br>
                <% out.println((msgErrorEmail == null) ? "<p></p>" : "<p>" + msgErrorEmail + "</p>"); %>
            </div>

            <div class="input-container">
                <i class="fa fa-key icon"></i>
                <input class="input-field" type="password" placeholder="Mot de passe" name="mdp"><br>
                <% out.println((msgErrorMdp == null) ? "<p></p>" : "<p>" + msgErrorMdp + "</p>"); %>

            </div>

            <div class="input-container">
                <i class="fa fa-key icon"></i>
                <input class="input-field" type="password" placeholder="Mot de passe" name="mdp2"><br>
                <% out.println((msgErrorMdp == null) ? "<p></p>" : "<p>" + msgErrorMdp + "</p>"); %>
            </div>
            <input type="submit" class="btn" value="Inscription"/>
        </form>
        <% out.println((msgInscriptionOk == null) ? "<p></p>" : "<p>" + msgInscriptionOk + "</p>");%>
    </body>
</html>
