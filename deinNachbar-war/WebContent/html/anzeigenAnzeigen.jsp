<!-- Lukas -->
<%@ page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<br><b>Bild: </b><img src="./../ServletBildAnzeige?anzeigeID=${AnzeigeForm.anzeigeID}" width="400" height="auto" alt="Kein Bild vorhanden">
		<br>
		
	<!-- Lukas -->
	<form action="./../ServletAnzeigeBuchen?id=${AnzeigeForm.anzeigeID}" method="post">
	<button type="submit" name="buchungsbutton" value="buchungneu">Buchen</button>
	</form>
</main>

<!-- Lukas -->
<%@ include file="footer.jspf"%>