<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>HTML-Formularausgabe direkt mittels JSP-Expression Language</h2>
		
		<h3>Ihre Formulareingaben</h3>
		<br><b>E-Mail: </b>${loginForm.email}
		<br><b>Passwort: </b>${loginForm.passwort}
		
		<br><b>Vorname: </b>${registrierenForm.vorname}
		<br><b>E-Mail: </b>${registrierenForm.email}
		<br><b>Passwort: </b>${registrierenForm.passwort}
		<br><b>Standort: </b>${registrierenForm.standort}
		
		<br><b>Standort: </b>${AnzeigeAufgebenForm.anzeigeArt}
		<br><b>Standort: </b>${AnzeigeAufgebenForm.titelAnzeige}
		<br><b>Standort: </b>${AnzeigeAufgebenForm.preis}
		<br><b>Standort: </b>${AnzeigeAufgebenForm.preiskategorie}
		
		<br><b>Vorname: </b>${loginForm.vorname}
		<br><b>E-Mail: </b>${loginForm.email}
		<br><b>Passwort: </b>${loginForm.passwort}
		<br><b>Standort: </b>${loginForm.standort}
		<br><b>Standort: </b>${loginForm.benutzerID}
		

</body>
</html>