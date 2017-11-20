import java.util.Arrays;
import java.util.List;

/** 
 * @author r.peytavin
 * Contact: raphael.degaram.free.fr
 * Last update: 17/11/2017
 */
public class Classroom {

	public static void main(String[] args) {
		
		List<Eleve> liste = Arrays.asList(
				new Eleve ("Doe", "Jhon",14,15,17), 
				new Eleve ("Benson", "George",18,7,6), 
				new Eleve ("Wayne", "Bruce", 10,11,8), 
				new Eleve ("Allen", "Barry", 10,7,8), 
				new Eleve ("Cage", "Luke", 11, 12, 19), 
				new Eleve ("Ferrand", "Clermont", 12, 12, 12),
				new Eleve ("Costa", "Diego", 7, 14, 9),
				new Eleve ("Billie", "jean", 11, 19, 10),
				new Eleve ("Durrif", "Sylvain", 17, 16, 16)
				);
		
				//Appels fonctions Java 7
				System.out.println("__________________JAVA 7 _______________________");
				Eleve.printListe(liste);
				System.out.println();
				double globalAverage = Eleve.getGlovalAverage(liste);
				System.out.println("Moyenne de la classe: " + globalAverage);
				System.out.println(); 
				System.out.println("Liste rattrapage: ");
				System.out.println(Eleve.getListRattrapage(liste));
				System.out.println();
				System.out.println("Liste trié par note");
				System.out.println(Eleve.getSortedList(liste));
				System.out.println();
				System.out.println("MENTIONS: ");
				System.out.println(Eleve.getMentions(liste));
				System.out.println();
		
				//Appel fonctions Java 8
				System.out.println("__________________JAVA 8 _______________________");
				Eleve.printListe8(liste);
				System.out.println();
				double globalAverage8 = Eleve.getGlobalAverage8(liste);
				System.out.println("Moyenne de la classe: "   + globalAverage8);
				System.out.println();
				System.out.println("Liste rattrapage: ");
				System.out.println(Eleve.getListRattrapage8(liste));
				System.out.println();
				System.out.println("Liste trié par note: ");
				System.out.println(Eleve.getSortedList8(liste));
				System.out.println();
				System.out.println();
				System.out.println("MENTIONS: ");
				System.out.println(Eleve.getMentions8(liste));
				System.out.println();
		
	}
	
}
