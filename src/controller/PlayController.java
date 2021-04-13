package controller;

import model.Logic;
import processing.core.PApplet;

public class PlayController {
	
	private PApplet app;
	private Logic logic;
	
	public PlayController(PApplet app) {
		this.app = app;
		
		logic = new Logic(app);
	}
	
	public void draw() {
		logic.draw();
	}
	
	public void dragOutfit() {
		logic.dragOutfit();
	}
	
	public void releaseOutfit() {
		logic.releaseOutfit();
	}

}
