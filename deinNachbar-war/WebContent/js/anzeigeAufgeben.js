//Veronika
"use strict";

document.addEventListener("DOMContentLoaded", init);

function init() {
    var preiskategorie = document.getElementById("preiskategorie");
    preiskategorie.addEventListener("change", zuVerschenken);
}

	
function zuVerschenken() {
	if (document.getElementById("preiskategorie").value === "Gratis") {
        document.getElementById("preis").outerHTML = '<input type="number" name="preis" id="preis" value="0" readonly>';
	}else{
		document.getElementById("preis").outerHTML = '<input type="number" name="preis" id="preis" max="999" placeholder="Preis in Euro" required class="rahmenRot" title="Gib ein, wie viel du verlangen willst bzw. wie viel du zahlen willst">';
	}
}