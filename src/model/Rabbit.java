package model;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Rabbit extends Element{

	private PImage rabbit, bag, three;
	private boolean visible;
	private boolean click;
	
	public Rabbit(PApplet app, int posX, int posY, int width, int height) {
		super(app, posX, posY, width, height);
		this.visible = true;
		this.click = false;
		
		//Loading images
		rabbit = app.loadImage("./data/bunny.png");
		bag = app.loadImage("./data/bunnybag.png");
		three = app.loadImage("./data/3.png");

	}
	
	public void draw() {
		if (visible) {
			app.imageMode(PConstants.CENTER);
			app.image(rabbit, posX, posY, width, height);
		}

	}
	
	public void drawBag() {
		app.imageMode(PConstants.CENTER);
		app.image(bag, posX, posY, width, height);
		app.image(three, posX+40, posY+60, 40, 40);
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	public boolean isClick() {
		return click;
	}
	
	public void setClick(boolean click) {
		this.click = click;
	}

}
