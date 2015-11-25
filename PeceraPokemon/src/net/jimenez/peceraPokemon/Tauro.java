package net.jimenez.peceraPokemon;

import acm.graphics.GImage;
import acm.graphics.GRectangle;

public class Tauro extends Animal {

	/**
	 * Constructor de l'objecte Tortuga que hereta del objecte abstracte Animal.
	 * 
	 * @param img GImage que conte el valor de la imatge de l'objecte
	 * @param sex String que conte el valor del sexe de l'objecte
	 * @param a Integer que conte el valor del angle de l'objecte
	 */
	public Tauro(GImage img, String sex, int a) {

		super(img, sex, a);

	}

	/**
	 * Metode que controlara si l'objecte Tauro matara o no
	 * 
	 * @param a Objecte peix que pasem per parametre
	 * @return
	 */
	@Override
	public boolean matoAnimal(Animal a) {

		if (a instanceof Peix || (a instanceof Tauro && this.sexeAnimals(a))) {
			return true;
		}
		return false;
	}

	/**
	 * Metode encarregat de direccionar l'objecte Tauro
	 * 
	 * @param peixera GRectangle que conte els valors del canvas 
	 */
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
		flipHorizontal();
	}
}
