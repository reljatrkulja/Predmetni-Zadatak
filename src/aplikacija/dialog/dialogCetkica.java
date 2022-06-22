package aplikacija.dialog;

import javax.swing.JDialog;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.GridBagConstraints;
import java.awt.CardLayout;
import java.awt.Button;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import aplikacija.model.Cetkica;
import aplikacija.model.Softver;
import aplikacija.utils.Utils;

import java.awt.FlowLayout;
import javax.swing.JButton;

public class dialogCetkica extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2888910714227300329L;
	public dialogCetkica(int index) {
		setTitle("Cetkice");
		getContentPane().setLayout(null);
		setSize(500, 500);
		
		
		
		
		String[] cetkiceHeader = new String[] { "Naziv", "Namena", "Boja" };
		ArrayList<Cetkica> cetkico = Utils.getSoftveri().get(index).getCetkice();
		int velicinaCetkica = cetkico.size();
		Object[][] contentSoftver = new Object[velicinaCetkica][cetkiceHeader.length];

		for (int i = 0; i < velicinaCetkica; i++) {
			contentSoftver[i][0] = cetkico.get(i).getNaziv();
			contentSoftver[i][1] = cetkico.get(i).getNamena();
			contentSoftver[i][2] = cetkico.get(i).getBoja();
		}

		DefaultTableModel stModel = new DefaultTableModel(contentSoftver, cetkiceHeader);
		JTable cetkiceTable = new JTable(stModel);

		cetkiceTable.setRowSelectionAllowed(true);
		cetkiceTable.setColumnSelectionAllowed(false);
		cetkiceTable.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		cetkiceTable.setDefaultEditor(Object.class, null);
		
		JScrollPane stScrollPane = new JScrollPane(cetkiceTable);
		stScrollPane.setLocation(0, 0);
		stScrollPane.setSize(484, 400);
		
		getContentPane().add(stScrollPane);
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.setBounds(385, 413, 89, 23);
		getContentPane().add(btnNewButton);
		
	}
}
