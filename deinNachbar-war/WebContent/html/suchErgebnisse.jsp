<!-- Tobi -->
<%@ page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page errorPage="fehlerausgabe.jsp"%>
<%@ include file="header.jspf"%>

<main>

<h2>Erfolgreiches Suchen von Anzeigen</h2>
		<h3>Gelesene Daten</h3>
		<table>
			<tr>
				<th>Anzeigetitel</th>
				<th>Preis</th>
				<th>Preiskategorie</th>
				<th>Kategorie</th>
				<th>Standort</th>
				<th>Umkreis</th>
				<th>Beschreibung</th>
				<th>AnzeigeID</th>
				<th>BenutzerID</th>
				<th>AnzeigeArt</th>
				<th>Foto</th>
				<th>Datum und Uhrzeit</th>
				<th>Aktion</th>
				
			</tr>
			<c:forEach items="${Anzeigen}" var="anzeige">
				<tr>
					<td>${anzeige.titelAnzeige}</td>
					<td>${anzeige.preis}</td>
					<td>${anzeige.preiskategorie}</td>
					<td>${anzeige.kategorie}</td>
					<td>${anzeige.standort}</td>
					<td>${anzeige.umkreis}</td>
					<td>${anzeige.beschreibung}</td>
					<td>${anzeige.anzeigeID}</td>
					<td>${anzeige.benutzerID}</td>
					<td>${anzeige.anzeigeArt}</td>
					<td>${anzeige.foto}</td>
					<td>${anzeige.datetime}</td>
					<td><a href="./../ServletAnzeigeAnzeigen?anzeigeid=${anzeige.anzeigeID}">Hier gehts zur Anzeige</a></td>
				</tr>
			</c:forEach>
		</table>

</main>

<%@ include file="footer.jspf"%>