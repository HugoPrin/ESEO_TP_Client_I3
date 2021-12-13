<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Villes</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>

	<%@ include file="navbar.jsp"%>
	<div class="row row align-items-center justify-content-center p-3">
	<div class="col-xs-12 col-sm-12 col-md-8 col-lg-8 text-center p-3">
		<h2>Bonjour, ce site répertorie l'ensemble des villes de France</h2>
	</div>
		<div class="col-xs-12 col-sm-12 col-md-8 col-lg-8 text-center p-3">
			<form class="d-flex">
		        <input class="form-control me-2" type="search" placeholder="Rechercher une ville selon son codeCommune" aria-label="Search" name="villeAChercher">
		        <button class="btn btn-outline-success" type="submit">Rechercher</button>
	      </form>
	      <ul class="list-group p-2">
			  <li class="list-group-item active" aria-current="true"><c:out value="${villetrouvee.nom_commune}"/></li>
			  <li class="list-group-item">Code commune: ${villetrouvee.codeCommune}</li>
			  <li class="list-group-item">Code postal: ${villetrouvee.code_postal}</li>
			  <li class="list-group-item">Libelle: ${villetrouvee.libelle_acheminement}</li>
			  <li class="list-group-item">Ligne_5: ${villetrouvee.ligne_5}</li>
			  <li class="list-group-item">Latitude: ${villetrouvee.coordonnees.latitude}</li>
			  <li class="list-group-item">Longitude: ${villetrouvee.coordonnees.longitude}</li>
			</ul>
	     </div>
		<div class="col-xs-12 col-sm-12 col-md-8 col-lg-8 text-center">
			<ul class="list-group">
				<li class="list-group-item active">				
						<h2>Villes de France <span class="badge bg-success rounded-pill"><c:out value="Nbre: ${nbreVilles}"/></span></h2>
					</li>
				<c:forEach var="ville" items="${ listeVille }">
					
					<a href="infoville?codeCommune=${ ville.codeCommune }" class="list-group-item list-group-item-action">				
						<p>Code Commune: ${ ville.codeCommune }</p>
						<p>Nom Commune: ${ville.nom_commune}</p>
					</a>

				</c:forEach>
			</ul>
		</div>
	</div>

</body>
</html>