package model;

import java.util.Date;
	
public dodavanjeZaposleni() {
	
	Color backgroundColor = new Color(240, 240, 240);// for inputs
	setLayout(new GridBagLayout());
	JPanel polja = new JPanel(new GridLayout(6, 2));

	polja.setBackground(Color.lightGray);// for small panel
	setBackground(new Color(200, 200, 200));
	
	
	JButton addBtn = new JButton("Dodaj");
	
	
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

	JTextField adresalPolje = new JTextField();
	polja.add(adresalPolje);
	
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
			
			if(Zaposleni.register(user)) {
				MainWindow.setView(new listPanel());
			}
			else {
				JOptionPane.showMessageDialog(null, "JMBG već postoji");

			}
			
		}
	}
}
