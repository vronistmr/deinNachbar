<!-- Tobi -->
<%@ page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page errorPage="fehlerausgabe.jsp" %>

<!-- Lukas -->
<%@ include file="header.jspf" %> 

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
			<!-- Tobi -->
			<form action="./../SuchServlet" method="post">
				<input type="text" name="suchstring" size="50" maxlength="50" placeholder="Was suchtst du?">
				<button name= "submit" type="submit">Suchen</button>
			</form>
			<!-- Tobi -->
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
	<%@ include file="footer.jspf" %> 