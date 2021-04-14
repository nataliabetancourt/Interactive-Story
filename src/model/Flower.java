package model;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Flower extends Element{
	
	private PImage flowers, six;
	private boolean showScale;
	private int xScale, yScale, widthScale, heightScale, opacity;
	private float scaleValue;

	public Flower(PApplet app, int posX, int posY, int width, int height) {
		super(app, posX, posY, width, height);
		this.showScale = false;
		this.xScale = posX + 70;
		this.yScale = 270;
		this.widthScale = 20;
		this.heightScale = 20;
		this.scaleValue = (float) 0.5;
		this.opacity = 255;
		
		//Loading images
		flowers = app.loadImage("./data/flowers.png");
		six = app.loadImage("./data/6.png");

	}
	
	public void draw() {
		app.imageMode(PConstants.CENTER);
		app.tint(255, opacity*scaleValue);
		app.image(flowers, posX, posY, width, height);
		app.tint(255, 255);
		app.image(six, posX+20, posY+80, 40, 40);
		
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
	
	public void setScaleValue(float scaleValue) {
		this.scaleValue = scaleValue;
	}

	public int getxScale() {
		return xScale;
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
}
