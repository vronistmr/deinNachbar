//Lukas

document.addEventListener("DOMContentLoaded", init);

function init() {
	window.addEventListener('load', warnungCookies());
}

//https://developer.mozilla.org/en-US/docs/Web/API/Navigator/cookieEnabled
function warnungCookies() {
	if (navigator.cookieEnabled) {
		// Cookies sind aktiviert
		console.log("Cookies sind aktiviert.");
	} else {
		// Cookies sind deaktiviert
		alert("🍪 Bitte aktiviere Cookies, um diese Website richtig nutzen zu können.");
	}
}