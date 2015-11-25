package net.jimenez.peceraPokemon;

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

	private static final long serialVersionUID = 4266158358432665610L;
	private static final int TOTAL_ANIMALS = 100;
	private static final int PEIXERA_AMP = 1900;
	private static final int PEIXERA_ALT = 940;
	private static final String[] TIPUS_ANIMAL = {"Tauro", "Peix", "Dofi", "Pop", "Tortuga", "Estrella"};
	List<Animal> Animals = new ArrayList<Animal>();
	Random rnd = new Random();

	/**
	 * Metode on creem variables que no variaran mentre fem servir el programa.
	 */
	public void init() {

		setSize(PEIXERA_AMP, PEIXERA_ALT);
		GImage fons = new GImage("fondo.jpg");
		fons.setSize(PEIXERA_AMP, PEIXERA_ALT);
		add(fons);

	}

	/**
	 * Metode principal del programa, on creem tots els objectes necessaris.
	 */
	public void run() {
		
		totalAnimals();
		AnimalBuilder AB = new AnimalBuilder();

		Peixera peixera = new Peixera(Animals, this, AB);
		boolean noAnimals = peixera.inici();

		if (noAnimals) {
			GImage fi = new GImage("fi.png");
			fi.setLocation(((getWidth()/2)-(fi.getWidth()/2)), ((getHeight()/2)-(fi.getHeight()/2)));
			add(fi);
		}
	}

	/**
	 * Metode principal on creem tots els objectes de tipus Animal.
	 */
	private void totalAnimals() {
		
		for(int i = 0; i < TOTAL_ANIMALS; i++){
			
			AnimalBuilder AB = new AnimalBuilder();
			String tipus = TIPUS_ANIMAL[rnd.nextInt(TIPUS_ANIMAL.length)];
			Animals.add(AB.generarAnimal(tipus));
			add(Animals.get(i).getImatge());
			
		}
	}
}
