package beans.formulare;



import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
//Veronika

/**
 * Session Bean implementation class BeanAnzeigeAufgeben
 */
@Stateless
@LocalBean
public class BeanAnzeigeAufgeben {
private String anzeigeArt;
private String titelAnzeige;
private int preis;
private String preiskategorie;
private String kategorie;
private String standort;
private int umkreis;
private String beschreibung;



    public String getAnzeigeArt() {
	return anzeigeArt;
}



public void setAnzeigeArt(String anzeigeArt) {
	this.anzeigeArt = anzeigeArt;
}



public String getTitelAnzeige() {
	return titelAnzeige;
}



public void setTitelAnzeige(String titelAnzeige) {
	this.titelAnzeige = titelAnzeige;
}



public int getPreis() {
	return preis;
}



public void setPreis(int preis) {
	this.preis = preis;
}



public String getPreiskategorie() {
	return preiskategorie;
}



public void setPreiskategorie(String preiskategorie) {
	this.preiskategorie = preiskategorie;
}



public String getKategorie() {
	return kategorie;
}



public void setKategorie(String kategorie) {
	this.kategorie = kategorie;
}



public String getStandort() {
	return standort;
}



public void setStandort(String standort) {
	this.standort = standort;
}



public int getUmkreis() {
	return umkreis;
}



public void setUmkreis(int umkreis) {
	this.umkreis = umkreis;
}



public String getBeschreibung() {
	return beschreibung;
}



public void setBeschreibung(String beschreibung) {
	this.beschreibung = beschreibung;
}



	/**
     * Default constructor. 
     */
    public BeanAnzeigeAufgeben() {
        // TODO Auto-generated constructor stub
    }

}
