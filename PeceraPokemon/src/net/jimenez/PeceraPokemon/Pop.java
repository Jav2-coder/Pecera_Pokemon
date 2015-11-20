package net.jimenez.PeceraPokemon;

import acm.graphics.GImage;

public class Pop extends Animal{

	public Pop(GImage img, String sex, int x, int y) {
		super(img, sex, x, y);
	}

	@Override
	public boolean matoAnimal(Animal a) {
		return false;
	}
}
