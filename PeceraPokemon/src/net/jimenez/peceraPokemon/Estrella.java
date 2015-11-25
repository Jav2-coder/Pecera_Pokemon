package net.jimenez.peceraPokemon;

import acm.graphics.GImage;
import acm.graphics.GRectangle;

public class Estrella extends Animal {

	/**
	 * Constructor de l'objecte Estrella que hereta del objecte abstracte Animal.
	 * 
	 * @param img GImage que conte el valor de la imatge de l'objecte
	 * @param sex String que conte el valor del sexe de l'objecte
	 * @param a Integer que conte el valor del angle de l'objecte
	 */
	public Estrella(GImage img, String sex, int a) {
		super(img, sex, a);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Metode que controlara si l'objecte Estrella matara o no
	 * 
	 * @param a Objecte animal que pasem per parametre
	 * @return retorna un valor boolean
	 */
	@Override
	public boolean matoAnimal(Animal a) {
		return false;
	}

	/**
	 * Metode que permet afegir un nou angle a l'objecte Estrella
	 * 
	 * @param a Integer que conte el nou valor de l'angle 
	 */
	public void setAngle(int a) {
		ang = a;
	}

	/**
	 * Metode encarregat de direccionar l'objecte Estrella
	 * 
	 * @param peixera GRectangle que conte els valors del canvas 
	 */
	@Override
	public void canviDireccio(GRectangle peixera) {
		int angle = this.ang;

		if (getPosY() < 0) {
			if (angle < 90) {
				setAngle(360 - angle);
			} else {
				angle = angle + 90;
				setAngle(angle);
			}
		} else if (getPosY() > peixera.getHeight()) {
			if (angle > 270) {
				setAngle(360 - angle);
			} else {
				setAngle(angle - 90);
			}
		} else if (getPosX() < 0) {
			if (angle > 180) {
				setAngle(angle + 90);
			} else {
				setAngle(angle - 90);
			}
			flipHorizontal();
		} else if (getPosX() > peixera.getWidth()) {
			if (angle > 90) {
				setAngle(angle - 90);
			} else {
				setAngle(angle + 90);
			}
			flipHorizontal();
		}
	}
}
