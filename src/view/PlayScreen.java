package view;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class PlayScreen {
	
	private PApplet app;
	private PImage background, window;
	private int parallax;

	
	public PlayScreen(PApplet app) {
		this.app = app;
		this.app = app;
		
		//Load image
		background = app.loadImage("./data/playscreen.png");
		window = app.loadImage("./data/window.jpg");
		
	}
	
	public void draw() {
		//Parallax (window)
		parallax = (app.mouseX - 1400)/15;
		
		app.imageMode(PConstants.CORNER);
		app.image(window, parallax, 5, 1200, 700);
		
		//Play screen
		app.imageMode(PConstants.CORNER);
		app.image(background, 0, 0, 1200, 700);
	}

}
