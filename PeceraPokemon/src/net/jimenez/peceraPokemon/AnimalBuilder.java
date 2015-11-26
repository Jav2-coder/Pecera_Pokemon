package net.jimenez.peceraPokemon;

import java.util.Random;

import acm.graphics.GImage;

public class AnimalBuilder {

	private static final int[] DIRECCIO = { 0, 90, 180, 270 };
	private static final int[] DIAGONAL = { 45, 135, 225, 315 };
	private static final String[] SEXE = { "mascle", "femella" };
	Random rnd = new Random();

	public AnimalBuilder() {
	}

	/**
	 * Metode que s'encarrega de decidir quin animal es crea cada cop gracies al
	 * String que se l'hi passa per parametre.
	 * 
	 * @param tipus String que decideix l'objecte Animal que es crea.
	 * @return Retorna un objecte Animal
	 */
	public Animal generarAnimal(String tipus) {

		Animal A = null;
		int pos = rnd.nextInt(2);

		switch (tipus) {
		case "Peix":
			A = crearPeix(SEXE[pos]);
			break;
		case "Tauro":
			A = crearTauro(SEXE[pos]);
			break;
		case "Dofi":
			A = crearDofi(SEXE[pos]);
			break;
		case "Tortuga":
			A = crearTortuga(SEXE[pos]);
			break;
		case "Estrella":
			A = crearEstrella();
			break;
		case "Pop":
			A = crearPop();
			break;
		default:
			break;
		}
		return A;
	}

	/**
	 * Metode que crea un objecte Peix
	 * 
	 * @param sexe String per determinar l'atribut sexe de l'objecte Peix
	 * @return Retorna un objecte Peix.
	 */
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

		if (pos > 1) {
			P.flipHorizontal();
		}

		return P;
	}

	/**
	 * Metode que crea un objecte Tauro
	 * 
	 * @param sexe String per determinar l'atribut sexe de l'objecte Tauro
	 * @return Retorna un objecte Tauro 
	 */
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

		if (pos > 1) {
			T.flipHorizontal();
		}

		return T;
	}

	/**
	 * Metode que crea un objecte Tortuga
	 * 
	 * @param sexe String per determinar l'atribut sexe de l'objecte Tortuga
	 * @return Retorna un objecte Tortuga 
	 */
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

		if (pos > 1) {
			T.flipHorizontal();
		}

		return T;
	}

	/**
	 * Metode que crea un objecte Dofi
	 * 
	 * @param sexe String per determinar l'atribut sexe de l'objecte Dofi
	 * @return Retorna un objecte Dofi 
	 */
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

		if (pos == 1 || pos == 2) {
			D.flipHorizontal();
		}

		return D;
	}

	/**
	 * Metode que crea un objecte Pop
	 * 
	 * @return Retorna un objecte Pop 
	 */
	public Pop crearPop() {

		GImage img;

		img = new GImage("Octillery.png");

		Pop P = new Pop(img, "asexual", 90);

		return P;
	}

	/**
	 * Metode que crea un objecte Estrella
	 * 
	 * @return Retorna un objecte Estrella
	 */
	public Animal crearEstrella() {
		int pos = rnd.nextInt(4);
		int angle = DIAGONAL[pos];

		GImage img;

		img = new GImage("Staryu.png");

		Estrella E = new Estrella(img, "asexual", angle);

		if (pos == 1 || pos == 2) {
			E.flipHorizontal();
		}

		return E;
	}
}