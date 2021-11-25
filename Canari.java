public class Canari extends Animal{
	public Canari(String nom, int age){
		super(nom,age);
	}
	
	public Canari(String nom){
		super(nom);
	}
	
	public void affiche(){
		System.out.println("Je suis un canari");
		super.affiche();
	}
}