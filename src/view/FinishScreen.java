package view;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class FinishScreen {
	
	private PApplet app;
	private PImage background, restart;
	private int xButton, yButton, width, height;
	
	public FinishScreen(PApplet app) {
		this.app = app;
		this.app = app;
		this.xButton = 600;
		this.yButton = 600;
		this.width = 200;
		this.height = 65;
		
		//Loading images
		background = app.loadImage("./data/gameover.jpg");
		restart = app.loadImage("./data/restart.png");
		
	}

	public void draw() {
		app.tint(255, 255);
		app.imageMode(PConstants.CORNER);
		app.image(background, 0, 0, 1200, 700);
		app.imageMode(PConstants.CENTER);
		app.image(restart, xButton, yButton, width, height);

	}
	
	public boolean clickButton() {
		if (app.mouseX > xButton-width/2 && app.mouseX < xButton+width/2 && 
				app.mouseY > yButton-width/2 && app.mouseY < yButton+width/2) {
		}
		return true;
	}

}
