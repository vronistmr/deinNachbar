package beans.formulare;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

//Veronika

public class BeanAnzeige implements Serializable{
	private static final long serialVersionUID = 1L;

	private String anzeigeArt;
	private String titelAnzeige;
	private int preis;
	private String preiskategorie;
	private String kategorie;
	private String standort;
	private int umkreis;
	private String beschreibung;
	private int benutzerID;
	private Date datum;
	private Time zeit;
	private Date datetime;
	private int anzeigeID;
	private byte[] foto;


	public int getAnzeigeID() {
		return anzeigeID;
	}

	public void setAnzeigeID(int anzeigeID) {
		this.anzeigeID = anzeigeID;
	}

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

	public int getBenutzerID() {
		return benutzerID;
	}

	public void setBenutzerID(int benutzerID) {
		this.benutzerID = benutzerID;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public Time getZeit() {
		return zeit;
	}

	public void setZeit(Time zeit) {
		this.zeit = zeit;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

}
