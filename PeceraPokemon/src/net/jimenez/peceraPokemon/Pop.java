package net.jimenez.peceraPokemon;

import java.util.Random;

import acm.graphics.GImage;
import acm.graphics.GRectangle;

public class Pop extends Animal {

	/**
	 * Constructor de l'objecte Pop que hereta del objecte abstracte Animal.
	 * 
	 * @param img GImage que conte el valor de la imatge de l'objecte
	 * @param sex String que conte el valor del sexe de l'objecte
	 * @param a Integer que conte el valor del angle de l'objecte
	 */
	public Pop(GImage img, String sex, int a) {
		super(img, sex, a);
	}

	/**
	 * Metode que controlara si l'objecte Pop matara o no
	 * 
	 * @param a Objecte animal que pasem per parametre
	 * @return retorna un valor boolean
	 */
	@Override
	public boolean matoAnimal(Animal a) {
		if (a instanceof Peix || a instanceof Pop || a instanceof Estrella) {
			return true;
		}
		return false;
	}

	/**
	 * Metode que permet afegir un nou angle a l'objecte Pop
	 * 
	 * @param a Integer que conte el nou valor de l'angle 
	 */
	public void setAngle(int a) {
		ang = a;
	}

	/**
	 * Metode encarregat de direccionar l'objecte Pop
	 * 
	 * @param peixera GRectangle que conte els valors del canvas 
	 */
	public void canviDireccio(GRectangle peixera) {
		
		Random rnd = new Random();
		int pos = rnd.nextInt(2);
		
		if(getPosY() == 0 && getPosX() == 0){
			
			int [] angle = {0, 270};
			setAngle(angle[pos]);
			
		} else if (getPosY() == 0 && getPosX() == (peixera.getWidth() - widthImg())) {
			
			int [] angle = {180, 270};
			setAngle(angle[pos]);
			
		} else if (getPosY() == (peixera.getHeight() - heightImg()) && getPosX() == 0) {
			
			int [] angle = {0, 90};
			setAngle(angle[pos]);
			
		} else if (getPosY() == (peixera.getHeight() - heightImg()) && getPosX() == (peixera.getWidth() - widthImg())) {
			
			int [] angle = {180, 90};
			setAngle(angle[pos]);
			
		} 
	}
}
