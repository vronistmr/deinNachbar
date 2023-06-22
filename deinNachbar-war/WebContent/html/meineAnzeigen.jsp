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
				<span><img src="./../ServletBildAnzeige?anzeigeID=${currentAnzeige.anzeigeID}" width="300" height="200" onerror="this.src='./../img/logo.jpeg';" alt="Kein Bild vorhanden"></span><br /><!--onerror: https://bit.ly/3N6GpwJ  -->
					<span>${currentAnzeige.anzeigeArt}</span><br />
					<h4>${currentAnzeige.titelAnzeige}</h4><br />
					<c:if test="${currentAnzeige.preiskategorie == 'Gratis'}">
							<span>Zu Verschenken</span><br />
					 </c:if>
					<c:if test="${currentAnzeige.preiskategorie != 'Gratis'}">
							<span>${currentAnzeige.preis} € 
							${currentAnzeige.preiskategorie}</span><br />
					</c:if>
					<span>${currentAnzeige.standort}</span><br />
					<br />
					<span><a href="./../ServletAnzeigeAnzeigen?anzeigeid=${currentAnzeige.anzeigeID}" class="button">Zur Anzeige</a></span><br />
			</div>
	</c:forEach>
</main>
</div>

<!-- Lukas -->
<%@ include file="footer.jspf"%>