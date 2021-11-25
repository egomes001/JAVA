import java.io.*;
import java.util.*;

public class GestionAnimalVec{ 
	public static void main(String[] args){
		Vector <Animalerie> Animaleries = new Vector <Animalerie>(); 
		while(true){
			affiche_menu();
			int reponse = Animalerie.saisie_entier();
			switch (reponse)
				{
				case 1 : Animaleries.addElement(creer_animalerie());break;
				case 2 : modif_animalerie(Animaleries);break;
				case 3 : Animaleries.addElement(FetchAnimalerie(Animaleries));break;
				case 0 : System.exit(0);
				default :
				System.out.println("Option inexistante, recommencez\n");
				}
			}
	}

	public static Animalerie FetchAnimalerie(Vector <Animalerie> Animaleries){
		System.out.println("Quelle animalerie souhaitez-vous récupérer : ");
		String nom = saisie_chaine();
		Animalerie fromFile = new Animalerie(nom);
		try{
			fromFile.lire();
			return fromFile;
		}catch(IOException e){System.out.println("Impossible de récupérer l'animalerie");}
		return null;
	}
	
	public static Animalerie creer_animalerie(){
		System.out.println("Donnez un nom à l'animalerie\n");
		String nom = saisie_chaine();
		return new Animalerie(nom);
	}
	
	public static Animalerie find (Vector <Animalerie> Animaleries){
		if (Animaleries.isEmpty()){
			System.out.println("Pas d'animalerie existantes\n");
			return null;
		}
		System.out.println("Donnez le nom de l'animalerie\n");
		String nom = saisie_chaine();
		for(Enumeration <Animalerie> e = Animaleries.elements(); e.hasMoreElements();){
			Animalerie courant = e.nextElement();
			if(courant.getNom().equals(nom)){
				return courant;
			}
		}
		System.out.println("L'animalerie " + nom + " n'existe pas");
		return null;
	}
    
    public static void modif_animalerie(Vector <Animalerie> Animaleries){
        if (Animaleries.isEmpty()){
            System.out.println("Erreur : Pas d'animalerie dans la colection.");
        } else {
            System.out.println("Liste des animaleries :");
            affiche_noms_animaleries(Animaleries);
            Animalerie animalerieSelect=find(Animaleries);
            
            animalerieSelect.modif();
        }
    }
    
    public static void affiche_noms_animaleries (Vector <Animalerie> Animaleries){
        for (Enumeration <Animalerie> e = Animaleries.elements(); e.hasMoreElements();){
            String item = e.nextElement().getNom();
            System.out.println(item);
        }
    }
    

	public static String saisie_chaine (){
		try {
			BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
			String chaine=buff.readLine();
			return chaine;
		}
		catch(IOException e) {
			System.out.println("Impossible de travailler\n" +e);
			return null;
		}
	}

	public static int saisie_entier (){
		try{
			BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
			String chaine=buff.readLine();
			int num = Integer.parseInt(chaine);
			return num;
		}
		catch(IOException e){return 0;}
	}
	
	public static void affiche_menu(){
        System.out.println("Que voulez-vous faire ?");
        System.out.println("1 - Creer une animalerie");
        System.out.println("2 - Modifier une animalerie");
		System.out.println("3 - Récuperer une animalerie");
        System.out.println("0 - Quitter \n");
    }
}
