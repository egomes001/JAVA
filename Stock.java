import java.util.*;

public class Stock/* extends Vector*/{
	public Vector<Product> vecStock = new Vector();
	private String stockname;
	private String adress;
	public static int cpt;

	public Stock(String stockname){
		this.stockname = stockname;
		adress = "adress";
		cpt = 1;
	}


	public Stock(String stockname, String adress){
		this.stockname = stockname;
		this.adress = adress;
		cpt = 1;
	}
	
	public String getStockname(){return stockname;}
	public String getAdress(){return adress;}
	public void show(){System.out.println(stockname);}
	
	public void menu(){
		while(true){
			show_menu();
			int choice = inputInt();
			switch (choice){
				case 1 : add();break;
				case 2 : show_all();break;
				case 0 : System.exit(0);break;
			}
		}
	}
	
	public void add(){
		int num = 1;
		while(num != 0){
			System.out.println("Donnez un nom");
			String name = inputString();
			System.out.println("Donnez une quantité");
			int quantity = inputInt();
			Product item = new Product(name, quantity);
			if (item !=null){vecStock.addElement(item);}
			show_menu2();
			num = inputInt();
			switch(num){
				case 1 : return;
				case 0 : return;
				default : System.out.println("Option inexistante, recommencez");
				}
		}
	}
	
	public void show_all(){
	 if (vecStock.isEmpty())
	     {
		 System.out.println("Pas de produits dans le stock");
		 return;
	     }
	 System.out.println("Affichage de tous les produits :\n");
	 for (Iterator it=vecStock.iterator();it.hasNext();)
	     {
		 Product item=(Product)it.next();
		 item.show();
	     }
	}
	
	public void show_menu(){
		System.out.println("Que voulez-vous faire ?");
		System.out.println("1 - Saisir des produits");
		System.out.println("2 - Afficher le stock");
		System.out.println("0 - Quitter \n");		
	}
	
	public void show_menu2(){
		System.out.println("Que voulez-vous faire ?");
		System.out.println("1 - Continuer la saisie");
		System.out.println("0 - Retourner à la gestion des stocks\n");		
	}
	
	
    public Product find  (Vector vecStock){
    
	if (vecStock.isEmpty())
	    {
		System.out.println("Pas de produits dans le stock");
		return null;
	    }
	System.out.println("Donnez le nom du produit");
	String name=inputString();
	for(Enumeration e = vecStock.elements() ; e.hasMoreElements() ;)
	    {
		Product current = (Product)e.nextElement();	
		if (current.getName().equals(name))
		    return current;
	    }
	System.out.println("Le produit " +name+" n'est pas dans le stock");
	return null;
    }
	
	public String inputString(){
		Scanner x = new Scanner(System.in);
		return x.nextLine();
	}
	public int inputInt(){
		Scanner x = new Scanner(System.in);
		return x.nextInt();
	}
}