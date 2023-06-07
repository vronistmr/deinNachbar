<!-- Tobi -->

<%@ page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page errorPage="fehlerausgabe.jsp" %>


<!-- Lukas -->
<%@ include file="header.jspf" %> 

	<main>
		<h1>Meine Gebuchten</h1>
		<!-- Veronika -->
		
		<c:forEach var="currentGebuchte" items="${anzeigen}" varStatus="status">
				<div class="anzeigeBox">
				<ul>
					<li>
					<img src="./../ServletBildAnzeige?anzeigeID=${currentGebuchte.anzeigeID}" width="300" height="auto" onerror="this.src='./../img/blume.png';"></li><!--onerror: https://bit.ly/3N6GpwJ  --> 
					<li><h4>${currentGebuchte.titelAnzeige}</h4></li>
					<li>${currentGebuchte.preis} €</li>
					<li>${currentGebuchte.preiskategorie}</li>
					<li>${currentGebuchte.standort}</li>
					<li><a href="./../ServletAnzeigeAnzeigen?anzeigeid=${currentGebuchte.anzeigeID}" class = "button">Zur Anzeige</a></li>
					<li><a href="./../ServletBuchungLoeschen?anzeigeID=${currentGebuchte.anzeigeID}" class = "button">Buchung löschen</a></li>
				</ul>
				</div>
			</c:forEach>
			
			<!-- Lukas -->
			
		<br/>
	</main>


<%@ include file="footer.jspf" %> 