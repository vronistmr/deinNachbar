//Lukas
"use strict";

document.addEventListener("DOMContentLoaded", init);
var cookiesAccepted = localStorage.getItem('cookiesAccepted');
    
function init(){
	warnung();
}

function warnung() {
    alert("🍪 Wir verwenden Cookies! Möchtest du diese akzeptieren?");
}