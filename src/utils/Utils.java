package utils;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Adresa;
import model.Cetkica;
import model.RadnoMesto;
import model.Render;
import model.Softver;
import model.Zaposleni;

public class Utils {
	public static List<Adresa> adrese = new ArrayList<Adresa>();
	public static List<Cetkica> cetkice = new ArrayList<Cetkica>();
	public static List<Render> renderi = new ArrayList<Render>();
	public static List<Softver> softveri = new ArrayList<Softver>();
	public static List<Zaposleni> zaposleni = new ArrayList<Zaposleni>();
	
	static Adresa adresa01 = new Adresa(1, 13, "Nevinih Zrtava", "Beograd");
	static Adresa adresa02 = new Adresa(2, 21, "Maloga Momira", "Ruma");
	static Adresa adresa03 = new Adresa(3, 56, "Begecka", "Novi Sad");
	
	static Cetkica cetkica01 = new Cetkica(1, "Standard", "Crta u datoj boji", new Color(255, 0, 0, 255));
	static Cetkica cetkica02 = new Cetkica(2, "Smooth", "Ugladjava povrsinu", new Color(0, 0, 0, 0));
	static Cetkica cetkica03 = new Cetkica(3, "Deform", "Deformise povrsinu", new Color(0, 0, 0, 0));
	
	static Render render01 = new Render(1, new ArrayList<String>(List.of("zemlja", "trava", "kamen")), 
			new ArrayList<String>(List.of("kamera01")), 
			new ArrayList<String>(List.of("panj, tlo, kamen01, kamen02")), "Panj");
	static Render render02 = new Render(2, new ArrayList<String>(List.of("w", "a", "w")), 
			new ArrayList<String>(List.of("kamera02")), 
			new ArrayList<String>(List.of("suncobran, peskir, peskir2, lopta")), "Plaza");
	
	static Softver softver01= new Softver(1, "3ds Max", new ArrayList<Cetkica>(List.of(cetkica01)), "obj", new ArrayList<String>(List.of("alat")), render01);
	
	static Zaposleni zaposlen01= new Zaposleni(1, "Marko", "Markovic", 
			"5345345", 
			new Date(2001,3,3), 
			"krofna@gmail.com", 
			adresa01, 
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
		zaposleni.add(zaposlen01);
	}
	
	
}
