<!-- Lukas -->

<%@ page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="fehlerausgabe.jsp"%>

<%@ include file="header.jspf"%>


	<main>
		<!-- Veronika -->
		<h1>Anzeige aufgeben</h1>
		<div id=FormularAnzeige>
			<form method="POST" action="./../ServletAnzeigeAufgeben" enctype="multipart/form-data">
				<input type="radio" name="anzeigeArt" id="suche" value="Suche" checked> 
						<label for="suche">Suche</label> <br> 
					<input type="radio" name="anzeigeArt" id="biete" value="Biete"> 
						<label for="biete">Biete</label> 
					
					<input type="text" name="titelAnzeige" size="50" maxlength="200" placeholder="Titel der Anzeige" > 
					
					<input type="number" name="preis" max="999" placeholder="Preis" required> 
				
				<select name="preiskategorie" size="1">
					<option value="Fix">Festpreis</option>
					<option value="VB">Verhandlungsbasis</option>
					<option value="Gratis">Zu verschenken</option>
				</select> 
				
				<select name="kategorie" size="1">
					<option value="Haus">Haus</option>
					<option value="Harten">Garten</option>
					<option value="Elektronik">Elektronik</option>
					<option value="Technik">Technik</option>
					<option value="Kreativ">Kreativ</option>
				</select> 
				
				<input type="text" name="standort" size="50" maxlength="50" placeholder="Dein Standort">
				
				<input type="number" name="umkreis" size="50" max="999" placeholder="Umkreis" required>
				
				<textarea name="beschreibung" rows="10" cols="100" maxlength="1000" placeholder="Beschreibung deiner Anzeige..." maxlength=1000"></textarea>
				
				<label for="foto">Foto hochladen:</label> 
				<input type="file" id="foto" name="foto" accept="image/*"> <br>
				
				<button type="submit" value="neu" name="veroeffentlichen">Anzeige aufgeben</button>
			</form>
		</div>
	</main>


<!-- Lukas -->
<%@ include file="footer.jspf"%>