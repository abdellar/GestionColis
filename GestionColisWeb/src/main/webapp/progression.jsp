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
    <title>Progression</title>
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
                <li class="nav-item">
                    <a class="nav-link" href="Enregistrement">Enregistrement</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="Progression">Progression <span class="sr-only">(current)</span></a>
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

    <c:choose>
        <c:when test = "${colis == null}">
            <h3>Entrer le code colis</h3>
            <form action="Progression" method="get" class="form-group">
                <input name="unique_id" placeholder="Search Colis" type="text" >
                <input class="btn btn-success" type="submit" class="form-control">
            </form>
        </c:when>
        <c:otherwise>
            <h3>Progression du colis</h3>
            <table class="table">
                <thead class="thead-dark">
                <tr>
                    <th>ID</th>
                    <th>Poids</th>
                    <th>Valeur</th>
                    <th>Origine</th>
                    <th>Destination</th>
                </tr>
                </thead>
                <tr>
                    <td>${colis.unique_id}</td>
                    <th>${colis.poids}</th>
                    <td><fmt:formatNumber type="currency" currencySymbol="&euro;"
                                          value="${colis.valeur}"></fmt:formatNumber></td>
                    <td>${colis.origine}</td>
                    <td>${colis.destination}</td>
                </tr>
            </table>
            <h3>Les acheminements du colis</h3>
            <table class="table">
                <thead class="thead-dark">
                <tr>
                    <th>Date</th>
                    <th>Emplacement</th>
                    <th>Etat</th>
                    <th>latitude</th>
                    <th>longitude</th>
                </tr>
                </thead>
                <c:forEach items="${colis.acheminements}" var="acheminements">
                    <tr>
                        <td>${acheminements.date}</td>
                        <td>${acheminements.emplacement}</td>
                        <td>${acheminements.etat.toString()}</td>
                        <td>${acheminements.latitude}</td>
                        <td>${acheminements.longitude}</td>
                    </tr>
                </c:forEach>
            </table>
            <h3>Ajouter prochaine acheminement</h3>
            <form action="Progression" method="post" class="form-group">
                <input name="unique_id" type="hidden" value="${colis.unique_id}">
                Emplacement : <input type="text" name="emplacement" class="form-control">
                Etat :
                <select name="etat" class="form-control">
                    <c:forEach items="${etats}" var="etats">
                        <option>${etats.toString()}</option>
                    </c:forEach>
                </select>
                <br/>
                <input class="btn btn-primary" type="submit" value="Ajouter Emplacement">
            </form>
        </c:otherwise>
    </c:choose>

</main>

<footer class="footer">
    <div class="container">
        <spam class="text-muted"> TP Serveurs d'applications - RAFIK Abdellatif / ESTOPINAN Raphael</spam>
    </div>
</footer>

</body>
</html>

