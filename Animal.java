import java.io.*;
import java.util.*;

public class Animal{
	private String nom;
	private int age;
	private boolean vivant;
	public Animal(String chaine, int valeur){
		nom=chaine;
		age=valeur;
		vivant=true;
	}
	public Animal(String chaine){
		nom=chaine;
		age=0;
		vivant=true;
	}
	
	public String getNom()
    { return nom;}

	public boolean getEtat()
    { return vivant;}
	
	public void setAge(int num){
		age=num;
	}
	
	void affiche(){
	System.out.println("\nL'animal : " +nom+ " ; son age : "+ age + "\n");
	if (vivant)
	    System.out.println("Animal vivant\n" );
	else 
	    System.out.println("Animal mort\n" );
    }
	
	void vieillir(){
		age++;
		System.out.println("\nDesormais l'animal " +nom+" a " + age +" ans\n"); 
    }
	
    void vieillir(int inc){
		age+=inc;
		System.out.println("\nDesormais l'animal " +nom+" a " + age+" ans\n"); 
    }
	
	void mourir(){
		vivant=false;
	}
	
	public String toString(){
		String msg="je m'appelle " +nom+" numero" + " age "+ age;
		if (vivant){
			msg+="animal vivant" ;
		}else{ 
			msg+="animal mort" ;}
		return msg;
	}
	
	void save(BufferedWriter buff)throws IOException{
		buff.newLine();
		buff.write(nom);
		buff.newLine();
		buff.write((new Integer(age)).toString());
		buff.newLine();
		if (vivant) {
			buff.write("vivant");
			}
		else{
			buff.write("mort");
			buff.newLine();
		}
	}
}
