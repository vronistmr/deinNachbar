//Lukas
"use strict";

document.addEventListener("DOMContentLoaded", init);

function init() {
	var loeschLink = document.getElementsByClassName("loeschLink");
	for (var i = 0; i < loeschLink.length; i++) {
		loeschLink[i].addEventListener("click", warnung)
	}
	evtfilterSuche(); //EventListner für Filter initiieren
	evtfilterBiete(); //EventListner für Filter initiieren 
	evtfilterKategorie();
	evtfilterAus();
	evtKategorieBearbeiten();
	evtNeueKategorie();
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
function evtfilterSuche() {
	var filterSuche = document.getElementById("ButtonFilterSuche");
	filterSuche.addEventListener("click", sucheAnzeigenFiltern);
}

//EventLister auf Filter "Biete"
function evtfilterBiete() {
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
function evtfilterKategorie() {
	var kategorien = document.querySelectorAll("button.kategorieButton");
	for (var i = 0; i < kategorien.length; i++) {
		kategorien[i].addEventListener("click", filter);
	}
}

//Fiter ausschalten - alle Kategorien werden angezeigt
function filterAus() {
	var kategorieAnzeige = document.getElementsByClassName("kategorie");
	for (var i = 0; i < kategorieAnzeige.length; i++) {
		//Quelle: https://developer.mozilla.org/en-US/docs/Web/API/Element/closest -> sucht Elternelemente mit angegebener css selector
		var anzeigeBoxElement = kategorieAnzeige[i].closest(".anzeigeBox"); //alle Anzeigeboxen einblenden
		anzeigeBoxElement.classList.add("eingeblendet");
		anzeigeBoxElement.classList.remove("ausgeblendet");
	}
}

//EventListener für "alle Kategorien"
function evtfilterAus() {
	var alleKategorien = document.getElementById("alleKategorien");
	alleKategorien.addEventListener("click", filterAus);
}

function kategorieBearbeitenEinblenden() {
	//nextSibling -> form für die Kategroie bearbeiten (nächstes Element nach dem Stift)
	var kategorieBearbeitenForm = this.nextElementSibling;
	var alleFormulareBearbeiten = document.querySelectorAll(".bearbeitenForm");
	for (var i = 0; i < alleFormulareBearbeiten.length; i++) {
		if (alleFormulareBearbeiten[i] !== kategorieBearbeitenForm) {
			alleFormulareBearbeiten[i].classList.add("ausgeblendet");
			alleFormulareBearbeiten[i].classList.remove("eingeblendet");
		}
	}
	//wenn drauf geklickt wird, aber bereits eingeblendet ist -> wird wieder ausgeblendet
	if (kategorieBearbeitenForm.classList.contains("eingeblendet")) {
		kategorieBearbeitenForm.classList.remove("eingeblendet");
		kategorieBearbeitenForm.classList.add("ausgeblendet");
	} else {
		kategorieBearbeitenForm.classList.add("eingeblendet");
		kategorieBearbeitenForm.classList.remove("ausgeblendet");
	}
}


//EventListner für Bearbeiten-Form
function evtKategorieBearbeiten() {
	var kategorieBearbeiten = document.querySelectorAll(".kategorieBearbeiten");
	for (var i = 0; i < kategorieBearbeiten.length; i++) {
		kategorieBearbeiten[i].addEventListener("click", kategorieBearbeitenEinblenden);
	}
}

function neueKategorie(event){
var neueKategorie = document.getElementById("neueKategorie").value;
console.log(neueKategorie);
var vorhandeneKategorien = document.querySelectorAll("button.kategorieButton");
for (var i = 0; i < vorhandeneKategorien.length; i++) {
	console.log(vorhandeneKategorien[i].textContent);
		if (neueKategorie === vorhandeneKategorien[i].textContent) {
			event.preventDefault(); 
			document.getElementById("fehlerKategorie").innerHTML = "Kategorie ist bereits vorhanden";
			return;
		}else{
			document.getElementById("fehlerKategorie").innerHTML = "";
		}
	}
}

function evtNeueKategorie() {
	var kategorieNeuButton = document.getElementById("neueKategorieButton");
		kategorieNeuButton.addEventListener("click", neueKategorie);
	}