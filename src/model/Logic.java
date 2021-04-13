	package model;

import java.util.ArrayList;

import processing.core.PApplet;

public class Logic {
	
	private PApplet app;
	private int numPotatos, numRabbits, numPlants;
	private int xO, yO, xO2, yO2, xR1, yR1, xR2, yR2, xPo, yPo, xRabbit, yRabbit, posArrayR;
	private int xPlant, yPlant, widthPlant, heightPlant;
	private boolean showScale;
	
	//Classes and Lists
	private Flower flower;
	private Outfit outfit;
	private Potato potatoBag;
	private Rabbit rabbitBag;
	private ArrayList<Plant> plants;
	private ArrayList<Potato> potatos;
	private ArrayList<Rabbit> rabbits;
	private Cat cat;
	
	
	public Logic(PApplet app) {
		this.app = app;
		this.numPlants = 2;
		this.numPotatos = 3;
		this.numRabbits = 2;
		this.xO = 460;				this.xR1 = 620;				this.xPo = 1100;
		this.yO = 280;				this.yR1 = 580;				this.yPo = 580;
		this.xO2 = 300;				this.xR2 = 480;				this.xRabbit = 0;
		this.yO2 = 150;				this.yR2 = 620;				this.yRabbit = 0;
		this.posArrayR = 0;		this.xPlant = 450;			this.yPlant = 220;
		this.widthPlant = 125;	this.heightPlant = 165;
		this.showScale = false;
		
		//Classes and Lists
		flower = new Flower(app, 830, 200, 110, 200);
		outfit = new Outfit(app, 460, 280, 205, 215);
		potatoBag = new Potato(app, 950, 420, 205, 200);
		rabbitBag = new Rabbit(app, 750, 420, 205, 200);
		plants = new ArrayList<>();
		potatos = new ArrayList<>();
		rabbits = new ArrayList<>();
		cat = new Cat(app);
		
		//Lists init
		initPotatos();
		initRabbits();
		initPlants();

	}
	
	public void draw() {
		cat.draw();
		flower.draw();
		//plant1.draw(1);
		//plant2.draw(2);
		outfit.draw();
		potatoBag.drawBag();
		rabbitBag.drawBag();
		
		/*for (int i = 0; i <potatos.size(); i++) {
			potatos.get(i).draw();
		}*/
		
		for (int i = 0; i < rabbits.size(); i++) {
			rabbits.get(i).draw();
		}
		
		for (int i = 0; i < plants.size(); i++) {
			plants.get(i).draw();

		}
	}
	
	private void initPlants() {
		for (int i = 0; i < numPlants; i++) {
			xPlant += 250;
			plants.add(new Plant(app, xPlant, yPlant, widthPlant, heightPlant));
		}
	}

	public void clickPlants() {
		for (int i = 0; i < plants.size(); i++) {
			if (app.dist(app.mouseX, app.mouseY, plants.get(i).posX, plants.get(i).getPosY())<plants.get(i).getWidth()/2) {
				plants.get(i).setShowScale(true);
			}
		}
	}
	
	private void initPotatos() {
		//Piling the potatos on top of the other
		for (int i = 0; i < numPotatos; i++) {
				xPo += 20;
				yPo += 30;
				potatos.add(new Potato(app, xPo, yPo, 80, 60));
		}
		
		for (int i = 0; i < numPotatos; i++) {
			xPo += 20;
			yPo += 30;
			potatos.add(new Potato(app, xPo, yPo, 80, 60));
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
	
	public void clickOutfit() {
		

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
	
	public void clickRabbit() {
		for (int i = 0; i < rabbits.size(); i++) {
			if (app.dist(app.mouseX, app.mouseY, rabbits.get(i).getPosX(), rabbits.get(i).getPosY())<rabbits.get(i).getWidth()/2){
				xRabbit = rabbits.get(i).getPosX();
				yRabbit = rabbits.get(i).getPosY();
				rabbits.get(i).setClick(true);
			}
		}
	}
	
	public void dragRabbit() {
		//Distance between mouse and rabbits
		for (int i = 0; i < rabbits.size(); i++) {
			if (app.dist(app.mouseX, app.mouseY, rabbits.get(i).getPosX(), rabbits.get(i).getPosY())<rabbits.get(i).getWidth()/2 && rabbits.get(i).isClick()){
				rabbits.get(i).setPosX(app.mouseX);
				rabbits.get(i).setPosY(app.mouseY);
			}
		}
	}
	
	public void releaseRabbit() {
		//Distance between rabbit and bag
		for (int i = 0; i < rabbits.size(); i++) {
			if (rabbits.get(i).isClick()) {
				if (app.dist(rabbitBag.getPosX(), rabbitBag.getPosY(), rabbits.get(i).getPosX(), rabbits.get(i).getPosY())<rabbitBag.getWidth()/2) {
					rabbits.remove(i);
					return;
				} else {
					rabbits.get(i).setPosX(xRabbit);
					rabbits.get(i).setPosY(yRabbit);
				}
			}
			rabbits.get(i).setClick(false);
		}
	}
	
	public void dragPotato() {
		//Distance between mouse and potatos
		for (int i = 0; i < rabbits.size(); i++) {
			if (app.dist(app.mouseX, app.mouseY, potatos.get(i).getPosX(), potatos.get(i).getPosY())<potatos.get(i).getWidth()/2) {
				potatos.get(i).setPosX(app.mouseX);
				potatos.get(i).setPosY(app.mouseY);
			}
		}
	}
	
	public void releasePotato() {
		//Distance between potato and bag
		for (int i = 0; i < potatos.size(); i++) {
			if (app.dist(potatoBag.getPosX(), potatoBag.getPosY(), potatos.get(i).getPosX(), potatos.get(i).getPosY())<potatoBag.getWidth()/2) {
				potatos.get(i).setVisible(false);
			} else {
				potatos.get(i).setPosX(xPo);
				potatos.get(i).setPosY(yPo);
			}
		}
	}


	
}
