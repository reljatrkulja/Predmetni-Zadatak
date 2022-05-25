package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class Toolbar extends JToolBar {
	public Toolbar() {
		
		
		super(SwingConstants.HORIZONTAL);
		
		ImageIcon addImage = new ImageIcon("images/add-file.png");
		Image addIcon = addImage.getImage();
		Image newAdd = addIcon.getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH);
		addImage = new ImageIcon(newAdd);
		
		ImageIcon editImage = new ImageIcon("images/document.png");
		Image editIcon = editImage.getImage();
		Image newEdit = editIcon.getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH);
		editImage = new ImageIcon(newEdit);
		
		ImageIcon deleteImage = new ImageIcon("images/delete.png");
		Image deleteIcon = deleteImage.getImage();
		Image newDelete = deleteIcon.getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH);
		deleteImage = new ImageIcon(newDelete);
		
				
				
		JButton btnNew = new JButton();
		btnNew.setToolTipText("New");
		btnNew.setIcon(addImage);
		add(btnNew);
		
		addSeparator();

		JButton btnEdit = new JButton();
		btnEdit.setToolTipText("Edit");
		btnEdit.setIcon(editImage);
		add(btnEdit);

		addSeparator();

		JButton btnDelete = new JButton();
		btnDelete.setToolTipText("Delete");
		btnDelete.setIcon(deleteImage);
		add(btnDelete);

		setFloatable(true);
	}
}
