<!-- Lukas -->

<%@ page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="fehlerausgabe.jsp"%>

<%@ include file="header.jspf"%>


<main>
	<!-- Tobi -->
	<h2>Ausgewählte Anzeige:</h2>
	
		<br><b>Anzeige ID: </b>${AnzeigeForm.anzeigeID}
		<br><b>Art der Anzeige: </b>${AnzeigeForm.anzeigeArt}
		<br><b>Titel der Anzeige: </b>${AnzeigeForm.titelAnzeige}
		<br><b>Preis: </b>${AnzeigeForm.preis}
		<br><b>Preiskategorie: </b>${AnzeigeForm.preiskategorie}
		<br><b>Kategorie: </b>${AnzeigeForm.kategorie}
		<br><b>Standort: </b>${AnzeigeForm.standort}
		<br><b>Umkreis: </b>${AnzeigeForm.umkreis}
		<br><b>Beschreibung: </b>${AnzeigeForm.beschreibung}
		<br><b>Bild: </b><img src="./../ServletBildAnzeige?anzeigeID=${AnzeigeForm.anzeigeID}" width="300" height="auto" onerror="this.src='./../img/blume.png';"> <!--onerror: https://bit.ly/3N6GpwJ  -->
		<br>
		
	<!-- Lukas -->
	<c:if test="${AnzeigeForm.benutzerID != loginForm.benutzerID}">
		<form action="./../ServletAnzeigeBuchen?id=${AnzeigeForm.anzeigeID}" method="post">
			<button type="submit" name="buchung" value="neu">Buchen</button>
		</form>
	</c:if>
	
	<c:if test="${AnzeigeForm.benutzerID == loginForm.benutzerID}">
		<form action="./../ServletAnzeigeLoeschen?id=${AnzeigeForm.anzeigeID}" method="post">
			<button type="submit" name="löschen" value="neu">Löschen</button>
		</form>
	</c:if>
	
</main>


<!-- Lukas -->
<%@ include file="footer.jspf"%>