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
		if (a instanceof Tauro || (a instanceof Dofi && this.sexeAnimals(a))) {

			return true;
		}
		return false;
	}

	@Override
	public void canviDireccio(GRectangle peixera) {
		// TODO Auto-generated method stub
		
	}

}
