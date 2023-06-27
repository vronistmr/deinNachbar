//Lukas
"use strict";

document.addEventListener("DOMContentLoaded", init);

function init() {
	warnung();
	document.getElementById("ajaxLogIn").addEventListener("click", check);
}
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
    var searchURL = "ServletIndex";
    var email = document.getElementById("email").value;
    var passwort = document.getElementById("passwort").value;

    var xmlhttp = new XMLHttpRequest();
    xmlhttp.addEventListener("load", function() {
        var response = xmlhttp.responseText;

        if (response === "success") {
            document.getElementById("ajaxPasswortFalsch").innerHTML = "";
            document.getElementById("loginForm").submit();
        } else {
            document.getElementById("ajaxPasswortFalsch").innerHTML = xmlhttp.responseText;
        }
    });
    xmlhttp.open("POST", searchURL, true);
    xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xmlhttp.send("email=" + email + "&passwort=" + passwort);
}


function warnung() {
	alert("🍪 Wir verwenden Cookies! Möchtest du diese akzeptieren?");
}