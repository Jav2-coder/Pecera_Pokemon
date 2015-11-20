package net.jimenez.PeceraPokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import acm.graphics.GImage;
import acm.program.GraphicsProgram;

/**
 * 
 * @author Surrui
 *
 */
public class App extends GraphicsProgram {

	private static final long serialVersionUID = 2349435614345549677L;
	private static final int TOTAL_PEIXOS = 50;
	private static final int TOTAL_TAURONS = 10;
	private static final int PEIXERA_AMP = 600;
	private static final int PEIXERA_ALT = 776;
	private static final int[] DIRECCIO = { 0, 1, -1 };
	List<Animal> Animals = new ArrayList<Animal>();
	Random rnd = new Random();

	/**
	 * Metode on creem variables que no variaran mentre fem servir el programa.
	 */
	public void init() {

		GImage fons = new GImage("fondo.png");
		add(fons);
		setSize((int) fons.getWidth(), (int) fons.getHeight());

	}

	/**
	 * Metode principal del programa, on creem tots els objectes.
	 */
	public void run() {
		for (int i = 0; i < TOTAL_PEIXOS; i++) {

			if (i < (TOTAL_PEIXOS / 2)) {
				Animals.add(crearPeix("mascle"));

			} else {
				Animals.add(crearPeix("femella"));
			}
		}
		
		for (int i = 0; i < TOTAL_TAURONS; i++) {
			
			if (i < (TOTAL_TAURONS / 2)) {
				Animals.add(crearTauro("mascle"));

			} else {
				Animals.add(crearTauro("femella"));
			}
			
		}

		Peixera peixera = new Peixera(Animals, this);
		boolean noPeixos = peixera.inici();

		if (noPeixos) {
			GImage fi = new GImage("fi.png");
			fi.setLocation(0, (getHeight() / 2) - (fi.getHeight() / 2));
			add(fi);
		}
	}

	/**
	 * Metode que s'encarrega de crear objectes Tauro, als quals
	 * els hi dona la direcció del moviment, la GImage i un 
	 * String amb el seu sexe.
	 * 
	 * @param sexe String que dona el sexe al objecte Tauro.
	 * @return
	 */
	public Animal crearTauro(String sexe) {
		
		int movX = DIRECCIO[rnd.nextInt(3)];
		int movY = 0;

		if (movX == 0) {
			movY = DIRECCIO[rnd.nextInt(2) + 1];
		}

		GImage img;

		if (sexe.equals("mascle")) {
			img = new GImage("Sharpedo.png");
			img.scale(0.2);
			add(img);
		} else {
			img = new GImage("");
			img.scale(0.2);
			add(img);
		}

		Tauro T = new Tauro(img, sexe, movX, movY);

		return T;
	}

	/**
	 * Metode que s'encarrega de crear objectes Peix_Fantasma, als 
	 * quals els hi dona la direcció del moviment, la GImage i un 
	 * String amb el seu sexe.
	 * 
	 * @param sexe String que dona el sexe al objecte Peix_Fantasma.
	 * @return
	 */
	public Animal crearPeix(String sexe) {

		int movX = DIRECCIO[rnd.nextInt(3)];
		int movY = 0;

		if (movX == 0) {
			movY = DIRECCIO[rnd.nextInt(2) + 1];
		}

		GImage img;

		if (sexe.equals("mascle")) {
			img = new GImage("Magikarp.png");
			img.scale(0.2);
			add(img);
		} else {
			img = new GImage("");
			img.scale(0.2);
			add(img);
		}

		Peix P = new Peix(img, sexe, movX, movY);

		return P;
	}
	
	public Animal crearDofi(String sexe) {

		int movX = DIRECCIO[rnd.nextInt(3)];
		int movY = 0;

		if (movX == 0) {
			movY = DIRECCIO[rnd.nextInt(2) + 1];
		}

		GImage img;

		if (sexe.equals("mascle")) {
			img = new GImage("Lanturn.png");
			img.scale(0.2);
			add(img);
		} else {
			img = new GImage("");
			img.scale(0.2);
			add(img);
		}

		Dofi D = new Dofi(img, sexe, movX, movY);

		return D;
	}
	
	public Animal crearPop() {

		
		int movX = DIRECCIO[rnd.nextInt(3)];
		int movY = 0;

		if (movX == 0) {
			movY = DIRECCIO[rnd.nextInt(2) + 1];
		}

		GImage img;

		img = new GImage("Octillery.png");
		img.scale(0.2);
		add(img);
		
		Pop P = new Pop(img, "mascle", movX, movY);

		return P;
	}
	
}
