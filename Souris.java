public class Souris extends Animal{
	public Souris(String nom, int age){
		super(nom,age);
	}
	
	public Souris(String nom){
		super(nom);
	}
	
	public void affiche(){
		System.out.println("Je suis une souris");
		super.affiche();
	}
}