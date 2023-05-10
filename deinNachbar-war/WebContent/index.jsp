 <!-- Lukas -->
<%@ page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page errorPage="fehlerausgabe.jsp"%>
<%@ include file="./html/header.jspf"%>

<main>
	<!-- Tobi -->
	<form method="POST" action="./ServletIndex">
		<h2>Login</h2>

		<label for="email">Email:</label> <input autofocus type="text"
			id="email" name="email"
			pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$"
			title="Bitte geben sie eine g&uuml;ltige Email-Adresse der Form: characters@characters.domain ein!"
			required> <label for="passwort">Passwort:</label> <input
			type="password" id="passwort" name="passwort"
			pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
			title="Das Passwort muss mindestens einen Gro&szlig;buchstaben, einen Kleinbuchstaben, eine Nummer und mindestens 8 Zeichen enthalten!"
			required>

		<button type="submit">OK</button>
	</form>

	<nav>
		<p>
			Noch nicht registriert? <a href="./html/registrieren.jsp">Hier
				registrieren</a>
		</p>
	</nav>

</main>

<!-- Lukas -->
<%@ include file="./html/footer.jspf"%>
