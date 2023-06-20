//Lukas
"use strict"

document.addEventListener("DOMContentLoaded", init);
    
function init(){
	var loeschLink = document.getElementsByClassName("loeschLink");
	for (var i=0; i<loeschLink.length; i++){
		loeschLink[i].addEventListener("click",warnung)
	}
}

function warnung(evt){
	var really = confirm("⚠️ Möchtest du diese Kategorie wirklich endgültig Löschen? Damit werden automatisch auch alle zur Kategorie gehörigen Anzeigen endgültig gelöscht!");
	if(!really){
		evt.preventDefault();
		}
	}