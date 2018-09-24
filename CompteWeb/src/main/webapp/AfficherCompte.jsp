<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Info compte</title>
	<link rel="stylesheet" type="text/css" href="css/base.css" ></style>
</head>
<body>
	<h1>Affichage compte</h1>
	<h2>Informations compte :</h2>
	<p>numero : ${compte.numero }</p>
	<p>solde : <fmt:formatNumber type="currency" currencySymbol="&euro;"
	   value="${compte.solde }"></fmt:formatNumber>
	</p>
	<a href="index.html">Revenir à la page principale</a>
</body>
</html>