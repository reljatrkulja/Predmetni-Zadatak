package aplikacija.utils;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import aplikacija.model.Adresa;
import aplikacija.model.Cetkica;
import aplikacija.model.RadnoMesto;
import aplikacija.model.Render;
import aplikacija.model.Softver;
import aplikacija.model.Zaposleni;

public class Utils {
	public static ArrayList<Adresa> adrese = new ArrayList<Adresa>();
	public static ArrayList<Cetkica> cetkice = new ArrayList<Cetkica>();
	public static ArrayList<Render> renderi = new ArrayList<Render>();
	public static ArrayList<Softver> softveri = new ArrayList<Softver>();
	public static ArrayList<Zaposleni> zaposleni = new ArrayList<Zaposleni>();
	
	static Adresa adresa01 = new Adresa("13", "Nevinih Zrtava", "Beograd");
	static Adresa adresa02 = new Adresa("21", "Maloga Momira", "Ruma");
	static Adresa adresa03 = new Adresa("56", "Begecka", "Novi Sad");
	
	static Cetkica cetkica01 = new Cetkica("Standard", "Crta u datoj boji", new Color(255, 0, 0, 255));
	static Cetkica cetkica02 = new Cetkica("Smooth", "Ugladjava povrsinu", new Color(0, 0, 0, 0));
	static Cetkica cetkica03 = new Cetkica("Deform", "Deformise povrsinu", new Color(0, 0, 0, 0));
	
	static Render render01 = new Render("zemlja, trava, kamen", 
			"kamera01", 
			"panj, tlo, kamen01, kamen02", "Panj");
	static Render render02 = new Render("w, a, w", 
			"kamera02", 
			"suncobran, peskir, peskir2, lopta", "Plaza");
	
	static Softver softver01= new Softver("3ds Max", new ArrayList<Cetkica>(List.of(cetkica01)), "max", "alat", render01);
	static Softver softver02= new Softver("Maya", new ArrayList<Cetkica>(List.of(cetkica01, cetkica02)), "fbx", "alat, alat2", render01);
	static Softver softver03= new Softver("Blender", new ArrayList<Cetkica>(List.of(cetkica01, cetkica02, cetkica03)), "obj", "alat, alat3", render01);
	
	static Zaposleni zaposlen01 = new Zaposleni("Marko", "Markovic", 
			"5345345", 
			new Date(2001,3,3), 
			"krofna@gmail.com", 
			adresa01, 
			softver01, 
			RadnoMesto.Animator);
	
	static Zaposleni zaposlen02 = new Zaposleni("Petar", "Petrovic", 
			"3335552", 
			new Date(2001,3,3), 
			"peracar@gmail.com", 
			adresa02, 
			softver01, 
			RadnoMesto.Animator);
	
	static Zaposleni zaposlen03 = new Zaposleni("Sima", "Simic", 
			"1113336", 
			new Date(2001,3,3), 
			"simakralj@gmail.com", 
			adresa03, 
			softver01, 
			RadnoMesto.Animator);
	
	public static void popuniListe() {
		adrese.add(adresa01);
		adrese.add(adresa02);
		adrese.add(adresa03);
		cetkice.add(cetkica01);
		cetkice.add(cetkica01);
		cetkice.add(cetkica01);
		renderi.add(render01);
		renderi.add(render02);
		softveri.add(softver01);
		softveri.add(softver02);
		softveri.add(softver03);
		zaposleni.add(zaposlen01);
		zaposleni.add(zaposlen02);
		zaposleni.add(zaposlen03);
	}
	
	public static ArrayList<Adresa> getAdrese() {
		return adrese;
	}
	
	public static ArrayList<Cetkica> getCetkice() {
		return cetkice;
	}
	
	public static ArrayList<Render> getRenderi() {
		return renderi;
	}
	
	public static ArrayList<Softver> getSoftveri() {
		return softveri;
	}
	
	public static ArrayList<Zaposleni> getZaposleni() {
		return zaposleni;
	}

}
