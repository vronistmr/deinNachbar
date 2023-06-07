<!-- Tobi -->

<%@ page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="fehlerausgabe.jsp"%>

<!-- Lukas -->
<%@ include file="header.jspf" %>

	<main>
		<!-- Veronika -->
		
		<aside>
			<h2>Kategorien</h2>
			
			<c:forEach var="currentKategorie" items="${kategorien}" varStatus="status">
					<li>${currentKategorie.kategorie}</li>
				<c:if test="${sessionScope.loginForm.istAdmin}">
					
						<a href="./../ServletKategorieBearbeiten?kategorieID=${currentKategorie.kategorieID}">Bearbeiten</a>
  						<a href="./../ServletKategorieLoeschen?kategorieID=${currentKategorie.kategorieID}&kategorie=${currentKategorie.kategorie}">Löschen</a>
					
					</c:if>
			</c:forEach>
			
			<c:if test="${sessionScope.loginForm.istAdmin}">
    	<!-- Hier der Code für Admin - Kategorien bearbeiten  -->
    	<form action="./../ServletKategorieNeu" method="POST">
    	<input type="text" name="neueKategorie" size="50" maxlength="50" placeholder="Neue Kategorie" required> <br>
    	<button type="submit" value="neu" name="action">Kategorie ergänzen</button>
    	</form>
    	
			</c:if>

		</aside>
		<nav>
			<!-- Tobi -->
			<form action="./../SuchServlet" method="post">
				<input type="text" name="suchstring" size="50" maxlength="50" placeholder="Was suchtst du?">
				<button name= "submit" type="submit">Suchen</button>
			</form>
		</nav>
		<!-- Veronika -->
		<div class="tabsSucheBiete">
				<ul>
					<!-- Navigation zu IDs - ausblenden der anderen Liste mit JavaScript -->
					<li><a href="#tabSuche">Suche</a></li>
					<li><a href="#tabBiete">Biete</a></li>
				</ul>
	</div>
	<div id="tabSuche">
		<c:forEach var="currentSucheAnzeige" items="${suchenAnzeigen}" varStatus="status">
				<ul>
					<li>
					<img src="./../ServletBildAnzeige?anzeigeID=${currentSucheAnzeige.anzeigeID}" width="300" height="auto" onerror="this.src='./../img/blume.png';"></li>  <!--onerror: https://bit.ly/3N6GpwJ  -->
					<li><h4>${currentSucheAnzeige.titelAnzeige}</h4></li>
					<li>${currentSucheAnzeige.preis} €</li>
					<li>${currentSucheAnzeige.preiskategorie}</li>
					<li>${currentSucheAnzeige.standort}</li>
					<li><a href="./../ServletAnzeigeAnzeigen?anzeigeid=${currentSucheAnzeige.anzeigeID}" class="button">Zur Anzeige</a></li>
				</ul>
		</c:forEach>
	</div>
	
	<div id="tabBiete">
		<c:forEach var="currentBieteAnzeige" items="${bieteAnzeigen}" varStatus="status">
				<ul>
					<li>
					<img src="./../ServletBildAnzeige?anzeigeID=${currentBieteAnzeige.anzeigeID}" width="300" height="auto" onerror="this.src='./../img/blume.png';"></li> <!--onerror: https://bit.ly/3N6GpwJ  -->
					<li><h4>${currentBieteAnzeige.titelAnzeige}</h4></li>
					<li>${currentBieteAnzeige.preis} €</li>
					<li>${currentBieteAnzeige.preiskategorie}</li>
					<li>${currentBieteAnzeige.standort}</li>
					<li><a href="./../ServletAnzeigeAnzeigen?anzeigeid=${currentBieteAnzeige.anzeigeID}" class="button">Zur Anzeige</a></li>
				</ul>
		</c:forEach>
	</div>
			
	</main>
	


<!-- Lukas -->
<%@ include file="footer.jspf" %> 