<!-- Tobi -->

<%@ page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="fehlerausgabe.jsp"%>

<!-- Lukas -->
<%@ include file="header.jspf" %>
<script type="text/javascript" src="./../js/startseite.js"></script>

	<nav class="navStartseite">
			<!-- Tobi -->
			<form action="./../SuchServlet" method="post">
				<input type="text" name="suchstring" size="50" maxlength="50" placeholder="Was suchtst du?">
				<button type="submit" name= "suche" value="neu">🔎 Suchen</button>
			</form>
	</nav>
		
		<!-- Veronika -->
		
<div class="startseiteFlex">
		<!-- Veronika -->
		<main class="mainStartseite">
				<ul class="tabsSucheBiete">
					<!-- Navigation zu IDs - ausblenden der anderen Liste mit JavaScript -->
					<li><a href="#tabSuche">Suche</a></li>
					<li><a href="#tabBiete">Biete</a></li>
				</ul>
		<c:forEach var="currentSucheAnzeige" items="${suchenAnzeigen}" varStatus="status">
			<div  class="anzeigeBox"> <!-- id="tabSuche" -->
				<ul>
					<li>
					<img src="./../ServletBildAnzeige?anzeigeID=${currentSucheAnzeige.anzeigeID}" width="300" height="auto" onerror="this.src='./../img/logo.jpeg';" alt="Kein Bild vorhanden"></li>  <!--onerror: https://bit.ly/3N6GpwJ  -->
					<li>${currentSucheAnzeige.anzeigeArt}</li>
					<li><h4>${currentSucheAnzeige.titelAnzeige}</h4></li>
					<li>${currentSucheAnzeige.preis} € ${currentSucheAnzeige.preiskategorie}</li>
					<li>${currentSucheAnzeige.standort}</li>
					<br>
					<li><a href="./../ServletAnzeigeAnzeigen?anzeigeid=${currentSucheAnzeige.anzeigeID}" class="button">Zur Anzeige</a></li>
				</ul>
			</div>
		</c:forEach>

		<c:forEach var="currentBieteAnzeige" items="${bieteAnzeigen}" varStatus="status">
			<div  class="anzeigeBox"> <!--  id="tabBiete" -->
		
				<ul>
					<li>
					<img src="./../ServletBildAnzeige?anzeigeID=${currentBieteAnzeige.anzeigeID}" width="300" height="auto" onerror="this.src='./../img/logo.jpeg';" alt="Kein Bild vorhanden"></li> <!--onerror: https://bit.ly/3N6GpwJ  -->
					<li>${currentBieteAnzeige.anzeigeArt}</li>
					<li><h4>${currentBieteAnzeige.titelAnzeige}</h4></li>
					<li>${currentBieteAnzeige.preis} € ${currentBieteAnzeige.preiskategorie}</li>
					<li>${currentBieteAnzeige.standort}</li>
					<br>
					<li><a href="./../ServletAnzeigeAnzeigen?anzeigeid=${currentBieteAnzeige.anzeigeID}" class="button">Zur Anzeige</a></li>
				</ul>
			</div>
		</c:forEach>
	</main>
	<aside class="sidebar">
			<h2>Kategorien</h2>
			
<c:forEach var="currentKategorie" items="${kategorien}" varStatus="status">
	<span>${currentKategorie.kategorie}</span>
			<c:if test="${sessionScope.loginForm.istAdmin}">
				<a href="./../ServletKategorieBearbeiten?kategorieID=${currentKategorie.kategorieID}"><img src="./../img/pencil.png" width="17px" height="17px"></a> <!--Bildquelle: http://bitly.ws/IDup-->
  				<a class="loeschLink" href="./../ServletKategorieLoeschen?kategorieID=${currentKategorie.kategorieID}&kategorie=${currentKategorie.kategorie}" ><img src="./../img/bin.png" width="17px" height="17px"></a><!--Bildquelle: http://bitly.ws/IDuh-->
			</c:if>
			<br>
</c:forEach>
			
	<c:if test="${sessionScope.loginForm.istAdmin}">
    	<!--  Admin Kategorien bearbeiten  -->
    <form action="./../ServletKategorieNeu" method="POST" class="spaceTop">
    	<input type="text" name="neueKategorie" size="50" maxlength="50" placeholder="Neue Kategorie" required> 
    	<br>
    	<button type="submit" value="neu" name="kategorie">➕ Kategorie ergänzen</button>
    </form>
    	
	</c:if>

		</aside>
	


<!-- Lukas -->
<%@ include file="footer.jspf" %> 