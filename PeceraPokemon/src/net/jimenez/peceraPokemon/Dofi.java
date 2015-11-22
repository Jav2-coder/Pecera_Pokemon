package net.jimenez.peceraPokemon;

import acm.graphics.GImage;
import acm.graphics.GRectangle;

public class Dofi extends Animal {

	public Dofi(GImage img, String sex, int a) {
		super(img, sex, a);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean matoAnimal(Animal a) {
		
		if((a instanceof Dofi && this.sexeAnimals(a)) || a instanceof Tauro){
			return true;
		}
		return false;
	}
	public void setAngle(int a) {
		ang = a;
	}

	@Override
	public void canviDireccio(GRectangle peixera) {
		
		int angle = this.ang;
		
		if(getPosY() < 0) {
			
			if(angle < 90){
				setAngle(360 - angle);
			} else {
				setAngle(270 - angle);
			}
			
		} else if(getPosY() > peixera.getHeight()) {
			
			if(angle < 270){
				setAngle(270 - angle);
			} else {
				setAngle(360 - angle);
			}
			
		} else if(getPosX() < 0) {
			
			if(angle < 90){
				setAngle(180 - angle);
			} else {
				setAngle();
			}
			
			flipHorizontal();
			
		} else if (getPosX() > peixera.getWidth()) {
			
			if(angle < 180){
				setAngle();
			} else {
				setAngle();
			}
			
			flipHorizontal();
			
		}
	}
}
