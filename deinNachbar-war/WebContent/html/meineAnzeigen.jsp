<!-- Tobi -->

<%@ page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="fehlerausgabe.jsp"%>

<!-- Lukas -->
<%@ include file="header.jspf"%>


<!-- Veronika -->
<div class="startseiteFlex">
<main>
	<h1>Meine Anzeigen</h1>
	<c:forEach var="currentAnzeige" items="${anzeigen}" varStatus="status">
			<div class="anzeigeBox">
				<ul>
					<li>
					<img src="./../ServletBildAnzeige?anzeigeID=${currentAnzeige.anzeigeID}" width="300" height="auto" onerror="this.src='./../img/logo.jpeg';" alt="Kein Bild vorhanden"></li><!--onerror: https://bit.ly/3N6GpwJ  --> 
					<li>${currentAnzeige.anzeigeArt}</li>
					<li><h4>${currentAnzeige.titelAnzeige}</h4></li>
					<li>${currentAnzeige.preis} € ${currentAnzeige.preiskategorie}</li>
					<li>${currentAnzeige.standort}</li>
					<br>
					<li><a href="./../ServletAnzeigeAnzeigen?anzeigeid=${currentAnzeige.anzeigeID}" class = "button">Zur Anzeige</a></li>
				</ul>
			</div>
	</c:forEach>
</main>
</div>

<!-- Lukas -->
<%@ include file="footer.jspf"%>