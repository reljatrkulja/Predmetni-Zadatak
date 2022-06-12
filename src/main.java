import model.Adresa;
import utils.Utils;

public class main {
	public static void main(String[] args) {		
		Utils.popuniListe();
		
		System.out.println("----------------------");
		
		System.out.println("Pre brisanja: " + Utils.adrese);
		Adresa dfdf = Utils.adrese.get(1);
		Utils.adrese.remove(dfdf);
		System.out.println("Posle brisanja: " + Utils.adrese);
		
		System.out.println("----------------------");
		
		System.out.println("Pre izmene: " + Utils.adrese.get(0));
		Utils.adrese.get(0).setBroj(123);
		Utils.adrese.get(0).setUlica("Proba ulica");
		Utils.adrese.get(0).setGrad("Novi Sad");
		System.out.println("Posle izmene: " + Utils.adrese.get(0));
		
		System.out.println("----------------------");
		System.out.println("Pre brisanja: " + Utils.adrese);
		for (Adresa adresa:Utils.adrese) {
			if(adresa.getBroj() == 123) {
				Utils.adrese.remove(adresa);
			}
		}
		System.out.println("Posle brisanja: " + Utils.adrese);
		
		
	}
}
