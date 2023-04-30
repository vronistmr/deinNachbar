package beans.formulare;

import java.io.Serializable;


import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
//Veronika
/**
 * Session Bean implementation class BeanIndex
 */
@Stateless
@LocalBean
public class BeanIndex implements Serializable{
	private String email;
	private String passwort;
	
	
	
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



	/**
     * Default constructor. 
     */
    public BeanIndex() {
        // TODO Auto-generated constructor stub
    }

}
