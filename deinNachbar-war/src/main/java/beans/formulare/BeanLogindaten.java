package beans.formulare;

import java.io.Serializable;

//Veronika 

public class BeanLogindaten implements Serializable {
	private static final long serialVersionUID = 1L;

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

}
