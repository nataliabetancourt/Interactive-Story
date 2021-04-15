package model;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Outfit extends Element{
	
	private PImage clothes, hat, one, two;
	private int posX2, posY2, width2, height2;
	private boolean visible1, visible2;
	private String outfit1, outfit2, outfit3;

	public Outfit(PApplet app, int posX, int posY, int width, int height) {
		super(app, posX, posY, width, height);
		//Variables for hat
		this.posX2 = 300;
		this.posY2 = 150;
		this.width2 = 145;
		this.height2 = 180;
		this.visible1 = true;
		this.visible2 = true;
		
		//Loading images
		clothes = app.loadImage("./data/clothes.png");
		hat = app.loadImage("./data/hat.png");
		one = app.loadImage("./data/1.png");
		two = app.loadImage("./data/2.png");
		
		//Words from story
		outfit1 = "abrigo elegante";
		outfit2 = "sombrero";
		outfit3 = "botas";

	}
	
	public void draw() {
		app.tint(255, 255);
		if (visible1) {
			app.imageMode(PConstants.CENTER);
			app.image(clothes, posX, posY, width, height);
			app.image(one, posX+20, posY+60, 40, 40);
		}
		
		if (visible2) {
			app.image(hat, posX2, posY2, width2, height2);
			app.image(two, posX2+20, posY2+60, 40, 40);
		}
	}

	public int getPosX2() {
		return posX2;
	}

	public void setPosX2(int posX2) {
		this.posX2 = posX2;
	}

	public int getPosY2() {
		return posY2;
	}

	public void setPosY2(int posY2) {
		this.posY2 = posY2;
	}

	public int getWidth2() {
		return width2;
	}

	public int getHeight2() {
		return height2;
	}
	
	public void setVisible1(boolean visible1) {
		this.visible1 = visible1;
	}
	
	public void setVisible2(boolean visible2) {
		this.visible2 = visible2;
	}

	public String getOutfit1() {
		return outfit1;
	}

	public String getOutfit2() {
		return outfit2;
	}

	public String getOutfit3() {
		return outfit3;
	}
	
}
