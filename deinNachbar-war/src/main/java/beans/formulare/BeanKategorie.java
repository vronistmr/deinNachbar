package beans.formulare;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
//Veronika
/**
 * Session Bean implementation class BeanKategorie
 */
@Stateless
@LocalBean
public class BeanKategorie {
private int kategorieID;
private String kategorie;
public int getKategorieID() {
	return kategorieID;
}
public void setKategorieID(int kategorieID) {
	this.kategorieID = kategorieID;
}
public String getKategorie() {
	return kategorie;
}
public void setKategorie(String kategorie) {
	this.kategorie = kategorie;
}

  

}
