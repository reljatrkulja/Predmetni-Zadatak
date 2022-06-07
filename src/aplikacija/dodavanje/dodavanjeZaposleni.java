package aplikacija.dodavanje;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import aplikacija.model.Zaposleni;
import aplikacija.model.Adresa;
import aplikacija.model.Softver;
import aplikacija.model.RadnoMesto;

	

public class dodavanjeZaposleni extends JPanel {
	
	private static final long serialVersionUID = -514322840576145538L;

		public dodavanjeZaposleni() {
		
		Color backgroundColor = new Color(240, 240, 240);// for inputs
		setLayout(new GridBagLayout());
		JPanel polja = new JPanel(new GridLayout(6, 2));
		
		//////////////////////////////////////////////////////////Dugme za dodavanje
		JButton addBtn = new JButton("OK");
		
		
		//////////////////////////////////////////////////////////Polja
		
		//////////////////////////////////////////////////////////Ime i prezime
		JLabel ime = new JLabel("Ime:");
		polja.add(ime);
		String imeString = new String(ime.toString());
	
		JTextField imePolje = new JTextField();
		polja.add(imePolje);
	
	
		JLabel prezime = new JLabel("Prezime:");
		polja.add(prezime);
		String prezimeString = new String(prezime.toString());
	
		JTextField prezimePolje = new JTextField();
		polja.add(prezimePolje);
		
		
		//////////////////////////////////////////////////////////Jmbg
		JLabel jmbg = new JLabel("JMBG:");
		polja.add(jmbg);
		String jmbgString = new String(jmbg.toString());
	
		JTextField jmbgPolje = new JTextField();
		polja.add(jmbgPolje);
		
		
		//////////////////////////////////////////////////////////Datum rodjenja
		//Dan
		JLabel dan = new JLabel("Dan:");
		polja.add(dan);
		String danString = new String(dan.toString());
		int danInt = Integer.parseInt(danString);
		
		JTextField danPolje = new JTextField();
		polja.add(danPolje);
		
		//Mesec
		JLabel mesec = new JLabel("Mesec:");
		polja.add(mesec);
		String mesecString = new String(mesec.toString());
		int mesecInt = Integer.parseInt(mesecString);
		
		JTextField mesecPolje = new JTextField();
		polja.add(mesecPolje);
		
		//Godina
		JLabel godina = new JLabel("Godina:");
		polja.add(godina);
		String godinaString = new String(godina.toString());
		int godinaInt = Integer.parseInt(godinaString);
		
		JTextField godinaPolje = new JTextField();
		polja.add(godinaPolje);
	   
		
		Date datumRodjenja = new Date(danInt, mesecInt, godinaInt);
		
		
		//JLabel datumRodjenja = new JLabel("Datum rodjenja:");
		//polja.add(datumRodjenja);
		//Date datumRodjenja1;
		//datumRodjenja1.setDatumRodjenja(datumRodjenja);
	
		//JTextField datumRodjenjaPolje = new JTextField();
		//polja.add(datumRodjenjaPolje);
		
		
		//////////////////////////////////////////////////////////Email
		JLabel email = new JLabel("Email:");
		polja.add(email);
		String emailString = new String(email.toString());
	
		JTextField emailPolje = new JTextField();
		polja.add(emailPolje);
		
		
		//////////////////////////////////////////////////////////Adresa
		//Broj ulice
		JLabel brojUlice = new JLabel("Broj ulice:");
		polja.add(brojUlice);
		String brojUliceString = new String(brojUlice.toString());
		int brojInt = Integer.parseInt(brojUliceString);
	
		JTextField brojUlicePolje = new JTextField();
		polja.add(brojUlicePolje);
		
		//Naziv ulice
		JLabel nazivUlice = new JLabel("Naziv ulice:");
		polja.add(nazivUlice);
		String nazivUliceString = new String(nazivUlice.toString());
		
		JTextField nazivUlicePolje = new JTextField();
		polja.add(nazivUlicePolje);
		
		//Grad
		JLabel grad = new JLabel("Grad:");
		polja.add(grad);
		String gradString = new String(grad.toString());
		
		JTextField gradPolje = new JTextField();
		polja.add(gradPolje);
		
		Adresa adresa = new Adresa();
		adresa.setBroj(brojInt);
		adresa.setUlica(nazivUliceString);
		adresa.setGrad(gradString);
		
		
		//////////////////////////////////////////////////////////Softver
		JLabel softver = new JLabel("Softver:");
		polja.add(softver);
		String softverString = new String(softver.toString());
	
		JTextField softverPolje = new JTextField();
		polja.add(softverPolje);
		
		Softver softverNaziv = new Softver();
		softverNaziv.setNaziv(softverString);
		
		
		//////////////////////////////////////////////////////////Radno mesto
		JLabel radnoMesto = new JLabel("Radno mesto:");
		polja.add(radnoMesto);
		JComboBox<RadnoMesto> RadnoMesto = new JComboBox<RadnoMesto>(RadnoMesto.values()); 
		
		
		//////////////////////////////////////////////////////////Dugme za nazad
		JButton back= new JButton("CANCEL");
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Frame1.setView(new Frame1());
			}
		});
		polja.add(back);
		
		
		polja.add(addBtn);
		add(polja);
		
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Zaposleni user= new Zaposleni();
				user.setIme(imeString);
				user.setPrezime(prezimeString);
				user.setJmbg(jmbgString);
				user.setDatumRodjenja(datumRodjenja);
				user.setEmail(emailString);
				user.setAdresa(adresa);
				user.setSoftver(softverNaziv);
				//user.setRadnoMesto(RadnoMesto); ?
				
				if(Zaposleni.register(user)) {
					Frame1.setView(new Frame1());
				}
				else {
					JOptionPane.showMessageDialog(null, "JMBG već postoji");
				}
				
			});
		}
	}
}