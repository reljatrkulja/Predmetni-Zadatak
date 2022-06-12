package model;

import java.awt.Color;

public class Cetkica {
	private long id;
	private String naziv;
	private String namena;
	private Color boja;
	
	public Cetkica() {
		super();
	}
	public Cetkica(long id, String naziv, String namena, Color boja) {
		super();
		this.naziv = naziv;
		this.namena = namena;
		this.boja = boja;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getNamena() {
		return namena;
	}
	public void setNamena(String namena) {
		this.namena = namena;
	}
	public Color getBoja() {
		return boja;
	}
	public void setBoja(Color boja) {
		this.boja = boja;
	}
}
