import java.util.*;

public class Food extends Product{
	private String exp_date;
	public Food(String name,int quantity,String exp_date){
		super(name,quantity);
		this.exp_date = exp_date;
		
	}
	
	public void show(){
		super.show();
		System.out.println(" -- Sa date d'expiration" + exp_date);
		}
	
	public String getExp(){return exp_date;}
}
