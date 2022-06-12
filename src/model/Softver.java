package model;

import java.util.ArrayList;
import java.util.List;

public class Softver {
	private long id;
	private String naziv;
	private List<Cetkica> cetkice = new ArrayList<Cetkica>();
	private String fajlFormat;
	private List<String> alati = new ArrayList<String>();
	private Render render;
	
	public Softver() {
		super();
	}
	public Softver(long id, String naziv, List<Cetkica> cetkice, String fajlFormat, List<String> alati, Render render) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.cetkice = cetkice;
		this.fajlFormat = fajlFormat;
		this.alati = alati;
		this.render = render;
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
	public List<Cetkica> getCetkice() {
		return cetkice;
	}
	public void setCetkice(List<Cetkica> cetkice) {
		this.cetkice = cetkice;
	}
	public String getFajlFormat() {
		return fajlFormat;
	}
	public void setFajlFormat(String fajlFormat) {
		this.fajlFormat = fajlFormat;
	}
	public List<String> getAlati() {
		return alati;
	}
	public void setAlati(List<String> alati) {
		this.alati = alati;
	}
	public Render getRender() {
		return render;
	}
	public void setRender(Render render) {
		this.render = render;
	}
	
	
}
