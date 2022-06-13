package aplikacija.model;

import java.util.ArrayList;
import java.util.List;

public class Render {
	private String materijali = new String();
	private String kamere = new String();
	private String objekti = new String();
	private String naziv;
	
	public Render() {
		super();
	}
	public Render(String materijali, String kamere, String objekti, String naziv) {
		super();
		this.materijali = materijali;
		this.kamere = kamere;
		this.objekti = objekti;
		this.naziv = naziv;
	}
	
	public String getMaterijali() {
		return materijali;
	}
	public void setMaterijali(String materijali) {
		this.materijali = materijali;
	}
	public String getKamere() {
		return kamere;
	}
	public void setKamere(String kamere) {
		this.kamere = kamere;
	}
	public String getObjekti() {
		return objekti;
	}
	public void setObjekti(String objekti) {
		this.objekti = objekti;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	
}
