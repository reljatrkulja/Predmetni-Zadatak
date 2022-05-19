package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

public class Frame1 extends JFrame {
	public Frame1(){
	
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int Height = screenSize.height;
		int Width = screenSize.width;
	
		setSize(Width*3/4,Height*3/4);
		setTitle("Test");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setBackground(Color.RED);
		
		
		JMenuBar menuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("File");
		JMenu editMenu = new JMenu("Edit");
		JMenu aboutMenu = new JMenu("About");
		
		JMenuItem newMenutItem = new JMenuItem("New");
		JMenuItem openMenutItem = new JMenuItem("Open");
		JMenuItem exitMenutItem = new JMenuItem("Exit");
		
		JMenuItem editMenutItem = new JMenuItem("Edit");
		JMenuItem deleteMenutItem = new JMenuItem("Delete");
		
		JMenuItem aboutMenutItem = new JMenuItem("About");
		
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(aboutMenu);
		
		fileMenu.add(newMenutItem);
		fileMenu.add(openMenutItem);
		fileMenu.add(exitMenutItem);
		
		editMenu.add(editMenutItem);
		editMenu.add(deleteMenutItem);
		
		aboutMenu.add(aboutMenutItem);
		
		setJMenuBar(menuBar);
		
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

	}  
}


