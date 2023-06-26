//Lukas
"use strict";

document.addEventListener("DOMContentLoaded", init);

function init() {
	var buchungLoeschen = document.getElementsByClassName("buchungLoeschen");
	for (var i = 0; i < buchungLoeschen.length; i++) {
		buchungLoeschen[i].addEventListener("click", warnung)
	}

	var adminAnzeigeLoeschen = document.getElementsByClassName("adminAnzeigeLoeschen");
	for (var i = 0; i < adminAnzeigeLoeschen.length; i++) {
		adminAnzeigeLoeschen[i].addEventListener("click", warnungZwei)
	}

	var anzeigeLoeschen = document.getElementsByClassName("anzeigeLoeschen");
	for (var i = 0; i < anzeigeLoeschen.length; i++) {
		anzeigeLoeschen[i].addEventListener("click", warnungDrei)
	}
}

function warnung(evt) {
	var really = confirm("⚠️ Möchtest du deine Buchung wirklich endgültig löschen?");
	if (!really) {
		evt.preventDefault();
	}
}

function warnungZwei(evt) {
	var really = confirm("⚠️ Möchtest du die Anzeige eines anderen Benutzers wirklich endgültig löschen?");
	if (!really) {
		evt.preventDefault();
	}
}

function warnungDrei(evt) {
	var really = confirm("⚠️ Möchtest du deine Anzeige wirklich endgültig löschen?");
	if (!really) {
		evt.preventDefault();
	}
}