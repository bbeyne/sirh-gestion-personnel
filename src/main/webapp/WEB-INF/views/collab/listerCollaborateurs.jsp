<%@page import="java.util.List"%>
<%@page import="dev.sgp.entite.Collaborateur"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>SGP - App</title>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstrap-3.3.7-dist/css/bootstrap.css">

</head>

<body>
	<a href="<c:url value='/collaborateurs/nouveau'></c:url>"
		class="btn btn-primary">Nouveau</a>
	<a href="<c:url value='/activites'></c:url>" class="btn btn-primary">Activite</a>
	<a href="<c:url value='/statistiques'></c:url>" class="btn btn-primary">Statistiques</a>
	<a href="<c:url value='/collaborateurs/editer'></c:url>"
		class="btn btn-primary">Editer</a>
	<h1>Les collaborateurs</h1>
	<form class="form-horizontal">

		<div class="form-group">
			<label class="col-md-2 control-label" for="textinput">Rechercher
				un nom ou un prénom qui commence par :</label>
			<div class="col-md-2">
				<input id="textinput" name="textinput" type="text" placeholder=""
					class="form-control input-md">
			</div>

			<div>
				<label class=" col-md-1 checkbox-inline" for="checkboxes-0"
					align=Right> <input type="checkbox" name="checkboxes"
					id="checkboxes-0" value="" />

				</label> <label class=" control-label" for="checkboxes">Voir les
					collaborateurs désactivés</label>
			</div>
		</div>

		<!-- Select Basic -->
		<div class="form-group">
			<label class="col-md-2 control-label" for="selectbasic">Filtrer
				par département :</label>
			<div class="col-md-2">
				<select id="selectbasic" name="selectbasic" class="form-control">
					<option value="1">Tous</option>
					<c:forEach var="depart" items="${listeDepartements}">
						<option>${depart.nom}</option>
					</c:forEach>
				</select>
			</div>
		</div>

		<!-- Button -->
		<div class="form-group">
			<label class="col-md-2 control-label" for="singlebutton"></label>
			<div class="col-md-1">
				<button id="singlebutton" name="singlebutton"
					class="btn btn-inverse">Rechercher</button>
			</div>
		</div>
	</form>


	<ul>
		<c:forEach var="collab" items="${listeCollaborateurs}">
			<li>${collab.matricule}-${collab.nom}${collab.prenom}</li>
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