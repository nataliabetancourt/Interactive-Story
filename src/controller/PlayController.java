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
	
	public void clickObjects() {
		logic.clickRabbit();
		logic.clickPlants();
		logic.clickPotato();
		logic.clickFlower();
	}
	
	public void dragObjects() {
		logic.dragOutfit();
		logic.dragRabbit();
		logic.dragPotato();
		logic.dragPlantBar();
		logic.dragFlowerBar();
	}
	
	public void releaseObjects() {
		logic.releaseOutfit();
		logic.releaseRabbit();
		logic.releasePotato();
	}

}
