package aplikacija;

import aplikacija.gui.Frame1;
import aplikacija.gui.Toolbar;
import aplikacija.utils.Utils;

public class main {
	public static void main(String[] args) {
		Utils.popuniListe();
		Frame1 frame = new Frame1();
		frame.setVisible(true); // Prozor je inicijalno nevidljiv
		
	}
}