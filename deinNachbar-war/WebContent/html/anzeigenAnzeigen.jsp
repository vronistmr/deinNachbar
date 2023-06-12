<!-- Lukas -->

<%@ page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="fehlerausgabe.jsp"%>

<%@ include file="header.jspf"%>


<main>
	<!-- Tobi -->	
		<div id="flexanzeige">
			<aside>
					<img src="./../ServletBildAnzeige?anzeigeID=${AnzeigeForm.anzeigeID}" width="300" height="auto" onerror="this.src='./../img/logo.jpeg';"> <!--onerror: https://bit.ly/3N6GpwJ  -->
			</aside>
			<article>
					<h1>${AnzeigeForm.titelAnzeige}</h1>
					<h3> in ${AnzeigeForm.kategorie}<br/>
						${AnzeigeForm.anzeigeArt}</h3>
			</article>
			</div>
			<article>
				<div class="preis">
					${AnzeigeForm.preis}€
					${AnzeigeForm.preiskategorie}
				</div>
				<br/><p class="blocksatz"><b>Beschreibung: </b><br/>
					       ${AnzeigeForm.beschreibung}</p>
				<br/><b>${AnzeigeForm.standort} und im Umkreis von ${AnzeigeForm.umkreis} Kilometern</b>
				<br/>
			</article>
		
	<!-- Lukas -->
	<div class="unten">
		<c:if test="${AnzeigeForm.benutzerID != loginForm.benutzerID}">
			<a href="./../ServletAnzeigeBuchen?id=${AnzeigeForm.anzeigeID}" class = "button">Buchen</a>
		</c:if>
		
		<c:if test="${AnzeigeForm.benutzerID == loginForm.benutzerID}">
			<a href="./../ServletAnzeigeLoeschen?id=${AnzeigeForm.anzeigeID}" class = "button">Löschen</a>
		</c:if>
	</div>
</main>


<!-- Lukas -->
<%@ include file="footer.jspf"%>