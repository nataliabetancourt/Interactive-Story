package model;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Rabbit extends Element{

	private PImage rabbit, bag, three;
	private boolean click;
	private String rabbitText;
	
	public Rabbit(PApplet app, int posX, int posY, int width, int height) {
		super(app, posX, posY, width, height);
		this.click = false;
		
		//Loading images
		rabbit = app.loadImage("./data/bunny.png");
		bag = app.loadImage("./data/bunnybag.png");
		three = app.loadImage("./data/3.png");
		
		rabbitText = "conejos";

	}
	
	public void draw() {
		app.tint(255, 255);
		app.imageMode(PConstants.CENTER);
		app.image(rabbit, posX, posY, width, height);

	}
	
	public void drawBag() {
		app.tint(255, 255);
		app.imageMode(PConstants.CENTER);
		app.image(bag, posX, posY, width, height);
		app.image(three, posX+40, posY+60, 40, 40);
		
	}
	
	public boolean isClick() {
		return click;
	}
	
	public void setClick(boolean click) {
		this.click = click;
	}
	
	public String getRabbitText() {
		return rabbitText;
	}

}
