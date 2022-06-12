package model;

import java.util.ArrayList;
import java.util.List;

public class Render {
	private long id;
	private List<String> materijali = new ArrayList<String>();
	private List<String> kamere = new ArrayList<String>();
	private List<String> objekti = new ArrayList<String>();
	private String naziv;
	
	public Render() {
		super();
	}
	public Render(long id, List<String> materijali, List<String> kamere, List<String> objekti, String naziv) {
		super();
		this.id = id;
		this.materijali = materijali;
		this.kamere = kamere;
		this.objekti = objekti;
		this.naziv = naziv;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public List<String> getMaterijali() {
		return materijali;
	}
	public void setMaterijali(List<String> materijali) {
		this.materijali = materijali;
	}
	public List<String> getKamere() {
		return kamere;
	}
	public void setKamere(List<String> kamere) {
		this.kamere = kamere;
	}
	public List<String> getObjekti() {
		return objekti;
	}
	public void setObjekti(List<String> objekti) {
		this.objekti = objekti;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	
}
