package net.jimenez.peceraPokemon;

import acm.graphics.GImage;
import acm.graphics.GRectangle;

public class Tauro extends Animal {

	/**
	 * Constructor de l'objecte Tauro que hereta del objecte abstracte Peix.
	 * 
	 * @param img
	 * @param sex
	 * @param m
	 */
	public Tauro(GImage img, String sex, int a) {

		super(img, sex, a);

	}

	/**
	 * Metode que controlara si l'objecte Tauro matara o es reproduira
	 * 
	 * @param p
	 *            Objecte peix que pasem per parametre
	 * @return
	 */
	@Override
	public boolean matoAnimal(Animal a) {

		if (a instanceof Peix || a instanceof Pop || (a instanceof Tauro && this.sexeAnimals(a))) {
			return true;
		}
		return false;
	}

	@Override
	public void canviDireccio(GRectangle peixera) {

		GRectangle tauro = getRectangle();

		if (!tauro.intersects(peixera)
				&& (imatge.getX() < 0 || imatge.getY() < 0)) {
			ang = ang - 180;
		} else if (!tauro.intersects(peixera)
				&& (imatge.getX() > peixera.getWidth() || imatge.getY() > peixera
						.getHeight())) {
			ang = ang + 180;
		}
	}
}
