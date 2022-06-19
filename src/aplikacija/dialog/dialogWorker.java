package aplikacija.dialog;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.sound.midi.SysexMessage;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import aplikacija.model.Zaposleni;
import aplikacija.utils.Utils;
import aplikacija.model.Adresa;
import aplikacija.model.Softver;
import aplikacija.model.RadnoMesto;
import aplikacija.gui.Frame1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JFormattedTextField;

import java.awt.Frame;
import javax.swing.JDialog;

public class dialogWorker extends JDialog implements ActionListener {

	private static final long serialVersionUID = 3591599721565020284L;
	
	public static final int OK = 0;
	public static final int CANCEL = 1;
	
	private int mode = 1;
	private JTextField field;
	
	Utils utility =  new Utils();

	public dialogWorker(Frame1 parent, String title, boolean modal, boolean edit) {
		super(parent, title, modal);
		mode = dialogWorker.CANCEL;
		setLayout(new BorderLayout());

		setSize(500, 500);
		setLocationRelativeTo(parent);

		Zaposleni zaposleni = null;
		
		if(edit == true) {
			int i = parent.getSelectedIndex();
			zaposleni = utility.getZaposleni().get(i);
		}
		
		// Deo za unos zaposlenog
		JPanel polja = new JPanel(new GridLayout(12, 2));

		////////////////////// Ime
		JLabel ime = new JLabel("Ime:");
		polja.add(ime);
		
		JTextField imePolje = new JTextField();
		polja.add(imePolje);
		
		
		////////////////////// Prezime
		JLabel prezime = new JLabel("Prezime:");
		polja.add(prezime);
	
		JTextField prezimePolje = new JTextField();
		polja.add(prezimePolje);
		
		
        ////////////////////// JMBG
		JLabel jmbg = new JLabel("JMBG:");
		polja.add(jmbg);
		
		JTextField jmbgPolje = new JTextField();
		polja.add(jmbgPolje);
		
		
		////////////////////// Datum rodjenja
		JLabel datumRodjenja = new JLabel("Datum rodjenja:");
		polja.add(datumRodjenja);
		
		JFormattedTextField datumPolje = new JFormattedTextField(SimpleDateFormat.getDateInstance(DateFormat.MEDIUM));
		polja.add(datumPolje);
		datumPolje.setValue(new Date());


		
		
		////////////////////// Email
		JLabel email = new JLabel("Email:");
		polja.add(email);
		
		JTextField emailPolje = new JTextField();
		polja.add(emailPolje);
		
		String emailString = new String(email.toString());
		
		///////////////////// Adresa
		//Broj ulice
		JLabel brojUlice = new JLabel("ADRESA - Broj ulice:");
		polja.add(brojUlice);
		
		JTextField brojUlicePolje = new JTextField();
		polja.add(brojUlicePolje);
		
		String brojUliceString = brojUlicePolje.getText();
		
		//Naziv ulice
		JLabel nazivUlice = new JLabel("Naziv ulice:");
		polja.add(nazivUlice);
		
		JTextField nazivUlicePolje = new JTextField();
		polja.add(nazivUlicePolje);
		
		String nazivUliceString = nazivUlicePolje.getText();
		
		//Grad
		JLabel grad = new JLabel("Grad:");
		polja.add(grad);
		
		JTextField gradPolje = new JTextField();
		polja.add(gradPolje);
		
		String gradString = gradPolje.getText();
		
		Adresa adresa = new Adresa();
		adresa.setBroj(brojUliceString);
		adresa.setUlica(nazivUliceString);
		adresa.setGrad(gradString);
		
		//////////////////////////////Softver
		JLabel softver = new JLabel("Softver:");
		polja.add(softver);
		
		JComboBox softverPolje = new JComboBox<Softver>();
		polja.add(softverPolje);
		
		
		for(Softver s:utility.getSoftveri()) {
			softverPolje.addItem(s);
		}
		
		//String softverString = softverPolje.getText();
		Softver softverNaziv = new Softver();
		//softverNaziv.setNaziv(softverString);
		
		///////////////////////// /Radno mesto
		JLabel radnoMesto = new JLabel("Radno mesto:");
		polja.add(radnoMesto);
		
		JComboBox radnoMestoPolje = new JComboBox<RadnoMesto>(RadnoMesto.values());
		polja.add(radnoMestoPolje);
	
		radnoMestoPolje.getSelectedItem();
		
		if(edit == true) {
			imePolje.setText(zaposleni.getIme());
			prezimePolje.setText(zaposleni.getPrezime());
			emailPolje.setText(zaposleni.getEmail());
			jmbgPolje.setText(zaposleni.getJmbg());
			brojUlicePolje.setText(zaposleni.getAdresa().getBroj());
			nazivUlicePolje.setText(zaposleni.getAdresa().getUlica());
			gradPolje.setText(zaposleni.getAdresa().getGrad());
		}
		
		// Deo za dugmad
		JPanel panCommands = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(this);
		panCommands.add(btnOk);
		
		btnOk.addActionListener(x -> {
			System.out.println("ovo radi");
			System.out.println(imePolje.getText());
			if(imePolje.getText().equals("") || prezimePolje.getText().equals("") || jmbgPolje.getText().equals("")) {
				JOptionPane.showMessageDialog(parent, "Eror bre jebote");
			}else{
			
			String userIme = imePolje.getText();
			String userPrezime = prezimePolje.getText();
			String userJmbg = jmbgPolje.getText();
			String userDatum = datumPolje.getText();
			String userEmail = emailPolje.getText();
			String userUlica = nazivUlicePolje.getText();
			String userUlicaBroj = brojUlicePolje.getText();
			String userGrad = gradPolje.getText();
			int userSoftware = softverPolje.getSelectedIndex();
			int userRadno = radnoMestoPolje.getSelectedIndex();
			
			Adresa a = new Adresa();
			a.setBroj(userUlicaBroj);
			a.setGrad(userGrad);
			a.setUlica(userUlica);
			

			
			Zaposleni Z = new Zaposleni();
			Z.setIme(userIme);
			Z.setPrezime(userPrezime);
			Z.setJmbg(userJmbg);
			Z.setEmail(userEmail);
			if(userRadno == 0) {
				Z.setRadnoMesto(RadnoMesto.Animator);
			}else if(userRadno == 1) {
				Z.setRadnoMesto(RadnoMesto.Ilustrator);
			}else if(userRadno == 2) {
				Z.setRadnoMesto(RadnoMesto.Modelator);
			}else {
				Z.setRadnoMesto(RadnoMesto.Riger);
			}
			Z.setSoftver(utility.getSoftveri().get(userSoftware));
			Z.setAdresa(a);
			
			if(edit == true) {
				int i = parent.getSelectedIndex();
				utility.setZaposleni(i, Z);
			}else {
			
				utility.getZaposleni().add(Z);
			
				System.out.println(Z.getIme() + " " + Z.getPrezime());
			}
			Frame1 f = new Frame1();
			f.osvezi();
			parent.dispose();
			}
		});
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(this);
		panCommands.add(btnCancel);
		
		add(polja, BorderLayout.NORTH);
		add(panCommands, BorderLayout.SOUTH);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand().equals("OK")) {
			mode = dialogWorker.OK;
			
		} else {
			mode = dialogWorker.CANCEL;
		}
		setVisible(false);
	}
	
	public int getMode() {
		return mode;
	}
	
	public void setMode(int mode) {
		this.mode = mode;
	}
	

	public JTextField getArea() {
		return field;
	}

	public void setField(JTextField field) {
		this.field = field;
	}
	
}




