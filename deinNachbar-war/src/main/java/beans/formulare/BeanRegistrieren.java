package beans.formulare;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
//Veronika

/**
 * Session Bean implementation class BeanRegistrieren
 */
@Stateless
@LocalBean
public class BeanRegistrieren {
private String vorname;
private String email;
private String passwort;
private String standort;



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



	/**
     * Default constructor. 
     */
    public BeanRegistrieren() {
        // TODO Auto-generated constructor stub
    }

}
