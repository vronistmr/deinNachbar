//Veronika

package beans.formulare;

import java.io.Serializable;

public class BeanKategorie implements Serializable {
	private static final long serialVersionUID = 1L;

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