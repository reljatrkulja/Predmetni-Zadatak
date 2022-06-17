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
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import aplikacija.gui.MenuBar;
import aplikacija.gui.Toolbar;


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
		JLabel workersTab = new JLabel("Workers");
		JLabel softwareTab = new JLabel("Software");
		
		myTabbedPane.addTab("Workers", workersTab);
		myTabbedPane.addTab("Software", softwareTab);
		
		this.add(myTabbedPane);
		
		
	}  
}