 public class CommandLine{
	public Product product;
	public int quantity;
	public double tot;
	
	public CommandLine(Product p, int q){
		product = p;
		quantity = q;
		tot = product.getPrice() * q;
	}

	public String getName(){return product.getName();}
	public double getTotal(){return tot;}
	public void show(){System.out.println("ok");}

 }