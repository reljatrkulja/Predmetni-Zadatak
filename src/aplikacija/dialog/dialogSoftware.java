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
import aplikacija.model.Zaposleni;
import aplikacija.utils.Utils;
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

	public dialogSoftware( Frame1 parent, String title,boolean modal,boolean edit) {
		super(parent, title, modal);
		mode = dialogSoftware.CANCEL;
		setLayout(new BorderLayout());

		setSize(500, 500);
		setLocationRelativeTo(parent);

		Softver softver = null;
		
		if(edit == true) {
			int i = parent.getSelectedIndex();
			softver = Utils.getSoftveri().get(i);
		}


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
		
		ArrayList<Cetkica> cetkice = new ArrayList<Cetkica>();
		cetkice.add(cetkica);
		
		
		
		
		
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
		

        System.out.println(izabranAlat);
        System.out.println(izabranAlat);
        System.out.println(izabranAlat);
        System.out.println(izabranAlat);
        System.out.println(izabranAlat);
        
        
        
        
        
        
        
        
        
        
        
		
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
		
		
		
		
		

		if (edit == true) {
            nazivPolje.setText(softver.getNaziv());
            nazivCetkicePolje.setText(softver.getCetkice().get(0).getNaziv());
            namenaPolje.setText(softver.getCetkice().get(0).getNamena());
            cetkica.setColor(softver.getCetkice().get(0).getBoja());
            fajlFormatPolje.setText(softver.getFajlFormat());
            renderPolje.setText(softver.getRender().getNaziv());
            kamerePolje.setText(softver.getRender().getKamere());
            materijaliPolje.setText(softver.getRender().getMaterijali());
            objektiPolje.setText(softver.getRender().getObjekti());
        }
		
		
        JPanel panCommands = new JPanel(new FlowLayout(2));
        
        JButton btnOk = new JButton("OK");
        btnOk.addActionListener(this);
        panCommands.add(btnOk);
    
        btnOk.addActionListener(x -> {
            System.out.println("ovo radi");
            System.out.println(nazivPolje.getText());
        
            
            
            String softverNaziv = nazivPolje.getText();
            String softverNazivFajla = fajlFormatPolje.getText();
            String softverRenderNaziv = renderPolje.getText();
            String softverMaterijali = materijaliPolje.getText();
            String softverObjekti = objektiPolje.getText();
            String softverKamere = kamerePolje.getText();
            String softverCetkiceNaziv = nazivCetkicePolje.getText();
            String softverNamena = namenaPolje.getText();
            Color softverBoja = boja;
          
            String softverAlati = "alati";
            
            
            System.out.println(softverNaziv);
            System.out.println(softverNazivFajla);
            System.out.println(softverRenderNaziv);
            System.out.println(softverMaterijali);
            System.out.println(softverObjekti);
            System.out.println(softverKamere);
            System.out.println(softverCetkiceNaziv);
            System.out.println(softverNamena);
            System.out.println(softverAlati);
           
            
            
            Cetkica c = new Cetkica();
            c.setNaziv(softverCetkiceNaziv);
            c.setNamena(softverNamena);
            c.setColor(softverBoja);
            
            ArrayList<Cetkica> C = new ArrayList<Cetkica>();
            C.add(c);
            
            Render r = new Render();
            r.setNaziv(softverRenderNaziv);
            r.setMaterijali(softverMaterijali);
            r.setKamere(softverKamere);
            r.setObjekti(softverObjekti);
            
            Softver S = new Softver();
            S.setNaziv(softverNaziv);
            S.setCetkice(C);
            S.setFajlFormat(softverNazivFajla);
            S.setAlati(softverAlati);
            S.setRender(r);
            
            
            if (edit == true) {
                int j = parent.getSelectedIndex();
                Utils.setSoftveri(j, S);
            }
            else {
                Utils.getSoftveri().add(S);
            }
            Frame1 f = new Frame1();
            f.osvezi();
            parent.dispose();
            
        });
        
        JButton btnCancel = new JButton("CANCEL");
        btnCancel.addActionListener(this);
        panCommands.add(btnCancel);
        add(polja, "North");
        add(panCommands, "South");
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





