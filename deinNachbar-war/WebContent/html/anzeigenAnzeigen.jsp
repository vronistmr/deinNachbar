<!-- Lukas -->
<%@ page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page errorPage="fehlerausgabe.jsp"%>
<%@ include file="header.jspf"%>


<main>
	<!-- Veronika -->
	<h2>Ausgewählte Anzeige:</h2>
	
		<br><b>Anzeige ID: </b>${AnzeigeAufgebenForm.anzeigeID}
		<br><b>Art der Anzeige: </b>${AnzeigeAufgebenForm.anzeigeArt}
		<br><b>Titel der Anzeige: </b>${AnzeigeAufgebenForm.titelAnzeige}
		<br><b>Preis: </b>${AnzeigeAufgebenForm.preis}
		<br><b>Preiskategorie: </b>${AnzeigeAufgebenForm.preiskategorie}
		<br><b>Kategorie: </b>${AnzeigeAufgebenForm.kategorie}
		<br><b>Standort: </b>${AnzeigeAufgebenForm.standort}
		<br><b>Umkreis: </b>${AnzeigeAufgebenForm.umkreis}
		<br><b>Beschreibung: </b>${AnzeigeAufgebenForm.beschreibung}
		<br><b>Hier könnte noch das Foto stehen :) </b>
		<br>
			<!-- Tobias -->
	<button type="submit" name="buchungsbutton" value="buchungneu">Buchen</button>

</main>

<!-- Lukas -->
<%@ include file="footer.jspf"%>