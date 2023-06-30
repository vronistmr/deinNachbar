//Veronika 
/*
"use strict";

document.addEventListener("DOMContentLoaded", init);

function init() {
	evtBildladenFehler();
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
*/