//Lukas
"use strict"

document.addEventListener("DOMContentLoaded", init);
    
function init(){
	var loeschButton = document.getElementsByClassName("loeschButton");
	
	for (var i=0; i<loeschButton.length; i++){
		loeschButton[i].addEventListener("click",warnung)
	}
}

function warnung(evt){
	var really = confirm("⚠️ Möchtest du deine Buchung wirklich endgültig löschen?");
	if(!really){
		evt.preventDefault();
	}
}