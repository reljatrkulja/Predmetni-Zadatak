package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;

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
		
		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		
		setBackground(Color.RED);
		JButton button = new JButton("Test");
		add(button);
		
		
	}

}
