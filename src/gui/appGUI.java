package gui;

import java.awt.BorderLayout;
import model.Adresa;

public class appGUI {

	public static void main(String[] args) {
		int x = 10;
		int y = 20;
		
		System.out.println(x+y);
		
		Frame1 frame = new Frame1();
		frame.setVisible(true);
		
		Toolbar testTool = new Toolbar();
		
		frame.add(testTool, BorderLayout.NORTH);
	}

}
