// Tobi


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
    document.getElementById("fehlerText").innerHTML = "Die Passwörter stimmen nicht überein!";
  } else {
    registerButton.disabled = false;
    document.getElementById("fehlerText").innerHTML = ""; // Entfernt die Fehlermeldung
     // Überprüfe, ob das Formular korrekt ausgefüllt ist
    event.target.form.submit(); // Formular wird gesendet
    
  }
}


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
  var errorMessage = document.getElementById("fehlerText");

  if (password !== confirmPassword) {
    registerButton.disabled = true;
    errorMessage.innerHTML = "Die Passwörter stimmen nicht überein!";
  } else {
    errorMessage.innerHTML = ""; // Entfernt die Fehlermeldung
    registerButton.disabled = false;
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

/*

	window.onload = function(){

  var passwort = document.getElementById("passwort").value;
  var confirmPasswort = document.getElementById("passwortwdh").value;
  var registrierungsButton = document.querySelector(button[name="registrierung"]);
  var errorMessage = document.getElementById("fehlerText");
	
	confirmPasswort.addEventListener("input", function(){
		if(passwort !== confirmPasswort){
			errorMessage.innerHTML("Die Passwörter stimmen nicht überein!");
			errorMessage.style.color = "red";
			registrierungsButton.disabled = true;
			
		}else{
			errorMessage.innerHTML="";
			registrierungsButton.disabled = false;
		}
		
	});

}
 */