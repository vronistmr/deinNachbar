<!-- Tobi -->

<%@ page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page errorPage="fehlerausgabe.jsp"%>


<!-- Lukas -->
<%@ include file="header.jspf"%>
<script type="text/javascript" src="./../js/meineGebuchten.js"></script>


<div class="startseiteFlex">

	<main>
		<h1>Meine Gebuchten</h1>
		<!-- Veronika -->
		<c:forEach var="currentGebuchte" items="${anzeigen}"
			varStatus="status">
			<div class="anzeigeBox">
				<span><img
					src="./../ServletBildAnzeige?anzeigeID=${currentGebuchte.anzeigeID}"
					width="300" height="200" 
					alt="Kein Bild vorhanden"></span><br />
				<span>${currentGebuchte.anzeigeArt}</span><br />
				<h4>${currentGebuchte.titelAnzeige}</h4>
				<br />
				<c:if test="${currentGebuchte.preiskategorie == 'Gratis'}">
					<span>Zu Verschenken</span>
					<br />
				</c:if>
				<c:if test="${currentGebuchte.preiskategorie != 'Gratis'}">
					<span>${currentGebuchte.preis} €
						${currentGebuchte.preiskategorie}</span>
					<br />
				</c:if>
				<span>${currentGebuchte.standort}</span><br /> <br /> <span><a
					href="./../ServletAnzeigeAnzeigen?anzeigeid=${currentGebuchte.anzeigeID}"
					class="button">Zur Anzeige</a></span><br /> <br /> <span><a
					href="./../ServletBuchungLoeschen?anzeigeID=${currentGebuchte.anzeigeID}"
					class="button buchungLoeschen">Buchung löschen</a></span><br />
			</div>
		</c:forEach>
	</main>
</div>

<!-- Lukas -->
<%@ include file="footer.jspf"%>