package net.jimenez.peceraPokemon;

import acm.graphics.GImage;
import acm.graphics.GRectangle;

public class Estrella extends Animal {

	public Estrella(GImage img, String sex, int a) {
		super(img, sex, a);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean matoAnimal(Animal a) {
		return false;
	}

	@Override
	public void canviDireccio(GRectangle peixera) {
		flipHorizontal();
	}
}
