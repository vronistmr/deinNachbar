// Tobi

document.addEventListener("DOMContentLoaded", init);

//function init() {
 // document.getElementById("regbutton").addEventListener("click", checkPasswordMatch);
//}

function checkPasswordMatch(event) {
  event.preventDefault(); // Verhindert das Absenden des Formulars

  var password = document.getElementById("passwort").value;
  var confirmPassword = document.getElementById("passwortwdh").value;
  var registerButton = document.getElementById("registrierenButton");

  if (password !== confirmPassword) {
    registerButton.disabled = true;
    alert("Die Passwörter stimmen nicht überein!");
  } else {
    registerButton.disabled = false;
    // Hier kannst du weitere Logik hinzufügen, um das Formular zu senden oder andere Aktionen auszuführen
    document.getElementById("registrierung").submit(); // Beispiel: Formular wird automatisch gesendet
  }
}
