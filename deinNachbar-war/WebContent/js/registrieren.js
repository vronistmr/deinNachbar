// Tobi
"use strict";

document.addEventListener("DOMContentLoaded", init);

function init() {
	var form = document.getElementById("passwortwdh");
	form.addEventListener("keyup", checkPasswordMatch);
	evtemailValidierung();
}

function checkPasswordMatch(event) {

	var password = document.getElementById("passwort").value;
	var confirmPassword = document.getElementById("passwortwdh").value;
	var fehlerMessage = document.getElementById("fehlerText");

	if (password !== confirmPassword) {
		event.preventDefault(); // Verhindert das Absenden des Formulars (Standardverhalten)
		fehlerMessage.innerHTML = "Die Passwörter stimmen nicht überein!";
	} else {
		fehlerMessage.innerHTML = ""; // Entfernt die Fehlermeldung
	}
}

//Veronika, Tobi, Lukas
function emailValidierungAjax() {
	var form = document.getElementById("registrierenForm");
	var email = document.getElementById("email").value;
	var vorname = document.getElementById("vorname").value;
	var passwort = document.getElementById("passwort").value;
	var standort = document.getElementById("standort").value;


	var xmlhttp = new XMLHttpRequest();
	xmlhttp.responseType = "json";

	xmlhttp.addEventListener("load", function() {
		var fehlermeldung = xmlhttp.response;
		var fehlermeldungReg = fehlermeldung.fehlermeldungRegistieren;


		if (fehlermeldungReg === "Registrieren erfolgreich") {
			document.getElementById("registrierenForm").submit();
		} else {
			document.getElementById("ajaxMailSchonVergeben").innerHTML = fehlermeldungReg;
		}

	});

	if (form.checkValidity()) { //Prüft ob Vorgaben des HTML Formulars erfüllt sind
		xmlhttp.open("POST", "./../ServletRegistrierung", true);
		xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xmlhttp.send("vorname=" + vorname + "&email=" + email + "&passwort=" + passwort + "&standort=" + standort);
	}
	else {
		document.getElementById("formularPattern").innerHTML = "Bitte Vorgaben erfüllen!";
	}

}


function evtemailValidierung() {
	var registrierenButton = document.getElementById("registrierenButton");
	registrierenButton.addEventListener("click", emailValidierungAjax);
}