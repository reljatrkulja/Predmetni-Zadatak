package aplikacija.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import aplikacija.dialog.dialogWorker;

public class MenuBar extends JMenuBar {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5511353684955783810L;

	public MenuBar(final JFrame parent){
		JMenuBar menuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("File");
		JMenu editMenu = new JMenu("Edit");
		JMenu aboutMenu = new JMenu("About");
		
		JMenu newMenutItem = new JMenu("New");
		JMenuItem openMenutItem = new JMenuItem("Open");
		JMenuItem exitMenutItem = new JMenuItem("Exit");
		
		JMenuItem editMenutItem = new JMenuItem("Edit");
		JMenuItem deleteMenutItem = new JMenuItem("Delete");
		
		JMenuItem aboutMenutItem = new JMenuItem("About");
		
		JMenuItem newWorker = new JMenuItem("Worker");
		JMenuItem mniModalDialog = new JMenuItem("Modalni dijalog");
		
		mniModalDialog.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dialogWorker dialog = new dialogWorker(parent, "Add new Worker", true);
				dialog.setVisible(true);
			}
		});
		
		newMenutItem.add(newWorker);
		
		JMenuItem newSoftware = new JMenuItem("Software");
		
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(aboutMenu);
		
		fileMenu.add(newMenutItem);
		fileMenu.add(openMenutItem);
		fileMenu.add(exitMenutItem);
		
		editMenu.add(editMenutItem);
		editMenu.add(deleteMenutItem);
		
		aboutMenu.add(aboutMenutItem);
		
		
		newMenutItem.add(newSoftware);
		
		add(fileMenu);
		add(editMenu);
		add(aboutMenu);
	}
}