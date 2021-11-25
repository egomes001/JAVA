import java.util.*;

public class Myapp{
	public static void main(String []args){
		Vector<Myshop> myShops = new Vector();
		while(true){
			show_menu();
			int choice = inputInt();
			switch (choice)
				{
				case 1 : myShops.addElement(create_shop());break; //créer une boutique plutot
				case 2 : modify_shop(myShops);break;
				case 3 : show_shops(myShops);break;
				case 4 : delete_shop(myShops);break;
				case 0 : System.exit(0);break;
				default : System.out.println("Option inexistante, recommencez");
			}
		}

	}

    public static Myshop find  (Vector myShops){
	if (myShops.isEmpty())
	    {
		System.out.println("Pas de stocks pour l'instant");
		return null;
	    }
	System.out.println("Donnez le nom du magasin recherché");
	String name=inputString();
	for(Enumeration e = myShops.elements() ; e.hasMoreElements() ;)
	    {
		Myshop current = (Myshop)e.nextElement();	
		if (current.getShopname().equals(name))
		    return current;
	    }
	System.out.println("Le magasin " +name+" n'existe pas");
	return null;
    }
	

	public static Myshop create_shop(){
		System.out.println("Donnez un nom pour le nouveau magasin");
		String name=inputString();
		return new Myshop(name);	
	}

	public static void modify_shop(Vector myShops){
		Myshop item = find(myShops);
		if (item != null){
			//show_menu2();
			item.shop();
		} 		
	}

	public static void show_shops(Vector myShops){
	 if (myShops.isEmpty())
	     {
		 System.out.println("Pas de magasin créé");
		 return;
	     }
	 System.out.println("Affichage de tous les magasins :\n");
	 for (Iterator it=myShops.iterator();it.hasNext();)
	     {
		 Myshop item=(Myshop)it.next();
		 item.show();
	     }
	}
	
	public static void delete_shop(Vector myShops){
		Myshop item = find(myShops);
		if (item != null){
			myShops.remove(item);
		} 
		
	}
	public static void show_menu(){
        System.out.println("Que voulez-vous faire ?");
        System.out.println("1 - Créer un magasin");
        System.out.println("2 - Gérer un magasin");
        System.out.println("3 - Afficher les magasins");
        System.out.println("4 - Supprimer un magasin");
		System.out.println("0 - Quitter");

	}
	
	public static void show_menu2(){
        System.out.println("Que voulez-vous faire ?");
        System.out.println("1 - Créer un stock");
        System.out.println("2 - Gérer un stock");
        System.out.println("3 - Afficher les stocks");
        System.out.println("4 - Supprimer un stock");
		System.out.println("0 - Quitter");

	}

	
	public static String inputString(){
		Scanner x = new Scanner(System.in); 
		return x.nextLine();
	}
	public static int inputInt(){
		Scanner x = new Scanner(System.in);
		return x.nextInt();
	}

}