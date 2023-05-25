<!-- Lukas -->
<%@ page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page errorPage="fehlerausgabe.jsp"%>
<%@ include file="./html/header.jspf"%>

<main>
	<!-- Tobi -->
	<form method="POST" action="./ServletIndex">
		<h2>Login</h2>

		<label for="email">Email:</label> 
		<input autofocus type="text"
			id="email" name="email" size="30" maxlength="40"
			title="Bitte geben sie ihre Email-Adresse ein, mit der sie sich registriert haben!"
			required> 
		<label for="passwort">Passwort:</label> 
		<input
			type="password" id="passwort" name="passwort"
			size="30" maxlength="20"
			title="Bitte geben sie ihr Passwort ein, mit dem sie sich registriert haben!"
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
