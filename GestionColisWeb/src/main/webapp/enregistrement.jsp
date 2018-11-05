<%--
  Created by IntelliJ IDEA.
  User: mint-ra
  Date: 10/20/18
  Time: 2:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Enregistrement Colis</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="css/base.css" >
</head>
<body>

<header>
    <!-- Fixed navbar -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="home">Gestion Colis</a>
        <div class="collapse navbar-collapse" id="navbarCollapse">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="Enregistrement">Enregistrement <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="Progression">Progression</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="Suivi">Suivi</a>
                </li>
            </ul>
            <form class="form-inline mt-2 mt-md-0">
                <input class="form-control mr-sm-2" placeholder="Search Colis" aria-label="Search" type="text">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </nav>
</header>

<main role="main" class="container">
    <div class="container">
        <h2>Enregistrement d'un nouveau colis</h2>
        <form action="Enregistrement" method="post" class="form-group">
            Poids (kg): <input type="text" name="poids" placeholder="ex: 10" class="form-control">
            Valeur (euro): <input type="text" name="valeur" placeholder="ex: 20" class="form-control">
            Origine : <input type="text" name="origine" placeholder="ex: marrakech" class="form-control">
            Destination: <input type="text" name="destination" placeholder="ex: chambéry" class="form-control">
            <br/>
            <br/>
            <input class="btn btn-success" type="submit" value="Enregistrer Colis">
        </form>
    </div>
</main>

<footer class="footer">
    <div class="container">
        <spam class="text-muted"> TP Serveurs d'applications - RAFIK Abdellatif / ESTOPINAN Raphael</spam>
    </div>
</footer>

</body>
</html>
