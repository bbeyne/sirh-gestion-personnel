<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="java.time.ZonedDateTime" %>
<%@ page import="java.time.LocalDate" %>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>SGP - App</title>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstrap-3.3.7-dist/css/bootstrap.css">

</head>

<body>

	<h1>Nouveau collaborateur</h1>
	<form class="form-horizontal" method="POST">
		<fieldset>
			<div class="form-group">
				<label class="col-md-4 control-label" for="name">Nom</label>
				<div class="col-md-4">
					<input name="nom" type="text"
						class="form-control input-md" required>

				</div>
			</div>

			<div class="form-group">
				<label class="col-md-4 control-label" for="firstname">Prenom</label>
				<div class="col-md-4">
					<input name="prenom" type="text"
						class="form-control input-md" required>

				</div>
			</div>
			<div class="form-group">
				<label class="col-md-4 control-label" for="birthday">Date de
					naissance</label>
				<div class="col-md-4">
					<input  name="date" type="date"
						class="form-control input-md" required>

				</div>
			</div>
			<div class="form-group">
				<label class="col-md-4 control-label" for="adresse">Adresse</label>
				<div class="col-md-4">
					<input name="adresse" type="text"
						class="form-control input-md" required>

				</div>
			</div>
			<div class="form-group">
				<label class="col-md-4 control-label" for="numSecu">Numero
					de securite sociale</label>
				<div class="col-md-4">
					<input name="numsecu" type="text"
						class="form-control input-md" required  >

				</div>
			</div>
			<div class="form-group">
				<label class="col-md-4 control-label"></label>
				<div class="col-md-4 col-md-offset-7" >
					<button type="submit" class="btn btn-default">Creer</button>
				</div>
			</div>

		</fieldset>
	</form>
</body>

</html>

