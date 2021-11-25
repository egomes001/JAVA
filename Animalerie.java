import java.io.*;
import java.util.*;

public class Animalerie{ 
	public static Vector <Animal> Animalerie = new Vector <Animal>(); 
	String nom;
	
	public Animalerie(String chaine){
        nom=chaine;
    }
	
	public static void modif(){
		while(true){
		affiche_menu();
		int reponse = saisie_entier();
		switch (reponse)
			{
			case 1 : ajouter_animal();break;
			case 2 : vieillir_animal();break;
			case 3 : vieillir_animaux();break;
			case 4 : mourir_animal();break;
			case 5 : chercher_animal();break;
			case 6 : affiche();break;
			case 7 : ecrire();break;
			case 0 : System.exit(0);
			default :
			System.out.println("Option inexistante, recommencez\n");
			}
		}
	}
	
	public String getNom(){return nom;}
	
	//public void setAge(int num){}
	
	public static Animal find (){
		if (Animalerie.isEmpty()){
			System.out.println("Pas d'animalerie existante\n");
			return null;
		}
		System.out.println("Donnez le nom de l'animal\n");
		String nom = saisie_chaine();
		for(Enumeration<Animal> e = Animalerie.elements(); e.hasMoreElements();){
			Animal courant = e.nextElement();
			if(courant.getNom().equals(nom)){
				return courant;
			}
		}
		System.out.println("L'animalerie " + nom + " n'existe pas");
		return null;
	}

	public static void affiche(){
		if (Animalerie.isEmpty()){
			System.out.println("Pas d' animaux dans l'animalerie\n");
			return;
			}                        
		for (Enumeration<Animal> e = Animalerie.elements(); e.hasMoreElements();){
				Animal item=e.nextElement();
				item.affiche();
			}
		}

	
	
	public static void ajouter_animal(){
		System.out.println("Donnez un nom");
        String nom = saisie_chaine();
        affiche_Choix();
        int reponse = saisie_entier();
        Animal item=null;
        switch (reponse){
            case 1: item=new Chat(nom);break;
            case 2: item=new Souris(nom);break;
            case 3: item=new Canari(nom);break;
            default :
            System.out.println("option inexistante, recommencez");
        }
        if (item !=null){
            Animalerie.addElement(item); // modif
        }
        System.out.println("Vous avez creer "+ Animalerie.size() +" animaux");
    }

	public static void vieillir_animal(){
		Animal item =find();
		if (item !=null ){
			item.vieillir();
		} else {
			System.out.println("L'animal n'existe pas\n");
			}
		}	

	public static void chercher_animal(){
		Animal item =find();
		if (item !=null ){
			item.affiche();
		}
	}
	
	public static void mourir_animal(){
		Animal item =find();
		if (item !=null ){
			item.mourir();
		} else {
			System.out.println("L'animal est déjà mort\n");
			}
		}	

	public static void vieillir_animaux(){
        if (Animalerie.isEmpty()){
            System.out.println("pas d' animaux dans l'animalerie");
            return;
        }
        for (Enumeration<Animal> e = Animalerie.elements(); e.hasMoreElements();){
            e.nextElement().vieillir();
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
		System.out.println("1 - Saisir des animaux");
		System.out.println("2 - Vieillir un animal");
		System.out.println("3 - Vieillir tous les animaux");
		System.out.println("4 - Faire mourir un animal");
		System.out.println("5 - Chercher un animal");
		System.out.println("6 - Affichage Animalerie");
		System.out.println("7 - Sauvegarder");
		System.out.println("0 - Quitter \n");
	}


    public static void affiche_Choix(){
        System.out.println("Que voulez-vous faire ?");
        System.out.println(" 1 \t Ajouter un chat");
        System.out.println(" 2 \t Ajouter une souris");
        System.out.println(" 3 \t Ajouter un canari");
    }

	public static void ecrire(){
		try{
			BufferedWriter buff=new BufferedWriter(new FileWriter("fichier.txt"));
			for(Enumeration e = Animalerie.elements();e.hasMoreElements();){
				Animal courant = (Animal)e.nextElement();
				courant.save(buff);
			}
			buff.flush();
			buff.close();
		}catch(IOException e){
			System.out.println("Impossible de sauvegarder"+e);
		}
	}

	public static void lire ()throws IOException{
		
		BufferedReader buff = null;
		try{
			buff=new BufferedReader(new FileReader("fichier.txt"));
			Animal courant=null ;
			for(;;){ String nom = buff.readLine();
			courant = (Animal) new Animal(nom);
			int num = Integer.valueOf(buff.readLine()).intValue();
			courant.setAge(num);
			String en_vie = buff.readLine();
			if (en_vie.equals("mort")) {courant.mourir();}
			Animalerie.addElement(courant);
			}
		} catch (IOException e){
			System.out.println("Fini");
			buff.close();
			}
	}
}
