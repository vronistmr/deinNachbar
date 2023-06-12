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
					<img src="./../ServletBildAnzeige?anzeigeID=${anzeigeNeu.anzeigeID}" width="300" height="auto" onerror="this.src='./../img/logo.jpeg';"> <!--onerror: https://bit.ly/3N6GpwJ  -->
			</aside>
			<article>
					<h2>${anzeigeNeu.titelAnzeige}</h2>
					<h3> in ${anzeigeNeu.kategorie}<br/>
						${anzeigeNeu.anzeigeArt}</h3>
			</article>
			</div>
			<article>
				<div class="preis">
					${anzeigeNeu.preis}€
					${anzeigeNeu.preiskategorie}
				</div>
				<br/><p class="blocksatz"><b>Beschreibung: </b><br/>
					       ${anzeigeNeu.beschreibung}</p>
				<br/><b>${anzeigeNeu.standort} und im Umkreis von ${anzeigeNeu.umkreis} Kilometern</b>
				<br/>
			</article>
		
		<div class="unten">
				<a href="../ServletMeineAnzeigen" class="button">zu Meine Anzeigen</a>
		</div>
</main>


<!-- Lukas -->
<%@ include file="footer.jspf"%>