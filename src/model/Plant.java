package model;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Plant extends Element{
	
	private PImage plant, five, seven; 
	private boolean showScale;
	private int xScale, yScale, widthScale, heightScale;
	private float scaleValue;

	public Plant(PApplet app, int posX, int posY, int width, int height) {
		super(app, posX, posY, width, height);
		this.showScale = false;
		this.xScale = posX + 70;
		this.yScale = 270;
		this.widthScale = 20;
		this.heightScale = 20;
		this.scaleValue = (float) 0.5;

		//Loading images
		plant = app.loadImage("./data/plant.png");
		five = app.loadImage("./data/5.png");
		seven = app.loadImage("./data/7.png");
		
	}

	public void draw() {
		app.imageMode(PConstants.CENTER);
		app.image(plant, posX, posY, width*scaleValue, height*scaleValue);
		app.image(five, posX+20, posY+60, 40, 40);
		
		if (showScale) {
			app.stroke(80);
			app.strokeWeight(3);
			app.line(posX+70, 270, posX+70, 105);
			app.fill(250, 193, 195);
			app.noStroke();
			app.rectMode(PConstants.CENTER);
			app.rect(xScale, yScale, widthScale, heightScale);
		}
	}

	public void setShowScale(boolean showScale) {
		this.showScale = showScale;
	}
	
	public int getxScale() {
		return xScale;
	}
	
	public void setxScale(int xScale) {
		this.xScale = xScale;
	}
	
	public int getyScale() {
		return yScale;
	}
	
	public void setyScale(int yScale) {
		this.yScale = yScale;
	}
	
	public int getWidthScale() {
		return widthScale;
	}
	
	public int getHeightScale() {
		return heightScale;
	}
	
	public void setScaleValue(float scaleValue) {
		this.scaleValue = scaleValue;
	}
}
