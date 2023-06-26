<!-- Tobi -->

<%@ page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="fehlerausgabe.jsp"%>

<%@ include file="header.jspf"%>


<div class="startseiteFlex">
<main>
	<h1>Gesuchte Anzeigen</h1>
	
	<c:forEach items="${Anzeigen}" var="gesuchteAnzeige" varStatus="status">
				<div class="anzeigeBox">
					<span><img src="./../ServletBildAnzeige?anzeigeID=${gesuchteAnzeige.anzeigeID}" width="300" height="200" onerror="this.src='./../img/logo.jpeg';" alt="Kein Bild vorhanden"></span><br /><!--onerror: https://bit.ly/3N6GpwJ  -->
					<span>${gesuchteAnzeige.anzeigeArt}</span><br />
					<h4>${gesuchteAnzeige.titelAnzeige}</h4><br />
						<c:if test="${gesuchteAnzeige.preiskategorie == 'Gratis'}">
							<span>Zu Verschenken</span><br />
					 	</c:if>
						<c:if test="${gesuchteAnzeige.preiskategorie != 'Gratis'}">
							<span>${gesuchteAnzeige.preis} € 
							${gesuchteAnzeige.preiskategorie}</span><br />
						</c:if>
					<span>${gesuchteAnzeige.standort}</span><br />
					<br />
					<span><a href="./../ServletAnzeigeAnzeigen?anzeigeid=${gesuchteAnzeige.anzeigeID}" class="button">Zur Anzeige</a></span><br />
				</div>
			</c:forEach>
	<br>
	
</main>
</div>

<!-- Lukas -->
<%@ include file="footer.jspf"%>