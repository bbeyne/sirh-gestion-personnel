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
	<h1>SGP - Saisie des coordonnées bancaires</h1>
	<form class="form-horizontal">

		<div class="form-group">
			<label class="col-md-4 control-label" for="textinput">Rechercher
				par nom :</label>
			<div class="col-md-2">
				<input id="textinput" name="textinput" type="text" placeholder=""
					class="form-control input-md">
			</div>

		</div>

		<!-- Select Basic -->
		<div class="form-group">
			<label class="col-md-4 control-label" for="selectbasic">Filtrer
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
			<label class="col-md-4 control-label" for="singlebutton"></label>
			<div class="col-md-1">
				<button id="singlebutton" name="singlebutton"
					class="btn btn-inverse">Rechercher</button>
			</div>
		</div>
	</form>

	<div>
		<table class=" col-lg-offset-1 col-lg-6">
			<thead>
				<tr>
					<th class="col-lg=2">Matricule</th>
					<th class="col-lg=2">Nom</th>
					<th class="col-lg=2">Prenom</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="collab" items="${ listeCollaborateurs}">
					<tr>
						<th>${ collab.getMatricule() }</th>
						<th>${ collab.getNom() }</th>
						<th>${ collab.getPrenom() }</th>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<form class="form-horizontal">
			<fieldset>

				<div class="form-group">
					<label class="col-md-1 control-label" for="textinput">Banque</label>
					<div class="col-md-5">
						<input id="textinput" name="textinput" type="text" placeholder=""
							class="form-control input-md" required>

					</div>
				</div>

				<div class="form-group">
					<label class="col-md-1 control-label" for="textinput">IBAN</label>
					<div class="col-md-5">
						<input id="textinput" name="textinput" type="text" placeholder=""
							class="form-control input-md" required>

					</div>
				</div>

				<div class="form-group">
					<label class="col-md-1 control-label" for="textinput">BIC</label>
					<div class="col-md-5">
						<input id="textinput" name="textinput" type="text" placeholder=""
							class="form-control input-md" required>

					</div>
				</div>

				<div class="form-group">
					<label class="col-md-4 control-label" for="singlebutton"></label>
					<div class="col-md-4" >
						<button id="singlebutton" name="singlebutton"
							class="btn btn-default">Sauvegarder</button>
					</div>
				</div>

			</fieldset>
		</form>

	</div>
</body>

</html>