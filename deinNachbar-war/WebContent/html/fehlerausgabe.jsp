<!-- Tobi -->
<%@ page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

Es ist ein Fehler aufgetreten! Bitte setzen Sie sich mit Ihrem Administartor in Verbindung.
Die Fehlermeldung lautet: ${pageContext.exception}
Stack trace:
<c: forEach var = "trace items" = "${pageContext.exception.stackTrace}">
	<p>${trace}</p>
</c: forEach>