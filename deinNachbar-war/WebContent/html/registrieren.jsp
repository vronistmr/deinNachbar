<!-- Lukas -->

<%@ page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="fehlerausgabe.jsp"%>

<%@ include file="header.jspf"%>


<main>
	<!-- Tobi -->
	<div class="centeredflex">
	<form method="POST" action="./../ServletRegistrierung">
		<h1>Registrieren</h1>
		<div class="spaceReg">
		<input autofocus type="text"
			id="vorname" name="vorname" size="30" maxlength="40" required Placeholder="Name"><span></span> 
		</div>
		<div class="spaceReg">
		<input type="email" id="email"
			name="email" size="30" maxlength="50"
			pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$"
			title="Bitte geben sie eine g&uuml;ltige Email-Adresse der Form: characters@characters.domain ein!"
			required placeholder="E-Mail"><span></span>
		</div>
		<div class="spaceReg">
		    <input
			type="password" id="passwort" name="passwort" size="30"
			maxlength="255" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
			title="Das Passwort muss mindestens einen Gro&szlig;buchstaben, einen Kleinbuchstaben, eine Nummer und mindestens 8 Zeichen enthalten!"
			required placeholder="Passwort"><span></span>
		</div>
		<div class="spaceReg">
		<input type="password" id="passwortwdh"
			name="passwortwdh" size="30" maxlength="255" required placeholder="Passwort wiederholen"><span></span>
		</div>
		<div class="spaceReg">
		<input type="text" id="standort"
			name="standort" size="30" maxlength="50" required placeholder="Dein Standort"><span></span>
		</div>
		<div class="regbutton">
		<button type="submit" name="registrierung" value="neu">Registrieren</button>
		</div>
	</form>
	</div>
</main>


<!-- Lukas -->
<%@ include file="footer.jspf"%>