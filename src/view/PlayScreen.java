package view;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class PlayScreen {
	
	private PApplet app;
	private PImage background;
	
	public PlayScreen(PApplet app) {
		this.app = app;
		this.app = app;
		
		//Load image
		background = app.loadImage("./data/playscreen.jpg");
		
	}
	
	public void draw() {
		app.imageMode(PConstants.CORNER);
		app.image(background, 0, 0, 1200, 700);
	}

}
