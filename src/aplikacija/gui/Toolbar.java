package aplikacija.gui;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import aplikacija.dialog.dialogSoftware;
import aplikacija.dialog.dialogWorker;
import aplikacija.utils.Utils;

public class Toolbar extends JToolBar {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Toolbar(final Frame1 parent) {
		
		
		super(SwingConstants.HORIZONTAL);

		ImageIcon addImage = new ImageIcon(getClass().getResource("images/add-file.png"));
		Image addIcon = addImage.getImage();
		Image newAdd = addIcon.getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH);
		addImage = new ImageIcon(newAdd);

		ImageIcon editImage = new ImageIcon(getClass().getResource("images/document.png"));
		Image editIcon = editImage.getImage();
		Image newEdit = editIcon.getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH);
		editImage = new ImageIcon(newEdit);

		ImageIcon deleteImage = new ImageIcon(getClass().getResource("images/delete.png"));
		Image deleteIcon = deleteImage.getImage();
		Image newDelete = deleteIcon.getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH);
		deleteImage = new ImageIcon(newDelete);


		JButton btnNew = new JButton();
		btnNew.setToolTipText("New");
		btnNew.setIcon(addImage);
		add(btnNew);
		


		
		btnNew.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				int temp = parent.currentTab;
				
				if(temp == 0) {
					dialogWorker dialog = new dialogWorker(parent, "Add new Worker", true, false);
					dialog.setVisible(true);
				}
				else {
					dialogSoftware dialog = new dialogSoftware(parent, "Add new Software", true);
					dialog.setVisible(true);
				}	
			}
		});

		//System.out.println(temp);
		
		addSeparator();

		JButton btnEdit = new JButton();
		btnEdit.setToolTipText("Edit");
		btnEdit.setIcon(editImage);
		add(btnEdit);
		
		btnEdit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				int temp = parent.currentTab;
				
				if(temp == 0) {
					dialogWorker dialog = new dialogWorker(parent, "Edit Selected Worker", true, true);
					dialog.setVisible(true);
				}
				else {
					dialogSoftware dialog = new dialogSoftware(parent, "Add new Software", true);
					dialog.setVisible(true);
				}	
			}
		});

		addSeparator();

		JButton btnDelete = new JButton();
		btnDelete.setToolTipText("Delete");
		btnDelete.setIcon(deleteImage);
		add(btnDelete);
		
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int temp = parent.currentTab;
				int tableIndex = parent.getSelectedIndex();
				
				if(tableIndex == -1) {
					System.out.println("Greska, nije selektovan nijedan red u tabeli!");
					return;
				}
				
				if(temp == 0) {
					Utils.getZaposleni().remove(tableIndex);
				} else {
					Utils.getSoftveri().remove(tableIndex);
				}
				
				Frame1 f = new Frame1();
				f.osvezi();
				parent.dispose();
	
			}
		});

		setFloatable(true);
	}
}
