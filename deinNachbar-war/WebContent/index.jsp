<!-- Lukas -->

<%@ page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="fehlerausgabe.jsp"%>

<%@ include file="./html/header.jspf"%>

<main>
	<!-- Tobi -->
	<div class="centeredflex">
	<form method="POST" action="./ServletIndex">
		<h1>Login</h1>
		<div class="spacereg">
		<input autofocus type="text"
			id="email" name="email" maxlength="40"
			title="Bitte geben sie ihre Email-Adresse ein, mit der sie sich registriert haben!"
			required placeholder="E-Mail"> 
		</div>
		<div class="spaceReg">
		<input
			type="password" id="passwort" name="passwort" maxlength="20"
			title="Bitte geben sie ihr Passwort ein, mit dem sie sich registriert haben!"
			required placeholder="Passwort">
		</div>
		<div class="regbutton">
		<button type="submit">OK</button>
		</div>
	</form>
	<nav>
			<a href="./html/registrieren.jsp">Neu
				Registrieren</a>
	</nav>
	</div>
</main>


<!-- Lukas -->
<%@ include file="./html/footer.jspf"%>