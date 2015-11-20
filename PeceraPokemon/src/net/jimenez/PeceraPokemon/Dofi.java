package net.jimenez.PeceraPokemon;

import acm.graphics.GImage;

public class Dofi extends Animal {

	public Dofi(GImage img, String sex, int x, int y) {
		super(img, sex, x, y);	
	}

	@Override
	public boolean matoAnimal(Animal a) {
		return false;
	}

}
