//Lukas

package beans.formulare;

import java.io.Serializable;

public class BeanBuchen implements Serializable {
	private static final long serialVersionUID = 1L;

	private int benutzerID;
	private int anzeigeID;

	public int getBenutzerID() {
		return benutzerID;
	}

	public void setBenutzerID(int benutzerID) {
		this.benutzerID = benutzerID;
	}

	public int getAnzeigeID() {
		return anzeigeID;
	}

	public void setAnzeigeID(int anzeigeID) {
		this.anzeigeID = anzeigeID;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}