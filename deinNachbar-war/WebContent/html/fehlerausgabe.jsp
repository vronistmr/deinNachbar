<!-- Tobi -->

<%@ page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Fehlerseite</title>
	</head>

	<body>
		<h1>Fehlerseite</h1>
		Es ist ein Fehler aufgetreten!
		<br />Bitte benachrichtigen Sie den Web-Administrator unter <b>admin@demo.org</b>.
		<br />Die Fehlermeldung lautet: ${pageContext.exception}
		<p><b>Stack trace:</b>
			<c:forEach var="trace" items="${pageContext.exception.stackTrace}">
				<br />${trace}
			</c:forEach>
		</p>
	</body>
</html>