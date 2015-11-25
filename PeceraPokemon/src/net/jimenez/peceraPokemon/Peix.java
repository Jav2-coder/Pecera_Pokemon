package net.jimenez.peceraPokemon;

import acm.graphics.GImage;
import acm.graphics.GRectangle;

public class Peix extends Animal {

	/**
	 * Constructor de l'objecte Peix que hereta del objecte abstracte Animal.
	 * 
	 * @param img GImage que conte el valor de la imatge de l'objecte
	 * @param sex String que conte el valor del sexe de l'objecte
	 * @param a Integer que conte el valor del angle de l'objecte
	 */
	public Peix(GImage img, String sex, int a) {
		super(img, sex, a);
	}

	/**
	 * Metode que controlara si l'objecte Peix matara o no
	 * 
	 * @param a Objecte animal que pasem per parametre
	 * @return retorna un valor boolean
	 */
	@Override
	public boolean matoAnimal(Animal a) {

		if ((a instanceof Peix && this.sexeAnimals(a)) || a instanceof Estrella) {
			return true;
		}
		return false;
	}

	/**
	 * Metode encarregat de direccionar l'objecte Peix
	 * 
	 * @param peixera GRectangle que conte els valors del canvas 
	 */
	@Override
	public void canviDireccio(GRectangle peixera) {

		GRectangle peix = getRectangle();

		if (!peix.intersects(peixera)
				&& (imatge.getX() < 0 || imatge.getY() < 0)) {
			ang = ang - 180;
		} else if (!peix.intersects(peixera)
				&& (imatge.getX() > peixera.getWidth() || imatge.getY() > peixera
						.getHeight())) {
			ang = ang + 180;
		}
		flipHorizontal();
	}
}
