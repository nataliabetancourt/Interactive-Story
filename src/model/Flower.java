package model;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Flower extends Element{
	
	private PImage flowers, six;

	public Flower(PApplet app, int posX, int posY, int width, int height) {
		super(app, posX, posY, width, height);
		
		//Loading images
		flowers = app.loadImage("./data/flowers.png");
		six = app.loadImage("./data/6.png");

	}
	
	public void draw() {
		app.imageMode(PConstants.CENTER);
		app.image(flowers, posX, posY, width, height);
		app.image(six, posX+20, posY+80, 40, 40);
	}

}
