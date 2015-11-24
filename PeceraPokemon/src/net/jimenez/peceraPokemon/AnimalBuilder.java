package net.jimenez.peceraPokemon;

import java.util.Random;

import acm.graphics.GImage;

public class AnimalBuilder {

	private static final int[] DIRECCIO = {0, 90, 180, 270};
	private static final int[] DIAGONAL = {45, 135, 225, 315};
	private static final String[] SEXE = {"mascle", "femella"};
	Random rnd = new Random();
	
	public AnimalBuilder() {

	}

	public Animal generarAnimal(String tipus) {
		
		Animal A = null;
		int pos;
		
		switch (tipus) {
		        case "Peix":
		        	pos = rnd.nextInt(2);
		            A  = crearPeix(SEXE[pos]);
		            break;
		        case "Tauro":
		        	pos = rnd.nextInt(2);
		            A = crearTauro(SEXE[pos]);
		            break;
		        case "Dofi":
		        	pos = rnd.nextInt(2);
		            A = crearDofi(SEXE[pos]);
		            break;
		        case "Tortuga":
		        	pos = rnd.nextInt(2);
		            A = crearTortuga(SEXE[pos]);
		        case "Estrella":
		            A = crearEstrella();
		        case "Pop":
		        	A = crearPop();
		            break;
		        default:
		            break;
		        }
		return A;
	}
	
	public Peix crearPeix(String sexe) {

		int pos = rnd.nextInt(4);
		int angle = DIRECCIO[pos];
		
		GImage img;

		if (sexe.equals("mascle")) {
			img = new GImage("Magikarp.png");
		} else {
			img = new GImage("S_Magikarp.png");
		}

		Peix P = new Peix(img, sexe, angle);
		
		if(pos > 1){
			P.flipHorizontal();
		}
		
		return P;
	}
	
	public Animal crearTauro(String sexe) {

		int pos = rnd.nextInt(4);
		int angle = DIRECCIO[pos];
		
		GImage img;

		if (sexe.equals("mascle")) {
			img = new GImage("Sharpedo.png");
		} else {
			img = new GImage("S_Sharpedo.png");
		}

		Tauro T = new Tauro(img, sexe, angle);

		if(pos > 1){
			T.flipHorizontal();
		}
		
		return T;
	}
	
	public Tortuga crearTortuga(String sexe) {

		int pos = rnd.nextInt(4);
		int angle = DIRECCIO[pos];
		
		GImage img;

		if (sexe.equals("mascle")) {
			img = new GImage("Tirtouga.png");
		} else {
			img = new GImage("S_Tirtouga.png");
		}

		Tortuga T = new Tortuga(img, sexe, angle);
		
		if(pos > 1){
			T.flipHorizontal();
		}
		
		return T;
	}
	
	public Animal crearDofi(String sexe) {
		int pos = rnd.nextInt(4);
		int angle = DIAGONAL[pos];
		
		GImage img;

		if (sexe.equals("mascle")) {
			img = new GImage("Lanturn.png");
		} else {
			img = new GImage("S_Lanturn.png");
		}

		Dofi D = new Dofi(img, sexe, angle);
		
		if(pos == 1 || pos == 2){
			D.flipHorizontal();
		}
		
		return D;
	}
	
	public Pop crearPop() {

		GImage img;

		img = new GImage("Octillery.png");

		Pop P = new Pop(img, "asexual", 90);
		
		return P;
	}
	
	public Animal crearEstrella() {
		int pos = rnd.nextInt(4);
		int angle = DIAGONAL[pos];
		
		GImage img;

		img = new GImage("Staryu.png");

		Estrella E = new Estrella(img, "asexual", angle);
		
		if(pos == 1 || pos == 2){
			E.flipHorizontal();
		}
		
		return E;
	}
	
}