// Tobi

/*
document.addEventListener("DOMContentLoaded", init);

function init() {
  document.getElementById("registrierenButton").addEventListener("click", checkPasswordMatch);
}

function checkPasswordMatch(event) {
  
  event.preventDefault(); // Verhindert das Absenden des Formulars
  
  var password = document.getElementById("passwort").value;
  var confirmPassword = document.getElementById("passwortwdh").value;
  var registerButton = document.getElementById("registrierenButton");

  if (password !== confirmPassword) {
    registerButton.disabled = true;
    
    document.getElementById("meinTest").innerHTML = "Die Passwörter stimmen nicht überein!";
  } else {
    registerButton.disabled = false;
    document.getElementById("meinTest").innerHTML = ""; // Entfernt die Fehlermeldung
     // Überprüfe, ob das Formular korrekt ausgefüllt ist
    event.target.form.submit(); // Formular wird gesendet
    
  }
}
*/

document.addEventListener("DOMContentLoaded", init);

function init() {
  document.getElementById("registrierenButton").addEventListener("click", checkPasswordMatch);
}

function checkPasswordMatch(event) {
  event.preventDefault(); // Verhindert das Absenden des Formulars

  var password = document.getElementById("passwort").value;
  var confirmPassword = document.getElementById("passwortwdh").value;
  var registerButton = document.getElementById("registrierenButton");
  var errorMessage = document.getElementById("meinTest");

  if (password !== confirmPassword) {
    registerButton.disabled = true;
    errorMessage.innerHTML = "Die Passwörter stimmen nicht überein!";
  } else {
    registerButton.disabled = false;
    errorMessage.innerHTML = ""; // Entfernt die Fehlermeldung
  }

  if (isFormValid()) {
    event.target.form.submit(); // Formular wird gesendet
  }
}

function isFormValid() {
  var form = document.getElementById("registrierenForm");

  // Führe hier die Validierung für andere Felder des Formulars durch
  // Zum Beispiel: Überprüfung von Name, E-Mail usw.

  // Return true, wenn das Formular gültig ist, andernfalls false
  return form.checkValidity() && !document.getElementById("meinTest").innerHTML;
}





  