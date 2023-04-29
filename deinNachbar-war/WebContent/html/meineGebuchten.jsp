<!-- Tobi -->
<%@ page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page errorPage="fehlerausgabe.jsp" %>
<!-- Tobi -->

<!DOCTYPE html>
<html>
<!-- Lukas -->
<head>
<meta charset="UTF-8">
<title>meineGebuchten</title>
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
		<h1>Meine Gebuchten</h1>
		<table style="width: 100%">
			<tr>
				<td>test</td>
				<td>test</td>
				<td>test</td>
			</tr>
			<tr>
				<td>test</td>
				<td>test</td>
				<td>test</td>
			</tr>
			<tr>
				<td>test</td>
				<td>test</td>
				<td>test</td>
			</tr>
		</table>
		<br />
		<nav>
			<form>
				<button formaction="./startseite.html">+</button>
			</form>
		</nav><br/>
	</main>

	<!-- Lukas -->
	<footer>
		<nav>
			<a href="./agb.html">AGB</a> <a href="./impressum.html">Impressum</a>
			<a href="./Ã¼berUns.html">Ãber uns</a>
		</nav>
	</footer>
</body>
</html>