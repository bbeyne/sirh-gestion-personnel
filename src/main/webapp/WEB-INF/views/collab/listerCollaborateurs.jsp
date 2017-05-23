<%@page import="java.util.List"%>
<%@page import="dev.sgp.entite.Collaborateur" %>
<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>SGP - App</title>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstrap-3.3.7-dist/css/bootstrap.css">

</head>

<body>

	<h1>Les cocollaborateurs</h1>

	<ul>

		<%
			List<Collaborateur> listeNoms = (List<Collaborateur>) request.getAttribute("listeNoms");

			for (Collaborateur collabo : listeNoms) {
		%>

		<li><%=collabo.getNom()%></li>
		<li><%=collabo.getMatricule()%></li>
		<li><%=collabo.getDate_de_naissance()%></li>
		<li><%=collabo.getAdresse()%></li>
		<li><%=collabo.getNum_SecuSoc()%></li>
		<li><%=collabo.getEmailPro()%></li>
		<li><%=collabo.getPhoto()%></li>
		<li><%=collabo.isActif() %>
		<%
			}
		%>

	</ul>
</body>

</html>