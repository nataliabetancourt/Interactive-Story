package model;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Plant extends Element{
	
	private PImage plant, five, seven; 
	private boolean showScale;
	private int xScale, yScale;

	public Plant(PApplet app, int posX, int posY, int width, int height) {
		super(app, posX, posY, width, height);
		this.showScale = false;
		this.xScale = posX + 70;
		this.yScale = 270;

		//Loading images
		plant = app.loadImage("./data/plant.png");
		five = app.loadImage("./data/5.png");
		seven = app.loadImage("./data/7.png");
		
	}

	public void draw() {
		app.imageMode(PConstants.CENTER);
		app.image(plant, posX, posY, width, height);
		app.image(five, posX+20, posY+60, 40, 40);
		
		if (showScale) {
			app.stroke(80);
			app.strokeWeight(3);
			app.line(xScale, yScale, xScale, yScale-165);
			app.fill(250, 193, 195);
			app.noStroke();
			app.rectMode(PConstants.CENTER);
			app.rect(xScale, yScale, 20, 10);
		}
	}

	public void setShowScale(boolean showScale) {
		this.showScale = showScale;
	}
	
	public int getxScale() {
		return xScale;
	}
	
	public int getyScale() {
		return yScale;
	}
}
