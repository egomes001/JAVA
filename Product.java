import java.util.*;

public class Product{
	private String name;
	private int quantity;
	private int ref; 
	public static int num = 0;
	
	public Product(String name, int quantity){
		this.name = name;
		this.quantity = quantity;
		num++;
		ref = num;
		
	}
	
	public String getName(){return name;}
	public int getQuantity(){return quantity;}
	public int getRef(){return ref;}
	public void show(){System.out.println("Le produit : "+name+" ; Sa quantité : "+quantity+" Sa référence : "+ref);}
}