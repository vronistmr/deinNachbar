//Tobi

package beans.formulare;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;


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
	private String email;
	private String vorname;
	private Date datum;
	private Time zeit;
	private Timestamp datetime;
	private int anzeigeID;
	private boolean gebucht;
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
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}

	
	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
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
	
	public boolean getGebucht() {
		return gebucht;
	}

	public void setGebucht(boolean gebucht) {
		this.gebucht = gebucht;
	}
	
	public Timestamp getDatetime() {
		return datetime;
	}

	public void setDatetime(Timestamp datetime) {
		this.datetime = datetime;
	}

}