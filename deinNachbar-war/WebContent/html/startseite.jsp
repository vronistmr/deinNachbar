<!-- Tobi -->

<%@ page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page errorPage="fehlerausgabe.jsp"%>

<!-- Lukas -->
<%@ include file="header.jspf"%>
<script type="text/javascript" src="./../js/startseite.js"></script>
<script type="text/javascript" src="./../js/bildError.js"></script>


<nav class="navStartseite">
	<!-- Tobi -->
	<form action="./../SuchServlet" method="post">
		<input type="text" name="suchstring" size="50" maxlength="50"
			placeholder="Was suchtst du?">
		<button type="submit" name="suche" value="neu">🔎 Suchen</button>
	</form>
</nav>

<!-- Veronika -->

<div class="startseiteFlex">
	<main class="mainStartseite">
		<!-- Navigation zu IDs - ausblenden der anderen Liste mit JavaScript -->
		<!-- Bildquelle Filter: http://bitly.ws/J6Ay -->
		<button type="button" id="ButtonFilterSuche"
			class="aktiverFilterButton">
			<img height="17" width="17" src="./../img/filter.png" alt="Filter">
			Suche
		</button>
		<button type="button" id="ButtonFilterBiete"
			class="inaktiverFilterButton">
			<img height="17" width="17" src="./../img/filter.png" alt="Filter">
			Biete
		</button>
		<div id="sucheAnzeigen" class="eingeblendet">
			<c:forEach var="currentSucheAnzeige" items="${suchenAnzeigen}">
				<div class="anzeigeBox">
					<span><img
						src="./../ServletBildAnzeige?anzeigeID=${currentSucheAnzeige.anzeigeID}"
						width="300" height="200" alt="Kein Bild vorhanden"><br /></span>
					<span>${currentSucheAnzeige.anzeigeArt}</span><br />
					<h4>${currentSucheAnzeige.titelAnzeige}</h4>
					<br />
					<c:if test="${currentSucheAnzeige.preiskategorie == 'Gratis'}">
						<span>Zu Verschenken</span>
						<br />
					</c:if>
					<c:if test="${currentSucheAnzeige.preiskategorie != 'Gratis'}">
						<span>${currentSucheAnzeige.preis} €
							${currentSucheAnzeige.preiskategorie}</span>
						<br />
					</c:if>
					<span>${currentSucheAnzeige.standort}</span><br /> <br /> <span><a
						href="./../ServletAnzeigeAnzeigen?anzeigeid=${currentSucheAnzeige.anzeigeID}"
						class="button">Zur Anzeige</a> </span><br /> <span
						class="ausgeblendet kategorie">${currentSucheAnzeige.kategorie}</span>
				</div>
			</c:forEach>
		</div>

		<div id="bieteAnzeigen" class="ausgeblendet">
			<c:forEach var="currentBieteAnzeige" items="${bieteAnzeigen}">
				<div class="anzeigeBox">
					<span><img
						src="./../ServletBildAnzeige?anzeigeID=${currentBieteAnzeige.anzeigeID}"
						width="300" height="200" alt="Kein Bild vorhanden"></span><br />
					<span>${currentBieteAnzeige.anzeigeArt}</span><br />
					<h4>${currentBieteAnzeige.titelAnzeige}</h4>
					<br />
					<c:if test="${currentBieteAnzeige.preiskategorie == 'Gratis'}">
						<span>Zu Verschenken</span>
						<br />
					</c:if>
					<c:if test="${currentBieteAnzeige.preiskategorie != 'Gratis'}">
						<span>${currentBieteAnzeige.preis} €
							${currentBieteAnzeige.preiskategorie}</span>
						<br />
					</c:if>
					<span>${currentBieteAnzeige.standort}</span><br /> <br /> <span><a
						href="./../ServletAnzeigeAnzeigen?anzeigeid=${currentBieteAnzeige.anzeigeID}"
						class="button">Zur Anzeige</a></span><br /> <span
						class="ausgeblendet kategorie">${currentBieteAnzeige.kategorie}</span>
				</div>
			</c:forEach>
		</div>
	</main>
	<aside class="sidebar">
		<h2>Kategorien</h2>
		<!-- Sidebar für normalen Benutzer/nichtAdmin -->
		<c:if test="${not sessionScope.loginForm.istAdmin}">
			<button type="button" class="kategorieButton kategorieAktiv"
				id="alleKategorien">Alle Kategorien</button>
			<c:forEach var="currentKategorie" items="${kategorien}">
				<button type="button" class="kategorieButton">${currentKategorie.kategorie}</button>
				<br />
			</c:forEach>
		</c:if>

		<!-- Sidebar für Admin -->
		<c:if test="${sessionScope.loginForm.istAdmin}">
			<button type="button"
				class="kategorieButton kategorieAktiv kategorieButtonWidthAdmin"
				id="alleKategorien">Alle Kategorien</button>
			<c:forEach var="currentKategorie" items="${kategorien}">
				<button type="button"
					class="kategorieButton kategorieButtonWidthAdmin">${currentKategorie.kategorie}</button>
				<a
					href="./../ServletKategorieLoeschen?kategorieID=${currentKategorie.kategorieID}&kategorie=${currentKategorie.kategorie}"
					class="loeschLink"><img src="./../img/bin.png" width="17"
					height="17" alt="löschen"></a>
				<!--Bildquelle: http://bitly.ws/IDuh-->
				<img src="./../img/pencil.png" width="17" height="17"
					alt="bearbeiten" class="kategorieBearbeiten">
				<!--Bildquelle: http://bitly.ws/IDup-->
				<!-- Lukas -->
				<form
					action="./../ServletKategorieBearbeiten?kategorieID=${currentKategorie.kategorieID}"
					method="POST" class="ausgeblendet bearbeitenForm">
					<input type="text" name="neuerName" size="50" maxlength="50"
						placeholder="Neuer Name" pattern="[A-Z].*"
						title="Kategorie muss mit einem Großbuchstaben beginnen" required>
					<br />
					<button type="submit" value="neu" name="bearbeiten">🖊️
						Kategorie umbenennen</button>
				</form>
				<!-- Veronika -->
				<br />
			</c:forEach>
			<form action="./../ServletKategorieNeu" method="POST"
				class="spaceTop">
				<input type="text" name="neueKategorie" size="50" maxlength="50"
					placeholder="Neue Kategorie" pattern="[A-Z].*"
					title="Kategorie muss mit einem Großbuchstaben beginnen"
					id="neueKategorie" required> <br />
				<button type="submit" value="neu" name="hinzufuegen"
					id="neueKategorieButton">➕ Kategorie ergänzen</button>
				<div id="fehlerKategorie"></div>
			</form>
		</c:if>

	</aside>
</div>


<!-- Lukas -->
<%@ include file="footer.jspf"%>