package model;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Potato extends Element{
	
	private PImage potato, bag, four;
	private boolean visible;

	public Potato(PApplet app, int posX, int posY, int width, int height) {
		super(app, posX, posY, width, height);
		
		//Loading images
		potato = app.loadImage("./data/potato.png");
		bag = app.loadImage("./data/potatobag.png");
		four = app.loadImage("./data/4.png");

	}

	public void draw() {
		if (visible) {
			app.imageMode(PConstants.CENTER);
			app.image(potato, posX, posY, height, width);
		}

	}
	
	public void drawBag() {
		app.imageMode(PConstants.CENTER);
		app.image(bag, posX, posY, width, height);
		app.image(four, posX+40, posY+60, 40, 40);

	}
	
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

}
