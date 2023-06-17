<!-- Lukas -->

<%@ page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="fehlerausgabe.jsp"%>

<%@ include file="header.jspf"%>


<main>
	<!-- Veronika -->
	
	<h1>Juhu! Deine Anzeige ist jetzt online!</h1>
	<br>

		<div id="flexanzeige">
			<aside>
					<img src="./../ServletBildAnzeige?anzeigeID=${anzeigeNeu.anzeigeID}" width="300" height="auto" onerror="this.src='./../img/logo.jpeg';" alt="Kein Bild vorhanden"> <!--onerror: https://bit.ly/3N6GpwJ  -->
			</aside>
			<article>
					<h3>${anzeigeNeu.anzeigeArt} </h3>
					<h1>${anzeigeNeu.titelAnzeige}</h1>
					<h3>in ${anzeigeNeu.kategorie}</h3>
			</article>
			</div>
			<article>
				<div class="preis">
					${anzeigeNeu.preis}€
					${anzeigeNeu.preiskategorie}
				</div>
				<br>
				<p class="blocksatz">
				<span class="fett">Beschreibung: </span>
				<br>
					       ${anzeigeNeu.beschreibung}</p>
				<p class="blocksatz">
				<span class="fett">${anzeigeNeu.standort} und im Umkreis von ${anzeigeNeu.umkreis} Kilometern</span> </p> <br>
				<p class="blocksatz">
				Anzeige veröffentlicht von <span class="fett">${anzeigeNeu.vorname}</span> </p>
				<br>
			</article>
		
		<div class="unten">
				<a href="../ServletMeineAnzeigen" class="button">zu allen meinen Anzeigen</a>
		</div>
</main>


<!-- Lukas -->
<%@ include file="footer.jspf"%>