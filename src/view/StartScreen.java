package view;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class StartScreen {
	
	private PApplet app;
	private PImage background, start;
	private int xButton, yButton, width, height;

	public StartScreen(PApplet app) {
		this.app = app;
		this.xButton = 850;
		this.yButton = 550;
		this.width = 300;
		this.height = 85;
		
		//Loading images
		background = app.loadImage("./data/start.jpg");
		start = app.loadImage("./data/start.png");
		
	}
	
	public void draw() {
		app.imageMode(PConstants.CORNER);
		app.image(background, 0, 0, 1200, 700);
		app.imageMode(PConstants.CENTER);
		app.image(start, xButton, yButton, width, height);
		
	}
	
	public boolean clickButton() {
		if (app.mouseX > xButton-width/2 && app.mouseX < xButton+width/2 && 
				app.mouseY > yButton-width/2 && app.mouseY < yButton+width/2) {
		}
		return true;
	}
}
