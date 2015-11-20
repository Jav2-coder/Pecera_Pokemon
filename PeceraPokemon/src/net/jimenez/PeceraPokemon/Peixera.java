package net.jimenez.PeceraPokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import acm.graphics.GRectangle;

/**
 * 
 * @author Surrui
 *
 */
public class Peixera {

	private static final String[] GENERE = { "mascle", "femella" };

	List<Animal> Animals;
	List<Animal> Bebes = new ArrayList<Animal>();
	App pantalla;
	Random rnd;
	GRectangle peixera;

	/**
	 * Constructor de l'objecte Peixera
	 * 
	 * @param fish parametre que dona el valor List de "Peixos" a l'objecte Peix.
	 * @param a parametre que fa referencia al App del programa.
	 */
	public Peixera(List<Animal> anim, App a) {

		Animals = anim;
		pantalla = a;
	}

	/**
	 * Metode que inicia el programa
	 * 
	 * @return
	 */
	public boolean inici() {

		peixera = new GRectangle(0, 0, pantalla.getWidth(), pantalla.getHeight());

		posicionament();

		while (Animals.size() > 0) {
			mourePeixos();
			pantalla.pause(5);
			colisioPeixos();
		}

		return true;
	}

	/**
	 * Metode que posiciona totes les GImage de tots els objectes Peix.
	 */
	private void posicionament() {

		rnd = new Random();

		for (int i = Animals.size() - 1; i >= 0; i--) {

			boolean semafor = true;

			while (semafor) {

				int interseccio = 0;

				int posicio = rnd.nextInt(4);

				if (posicio == 0) {

					int altImg = Animals.get(i).heightImg();

					Animals.get(i).setPosicio(0, rnd.nextInt(pantalla.getHeight() - altImg));

				} else if (posicio == 1) {

					int ampImg = Animals.get(i).widthImg();

					Animals.get(i).setPosicio(rnd.nextInt(pantalla.getWidth() - ampImg), 0);

				} else if (posicio == 2) {

					int altImg = Animals.get(i).heightImg();
					int ampImg = Animals.get(i).widthImg();

					Animals.get(i).setPosicio(pantalla.getWidth() - ampImg, rnd.nextInt(pantalla.getHeight() - altImg));

				} else {

					int altImg = Animals.get(i).heightImg();
					int ampImg = Animals.get(i).widthImg();

					Animals.get(i).setPosicio(rnd.nextInt(pantalla.getWidth() - ampImg), pantalla.getHeight() - altImg);

				}
				GRectangle peix1 = Animals.get(i).getRectangle();

				for (int j = 0; j < Animals.size(); j++) {

					GRectangle peix2 = Animals.get(j).getRectangle();

					if (i != j && peix1.intersects(peix2)) {
						interseccio++;
					}
				}
				if (interseccio == 0) {
					semafor = false;
				}
			}
			semafor = true;
		}
	}

	/**
	 * Metode que s'encarrega del moviment dels objectes Peix
	 */
	private void mourePeixos() {

		for (int i = 0; i < Animals.size(); i++) {

			GRectangle peix = Animals.get(i).getRectangle();

			if (peix.intersects(peixera) && Animals.get(i).getVida()) {

				Animals.get(i).movimentPeix();

			} else {

				Animals.get(i).canviDireccio();
				Animals.get(i).movimentPeix();

			}
		}
	}

	/**
	 * Metode que s'encarrega de produir el resultat de la colisio dels objectes
	 * Peix i decideix si elminiar els objectes o crear un nou objecte Peix
	 * depenent del seu valor del String sexe i del seu tipus objecte.
	 */
	private void colisioPeixos() {

		for (int i = 0; i < Animals.size(); i++) {

			Animal animal1 = Animals.get(i);

			Animal animal2 = XocaAmbPeix(animal1);

			if (animal2 == null) {

				// ja pot tornar a tenir sexe
				Animals.get(i).setRepro(true);

			} else {

				if (animal1 instanceof Peix) {

					boolean matarPeix = animal1.matoAnimal(animal2);

					if (matarPeix) {

						animal1.setVida(false);
						animal2.setVida(false);

						animal1.setPosicio(1000, 1000);
						animal2.setPosicio(1000, 1000);

					} else if (!matarPeix && animal2 instanceof Peix) {

						if (animal1.getRepro() && animal2.getRepro()) {

							animal1.setRepro(false);

							String sex = GENERE[rnd.nextInt(2)];

							Animal a = pantalla.crearPeix(sex);

							if (animal1.equals(sex)) {

								int X = animal1.getPosX();
								int Y = animal1.getPosY();
								a.setPosicio(X, Y);

							} else {

								int X = animal2.getPosX();
								int Y = animal2.getPosY();
								a.setPosicio(X, Y);

							}
							Bebes.add(a);
						}
					}
				} else {

					boolean matarPeix = animal1.matoAnimal(animal2);

					if (matarPeix) {

						if (animal2 instanceof Tauro) {

							animal1.setVida(false);
							animal2.setVida(false);

							animal1.setPosicio(1000, 1000);
							animal2.setPosicio(1000, 1000);

						} else {

							animal2.setVida(false);

							animal2.setPosicio(1000, 1000);

						}
						
					} else {
						
						if (animal1.getRepro() && animal2.getRepro()) {

							animal1.setRepro(false);

							String sex = GENERE[rnd.nextInt(2)];

							Animal a = pantalla.crearTauro(sex);

							if (animal1.equals(sex)) {

								int X = animal1.getPosX();
								int Y = animal1.getPosY();
								a.setPosicio(X, Y);

							} else {

								int X = animal2.getPosX();
								int Y = animal2.getPosY();
								a.setPosicio(X, Y);

							}
							Bebes.add(a);
						}
					}
				}
			}
		}
		netejarPeixera();

		for (int i = Bebes.size() - 1; i >= 0; i--) {

			Animal animal1 = Bebes.get(i);

			Animal animal2 = XocaAmbPeix(animal1);

			if (animal2 == null) {

				Animals.add(animal1);
				Bebes.remove(i);

			}
		}
	}

	/**
	 * Metode que comprova si hi ha colisio entre els objectes Peix, retornant
	 * un objecte Peix o un null per saber amb quin ha tingut la colisio
	 * l'objecte que pasem per parametre
	 * 
	 * @param animal1
	 * @return
	 */
	private Animal XocaAmbPeix(Animal animal1) {

		GRectangle peix1rect = animal1.getRectangle();

		for (Animal animal2 : Animals) {

			if (animal2 != animal1) {

				GRectangle peix2rect = animal2.getRectangle();

				if (peix1rect.intersects(peix2rect)) {
					return animal2;
				}
			}
		}
		return null;
	}

	/**
	 * Metode que s'encarrega d'eliminar els objectes Peix que estan morts.
	 */
	private void netejarPeixera() {

		for (int i = Animals.size() - 1; i >= 0; i--) {

			if (!Animals.get(i).getVida()) {

				Animals.remove(i);

			}
		}
	}
}