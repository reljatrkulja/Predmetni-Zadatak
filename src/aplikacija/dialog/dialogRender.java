package aplikacija.dialog;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import aplikacija.model.Cetkica;
import aplikacija.model.Render;
import aplikacija.utils.Utils;

public class dialogRender extends JDialog {
	public dialogRender(int index) {
		setTitle("Render");
		getContentPane().setLayout(null);
		setSize(500, 500);

		String[] renderHeader = new String[] { "Naziv", "Kamere", "Materijali", "Objekti" };

		Object[][] contentSoftver = new Object[1][renderHeader.length];
		Render render = Utils.getSoftveri().get(index).getRender();
		contentSoftver[0][0] = render.getNaziv();
		contentSoftver[0][1] = render.getKamere();
		contentSoftver[0][2] = render.getMaterijali();
		contentSoftver[0][3] = render.getObjekti();

		DefaultTableModel stModel = new DefaultTableModel(contentSoftver, renderHeader);
		JTable renderTable = new JTable(stModel);

		renderTable.setRowSelectionAllowed(true);
		renderTable.setColumnSelectionAllowed(false);
		renderTable.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		renderTable.setDefaultEditor(Object.class, null);

		JScrollPane stScrollPane = new JScrollPane(renderTable);
		stScrollPane.setLocation(0, 0);
		stScrollPane.setSize(484, 400);

		getContentPane().add(stScrollPane);

		JButton btnNewButton = new JButton("Close");
		btnNewButton.setBounds(385, 413, 89, 23);
		getContentPane().add(btnNewButton);
	}
}
