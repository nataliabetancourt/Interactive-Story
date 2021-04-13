package model;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Plant extends Element{
	
	private PImage plant, five, seven;

	public Plant(PApplet app, int posX, int posY, int width, int height) {
		super(app, posX, posY, width, height);

		//Loading images
		plant = app.loadImage("./data/plant.png");
		five = app.loadImage("./data/5.png");
		seven = app.loadImage("./data/7.png");
		
	}

	public void draw(int p) {
		app.imageMode(PConstants.CENTER);
		app.image(plant, posX, posY, width, height);
		if (p == 1) {
			app.image(five, posX+20, posY+60, 40, 40);
		} else {
			app.image(seven, posX+20, posY+60, 40, 40);
		}
	}
}
