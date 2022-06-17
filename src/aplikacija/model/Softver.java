package aplikacija.model;

import java.util.ArrayList;
import java.util.List;

public class Softver {
	private String naziv;
	private ArrayList<Cetkica> cetkice;
	private String fajlFormat;
	private String alati;
	private Render render;
	
	public Softver() {
		super();
	}
	public Softver(String naziv, ArrayList<Cetkica> cetkice, String fajlFormat, String alati, Render render) {
		super();
		this.naziv = naziv;
		this.cetkice = cetkice;
		this.fajlFormat = fajlFormat;
		this.alati = alati;
		this.render = render;
	}
	
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public ArrayList<Cetkica> getCetkice() {
		return cetkice;
	}
	public void setCetkice(ArrayList<Cetkica> cetkice) {
		this.cetkice = cetkice;
	}
	public String getFajlFormat() {
		return fajlFormat;
	}
	public void setFajlFormat(String fajlFormat) {
		this.fajlFormat = fajlFormat;
	}
	public String getAlati() {
		return alati;
	}
	public void setAlati(String alati) {
		this.alati = alati;
	}
	public Render getRender() {
		return render;
	}
	public void setRender(Render render) {
		this.render = render;
	}
	
	
}
