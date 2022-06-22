package aplikacija.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import aplikacija.dialog.dialogWorker;
import aplikacija.utils.Utils;
import aplikacija.dialog.dialogSoftware;

public class MenuBar extends JMenuBar {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5511353684955783810L;

	public MenuBar(final Frame1 parent){
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
		
		newWorker.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dialogWorker dialog = new dialogWorker(parent, "Add new Worker", true, false);
				dialog.setVisible(true);
			}
		});
		
		newMenutItem.add(newWorker);
		
		JMenuItem newSoftware = new JMenuItem("Software");
		
		newSoftware.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dialogSoftware dialog = new dialogSoftware(parent, "Add new Software", true, false);
				dialog.setVisible(true);
			}
		});
		
		exitMenutItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.dispose();
			}
		});
		
		editMenutItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dialogSoftware dialog = new dialogSoftware(parent, "Add new Software", true, true);
				dialog.setVisible(true);
			}
		});
		
		deleteMenutItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
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
		
		aboutMenutItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JDialog dialog = new JDialog();
				dialog.setSize(450,200);
				JLabel txt = new JLabel("Softver napravili Relja Trkulja, Igor Petrovski, Nikola Gaborov i Todor Jokic");
				dialog.add(txt);
				dialog.setVisible(true);
			}
		});
		
		newMenutItem.add(newSoftware);
		
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(aboutMenu);
		
		fileMenu.add(newMenutItem);
		fileMenu.add(openMenutItem);
		fileMenu.add(exitMenutItem);
		
		editMenu.add(editMenutItem);
		editMenu.add(deleteMenutItem);
		
		aboutMenu.add(aboutMenutItem);
		
		
		
		add(fileMenu);
		add(editMenu);
		add(aboutMenu);
	}
}