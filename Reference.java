 public class Reference{
	 public String ref;
	 public String name;
	 public String description;
	 public int price;
	 
	 public Reference(String r, String n, String d, int p){
		 ref = r;
		 name = n;
		 description = d;
		 price = p; 
	 }
	 
	 public String getName(){return name;}
	 public double getPrice(){return price;}
	 
 }