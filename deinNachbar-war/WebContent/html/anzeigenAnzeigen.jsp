<!-- Lukas -->

<%@ page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="fehlerausgabe.jsp"%>

<%@ include file="header.jspf"%>
<script type="text/javascript" src="./../js/anzeigeAnzeigen.js"></script>

<main>
	<!-- Tobi -->	
		<div id="flexanzeige">
			<aside>
					<img class="imganzeige" src="./../ServletBildAnzeige?anzeigeID=${AnzeigeForm.anzeigeID}" width="400" height="1000" onerror="this.src='./../img/logo.jpeg';" alt="Kein Bild vorhanden"> <!--onerror: https://bit.ly/3N6GpwJ  -->
			</aside>
			<article>
					<h3>${AnzeigeForm.anzeigeArt} </h3>
					<h1>${AnzeigeForm.titelAnzeige}</h1>
					<br/>
					<h3>in Kategorie ${AnzeigeForm.kategorie}</h3>
			</article>
			</div>
			<article>
				<div class="preis">
					${AnzeigeForm.preis}€
					${AnzeigeForm.preiskategorie}
				</div>
				<br/>
				<p class="blocksatz">
					<span class="fett">Beschreibung: </span><br/>
					 ${AnzeigeForm.beschreibung}
				</p>
				<p class="blocksatz">
				<span class="fett">${AnzeigeForm.standort} und im Umkreis von ${AnzeigeForm.umkreis} Kilometern</span> </p> <br>
				<p class="blocksatz">
				Anzeige veröffentlicht von <span class="fett">${AnzeigeForm.vorname}</span><br /><br /> 		
				</p>
			</article>
		
	<!-- Lukas -->
	<div class="unten">
		<c:if test="${AnzeigeForm.benutzerID != loginForm.benutzerID}">
			<a href="./../ServletAnzeigeBuchen?id=${AnzeigeForm.anzeigeID}" class = "button">Buchen</a>
		</c:if>
		<c:if test="${AnzeigeForm.benutzerID != loginForm.benutzerID}">
					<a href= "mailto:${AnzeigeForm.email}?subject=deinNachbar.de: ${AnzeigeForm.titelAnzeige}&body=Guten Tag ${AnzeigeForm.vorname}," title="hierzu muss ein E-Mail-Programm installiert sein" class="button"><img src="./../img/mail.png" width="17" height="13" alt="mail"> Nachricht an Inserenten</a><!-- quelle:https://www.tutorialspoint.com/de/html/html_email_links.htm#:~:text=HTML%20Email%20Tag,Adresse%20zusammen%20mit%20href%20attribute. -->
		</c:if>
		<c:if test="${AnzeigeForm.benutzerID == loginForm.benutzerID}">
			<a href="./../ServletAnzeigeLoeschen?id=${AnzeigeForm.anzeigeID}" class = "loeschButton">Löschen</a>
		</c:if>
	<!-- Veronika -->
		<c:if test="${AnzeigeForm.benutzerID != loginForm.benutzerID && loginForm.istAdmin}">
			<a href="./../ServletAnzeigeLoeschen?id=${AnzeigeForm.anzeigeID}" class = "loeschButton">Anzeige von ${AnzeigeForm.vorname} löschen</a>
		</c:if>
	<!-- Lukas -->
	</div>
</main>


<!-- Lukas -->
<%@ include file="footer.jspf"%>