package beans.formulare;

import java.io.Serializable;

//Veronika


public class BeanBenutzerdaten implements Serializable{
	private static final long serialVersionUID = 1L;

	private String vorname;
	public String email;
	public String passwort;
	private String standort;
	private Integer benutzerID;
	private boolean istAdmin;

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public String getStandort() {
		return standort;
	}

	public void setStandort(String standort) {
		this.standort = standort;
	}

	public Integer getBenutzerID() {
		return benutzerID;
	}

	public void setBenutzerID(Integer benutzerID) {
		this.benutzerID = benutzerID;
	}

	public boolean isIstAdmin() {
		return istAdmin;
	}

	public void setIstAdmin(boolean istAdmin) {
		this.istAdmin = istAdmin;
	}

}
