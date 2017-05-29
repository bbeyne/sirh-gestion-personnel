<%@page import="java.util.List"%>
<%@page import="dev.sgp.entite.VisiteWeb" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>SGP - App</title>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstrap-3.3.7-dist/css/bootstrap.css">

</head>

<body>
	<a href="<c:url value='/collaborateurs/nouveau'></c:url>" class="btn btn-primary">Nouveau</a>
	<a href="<c:url value='/activites'></c:url>" class="btn btn-primary">Activite</a>
	<a href="<c:url value='/collaborateurs/lister'></c:url>" class="btn btn-primary">Lister</a>
	<h1>Statistiques</h1>
	<Table>
	<thead><tr><td>Chemin</td><td>Nombres de visites</td><td>Min (ms)</td><td> Max (ms)</td><td> Moyenne (ms)</td></tr></thead>
	<tbody>
	<c:forEach var="visite" items="${listeVisites}">
	<tr>
		
			<th>${visite.chemin}</th><th> ${visite.compteur}</th><th> ${visite.maxtemps}</th><th> ${visite.mintemps}</th><th> ${visite.moytemps}</th>
		
	</tr>
	</c:forEach>
	</tbody>
	</Table>
</body>

</html>