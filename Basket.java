import java.util.*;
;public class Basket extends Vector{	 
	
	public double totalprice;

	public void chooseProduct (){
		System.out.println("Donnez le nom du produit :");
		String name=inputString();
		System.out.println("Donnez la quantité voulue :");
		int quantity=inputInt();
		CommandLine product = new CommandLine(name,quantity);
		if(product != null){
			addElement(product);
			totalprice+=product.getTotal();
		}
	}

	public void deleteProduct (){
		CommandLine product = find();
		if(product != null){
			totalprice-=product.getTotal();
			remove(product);
		}
	}


    public CommandLine find  (){
	if (isEmpty())
	    {
		System.out.println("Pas de produits dans le panier");
		return null;
	    }
	System.out.println("Donnez le nom du produit");
	String name=inputString();
	for(Iterator it=iterator();it.hasNext();)
	    {
		CommandLine current = (CommandLine)it.next();	
		if (current.getName().equals(name))
		    return current;
	    }
	System.out.println("Le produit " +name+" n'est pas dans le panier");
	return null;
    }

	public void show(){
	 if (isEmpty())
	     {
		 System.out.println("Pas de stocks dans le magasin");
		 return;
	     }
	 System.out.println("Affichage du panier :\n");
	 for (Iterator it=iterator();it.hasNext();)
	     {
		 CommandLine item=(CommandLine)it.next();
		 item.show();
	     }
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