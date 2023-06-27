package beans.formulare;


import java.io.Serializable;


public class BeanFehlermeldung implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String fehlernachricht;

	public String getFehlernachricht() {
		return fehlernachricht;
	}

	public void setFehlernachricht(String fehlernachricht) {
		this.fehlernachricht = fehlernachricht;
	}
	
}



