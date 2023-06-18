<!-- Tobi -->

<%@ page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page errorPage="fehlerausgabe.jsp" %>


<!-- Lukas -->
<%@ include file="header.jspf" %> 

<div class="startseiteFlex">

	<main>
		<h1>Meine Gebuchten</h1>
		<!-- Veronika -->
		<c:forEach var="currentGebuchte" items="${anzeigen}" varStatus="status">
			<div class="anzeigeBox">
				<span><img src="./../ServletBildAnzeige?anzeigeID=${currentGebuchte.anzeigeID}" width="300" height="200" onerror="this.src='./../img/logo.jpeg';" alt="Kein Bild vorhanden"></span><br /><!--onerror: https://bit.ly/3N6GpwJ  -->
					<span>${currentGebuchte.anzeigeArt}</span><br />
					<h4>${currentGebuchte.titelAnzeige}</h4><br />
					<span>${currentGebuchte.preis} € 
					      ${currentGebuchte.preiskategorie}</span><br />
					<span>${currentGebuchte.standort}</span><br />
					<br />
					<span><a href="./../ServletAnzeigeAnzeigen?anzeigeid=${currentGebuchte.anzeigeID}" class="button">Zur Anzeige</a></span><br />
					<br />
					<span><a href="./../ServletBuchungLoeschen?anzeigeID=${currentGebuchte.anzeigeID}" class = "button">Buchung löschen</a></span><br />
			</div>
		</c:forEach>
	</main>
</div>
<!-- Lukas -->
<%@ include file="footer.jspf" %> 