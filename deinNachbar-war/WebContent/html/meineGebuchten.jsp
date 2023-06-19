<!-- Tobi -->

<%@ page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page errorPage="fehlerausgabe.jsp" %>


<!-- Lukas -->
<%@ include file="header.jspf" %> 
<script type="text/javascript" src="./../js/meineGebuchten.js"></script>

<div class="startseiteFlex">

	<main>
		<h1>Meine Gebuchten</h1>
		<!-- Veronika -->
		<c:forEach var="currentGebuchte" items="${anzeigen}" varStatus="status">
			<div class="anzeigeBox">
				<ul>
					<li>
					<img src="./../ServletBildAnzeige?anzeigeID=${currentGebuchte.anzeigeID}" width="300" height="auto" onerror="this.src='./../img/logo.jpeg';" alt="Kein Bild vorhanden"></li><!--onerror: https://bit.ly/3N6GpwJ  --> 
					<li>${currentGebuchte.anzeigeArt}</li>				
					<li><h4>${currentGebuchte.titelAnzeige}</h4></li>
					<li>${currentGebuchte.preis} € ${currentGebuchte.preiskategorie}</li>
					<li>${currentGebuchte.standort}</li>				
					<brs>
					<li><a href="./../ServletAnzeigeAnzeigen?anzeigeid=${currentGebuchte.anzeigeID}" class = "button">Zur Anzeige</a></li>
					<br>
					<li><a href="./../ServletBuchungLoeschen?anzeigeID=${currentGebuchte.anzeigeID}" class = "loeschButton" id="loeschBuchung">Buchung löschen</a></li>
				</ul>
			</div>
		</c:forEach>
	</main>
</div>
<!-- Lukas -->
<%@ include file="footer.jspf" %> 