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
	<a href="<c:url value='/statistiques'></c:url>" class="btn btn-primary">Statistiques</a>
	<a href="<c:url value='/collaborateurs/lister'></c:url>" class="btn btn-primary">Lister</a>
	<h1>Activités depuis le démarrage de l'application</h1>
	<Table>
	<thead><tr><td>Date/Heure</td><td>Libelle</td></tr></thead>
	<tbody>
	<c:forEach var="activite" items="${listeActivites}">
	<tr>
		
			<th>${activite.dateform()}</th><th> ${activite.getType().toString()} - matricule : ${activite.getMatricule()}</th>
					
	</tr>
	</c:forEach>
	</tbody>
	</Table>
</body>

</html>