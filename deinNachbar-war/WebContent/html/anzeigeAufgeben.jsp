<!-- Lukas -->
<%@ page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page errorPage="fehlerausgabe.jsp"%>
<%@ include file="header.jspf"%>

	<main>
		<!-- Veronika -->
		<h1>Anzeige aufgeben</h1>
		<div id=FormularAnzeige>
			<form method="POST" action="./../ServletAnzeigeAufgeben" enctype="multipart/form-data">
				<input type="radio" name="anzeigeArt" id="suche" value="suche" checked> 
						<label for="suche">Suche</label> <br> 
					<input type="radio" name="anzeigeArt" id="biete" value="biete"> 
						<label for="biete">Biete</label> 
					
					<input type="text" name="titelAnzeige" size="50" maxlength="50" placeholder="Titel der Anzeige"> 
					
					<input type="number" name="preis" size="50" maxlength="50" placeholder="Preis" pattern="[1-9]|[1-9][0-9]|[1-9][0-9][0-9]"> 
				
				<select name="preiskategorie" size="1">
					<option value="fix">Festpreis</option>
					<option value="VB">Verhandlungsbasis</option>
					<option value="gratis">Zu verschenken</option>
				</select> 
				
				<select name="kategorie" size="1">
					<option value="haus">Haus</option>
					<option value="garten">Garten</option>
					<option value="elektronik">Elektronik</option>
					<option value="technik">Technik</option>
					<option value="kreativ">Kreativ</option>
				</select> 
				
				<input type="text" name="standort" size="50" maxlength="50" placeholder="Dein Standort">
				
				<input type="number" name="umkreis" size="50" maxlength="50" placeholder="Umkreis" pattern="[1-9]|[1-9][0-9]|[1-9][0-9][0-9]">
				
				<textarea name="beschreibung" rows="10" cols="100" maxlength="1000" placeholder="Beschreibung deiner Anzeige..."></textarea>
				
				<label for="foto">Foto hochladen:</label> 
				<input type="file" id="foto" name="foto" accept="image/*"> <br>
				
				<button type="submit" value="neu" name="verÃ¶ffentlichen">Anzeige aufgeben</button>
			</form>
		</div>
	</main>

	<!-- Lukas -->
	<%@ include file="footer.jspf"%>