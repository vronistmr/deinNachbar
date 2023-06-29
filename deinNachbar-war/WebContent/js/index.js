//Lukas
"use strict";

document.addEventListener("DOMContentLoaded", init);

function init() {
	document.getElementById("ajaxLogIn").addEventListener("click", check);
	document.getElementById("ajaxLogIn").addEventListener("click", check);
}

//Veronika, Tobi, Lukas
/*
function check() {
	var searchURL = "ServletIndex";
	var email = document.getElementById("email").value;
	var passwort = document.getElementById("passwort").value;

	var xmlhttp = new XMLHttpRequest();
	xmlhttp.addEventListener("load", function() {
		document.getElementById("ajaxPasswortFalsch").innerHTML = xmlhttp.responseText;
	});
	xmlhttp.open("POST", searchURL, true);
	xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xmlhttp.send("email=" + email + "&passwort=" + passwort);
}
*/
function check() {
	var email = document.getElementById("email").value;
	var passwort = document.getElementById("passwort").value;
	var xmlhttp = new XMLHttpRequest();
	xmlhttp.responseType = "json";
	xmlhttp.addEventListener("load", function() {
		var fehlermeldung = xmlhttp.response;
		if(fehlermeldung.fehlermeldungLogin === "richtig"){
			document.getElementById("loginForm").submit();
		}else {
			document.getElementById("ajaxPasswortFalsch").innerHTML = fehlermeldung.fehlermeldungLogin;
		}
	});

	xmlhttp.open("POST", "ServletIndex", true);
	xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xmlhttp.send("email=" + email + "&passwort=" + passwort);
}