package aplikacija.dialog;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;
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



public class dialogWorker extends JDialog implements ActionListener {

	private static final long serialVersionUID = -514322840576145538L;

	public static final int OK = 0;
	public static final int CANCEL = 1;

	private int mode = 1;
	private JTextArea area;

	public dialogWorker(Frame parent, String title, boolean modal) {
		super(parent, "Add Worker", true);
		mode = dialogWorker.CANCEL;
		setLayout(new BorderLayout());

		setSize(450, 250);
		setLocationRelativeTo(parent);
		
		JPanel polja = new JPanel(new GridLayout(6, 2));

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
		//JLabel radnoMesto = new JLabel("Radno mesto:");
		//polja.add(radnoMesto);
		//JComboBox<RadnoMesto> RadnoMesto = new JComboBox<RadnoMesto>(RadnoMesto.values()); 

		JPanel panCommands = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(this);
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(this);

		panCommands.add(btnOk);
		panCommands.add(btnCancel);

		add(new JScrollPane(area), BorderLayout.CENTER);
		add(panCommands, BorderLayout.SOUTH);
		
		btnOk.addActionListener(new ActionListener() {
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

	public JTextArea getArea() {
		return area;
	}

	public void setArea(JTextArea area) {
		this.area = area;
	}

}

