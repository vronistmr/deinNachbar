<!-- Lukas -->

<%@ page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="fehlerausgabe.jsp"%>

<%@ include file="header.jspf"%>


<main>
	<!-- Veronika -->
	
	<h1>Juhu! Deine Anzeige ist jetzt online!</h1>
	<br>
	
		<p>
		<b>Anzeige-ID: </b>${anzeigeNeu.anzeigeID}
		<br><b>Art der Anzeige: </b>${anzeigeNeu.anzeigeArt}
		<br><b>Titel der Anzeige:</b>${anzeigeNeu.titelAnzeige}
		<br><b>Preis: </b>${anzeigeNeu.preis} Euro
		<br><b>Preiskategorie: </b>${anzeigeNeu.preiskategorie}
		<br><b>Kategorie: </b>${anzeigeNeu.kategorie}
		<br><b>Standort: </b>${anzeigeNeu.standort}
		<br><b>Umkreis: </b>${anzeigeNeu.umkreis} Kilometer
		<br><b>Beschreibung: </b>${anzeigeNeu.beschreibung}
		<br><b>Bild: </b><img src="./../ServletBildAnzeige?anzeigeID=${anzeigeNeu.anzeigeID}" width="300" height="auto" onerror="this.src='./../img/blume.png';"> <!--onerror: https://bit.ly/3N6GpwJ  --> 
		</p>
		
		<form>
		<button formaction="../ServletMeineAnzeigen">Zu all meinen Anzeigen</button>
		</form>
	
</main>


<!-- Lukas -->
<%@ include file="footer.jspf"%>