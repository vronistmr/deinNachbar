<!-- Lukas -->

<%@ page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page errorPage="fehlerausgabe.jsp"%>

<%@ include file="header.jspf"%>
<script type="text/javascript" src="./../js/registrieren.js"></script>


<main>
<!-- Tobi -->
	<div class="centeredflex">
		<form id="registrierenForm" method="POST"
			action="./../ServletRegistrierungErfolgreich">
			<h1>Registrieren</h1>
			<div class="spaceReg">
				<input autofocus type="text" id="vorname" name="vorname" size="30"
					maxlength="40" required Placeholder="Name"
					title="Gib deinen Vor- und oder Nahchnamen ein"><span></span>
			</div>
			<div class="spaceReg">
<!-- patterns von W3Schools -->
				<input type="email" id="email" name="email" size="30" maxlength="50"
					pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$"
					title="Gib eine gültige Email-Adresse ein" required
					placeholder="E-Mail"><span></span>
			</div>
			<div class="spaceReg">
				<input type="password" id="passwort" name="passwort" size="30"
					maxlength="255" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
					title="Das Passwort muss mindestens einen Großbuchstaben, einen Kleinbuchstaben, eine Nummer und mindestens 8 Zeichen enthalten"
					required placeholder="Passwort"><span></span>
			</div>
			<div class="spaceReg">
				<input type="password" id="passwortwdh" name="passwortwdh" size="30"
					maxlength="255" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
					required placeholder="Passwort wiederholen"
					title="Wiederhole bitte das zuvor eingegebene Passwort"><span></span>
			</div>
			<div class="spaceReg">
				<input type="text" id="standort" name="standort" size="30"
					maxlength="50" required placeholder="Dein Standort"
					title="Gib bitte deinen Wohnort ein"><span></span>
			</div>
			<div class="regbutton">
				<button type="button" id="registrierenButton" name="registrierung"
					value="neu">Registrieren</button>
				<p id="fehlerText"></p>
			</div>
		</form>
		<p id="ajaxMailSchonVergeben"></p>
	</div>
</main>


<!-- Lukas -->
<%@ include file="footer.jspf"%>