package aplikacija.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import aplikacija.model.Softver;
import aplikacija.model.Zaposleni;
import aplikacija.utils.Utils;


public class Frame1 extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7240939624608584060L;

	public Frame1(){
	
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int Height = screenSize.height;
		int Width = screenSize.width;
		
		// glavni meni aplikacije - ActionListener
		MenuBar menu = new MenuBar(this);
		setJMenuBar(menu);
		// toolbar aplikacije - ActionListener
		Toolbar toolbar = new Toolbar();
		add(toolbar, BorderLayout.NORTH);
	
		setSize(Width*3/4,Height*3/4);
		setTitle("Test");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setBackground(Color.RED);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime currentTime = LocalDateTime.now();  
		System.out.println(dtf.format(currentTime));
	
		JPanel statusPanel = new JPanel();
		statusPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
		add(statusPanel, BorderLayout.SOUTH);
		statusPanel.setPreferredSize(new Dimension(getWidth(), 24));
		statusPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		JLabel statusLabel = new JLabel(dtf.format(currentTime));
		
		
		statusPanel.add(statusLabel);
		
		JTabbedPane myTabbedPane = new JTabbedPane();
		
//		Pravljenje tabele zaposlenih
		String[] zaposleniHeader = new String[] { "Ime", "Prezime", "JMBG", "Datum rodjenja", "Email", "Adresa", "Softver",
				"Radno mesto"};
		
		int velicinaZaposleni = Utils.getZaposleni().size();
		Object[][] contentZaposleni = new Object[velicinaZaposleni][zaposleniHeader.length];
		for(int i = 0; i < velicinaZaposleni; i++) {
			Zaposleni zaposleni = Utils.getZaposleni().get(i);
			contentZaposleni[i][0] = zaposleni.getIme();
			contentZaposleni[i][1] = zaposleni.getPrezime();
			contentZaposleni[i][2] = zaposleni.getJmbg();
			contentZaposleni[i][3] = zaposleni.getDatumRodjenja();
			contentZaposleni[i][4] = zaposleni.getEmail();
			contentZaposleni[i][5] = zaposleni.getAdresa().getUlica() + " " + zaposleni.getAdresa().getBroj();
			contentZaposleni[i][6] = zaposleni.getSoftver().getNaziv();
			contentZaposleni[i][7] = zaposleni.getRadnoMesto();
		}
		
		DefaultTableModel wtModel = new DefaultTableModel(contentZaposleni, zaposleniHeader);
		JTable zaposleniTable = new JTable(wtModel);
		
		zaposleniTable.setRowSelectionAllowed(true);
		zaposleniTable.setColumnSelectionAllowed(false);
		zaposleniTable.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		zaposleniTable.setDefaultEditor(Object.class, null);
		JScrollPane ztScrollPane = new JScrollPane(zaposleniTable);
		
//		Pravljenje tabele softvera		
		String[] softverHeader = new String[] { "Naziv", "Cetkice", "Format fajla", "Alati", "Render" };

		int velicinaSoftver = Utils.getSoftveri().size();
		Object[][] contentSoftver = new Object[velicinaSoftver][softverHeader.length];
		for(int i = 0; i < velicinaSoftver; i++) {
			Softver softver = Utils.getSoftveri().get(i);
			String cetkiceString = "";
			int brojCetkica = 0;
			for(int j = 0; j < softver.getCetkice().size(); j++) {
				if(brojCetkica != 0) {
					cetkiceString += ", ";
				}
				cetkiceString += softver.getCetkice().get(j).getNaziv();
				brojCetkica ++;
			}
			contentSoftver[i][0] = softver.getNaziv();
			contentSoftver[i][1] = cetkiceString;
			contentSoftver[i][2] = softver.getFajlFormat();
			contentSoftver[i][3] = softver.getAlati();
			contentSoftver[i][4] = softver.getRender().getNaziv();
		}
		
		DefaultTableModel stModel = new DefaultTableModel(contentSoftver, softverHeader);
		JTable softwareTable = new JTable(stModel);
		
		softwareTable.setRowSelectionAllowed(true);
		softwareTable.setColumnSelectionAllowed(false);
		softwareTable.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		softwareTable.setDefaultEditor(Object.class, null);
		JScrollPane stScrollPane = new JScrollPane(softwareTable);
		
		myTabbedPane.addTab("Zaposleni", ztScrollPane);
		myTabbedPane.addTab("Softver", stScrollPane);
		
		this.add(myTabbedPane);
		
		
	}  
}