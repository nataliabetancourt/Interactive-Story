package view;
import controller.PlayController;
import processing.core.PApplet;

public class Main extends PApplet{

	public static void main(String[] args) {
		PApplet.main("view.Main");
	}
	
	
	@Override
	public void settings() {
		size(1200, 700);	
	}
	
	int screen;
	StartScreen startScreen;
	StoryScreen storyScreen;
	PlayScreen playScreen;
	FinishScreen finishScreen;
	PlayController controller;
	
	@Override
	public void setup() {
		//Variables
		screen = 3;
		
		//Classes
		startScreen = new StartScreen(this);
		storyScreen = new StoryScreen(this);
		playScreen = new PlayScreen(this);
		finishScreen = new FinishScreen(this);
		controller = new PlayController(this);
		
	}
	
	@Override
	public void draw() {
		background(255);
		
		/*switch (screen) {
		case 1:
			startScreen.draw();
			break;
		case 2:
			storyScreen.draw();
			break;
		case 3:*/
			playScreen.draw();
			controller.draw();
		/*	break;
		case 4:
			finishScreen.draw();
			break;
		}*/
		
	}
	
	public void mousePressed() {
		//BUTTONS TO TRANSITION FROM SCREENS
			//Start button
			if (startScreen.clickButton()) {
				screen = 2;
			}
			//Next button
			if (storyScreen.clickButton()) {
				screen = 3;
			}
			//Restart button
			if (finishScreen.clickButton()) {
				screen = 1;
			}
	}
	
	@Override
	public void mouseDragged() {
		controller.dragObjects();
	}
	
	@Override
	public void mouseReleased() {
		controller.releaseObjects();
	}

}
