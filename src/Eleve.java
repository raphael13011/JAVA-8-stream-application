import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/** 
 * @author r.peytavin
 * Contact: raphael.degaram.free.fr
 * Last update: 17/11/2017
 */
public class Eleve {
	
	//Attributes 
	private String nom;
	private String prenom;
	private int note1, note2, note3;
	private double average;
	
	//Constructor
	public Eleve(String nom,String prenom, int note1, int note2, int note3) {
		this.nom = nom;
		this.prenom = prenom;
		this.note1 = note1;
		this.note2 = note2;
		this.note3 = note3;
		this.average = (double)(note1 + note2 + note3)/3; 
	}
	
	//Getters & Setters
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getNote1() {
		return note1;
	}
	public void setNote1(int note1) {
		this.note1 = note1;
	}
	public int getNote2() {
		return note2;
	}
	public void setNote2(int note2) {
		this.note2 = note2;
	}
	public int getNote3() {
		return note3;
	}
	public void setNote3(int note3) {
		this.note3 = note3;
	}
	public double getAverage() {
		return average;
	}

	//ToString
	@Override
	public String toString() {
		return new String("Nom: " + getNom() + ", Prenom: " + getPrenom() +"| Notes : " + getNote1() + " / " +getNote2()+ " /  " +getNote3()+ " | Moyenne: " + getAverage());
	}
	
	public boolean isPassing() {
		return this.getAverage()>10;
	}
	//Affichage des éléments de la liste
		//Java 7
		public static void printListe(List<Eleve> liste) {
			for (Eleve eleve: liste) {
				System.out.println(eleve);
			}
		}
		
		//Java 8
		public static void printListe8(List<Eleve> liste){
			liste.forEach(System.out::println);
			}
		
	//Calcul Moyenne de la Classe
		//Java 7
		public static double getGlovalAverage (List<Eleve> liste) {
			double globalAverage = 0;
			for (Eleve eleve: liste) {
				globalAverage += eleve.getAverage();
			}
			return globalAverage / liste.size();
		}
		
		//Java 8
		public static double getGlobalAverage8(List<Eleve> liste) {
				return liste.stream()
					.mapToDouble(p-> p.getAverage())
					.average()
					.getAsDouble();
		}
		
	//Ratrapage
		//Java 7
		public static List<Eleve> getListRattrapage(List<Eleve> liste) {
			List<Eleve> listeRattrapage = new ArrayList<Eleve>();
			for (Eleve eleve: liste) {
				if (eleve.getAverage()>=8 && eleve.getAverage()<10){
					listeRattrapage.add(eleve);
					}
				}
				return listeRattrapage;
			}
			
		//Java 8: Stream
		public static List<Eleve> getListRattrapage8(List<Eleve> liste) {
				return liste.stream()
						.filter(x ->x.getAverage()>=8 && x.getAverage()<10)
						.collect(Collectors.toList());
			}
			
		//Tri eleves par notes
			//Java 7
			public static List<Eleve> getSortedList(List<Eleve> liste){
			
				 Collections.sort(liste, new Comparator<Eleve>() {
					@Override
					public int compare(Eleve o1, Eleve o2) {
						return (int) (o2.getAverage() - o1.getAverage());
					}
				});
				return liste;
			}
			
			//Java 8: Stream
			public static List<Eleve> getSortedList8(List<Eleve> liste){
				return liste.stream()
						.sorted((x1, x2) -> Double.compare(x2.getAverage(), x1.getAverage()))
						.collect(Collectors.toList());
			}
			
		//Nombre d'eleves qui passe
			//java7
			public int getListWinners(List<Eleve> liste){
				int count = 0;
				for(Eleve eleve: liste) {
					if (eleve.isPassing()) count++;
				}
				return count;
			}
			
			//Java 8
			public int getListWinners8(List<Eleve> liste){
				return (int) liste.stream().filter(Eleve::isPassing).count();
			}
			
		//Mention	
			//Java 7
			public static HashMap<Mention, List<Eleve>> getMentions(List<Eleve> liste){
				//creation de la HashMap qui sera rempli et renvoyé
				HashMap<Mention, List<Eleve>> listeMentions = new HashMap<Mention, List<Eleve>>();
				
				//Création des listes de mention qui contiennent les éléves
				List<Eleve> mentionBof = new ArrayList<Eleve>();
				List<Eleve> mentionAB = new ArrayList<Eleve>();
				List<Eleve> mentionB  = new ArrayList<Eleve>();
				List<Eleve> mentionTB = new ArrayList<Eleve>();
				
				//Remplissage des liste de mentions avec la liste d'eleve qu'on passe en parametre de la fonction
				for (Eleve eleve: liste) {
					if (Mention.find(eleve.getAverage()).equals(Mention.ASSEZ_BIEN)) {mentionAB.add(eleve);}
					else if(Mention.find(eleve.getAverage()).equals(Mention.BIEN)) {mentionB.add(eleve);}
					else if (Mention.find(eleve.getAverage()).equals(Mention.TRES_BIEN)) {mentionTB.add(eleve);}
					else{mentionBof.add(eleve);}
				}
				
				//Remplissage de la map avec les liste des mentions préalablement remplis
				listeMentions.put(Mention.BOF, mentionBof);
				listeMentions.put(Mention.ASSEZ_BIEN, mentionAB);	
				listeMentions.put(Mention.BIEN,  mentionB);
				listeMentions.put(Mention.TRES_BIEN, mentionTB);
			
				return listeMentions;
			}
			
			
			//Java 8
			public static Map<Mention, List<Eleve>> getMentions8(List<Eleve> liste){
				Map<Mention, List<Eleve>> listeMentions =
					    liste.stream()
					         .collect(Collectors.groupingBy(e -> Mention.find(e.average)));
				return listeMentions;
			}
	}
