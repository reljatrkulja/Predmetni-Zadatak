package model;

import java.util.Date;

public class Zaposleni {
	private String ime;
	private String prezime;
	private String jmbg;
	private Date datumRodjenja;
	private String email;
	private Adresa adresa;
	private Softver softver;
	private RadnoMesto radnoMesto;
	
	public Zaposleni() {
		super();
	}
	public Zaposleni(String ime, String prezime, String jmbg, Date datumRodjenja, String email, Adresa adresa,
			Softver softver, RadnoMesto radnoMesto) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
		this.datumRodjenja = datumRodjenja;
		this.email = email;
		this.adresa = adresa;
		this.softver = softver;
		this.radnoMesto = radnoMesto;		
	}
	
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getJmbg() {
		return jmbg;
	}
	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}
	public Date getDatumRodjenja() {
		return datumRodjenja;
	}
	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Adresa getAdresa() {
		return adresa;
	}
	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}
	public Softver getSoftver() {
		return softver;
	}
	public void setSoftver(Softver softver) {
		this.softver = softver;
	}
	public RadnoMesto getRadnoMesto() {
		return radnoMesto;
	}
	public void setRadnoMesto(RadnoMesto radnoMesto) {
		this.radnoMesto = radnoMesto;
	}
}
