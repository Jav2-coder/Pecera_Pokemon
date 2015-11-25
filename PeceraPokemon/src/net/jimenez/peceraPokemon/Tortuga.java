package net.jimenez.peceraPokemon;

import acm.graphics.GImage;
import acm.graphics.GRectangle;

public class Tortuga extends Animal {

	/**
	 * Constructor de l'objecte Tortuga que hereta del objecte abstracte Animal.
	 * 
	 * @param img GImage que conte el valor de la imatge de l'objecte
	 * @param sex String que conte el valor del sexe de l'objecte
	 * @param a Integer que conte el valor del angle de l'objecte
	 */
	public Tortuga(GImage img, String sex, int a) {
		super(img, sex, a);
	}

	/**
	 * Metode que controlara si l'objecte Tortuga matara o no
	 * 
	 * @param a Objecte animal que pasem per parametre
	 * @return retorna un valor boolean
	 */
	@Override
	public boolean matoAnimal(Animal a) {
		if ((a instanceof Tortuga && this.sexeAnimals(a)) || a instanceof Peix) {
			return true;
		}
		return false;
	}

	/**
	 * Metode encarregat de direccionar l'objecte Tortuga
	 * 
	 * @param peixera GRectangle que conte els valors del canvas 
	 */
	@Override
	public void canviDireccio(GRectangle peixera) {
		GRectangle tortuga = getRectangle();

		if (!tortuga.intersects(peixera)
				&& (imatge.getX() < 0 || imatge.getY() < 0)) {
			ang = ang - 180;
		} else if (!tortuga.intersects(peixera)
				&& (imatge.getX() > peixera.getWidth() || imatge.getY() > peixera
						.getHeight())) {
			ang = ang + 180;
		}
		flipHorizontal();
	}
}
