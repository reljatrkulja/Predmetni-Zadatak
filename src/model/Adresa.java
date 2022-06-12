package model;

public class Adresa {
	private long id;
	private int broj;
	private String ulica;
	private String grad;
	
	public Adresa() {
		super();
	}
	public Adresa(long id, int broj, String ulica, String grad) {
		super();
		this.id = id;
		this.broj = broj;
		this.ulica = ulica;
		this.grad = grad;
	}

	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getBroj() {
		return broj;
	}
	public void setBroj(int broj) {
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
	
	@Override
	public String toString() {
		return "Adresa [broj=" + broj + ", ulica=" + ulica + ", grad=" + grad + "]";
	}
	
	
}
