package net.jimenez.peceraPokemon;

import java.util.Random;

import acm.graphics.GImage;
import acm.graphics.GRectangle;

public class Pop extends Animal {

	public Pop(GImage img, String sex, int a) {
		super(img, sex, a);
	}

	@Override
	public boolean matoAnimal(Animal a) {
		if (a instanceof Peix || a instanceof Pop || a instanceof Estrella) {
			return true;
		}
		return false;
	}

	public void setAngle(int a) {
		ang = a;
	}

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
