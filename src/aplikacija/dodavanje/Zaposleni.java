package dodavanje;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import aplikacija.model;

	

public class dodavanjeZaposleni extends JPanel {

		public dodavanjeZaposleni() {
		
		Color backgroundColor = new Color(240, 240, 240);// for inputs
		setLayout(new GridBagLayout());
		JPanel polja = new JPanel(new GridLayout(6, 2));
		
		//Dugme za dodavanje
		JButton addBtn = new JButton("OK");
		
		
		//Polja
		JLabel ime = new JLabel("Ime:");
		polja.add(ime);
	
		JTextField imePolje = new JTextField();
		polja.add(imePolje);
	
	
		JLabel prezime = new JLabel("Prezime:");
		polja.add(prezime);
	
		JTextField prezimePolje = new JTextField();
		polja.add(prezimePolje);
		
		
		JLabel jmbg = new JLabel("JMBG:");
		polja.add(jmbg);
	
		JTextField jmbgPolje = new JTextField();
		polja.add(jmbgPolje);
		
		
		JLabel datumRodjenja = new JLabel("Datum rodjenja:");
		polja.add(datumRodjenja);
	
		JTextField datumRodjenjaPolje = new JTextField();
		polja.add(datumRodjenjaPolje);
		
		
		JLabel email = new JLabel("Email:");
		polja.add(email);
	
		JTextField emailPolje = new JTextField();
		polja.add(emailPolje);
		
		
		JLabel adresa = new JLabel("Adresa:");
		polja.add(adresa);
	
		JTextField adresaPolje = new JTextField();
		polja.add(adresaPolje);
		
		
		JLabel softver = new JLabel("Softver:");
		polja.add(softver);
	
		JTextField softverPolje = new JTextField();
		polja.add(softverPolje);
		
		
		JLabel radnoMesto = new JLabel("Radno mesto:");
		polja.add(radnoMesto);
	
		JTextField radnoMestoPolje = new JTextField();
		polja.add(radnoMestoPolje);
		
		//Dugme za nazad
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
				user.setIme(ime);
				user.setPrezime(prezime);
				user.setJmbg(jmbg);
				user.setDatumRodjenja(datumRodjenja);
				user.setEmail(email);
				user.setAdresa(adresa);
				user.setSoftver(softver);
				user.setRadnoMesto(radnoMesto);
				
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