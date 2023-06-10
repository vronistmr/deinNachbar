<!-- Lukas -->

<%@ page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="fehlerausgabe.jsp"%>

<%@ include file="header.jspf"%>


	<main>
		<!-- Veronika -->
		<h1>Anzeige aufgeben</h1>
		
			<form method="POST" action="./../ServletAnzeigeAufgeben" enctype="multipart/form-data">
			<input type="radio" name="anzeigeArt" id="suche" value="Suche" checked> 
					
					<label for="suche">Suche</label> 
					<input type="radio" name="anzeigeArt" id="biete" value="Biete"> 
					
					
					<label for="biete">Biete</label> <br/>
			
			<div id="FormularAufgebenFlex">
					<article>
					<input type="text" name="titelAnzeige" size="50" maxlength="200" placeholder="Titel der Anzeige" > 
					
					<input type="number" name="preis" max="999" placeholder="Preis" required> <br/>
					
					<input type="text" name="standort" size="50" maxlength="50" placeholder="Dein Standort">
				
					<input type="number" name="umkreis" size="50" max="999" placeholder="Umkreis" required>
				
				<select name="preiskategorie" size="1">
					<option value="Fix">Festpreis</option>
					<option value="VB">Verhandlungsbasis</option>
					<option value="Gratis">Zu verschenken</option>
				</select> 
				
				<select name="kategorie" size="1">
				<c:forEach var="currentKategorie" items="${kategorien}" varStatus="status">
					<option value="${currentKategorie.kategorie}">${currentKategorie.kategorie}</option>  <!-- Scope Session für Kategorie!! -->
				</c:forEach>
				</select> 
				</article>
				
				
				<article class="beschreibung">
				<textarea name="beschreibung" maxlength="1000" placeholder="Beschreibung deiner Anzeige..."></textarea>
				
				</article>
				<article>
				<label for="foto">Foto hochladen:</label> 
				<input type="file" id="foto" name="foto" accept="image/*"> 
				</article>
				</div>
				<div class="Aufgebenbutton">
				<button type="submit" value="neu" name="veroeffentlichen">Anzeige aufgeben</button>
				</div>
			</form>
		
	</main>


<!-- Lukas -->
<%@ include file="footer.jspf"%>