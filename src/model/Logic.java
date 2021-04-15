	package model;

import java.util.ArrayList;

import processing.core.PApplet;

public class Logic {
	
	private PApplet app;
	private int numPotatos, numRabbits, numPlants;
	private int xO, yO, xO2, yO2, xR1, yR1, xR2, yR2, xPo, yPo,xPo2, yPo2, xRabbit, yRabbit, xPotato, yPotato;
	private int xPlant, yPlant, widthPlant, heightPlant;
	private boolean completeOutfit, completePlants, completeFlower, completeRabbits, completePotatos, interactionsComplete;
	private String [] storyTXT;
	private ArrayList<String> elementsText, storyList;
	
	//Classes and Lists
	private Flower flower;
	private Outfit outfit;
	private Plant plant;
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
		this.xO = 460;				this.xR1 = 620;				this.xPo = 1080;
		this.yO = 280;				this.yR1 = 580;				this.yPo = 490;
		this.xO2 = 300;				this.xR2 = 480;				this.xRabbit = 0;
		this.yO2 = 150;				this.yR2 = 620;				this.yRabbit = 0;
		this.xPlant = 450;			this.yPlant = 220;			this.widthPlant = 125;	
		this.heightPlant = 165;	this.xPotato = 0;			this.yPotato = 0;	
		this.xPo2 = 1050;			this.yPo2 = 530;
		
		//Interactions complete
		this.completeOutfit = false;
		this.completePlants = false;
		this.completeFlower = false;
		this.completeRabbits = false;
		this.completePotatos = false;
		this.interactionsComplete = false;
		
		//Classes and Lists
		flower = new Flower(app, 830, 200, 110, 200);
		plant = new Plant(app, 0, 0, 0, 0);
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
		
		//Strings from text
		storyTXT = app.loadStrings("./data/Story.txt");
		elementsText = new ArrayList<>();
		storyList = new ArrayList<>();
		
		//Make text an array
		for (int i = 0; i < storyTXT.length; i++) {
			storyList.add(storyTXT[i]);
		}
		
		//Array list of elements text
		elementsText.add(flower.getFlowerText());
		elementsText.add(outfit.getOutfit1());
		elementsText.add(outfit.getOutfit2());
		elementsText.add(outfit.getOutfit3());
		elementsText.add(rabbitBag.getRabbitText());
		elementsText.add(potatoBag.getPotatoText());
		elementsText.add(plant.getPlantText());
		elementsText.add(cat.getCatText());

	}
	
	public void draw() {
		cat.draw();
		flower.draw();
		outfit.draw();
		potatoBag.drawBag();
		rabbitBag.drawBag();
		
		for (int i = 0; i <potatos.size(); i++) {
			potatos.get(i).draw();
		}
		
		for (int i = 0; i < rabbits.size(); i++) {
			rabbits.get(i).draw();
		}
		
		for (int i = 0; i < plants.size(); i++) {
			plants.get(i).draw();

		}
		
		interactionsFinished();
		
		if (completeFlower && completeRabbits && completeOutfit && completePotatos && completePlants) {
			interactionsComplete = true;
		}
	}
	
	private void initPlants() {
		for (int i = 0; i < numPlants; i++) {
			xPlant += 250;
			plants.add(new Plant(app, xPlant, yPlant, widthPlant, heightPlant));
		}
		
	}
	
	private void initPotatos() {
		//Piling the potatos on top of the other
		for (int i = 0; i < numPotatos; i++) {
			xPo += 30;
			yPo += 35;
			potatos.add(new Potato(app, xPo, yPo, 80, 60));
		}
		
		for (int i = 0; i < numPotatos; i++) {
			xPo2 += 30;
			yPo2 += 35;
			potatos.add(new Potato(app, xPo2, yPo2, 80, 60));
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
	
	public void clickRabbit() {
		for (int i = 0; i < rabbits.size(); i++) {
			//Variable 
			Rabbit r = rabbits.get(i);
			
			//Distance between mouse and rabbits
			if (app.dist(app.mouseX, app.mouseY, r.getPosX(), r.getPosY())<r.getWidth()/2){
				xRabbit = r.getPosX();
				yRabbit = r.getPosY();
				r.setClick(true);
			}
		}
	}
	
	public void dragRabbit() {
		for (int i = 0; i < rabbits.size(); i++) {
			//Variable 
			Rabbit r = rabbits.get(i);
			
			//Distance between mouse and rabbits
			if (app.dist(app.mouseX, app.mouseY, r.getPosX(), r.getPosY())<r.getWidth()/2 && r.isClick()){
				r.setPosX(app.mouseX);
				r.setPosY(app.mouseY);
			}
		}
	}
	
	public void releaseRabbit() {
		for (int i = 0; i < rabbits.size(); i++) {
			//Variable 
			Rabbit r = rabbits.get(i);
			
			//Distance between rabbit and bag
			if (r.isClick()) {
				if (app.dist(rabbitBag.getPosX(), rabbitBag.getPosY(), r.getPosX(), r.getPosY())<rabbitBag.getWidth()/2) {
					rabbits.remove(i);
					return;
				} else {
					r.setPosX(xRabbit);
					r.setPosY(yRabbit);
				}
			}
			r.setClick(false);
		}
	}
	
	public void clickPotato() {
		for (int i = 0; i < potatos.size(); i++) {
			//Variable
			Potato p = potatos.get(i);
			
			//Distance between mouse and potatos
			if (app.dist(app.mouseX, app.mouseY, p.getPosX(), p.getPosY())<p.getWidth()/2){
				xPotato = p.getPosX();
				yPotato = p.getPosY();
				p.setClick(true);
			}
		}

	}
	
	public void dragPotato() {
		
		for (int i = 0; i < potatos.size(); i++) {
			//Variable
			Potato p = potatos.get(i);
			
			//Distance between mouse and potatos
			if (app.dist(app.mouseX, app.mouseY, p.getPosX(), p.getPosY())<p.getWidth()/2 && p.isClick()) {
				p.setPosX(app.mouseX);
				p.setPosY(app.mouseY);
			}
		}
	}
	
	public void releasePotato() {
		for (int i = 0; i < potatos.size(); i++) {
			//Variable
			Potato p = potatos.get(i);
			
			//Distance between potato and bag
			if (p.isClick()) {
				if (app.dist(potatoBag.getPosX(), potatoBag.getPosY(), p.getPosX(), p.getPosY())<potatoBag.getWidth()/2) {
					potatos.remove(i);
					return;
				} else {
					p.setPosX(xPotato);
					p.setPosY(yPotato);
				}
			}
			p.setClick(false);
		}
	}

	public void clickPlants() {
		for (int i = 0; i < plants.size(); i++) {
			if (app.dist(app.mouseX, app.mouseY, plants.get(i).posX, plants.get(i).getPosY())<plants.get(i).getWidth()/2) {
				plants.get(i).setShowScale(true);
			}
		}
	}
	
	public void dragPlantBar() {
		//Go through list of plants
		for (int i = 0; i < plants.size(); i++) {
			//Variable 
			Plant p = plants.get(i);
			
			//Sensitive area for the bar to be dragged
			if (app.mouseX > p.getxScale()-p.getWidthScale()/2 && app.mouseX < p.getxScale()+p.getWidthScale()/2 &&
					app.mouseY > p.getyScale()-p.getHeightScale()/2 && app.mouseY < p.getyScale()+p.getHeightScale()/2) {
				p.setyScale(app.mouseY);
				p.setScaleValue(app.abs((float) (app.map(p.getyScale(), 105, 270, (float) 0.5,1) -1.5)));
			}
			
			//Limits so that the bar can't go beyond the line 
			if (p.getyScale() >= 270) {
				p.setyScale(270);
			}
			
			if (p.getyScale() <= 105) {
				p.setyScale(105);
				
				//If plant is to full size, complete interaction
				if (p.getyScale() == 105) {
					p.setShowScale(false);
				}
			}
		}

	}

	public void clickFlower() {
		//Distance between mouse and the flower
		if (app.dist(app.mouseX, app.mouseY, flower.getPosX(), flower.getPosY())<flower.getWidth()/2) {
				flower.setShowScale(true);
		}
	}
	
	public void dragFlowerBar() {
		//Sensitive area for the bar to be dragged
		if (app.mouseX > flower.getxScale()-flower.getWidthScale()/2 &&
				app.mouseX < flower.getxScale()+flower.getWidthScale()/2 &&
				app.mouseY > flower.getyScale()-flower.getHeightScale()/2 && 
				app.mouseY < flower.getyScale()+flower.getHeightScale()/2) {
			flower.setyScale(app.mouseY);
			flower.setScaleValue(app.abs((float) (app.map(flower.getyScale(), 105, 270, (float) 0.5,1) -1.5)));
		}
		
		//Limits so that the bar can't go beyond the line 
		if (flower.getyScale() >= 270) {
			flower.setyScale(270);
		}
		
		if (flower.getyScale() <= 105) {
			flower.setyScale(105);
			
			//If flower is at complete opacity, complete interaction
			if (flower.getyScale() <= 105) {
				flower.setShowScale(false);
			}
		}

	}

	private void interactionsFinished() {
		//If all rabbits were eliminated from putting them in the bag
		if (rabbits.size() == 0) {
			completeRabbits = true;
		}
		
		//If all potatos were eliminated from putting them in the bag
		if (potatos.size() == 0) {
			completePotatos = true;
		}
		
		//If the cat is completely dressed
		if (cat.getCat() == 2) {
			completeOutfit = true;
		}
		
		//If flower is at complete opacity
		if (flower.getyScale() <= 105) {
			completeFlower = true;
		}
		
		//If plants are at complete size
		for (int i = 0; i < plants.size(); i++) {
			if (plants.get(i).getyScale() <= 105) {
				completePlants = true;
			}
		}
	}

	public boolean isInteractionsComplete() {
		return interactionsComplete;
	}
	
	public void textUpperCase() {
		for (int i = 0; i < storyList.size(); i++) {
			for (int j = 0; j < elementsText.size(); j++) {
				if (storyList.get(i).equals(elementsText.get(j))) {
					storyList.get(i).toUpperCase();
				}
			}
		}
		
		String [] newText = new String [storyList.size()];
		
		for (int j = 0; j < storyList.size(); j++) {
			newText[j] = String.join(" ", storyList.get(j));
		}
		
		app.saveStrings("./data/NewStoryTXT.txt", newText);
	
	}
	
}
