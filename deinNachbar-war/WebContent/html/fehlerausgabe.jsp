<!-- Tobi -->

<%@ page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="./../css/basis.css">
		<link rel="stylesheet" href="./css/basis.css">
		<title>Fehlerseite</title>
	</head>

	<body>
		<h1>Oooops! Hier ist etwas schief gelaufen. </h1>
		Es ist ein Fehler aufgetreten!
		<br>
		<img src="./../img/dog.jpeg" width="612" height="408"> <!-- Bildquelle: http://bitly.ws/IDv8 -->
		<br />Bitte benachrichtigen Sie den Web-Administrator unter <span class="fett">admin@demo.org</span>.
		<br />Die Fehlermeldung lautet: ${pageContext.exception}
		<p><span class="fett">Stack trace:</span>
			<c:forEach var="trace" items="${pageContext.exception.stackTrace}">
				<br />${trace}
			</c:forEach>
		</p>
	</body>
</html>