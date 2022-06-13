package aplikacija.dialog;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

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

	public dialogWorker(Frame parent, String title, boolean modal) {
		super(parent, title, modal);
		mode = dialogWorker.CANCEL;
		setLayout(new BorderLayout());

		setSize(500, 500);
		setLocationRelativeTo(parent);

		// Deo za unos zaposlenog
		JPanel polja = new JPanel(new GridLayout(12, 2));

		////////////////////// Ime
		JLabel ime = new JLabel("Ime:");
		polja.add(ime);
		
		JTextField imePolje = new JTextField();
		polja.add(imePolje);
		
		String imeString = new String(ime.toString());
		
		////////////////////// Prezime
		JLabel prezime = new JLabel("Prezime:");
		polja.add(prezime);
	
		JTextField prezimePolje = new JTextField();
		polja.add(prezimePolje);
		
		String prezimeString = new String(prezime.toString());
		
        ////////////////////// JMBG
		JLabel jmbg = new JLabel("JMBG:");
		polja.add(jmbg);
		
		JTextField jmbgPolje = new JTextField();
		polja.add(jmbgPolje);
		
		String jmbgString = new String(jmbg.toString());
		
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
		
		String brojUliceString = new String(brojUlice.toString());
		
		//Naziv ulice
		JLabel nazivUlice = new JLabel("Naziv ulice:");
		polja.add(nazivUlice);
		
		JTextField nazivUlicePolje = new JTextField();
		polja.add(nazivUlicePolje);
		
		String nazivUliceString = new String(nazivUlice.toString());
		
		//Grad
		JLabel grad = new JLabel("Grad:");
		polja.add(grad);
		
		JTextField gradPolje = new JTextField();
		polja.add(gradPolje);
		
		String gradString = new String(grad.toString());
		
		Adresa adresa = new Adresa();
		adresa.setBroj(brojUliceString);
		adresa.setUlica(nazivUliceString);
		adresa.setGrad(gradString);
		
		//////////////////////////////Softver
		JLabel softver = new JLabel("Softver:");
		polja.add(softver);
		
		JTextField softverPolje = new JTextField();
		polja.add(softverPolje);
		
		String softverString = new String(softver.toString());
		Softver softverNaziv = new Softver();
		softverNaziv.setNaziv(softverString);
		
		///////////////////////// /Radno mesto
		JLabel radnoMesto = new JLabel("Radno mesto:");
		polja.add(radnoMesto);
		
		JComboBox radnoMestoPolje = new JComboBox<RadnoMesto>(RadnoMesto.values());
		polja.add(radnoMestoPolje);
		
		//radnoMesto.getRadnoMesto(radnoMestoPolje);
		
		// Deo za dugmad
		JPanel panCommands = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(this);
		panCommands.add(btnOk);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(this);
		panCommands.add(btnCancel);
		
		add(polja, BorderLayout.NORTH);
		add(panCommands, BorderLayout.SOUTH);
		
		
		
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Zaposleni user= new Zaposleni();
				user.setIme(imeString);
				user.setPrezime(prezimeString);
				user.setJmbg(jmbgString);
				//user.setDatumRodjenja(datum1);
				user.setEmail(emailString);
				user.setAdresa(adresa);
				user.setSoftver(softverNaziv);
				//user.setRadnoMesto(radnoMesto);
				
				/*if(Zaposleni.register(user)) {
					Frame1.setView(new Frame1());
				}
				else {
					JOptionPane.showMessageDialog(null, "JMBG već postoji");
				}*/
				
			}
		});
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




