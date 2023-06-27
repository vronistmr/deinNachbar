//Lukas
"use strict";

document.addEventListener("DOMContentLoaded", init);

function init() {
	warnung();
	document.getElementById("ajaxLogIn").addEventListener("click", check);
}

function check() {
	var searchURL = "ServletIndex";

	var xmlhttp = new XMLHttpRequest();

	xmlhttp.addEventListener("load", function() {
		document.getElementById("ajaxPasswortFalsch").innerHTML = xmlhttp.responseText;
	});
	xmlhttp.open("POST", searchURL, true);
	xmlhttp.send();
}

function warnung() {
	alert("🍪 Wir verwenden Cookies! Möchtest du diese akzeptieren?");
}