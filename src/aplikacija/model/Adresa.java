package aplikacija.model;

public class Adresa {
	private String broj;
	private String ulica;
	private String grad;
	
	public Adresa() {
		super();
	}
	public Adresa(String broj, String ulica, String grad) {
		super();
		this.broj = broj;
		this.ulica = ulica;
		this.grad = grad;
	}

	public String getBroj() {
		return broj;
	}
	public void setBroj(String broj) {
		this.broj = broj;
	}
	public String getUlica() {
		return ulica;
	}
	public void setUlica(String ulica) {
		this.ulica = ulica;
	}
	public String getGrad() {
		return grad;
	}
	public void setGrad(String grad) {
		this.grad = grad;
	}
}
