<!-- Tobi -->
<%@ page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page errorPage="fehlerausgabe.jsp" %>
<!-- Tobi -->
<!DOCTYPE html>
<html>
<!-- Lukas -->
<head>
<meta charset="UTF-8">
<title>startseite</title>
<!-- Tobi -->
<base href="$ {pageContext.request.requestURI}"/>
<!-- Tobi -->

</head>
<body>
	<header>
		<nav>
			<a href="../index.html">deinNachbar.de</a>
			<div class="right-nav">
				<form>
					<button formaction="./anzeigeAufgeben.html">Anzeige
						aufgeben</button>
				</form>
			</div>
			<div class="dropdown">
				<button class="dropbtn">Profil</button>
				<div class="dropdown-content">
					<a href="./meineAnzeigen.html">Meine Anzeigen</a> <a
						href="./meineGebuchten.html">Meine Gebuchten</a> <a
						href="../index.html">Ausloggen</a>
				</div>
			</div>
		</nav>
	</header>

	<main>
		<!-- Veronika -->
		<aside>
			<h3>Kategorien</h3>
			<ol>
				<li><img src=../img/haus.jpg width="30" height="30"> Haus</li>
				<li><img src=../img/garten.jpg width="30" height="30">Garten</li>
				<li><img src=../img/elektronik.jpg width="30" height="30">Elektronik</li>
				<li><img src=../img/technik.jpg width="30" height="30">Technik</li>
				<li><img src=../img/kreativ.jpg width="30" height="30">Kreativ</li>
			</ol>
		</aside>
		<nav>
			<form>
				<input type="text" name="suche" size="50" maxlength="50" placeholder="Was suchtst du?">
				<button type="submit">Suchen</button>
			</form>
			<div id="tabsSucheBiete">
				<ul>
					<!-- Navigation zu IDs - ausblenden der anderen Liste mit JavaScript -->
					<li><a href="#tabSuche">Suche</a></li>
					<li><a href="#tabBiete">Biete</a></li>
				</ul>
			</div>
		</nav>
		<div id="FensterFürAnzeigen">
			<div id="tabSuche">
				<ul>
					<li>Suche Gärtner</li>
					<li>Suche Maler</li>
					<li>Suche Elektiker</li>
				</ul>
			</div>
			<div id="tabBiete">
				<ul>
					<li>Biete Malerarbeiten</li>
					<li>Biete Einaufshilfe</li>
					<li>Biete Elekronikservice</li>
				</ul>
			</div>
		</div>

	</main>

	<!-- Lukas -->
	<footer>
		<nav>
			<a href="./agb.html">AGB</a> <a href="./impressum.html">Impressum</a>
			<a href="./überUns.html">Über uns</a>
		</nav>
	</footer>
</body>
</html>