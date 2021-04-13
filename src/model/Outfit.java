package model;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Outfit extends Element{
	
	private PImage clothes, hat, one, two;
	private int posX2, posY2, width2, height2;

	public Outfit(PApplet app, int posX, int posY, int width, int height) {
		super(app, posX, posY, width, height);
		//Variables for hat
		this.posX2 = 300;
		this.posY2 = 150;
		this.width2 = 145;
		this.height2 = 180;
		
		
		//Loading images
		clothes = app.loadImage("./data/clothes.png");
		hat = app.loadImage("./data/hat.png");
		one = app.loadImage("./data/1.png");
		two = app.loadImage("./data/2.png");

	}
	
	public void draw() {
		app.imageMode(PConstants.CENTER);
		app.image(clothes, posX, posY, width, height);
		app.image(one, posX+20, posY+60, 40, 40);
		app.image(hat, posX2, posY2, width2, height2);
		app.image(two, posX2+20, posY2+60, 40, 40);
		
	}

}
