<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>InfoVille</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	
	<%@ include file="navbar.jsp"%>
	<div class="row row align-items-center justify-content-center p-3">
		<div class="col-xs-12 col-sm-12 col-md-8 col-lg-8 text-center p-3">
	<h1>${ ville.nom_commune }</h1>
	
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
		<button class="btn btn-outline-success" name="envoi" type="submit" value="Update">Mettre à jour</button>
		<button class="btn btn-outline-warning" name="envoi" type="submit" value="Delete">Supprimer</button>
	</form>
	</div>
	</div>
	
</body>
</html>