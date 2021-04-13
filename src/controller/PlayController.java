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
	
	public void dragObjects() {
		logic.dragOutfit();
		logic.dragRabbit();
	}
	
	public void releaseObjects() {
		logic.releaseOutfit();
		logic.releaseRabbit();
	}

}
