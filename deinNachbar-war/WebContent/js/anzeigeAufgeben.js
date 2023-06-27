//Veronika
"use strict";

document.addEventListener("DOMContentLoaded", init);

function init() {
	var preiskategorie = document.getElementById("preiskategorie");
	preiskategorie.addEventListener("change", zuVerschenken);
}

function zuVerschenken() {
	let preisfeld = document.getElementById("preis");
	if (document.getElementById("preiskategorie").value === "Gratis") {
		preisfeld.value = "0";
		preisfeld.readOnly = true;
	} else {
		preisfeld.readOnly = false;
		preisfeld.removeAttribute("value");

	}
}