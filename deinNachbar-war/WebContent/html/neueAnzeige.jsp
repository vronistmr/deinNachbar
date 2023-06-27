<!-- Lukas -->

<%@ page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page errorPage="fehlerausgabe.jsp"%>

<%@ include file="header.jspf"%>


<main>
<!-- Veronika -->

	<h1>Juhu! Deine Anzeige ist jetzt online!</h1>
	<br>

	<div id="flexanzeige">
		<aside>
			<img class="imganzeige"
				src="./../ServletBildAnzeige?anzeigeID=${anzeigeNeu.anzeigeID}"
				width="300" height="1000" onerror="this.src='./../img/logo.jpeg';"
				alt="Kein Bild vorhanden">
			<!--onerror: https://bit.ly/3N6GpwJ  -->
		</aside>
		<article>
			<h3>${anzeigeNeu.anzeigeArt}</h3>
			<h1>${anzeigeNeu.titelAnzeige}</h1>
			<br />
			<h3>in Kategorie ${anzeigeNeu.kategorie}</h3>
		</article>
	</div>
	<article>
		<div class="preis">
			<c:if test="${anzeigeNeu.preiskategorie == 'Gratis'}">
				<span>Zu Verschenken</span>
				<br />
			</c:if>
			<c:if test="${anzeigeNeu.preiskategorie != 'Gratis'}">
				<span>${anzeigeNeu.preis} € ${anzeigeNeu.preiskategorie}</span>
				<br />
			</c:if>
		</div>
		<br>
		<p class="blocksatz">
			<span class="fett">Beschreibung: </span> <br>
			${anzeigeNeu.beschreibung}
		</p>
		<p class="blocksatz">
			<span class="fett">${anzeigeNeu.standort} und im Umkreis von
				${anzeigeNeu.umkreis} Kilometern</span>
		</p>
		<br>
		<p class="blocksatz">
			Anzeige veröffentlicht von <span class="fett">${anzeigeNeu.vorname}</span>
		</p>
		<br>
	</article>

	<div class="unten">
		<a href="../ServletMeineAnzeigen" class="button">zu allen meinen
			Anzeigen</a>
	</div>
</main>


<!-- Lukas -->
<%@ include file="footer.jspf"%>