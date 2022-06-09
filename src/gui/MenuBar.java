package gui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5511353684955783810L;

	public MenuBar(){
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
		
		newMenutItem.add(newWorker);
		newMenutItem.add(newSoftware);
		
		add(fileMenu);
		add(editMenu);
		add(aboutMenu);
	}
}
