	package model;

import java.util.ArrayList;

import processing.core.PApplet;

public class Logic {
	
	private PApplet app;
	private int numPotatos1, numPotatos2, numRabbits;
	private int xO, yO, xO2, yO2, xR1, yR1, xR2, yR2;
	
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
		this.xO = 460;				this.xR1 = 620;
		this.yO = 280;				this.yR1 = 580;
		this.xO2 = 300;				this.xR2 = 480;
		this.yO2 = 150;				this.yR2 = 620;
		
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
		cat.draw();
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

	}
	
	private void initPotatos() {
		//Piling the potatos on top of the other
		for (int i = 0; i < numPotatos1; i++) {
			for (int j = 0; j < numPotatos2; j++) {
				int xTemp = 1100;
				int yTemp = 580;
				potatos.add(new Potato(app, xTemp+(i*20), yTemp+(j*30), 80, 60));
			}
		}
	}
	
	private void initRabbits() {
		//Creating the rabbits in two different lines for design purposes
		for (int i = 0; i < numRabbits; i++) {
			xR1 += 80;
			yR1 += 20;
			rabbits.add(new Rabbit(app, xR1, yR1, 95, 190));
		}
		
		for (int i = 0; i < numRabbits; i++) {
			xR2 += 80;
			yR2 += 20; 
			rabbits.add(new Rabbit(app, xR2,yR2, 95, 190));
		}
	}
	
	public void dragOutfit() {
		//Distance between cat and clothes with boots
		if (app.dist(app.mouseX, app.mouseY, outfit.getPosX(), outfit.getPosY())<outfit.getWidth()/2) {
			outfit.setPosX(app.mouseX);
			outfit.setPosY(app.mouseY);
		}
		
		//Distance between cat and hat
		if (app.dist(app.mouseX, app.mouseY, outfit.getPosX2(), outfit.getPosY2())<outfit.getWidth2()/2) {
			outfit.setPosX2(app.mouseX);
			outfit.setPosY2(app.mouseY);
		}
	}
	
	public void releaseOutfit() {
		//Distance between the naked cat and the clothes
		if (app.dist(cat.getPosX(), cat.getPosY(), outfit.getPosX(), outfit.getPosY())<cat.getWidth()/2 && cat.getCat()==1) {
			outfit.setVisible1(false);
			cat.setCat(4);
			
		//Distance between the naked cat and the hat
		} else if (app.dist(cat.getPosX(), cat.getPosY(), outfit.getPosX2(), outfit.getPosY2())<cat.getWidth()/2 && cat.getCat()==1) {
			outfit.setVisible2(false);
			cat.setCat(3);
			
		//Distance between the cat with a hat and the clothes
		} else if (app.dist(cat.getPosX(), cat.getPosY(), outfit.getPosX(), outfit.getPosY())<cat.getWidth()/2 && cat.getCat()==3) {
			outfit.setVisible1(false);
			cat.setCat(2);
			
		//Distance between the cat clothed and the hat
		} else if (app.dist(cat.getPosX(), cat.getPosY(), outfit.getPosX2(), outfit.getPosY2())<cat.getWidth()/2 && cat.getCat()==4) {
			outfit.setVisible2(false);
			cat.setCat(2);
			
		//Return to places
		} else {
			outfit.setPosX(xO);
			outfit.setPosY(yO);
			outfit.setPosX2(xO2);
			outfit.setPosY2(yO2);
		}
	}
	
	public void dragRabbit() {
		//Distance between mouse and rabbits
		for (int i = 0; i < rabbits.size(); i++) {
			if (app.dist(app.mouseX, app.mouseY, rabbits.get(i).getPosX(), rabbits.get(i).getPosY())<rabbits.get(i).getWidth()/2) {
				rabbits.get(i).setPosX(app.mouseX);
				rabbits.get(i).setPosY(app.mouseY);
			}
		}
	}
	
	public void releaseRabbit() {
		//Distance between rabbit and bag
		for (int i = 0; i < rabbits.size(); i++) {
			if (app.dist(rabbitBag.getPosX(), rabbitBag.getPosY(), rabbits.get(i).getPosX(), rabbits.get(i).getPosY())<rabbitBag.getWidth()/2) {
				rabbits.get(i).setVisible(false);
			} else {
				rabbits.get(i).setPosX(xR1);
				rabbits.get(i).setPosY(yR1);
			}
		}
	}

}
