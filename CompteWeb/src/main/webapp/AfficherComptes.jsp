<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Info comptes</title>
	<link rel="stylesheet" type="text/css" href="css/base.css" ></style>
</head>
<body>
	<h1>Affichage comptes</h1>
	<h2>Informations comptes :</h2>
	<table>
		<thead><tr><th>Numéro</th><th>Solde</th></tr></thead>
		<tbody>
			<c:forEach items="${comptes}"  var="compte">
				<tr><td>${compte.numero }</td>
				<td><fmt:formatNumber type="currency" currencySymbol="&euro;"
				   		value="${compte.solde }"></fmt:formatNumber></td></tr>
			</c:forEach>
		</tbody>
	</table>
	<p><a href="index.html">Revenir à la page principale</a></p>
</body>
</html>