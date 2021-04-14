package model;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Cat {
	
	private PApplet app;
	private PImage cat1, cat2, cat3, cat4;
	private int posX, posY, width, height;
	private int cat;
	
	public Cat(PApplet app) {
		this.app = app;
		this.posX = 150;
		this.posY = 380;
		this.width = 295;
		this.height = 460;
		this.cat = 1;
		
		//Loading images
		//Cat without clothes
		cat1 = app.loadImage("./data/cat1.png");
		//Cat fully clothed
		cat2 = app.loadImage("./data/cat2.png");
		//Cat with hat and no cape
		cat3 = app.loadImage("./data/cat3.png");
		//Cat with cape and no cape
		cat4 = app.loadImage("./data/cat4.png");
		
	}
	
	public void draw() {
		app.tint(255, 255);
		app.imageMode(PConstants.CENTER);
		switch (cat) {
		case 1:
			app.image(cat1, posX, posY, width, height);
			break;
		case 2:
			app.image(cat2, posX, posY, 305, 575);
			break;
		case 3:
			app.image(cat3, posX, posY, 305, 575);
			break;
		case 4:
			app.image(cat4, posX, posY, 305, 575);
			break;
		}
	
	}
	
	public int getPosX() {
		return posX;
	}
	
	public int getPosY() {
		return posY;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getCat() {
		return cat;
	}
	
	public void setCat(int cat) {
		this.cat = cat;
	}

}
