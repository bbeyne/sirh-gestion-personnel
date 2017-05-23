<%@page import="java.util.List"%>
<%@page import="dev.sgp.entite.Collaborateur" %>
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

	<h1>Les collaborateurs</h1>
	<a href="<c:url value='/collaborateurs/nouveau'></c:url>" class="btn btn-primary">Nouveau</a>
	<ul>
		<c:forEach var="collab" items="${listeCollaborateurs}">
			<li>${collab.matricule} - ${collab.nom} ${collab.prenom}</li>
		</c:forEach>
	</ul>
	<%-- <ul>

		<%
			List<Collaborateur> listeNoms = (List<Collaborateur>) request.getAttribute("listeCollaborateurs");

			for (Collaborateur collabo : listeNoms) {
		%>

		<li><%=collabo.getNom()%></li>
		<li><%=collabo.getMatricule()%></li>
		<li><%=collabo.getDate_de_naissance()%></li>
		<li><%=collabo.getAdresse()%></li>
		<li><%=collabo.getNum_SecuSoc()%></li>
		<li><%=collabo.getEmailPro()%></li>
		<li><%=collabo.getPhoto()%></li>
		<li><%=collabo.getDateCreation() %></li>
		<li><%=collabo.isActif() %></li>
		<%
			}
		%>

	</ul> --%>
</body>

</html>