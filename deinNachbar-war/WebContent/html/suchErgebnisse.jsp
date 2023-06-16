<!-- Tobi -->

<%@ page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="fehlerausgabe.jsp"%>

<%@ include file="header.jspf"%>

<div class="startseiteFlex">
<main>

	<h1>Gesuchte Anzeigen</h1>
	
	<c:forEach items="${Anzeigen}" var="gesuchteAnzeige" varStatus="status">
				<div class="anzeigeBox">
				<ul>
					<li>
					<img src="./../ServletBildAnzeige?anzeigeID=${gesuchteAnzeige.anzeigeID}" width="300" height="auto" onerror="this.src='./../img/logo.jpeg';" alt="Kein Bild vorhanden"></li> <!--onerror: https://bit.ly/3N6GpwJ  -->
					<li>${gesuchteAnzeige.anzeigeArt}</li>
					<li><h4>${gesuchteAnzeige.titelAnzeige}</h4></li>
					<li>${gesuchteAnzeige.preis} €</li>
					<li>${gesuchteAnzeige.preiskategorie}</li>
					<li>${gesuchteAnzeige.standort}</li>
					<br>
					<li><a href="./../ServletAnzeigeAnzeigen?anzeigeid=${gesuchteAnzeige.anzeigeID}" class="button">Zur Anzeige</a></li>
				</ul>
				</div>
			</c:forEach>
			
	<br>
	
</main>
</div>

<!-- Lukas -->
<%@ include file="footer.jspf"%>