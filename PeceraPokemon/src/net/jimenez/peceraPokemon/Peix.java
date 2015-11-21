package net.jimenez.peceraPokemon;

import acm.graphics.GImage;
import acm.graphics.GRectangle;

public class Peix extends Animal {

	/**
	 * Constructor de l'objecte Tauro que hereta del objecte abstracte Peix.
	 * 
	 * @param img
	 * @param sex
	 * @param m
	 */
	public Peix(GImage img, String sex, int a) {
		super(img, sex, a);
	}

	/**
	 * Metode que controlara si l'objecte Peix_Fantasma matara o es reproduira
	 * 
	 * @param a
	 *            Objecte peix que pasem per parametre
	 * @return
	 */
	@Override
	public boolean matoAnimal(Animal a) {

		if (a instanceof Peix) {

			if (this.sexeAnimals(a)) {
				return true;
			}
			return false;
		}
		return false;
	}

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
	}
}
