<!-- Lukas -->

<%@ page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="fehlerausgabe.jsp"%>

<%@ include file="header.jspf"%>


<main>
	<!-- Tobi -->
	<div class="centeredflex">
	<form method="POST" action="./../ServletRegistrierung">
		<h2>Registrieren</h2>
		<div class="vorname">
		<label for="vorname">Vorname:</label> <input autofocus type="text"
			id="vorname" name="vorname" size="30" maxlength="40" required><span></span> 
		</div>
		<div class="email">
		<label for="email">E-Mail:</label> <input type="email" id="email"
			name="email" size="30" maxlength="40"
			pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$"
			title="Bitte geben sie eine g&uuml;ltige Email-Adresse der Form: characters@characters.domain ein!"
			required><span></span> 
		</div>
		<div class="pwd">
		<label for="passwort">Passwort:</label> <input
			type="password" id="passwort" name="passwort" size="30"
			maxlength="20" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
			title="Das Passwort muss mindestens einen Gro&szlig;buchstaben, einen Kleinbuchstaben, eine Nummer und mindestens 8 Zeichen enthalten!"
			required><span></span> 
		</div>
		<div class="pwdwdh">
		<label for="passwortwdh">Passwort
			wiederholen:</label> <input type="password" id="passwortwdh"
			name="passwortwdh" size="30" maxlength="20" required><span></span> 
		</div>
		<div class="standort">
		<label for="standort">Standort:</label> <input type="text" id="standort"
			name="standort" size="30" maxlength="30" required><span></span> 
		</div>
		<div class="regbutton">
		<button type="submit" name="registrierung" value="neu">Registrieren</button>
		</div>
	</form>
	</div>
</main>


<!-- Lukas -->
<%@ include file="footer.jspf"%>