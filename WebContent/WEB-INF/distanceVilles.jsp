<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Distance villes</title>
</head>
<body>
	<%@ include file="navbar.jsp"%>
	<div class="row row align-items-center justify-content-center p-3">
		<div class="col-xs-12 col-sm-12 col-md-8 col-lg-8 text-center p-3">
			<h1>Calculer la distance entre deux villes de France</h1>
		</div>
		<div class="col-xs-12 col-sm-12 col-md-8 col-lg-8 text-center p-3">
		<form method="POST">
		<div class="col-xs-12 col-sm-12 col-md-8 col-lg-8 text-center p-3">
			<select class="form-select form-select-lg mb-3" aria-label=".form-select-lg example" name="ville1" id="ville1">
			  <c:forEach var="ville" items="${ listeVille }">
			  	<option selected value="${ ville.coordonnees.latitude };${ ville.coordonnees.longitude};${ ville.nom_commune}"><c:out value="${ ville.nom_commune}"/></option>
			  </c:forEach>
			</select>
		</div>
		<div class="col-xs-12 col-sm-12 col-md-8 col-lg-8 text-center p-3">
			<select class="form-select form-select-lg mb-3" aria-label=".form-select-lg example" name="ville2" id="ville2">
			  <c:forEach var="ville" items="${ listeVille }">
			  	<option selected value="${ ville.coordonnees.latitude };${ ville.coordonnees.longitude};${ ville.nom_commune}"><c:out value="${ ville.nom_commune}"/></option>
			  </c:forEach>
			</select>
		</div>
		<div class="col-xs-12 col-sm-12 col-md-8 col-lg-8 text-center p-3">
			<button type="submit" id="btn_distance" class="btn btn-outline-info">Calculer la distance</button>
		</div>
		</form>
		</div>
		<div class="col-xs-12 col-sm-12 col-md-8 col-lg-8 text-center p-3">
			<h2><c:out value="${distance}"/></h2>
		</div>
		
	</div>
	
	
	
</body>
</html>