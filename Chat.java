public class Chat extends Animal{
	public Chat(String nom, int age){
		super(nom,age);
	}
	
	public Chat(String nom){
		super(nom);
	}
	
	public void affiche(){
		System.out.println("Je suis un chat");
		super.affiche();
	}
}