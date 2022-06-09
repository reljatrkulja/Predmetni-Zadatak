package gui;

import java.awt.BorderLayout;

public class appGUI {

	public static void main(String[] args) {
		long x = Math.round(Math.random()*10000000);
		
		System.out.println(x);
		
		Frame1 frame = new Frame1();
		
		MenuBar menu = new MenuBar();
		frame.setJMenuBar(menu);
		
		frame.setVisible(true);
		
		Toolbar testTool = new Toolbar();
		
		frame.add(testTool, BorderLayout.NORTH);
		

	}

}
