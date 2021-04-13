package model;

import processing.core.PApplet;

public class Element {
	
	protected PApplet app;
	protected int posX, posY, width, height;
	
	public Element() {
		
	}
	
	public Element(PApplet app, int posX, int posY, int width, int height) {
		this.app = app;
		this.posX = posX;
		this.posY = posY;
		this.width = width;
		this.height = height;
		
	}

	public void draw() {}
	
	public void move() {}
	
	
}
