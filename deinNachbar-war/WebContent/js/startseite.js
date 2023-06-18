//Lukas
"use strict"

//https://www.digicomp.ch/blog/2017/10/18/wunderschone-javascript-dialoge-fur-meine-webapplikation-mit-alertifyjs
window.addEventListener('load', setAllEventListener);
    
function setAllEventListener(){
	var loeschLink = document.getElementById("loeschLink");
	loeschLink.addEventListener("click", warnung);
}

function warnung(){
	confirm('Möchtest du diesen Link öffnen?')
}