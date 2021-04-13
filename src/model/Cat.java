package model;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Cat {
	
	private PApplet app;
	private PImage cat1, cat2;
	private int posX, posY, width, height;
	
	public Cat(PApplet app) {
		this.app = app;
		this.posX = 150;
		this.posY = 380;
		this.width = 295;
		this.height = 460;
		
		//Loading images
		cat1 = app.loadImage("./data/cat1.png");
		cat2 = app.loadImage("./data/cat2.png");
		
	}
	
	public void draw() {
		app.imageMode(PConstants.CENTER);
		app.image(cat1, posX, posY, width, height);

	}

}
