//Lukas

document.addEventListener("DOMContentLoaded", init);

function init() {
	window.addEventListener("load", warnungCookies);
	evtBildladenFehler();
}

//https://developer.mozilla.org/en-US/docs/Web/API/Navigator/cookieEnabled
function warnungCookies() {
	if (navigator.cookieEnabled) {
	} else {
		// Cookies sind deaktiviert
		alert("🍪 Bitte aktiviere Cookies, um diese Website richtig nutzen zu können.");
	}
}

//onerror: https://bit.ly/3N6GpwJ

// Statt Attribut in img Tag: onerror="this.src='./../img/logo.jpeg';"
//Wenn ein Bild nicht geladen werden kann, weil nicht vorhanden - wird default Bild aus Ordnerstruktur angezeigt
function defautlBild(foto) {
	foto.src = "./../img/logo.jpeg";
}

function evtBildladenFehler() {
	var bilder = document.querySelectorAll("img");
	for (var i = 0; i < bilder.length; i++) {
		bilder[i].addEventListener("error", function() {
			defautlBild(this)
		});
	}
}