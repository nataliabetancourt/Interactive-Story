	package model;

import java.util.ArrayList;

import processing.core.PApplet;

public class Logic {
	
	private PApplet app;
	private int numPotatos1, numPotatos2, numRabbits;
	
	//Classes and Lists
	private Flower flower;
	private Plant plant1, plant2;
	private Outfit outfit;
	private Potato potatoBag;
	private Rabbit rabbitBag;
	private ArrayList<Potato> potatos;
	private ArrayList<Rabbit> rabbits;
	private Cat cat;
	
	
	public Logic(PApplet app) {
		this.app = app;
		this.numPotatos1 = 3;
		this.numPotatos2 = 2;
		this.numRabbits = 2;
		
		//Classes and Lists
		flower = new Flower(app, 830, 200, 110, 200);
		plant1 = new Plant(app, 700, 220, 125, 165);
		plant2 = new Plant(app, 960, 220, 125, 165);
		outfit = new Outfit(app, 460, 280, 205, 215);
		potatoBag = new Potato(app, 950, 420, 205, 200);
		rabbitBag = new Rabbit(app, 750, 420, 205, 200);
		potatos = new ArrayList<>();
		rabbits = new ArrayList<>();
		cat = new Cat(app);
		
		//Lists init
		initPotatos();
		initRabbits();
		
		
	}
	
	public void draw() {
		flower.draw();
		plant1.draw(1);
		plant2.draw(2);
		outfit.draw();
		potatoBag.drawBag();
		rabbitBag.drawBag();
		
		for (int i = 0; i <potatos.size(); i++) {
			potatos.get(i).draw();
		}
		
		for (int i = 0; i < rabbits.size(); i++) {
			rabbits.get(i).draw();
		}
		
		cat.draw();

	}
	
	private void initPotatos() {
		for (int i = 0; i < numPotatos1; i++) {
			for (int j = 0; j < numPotatos2; j++) {
				int xTemp = 1100;
				int yTemp = 580;
				potatos.add(new Potato(app, xTemp+(i*20), yTemp+(j*30), 80, 60));
			}
		}
	}
	
	private void initRabbits() {
		for (int i = 0; i < numRabbits; i++) {
				int xTemp = 620;
				int yTemp = 580;
				rabbits.add(new Rabbit(app, xTemp+(i*80), yTemp+(i*20), 95, 190));
			}
		
		for (int i = 0; i < numRabbits; i++) {
			int xTemp = 480;
			int yTemp = 620;
			rabbits.add(new Rabbit(app, xTemp+(i*80), yTemp+(i*20), 95, 190));
		}
	}

}
