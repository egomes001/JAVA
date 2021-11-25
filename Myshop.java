import java.util.*;

public class Myshop/* extends Vector*/{
	private String shopname;
	public Vector<Stock> myStocks = new Vector();

	public Myshop(String shopname){
		this.shopname = shopname;
	}
	
	public String getShopname(){return shopname;}	
	public void show(){System.out.println(shopname);}

	public void shop(){
		while(true){
			show_menu2();
			int choice = inputInt();
			switch (choice)
				{
				case 1 : myStocks.addElement(create_stock());break;
				case 2 : modify_stock(myStocks);break;
				case 3 : show_stocks(myStocks);break;				
				case 4 : delete_stock(myStocks);break;
				case 0 : System.exit(0);break;
				default : System.out.println("Option inexistante, recommencez");
			}
		}
		
	}
	
    public Stock find  (Vector myStocks){
	if (myStocks.isEmpty())
	    {
		System.out.println("Pas de stocks pour l'instant");
		return null;
	    }
	System.out.println("Donnez le nom du stock");
	String name=inputString();
	for(Enumeration e = myStocks.elements() ; e.hasMoreElements() ;)
	    {
		Stock current = (Stock)e.nextElement();	
		if (current.getStockname().equals(name))
		    return current;
	    }
	System.out.println("Le stock " +name+" n'existe pas");
	return null;
    }
	
	public Stock create_stock(){
		System.out.println("Donnez un nom pour le nouveau stock");
		String name=inputString();
		return new Stock(name);	
	}
	
	public void modify_stock(Vector myStocks){
		Stock item = find(myStocks);
		if (item != null){
			item.menu();
		} 
		
	}
	
	public void show_stocks(Vector myStocks){
	 if (myStocks.isEmpty())
	     {
		 System.out.println("Pas de stocks dans le magasin");
		 return;
	     }
	 System.out.println("Affichage de tous les stocks :\n");
	 for (Iterator it=myStocks.iterator();it.hasNext();)
	     {
		 Stock item=(Stock)it.next();
		 item.show();
	     }
	}
	
	public void delete_stock(Vector myStocks){
		Stock item = find(myStocks);
		if (item != null){
			myStocks.remove(item);
		} 
		
	}
	public String inputString(){
		Scanner x = new Scanner(System.in);
		return x.nextLine();
	}
	public int inputInt(){
		Scanner x = new Scanner(System.in);
		return x.nextInt();
	}
	public void show_menu2(){
			System.out.println("Que voulez-vous faire ?");
			System.out.println("1 - Créer un stock");
			System.out.println("2 - Gérer un stock");
			System.out.println("3 - Afficher les stocks");
			System.out.println("4 - Supprimer un stock");
			System.out.println("0 - Quitter");

	}
}

	
