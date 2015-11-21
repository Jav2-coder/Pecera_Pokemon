package net.jimenez.peceraPokemon;

import acm.graphics.GImage;
import acm.graphics.GRectangle;

public class Tortuga extends Animal {

	public Tortuga(GImage img, String sex, int a) {
		super(img, sex, a);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean matoAnimal(Animal a) {
		if ((a instanceof Tortuga && this.sexeAnimals(a)) || a instanceof Peix) {
			return true;
		}
		return false;
	}

	@Override
	public void canviDireccio(GRectangle peixera) {
		GRectangle tortuga = getRectangle();

		if (!tortuga.intersects(peixera)
				&& (imatge.getX() < 0 || imatge.getY() < 0)) {
			ang = ang - 180;
		} else if (!tortuga.intersects(peixera)
				&& (imatge.getX() > peixera.getWidth() || imatge.getY() > peixera
						.getHeight())) {
			ang = ang + 180;
		}
	}
}
