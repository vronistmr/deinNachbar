<!-- Tobi -->
<%@ page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page errorPage="fehlerausgabe.jsp"%>
<!-- Lukas -->
<%@ include file="header.jspf"%>


<!-- Veronika -->
<main>
	<h1>Meine Anzeigen</h1>
	
	<c:forEach var="currentAnzeige" items="${anzeigen}" varStatus="status">
				<div class="anzeigeBox">
				<ul>
					<li>
					<img src="./ServletBildAnzeige?anzeigeID=${currentAnzeige.anzeigeID}" width="300" height="auto" alt="Kein Bild vorhanden"></li> 
					<li><h4>${currentAnzeige.titelAnzeige}</h4><li>
					<li>${currentAnzeige.preis} €</li>
					<li>${currentAnzeige.preiskategorie}</li>
					<li>${currentAnzeige.standort}</li>
					<li><a href="./ServletAnzeigeAnzeigen?anzeigeid=${currentAnzeige.anzeigeID}"">Zur Anzeige</a></li>
				</ul>
				</div>
			</c:forEach>


	
	<br />

</main>

<%@ include file="footer.jspf"%>
