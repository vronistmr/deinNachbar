//Lukas
"use strict";

document.addEventListener("DOMContentLoaded", init);

function init() {
	var loeschLink = document.getElementsByClassName("loeschLink");
	for (var i = 0; i < loeschLink.length; i++) {
		loeschLink[i].addEventListener("click", warnung)
	}
	filterSuche(); //EventListner für Filter initieren
	filterBiete(); //EventListner für Filter initieren 
	filterKategorie();
	filterAus();
}

function warnung(evt) {
	var really = confirm("⚠️ Möchtest du diese Kategorie wirklich endgültig Löschen? Damit werden automatisch auch alle zur Kategorie gehörigen Anzeigen endgültig gelöscht!");
	if (!really) {
		evt.preventDefault();
	}
}



//Veronika
//Funktion, um nur Suche-Anzeigen zu Filtern + Filter Button wird entsprechend gefärbt
function sucheAnzeigenFiltern() {
	document.getElementById("sucheAnzeigen").className = "eingeblendet";
	document.getElementById("bieteAnzeigen").className = "ausgeblendet";
	document.getElementById("ButtonFilterSuche").className = "aktiverFilterButton";
	document.getElementById("ButtonFilterBiete").className = "inaktiverFilterButton";
}

//Funktion, um nur Biete-Anzeigen zu Filtern + Filter Button wird entsprechend gefärbt
function bieteAnzeigenFiltern() {
	document.getElementById("sucheAnzeigen").className = "ausgeblendet";
	document.getElementById("bieteAnzeigen").className = "eingeblendet";
	document.getElementById("ButtonFilterSuche").className = "inaktiverFilterButton";
	document.getElementById("ButtonFilterBiete").className = "aktiverFilterButton";
}

//EventLister auf Filter "Suche"
function filterSuche() {
	var filterSuche = document.getElementById("ButtonFilterSuche");
	filterSuche.addEventListener("click", sucheAnzeigenFiltern);
}

//EventLister auf Filter "Biete"
function filterBiete() {
	var filterSuche = document.getElementById("ButtonFilterBiete");
	filterSuche.addEventListener("click", bieteAnzeigenFiltern);
}

//Filtern der Anzeigen auf der Startseite
function filter() {
	var filterKategorie = this.textContent; //Content des Buttons, der von EventListener überwacht wird -> danach soll gefiltert werden
	var kategorieAnzeige = document.getElementsByClassName("kategorie"); //Liste an Kategorien der Anzeigen
	for (var i = 0; i < kategorieAnzeige.length; i++) {
		//Quelle: https://developer.mozilla.org/en-US/docs/Web/API/Element/closest -> sucht Elternelemente mit angegebener css selector
		var anzeigeBoxElement = kategorieAnzeige[i].closest(".anzeigeBox"); //suchen Elternelemente anhand Kategorien der Anzeigen (in jsp ausgeblendet)
		if (kategorieAnzeige[i].textContent === filterKategorie) {
			//AnzeigeBoxen entsprechend ein-/ausblenden 
			anzeigeBoxElement.classList.add("eingeblendet");
			anzeigeBoxElement.classList.remove("ausgeblendet");
		} else {
			anzeigeBoxElement.classList.add("ausgeblendet");
			anzeigeBoxElement.classList.remove("eingeblendet");
		}
	}
	//Grau hinterlegen der aktiven Kategorie - bei allen anderen die class für Auswahl entfernen
	var kategorien = document.querySelectorAll("button.kategorieButton");
	for (var i = 0; i < kategorien.length; i++) {
		kategorien[i].classList.remove("kategorieAktiv");
	}
	this.classList.add("kategorieAktiv");
}

//Event Listender für Kategorien
function filterKategorie() {
	var kategorien = document.querySelectorAll("button.kategorieButton");
	for (var i = 0; i < kategorien.length; i++) {
		kategorien[i].addEventListener("click", filter);
	}
}

//Fiter ausschalten - alle Kategorien werden angezeigt
function filterZuruecksetzten() {
	var kategorieAnzeige = document.getElementsByClassName("kategorie");
	for (var i = 0; i < kategorieAnzeige.length; i++) {
		//Quelle: https://developer.mozilla.org/en-US/docs/Web/API/Element/closest -> sucht Elternelemente mit angegebener css selector
		var anzeigeBoxElement = kategorieAnzeige[i].closest(".anzeigeBox"); //alle Anzeigeboxen einblenden
		anzeigeBoxElement.classList.add("eingeblendet");
		anzeigeBoxElement.classList.remove("ausgeblendet");
	}
}

//EventListener für "alle Kategorien"
function filterAus() {
	var alleKategorien = document.getElementById("alleKategorien");
	alleKategorien.addEventListener("click", filterZuruecksetzten);
}