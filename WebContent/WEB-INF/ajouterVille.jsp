<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajouter ville</title>
</head>
<body>
	
	<%@ include file="navbar.jsp"%>
	<div class="row row align-items-center justify-content-center p-3">
		<div class="col-xs-12 col-sm-12 col-md-8 col-lg-8 text-center p-3">
	<h1>Ajouter une ville française</h1>
	
	<form method="post" class="form-floating mb-3 p-2">
		<div class="input-group input-group-lg p-1">
		  <span class="input-group-text" id="inputGroup-sizing-lg">Nom commune</span>
		  <input type="text" class="form-control" aria-label="Sizing example input" name="nom_commune" value="${ ville.nom_commune }" aria-describedby="inputGroup-sizing-lg">
		</div>
		<div class="input-group input-group-lg p-1">
		  <span class="input-group-text" id="inputGroup-sizing-lg">Code commune</span>
		  <input type="text" class="form-control" aria-label="Sizing example input" name="codeCommune" value="${ ville.codeCommune }" aria-describedby="inputGroup-sizing-lg">
		</div>
		<div class="input-group input-group-lg p-1">
		  <span class="input-group-text" id="inputGroup-sizing-lg">Code postal</span>
		  <input type="text" class="form-control" aria-label="Sizing example input" name="code_postal" value="${ ville.code_postal }" aria-describedby="inputGroup-sizing-lg">
		</div>
		<div class="input-group input-group-lg p-1">
		  <span class="input-group-text" id="inputGroup-sizing-lg">Libelle acheminement</span>
		  <input type="text" class="form-control" aria-label="Sizing example input" name="libelle_acheminement" value="${ ville.libelle_acheminement }" aria-describedby="inputGroup-sizing-lg">
		</div>
		<div class="input-group input-group-lg p-1">
		  <span class="input-group-text" id="inputGroup-sizing-lg">Ligne 5</span>
		  <input type="text" class="form-control" aria-label="Sizing example input" name="ligne_5" value="${ ville.ligne_5 }" aria-describedby="inputGroup-sizing-lg">
		</div>	
		<div class="input-group input-group-lg p-1">
		  <span class="input-group-text" id="inputGroup-sizing-lg">Latitude</span>
		  <input type="text" class="form-control" aria-label="Sizing example input" name="Latitude" value="${ ville.coordonnees.latitude }" aria-describedby="inputGroup-sizing-lg">
		</div>
		<div class="input-group input-group-lg p-1">
		  <span class="input-group-text" id="inputGroup-sizing-lg">Longitude</span>
		  <input type="text" class="form-control" aria-label="Sizing example input" name="Longitude" value="${ ville.coordonnees.longitude }" aria-describedby="inputGroup-sizing-lg">
		</div>	        
		<button class="btn btn-outline-success" name="envoi" type="submit" value="Add">Ajouter une ville</button>
	</form>
	</div>
	</div>
	
</body>
</html>