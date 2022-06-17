package aplikacija.dialog;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.colorchooser.*;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


import aplikacija.model.Softver;
import aplikacija.model.Adresa;
import aplikacija.model.Cetkica;
import aplikacija.model.Render;

import aplikacija.gui.Frame1;

import java.awt.Frame;
import javax.swing.JDialog;

public class dialogSoftware extends JDialog implements ActionListener {

	private static final long serialVersionUID = 3591599721565020284L;
	
	public static final int OK = 0;
	public static final int CANCEL = 1;
	
	private int mode = 1;
	private JTextField field;

	public dialogSoftware(Frame parent, String title, boolean modal) {
		super(parent, title, modal);
		mode = dialogWorker.CANCEL;
		setLayout(new BorderLayout());

		setSize(500, 500);
		setLocationRelativeTo(parent);

		// Deo za unos zaposlenog
		JPanel polja = new JPanel(new GridLayout(12, 2));

		////////////////////// Naziv softvera
		JLabel nazivSoftvera = new JLabel("Naziv softvera:");
		polja.add(nazivSoftvera);
		
		JTextField nazivPolje = new JTextField();
		polja.add(nazivPolje);
		
		
		///////////////////// Cetkica
		//Naziv cetkice
		JLabel nazivCetkice = new JLabel("CETKICA - naziv cetkice:");
		polja.add(nazivCetkice);
		
		JTextField nazivCetkicePolje = new JTextField();
		polja.add(nazivCetkicePolje);
		
		String nazivCetkiceString = new String(nazivCetkice.toString());
		
		//Namena
		JLabel namena = new JLabel("Namena");
		polja.add(namena);
		
		JTextField namenaPolje = new JTextField();
		polja.add(namenaPolje);
		
		String namenaString = new String(namena.toString());
		
		//Boja
		JLabel Boja = new JLabel("Boja:");
		polja.add(Boja);
		
		JButton btnColor = new JButton("Choose color");
		Color boja = null;
		 ActionListener actionListener = new ActionListener() {
		      public void actionPerformed(ActionEvent actionEvent) {
		        Color initialBackground = btnColor.getBackground();
		        Color boja = JColorChooser.showDialog(null, "Change Button Background", initialBackground);
		        if (boja != null) {
		        	btnColor.setBackground(boja);
		        	boja.getColor("Boja");
		        }
		      }
		    };
		
		btnColor.addActionListener(actionListener);
		polja.add(btnColor);
		
		Cetkica cetkica = new Cetkica();
		cetkica.setNaziv(nazivCetkiceString);
		cetkica.setNamena(namenaString);
		cetkica.setColor(boja);
		
		
		///////////////////// Fajl format
		JLabel fajlFormat = new JLabel("Fajl format:");
		polja.add(fajlFormat);
		
		JTextField fajlFormatPolje = new JTextField();
		polja.add(fajlFormatPolje);
		
		
		///////////////////// Alati
		JLabel alati = new JLabel("Alati za animaciju:");
		polja.add(alati);
		
		ButtonGroup alatiDugmad = new ButtonGroup();
		
		JRadioButton max = new JRadioButton();
		max.setText("3DS Max");
		alatiDugmad.add(max);
		polja.add(max);
		
		
		JRadioButton blender = new JRadioButton();
		blender.setText("Blender");
		alatiDugmad.add(blender);
		polja.add(blender);
		
		
		JRadioButton zbrush = new JRadioButton();
		zbrush.setText("ZBrush");
		alatiDugmad.add(zbrush);
		polja.add(zbrush);
		
		JRadioButton selectedButton = new JRadioButton();

		if (max.isSelected()) {
		    selectedButton = max;
		} else if (blender.isSelected()) {
		    selectedButton = blender;
		} else if (zbrush.isSelected()) {
		    selectedButton = zbrush;
		}

		String izabranAlat = new String(selectedButton.getText());
		
		///////////////////// Render
		JLabel nazivRender = new JLabel("Render - NAZIV:");
		polja.add(nazivRender);
		
		JTextField renderPolje = new JTextField();
		polja.add(renderPolje);
		
		String renderString = renderPolje.getText();
		
		// Materijali
		JLabel materijali = new JLabel("Materijali:");
		polja.add(materijali);
		
		JTextField materijaliPolje = new JTextField();
		polja.add(materijaliPolje);
		
		String materijaliString = materijaliPolje.getText();
		// Kamere
		JLabel kamere = new JLabel("Kamere:");
		polja.add(kamere);
		
		JTextField kamerePolje = new JTextField();
		polja.add(kamerePolje);
		
		String kamereString = kamerePolje.getText();
		
		// Objekti
		JLabel objekti = new JLabel("Objekti:");
		polja.add(objekti);
		
		JTextField objektiPolje = new JTextField();
		polja.add(objektiPolje);
		
		String objektiString = objektiPolje.getText();
		
		Render render = new Render();
		render.setNaziv(renderString);
		render.setMaterijali(materijaliString);
		render.setKamere(kamereString);
		render.setObjekti(objektiString);

		

		
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
				Softver software= new Softver();
				software.setNaziv(nazivPolje.getText());
				software.setCetkice(new ArrayList<Cetkica>(List.of(cetkica)));
				software.setFajlFormat(fajlFormatPolje.getText());
				software.setAlati(izabranAlat);
				software.setRender(render);
				
				
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





