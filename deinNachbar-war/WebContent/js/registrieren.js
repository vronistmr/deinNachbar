// Tobi
"use strict";

document.addEventListener("DOMContentLoaded", init);

function init() {
  var form = document.getElementById("passwortwdh");
  form.addEventListener("change", checkPasswordMatch);
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
