package com.csus.csc133;

import java.util.Observable;

import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.csus.csc133.GameObjectCollection.Iterator;

public class GameModel extends Observable {
	long startofGame = System.currentTimeMillis();
    private Bird bird;
    private Pillar[] pillars;
    private GameObjectCollection collection;
    
    public void init() {
    	collection = new GameObjectCollection();
        bird = new Bird(this, 100, 400,700);
        collection.add(bird);
        
        pillars = new Pillar[4];
        
        pillars[0] = new Pillar(this, 400, 2500, 0);
        pillars[1] = new Pillar(this, 400, 1000, 0);
        pillars[2] = new Pillar(this, 400, 1500, 0);
        pillars[3] = new Pillar(this, 400, 2000, 0);
        for(int i = 0; i < pillars.length; i++) {
			collection.add(pillars[i]);
		}
    }
    long score = 0;
    boolean start = false;
    boolean downFlag = false;
	public void movePillars() {
		for(int i = 0; i < pillars.length; i++) {
			pillars[i].move();
		}
	}

	public void hop() {
		bird.hop();
		bird.setAngle(-30);
		downFlag = false;
		
	}
	boolean pillarFlag = false;
	public void frame() {
		double goingDown = .5;
		bird.motion -= goingDown;
		if(!downFlag) {
			if(bird.getAngle() == 30) {
			}else {
				bird.setAngle(bird.getAngle() + (goingDown* 5));
			}
		}
		bird.move();
		movePillars();
		if(!madeThrough() && pillarFlag == true) {
			gameOver();
		}
		this.setChanged();
        this.notifyObservers();
		
	}

	private boolean madeThrough() {
	    // Calculate the bird's bounding box coordinates
	    float birdMinX = bird.getX();
	    float birdMinY = (float) bird.getY();
	    float birdMaxX = bird.getX() + bird.getSize();
	    float birdMaxY = (float) (bird.getY() + bird.getSize());

	    pillarFlag = false; // Initialize the flag outside the loop
	    for (int i = 0; i < pillars.length; i++) {
	        if (pillars[i].getX() >= 300 && pillars[i].getX() <= 500) {
	            // Check if the bird is within the pillar's hole
	            boolean below = birdMinY >= pillars[i].opening;
	            boolean above = birdMaxY <= pillars[i].opening + 300;

	            pillarFlag = true;
	            if (above && below) {
	                return true; // Bird passed through the hole
	            } else {
	                return false;
	            }
	        }
	    }
	    return false; // Bird did not pass through any hole
	}




	public Iterator getCollection() {
		// TODO Auto-generated method stub
		return collection.getIterator();
	}
	public void gameOver() {
		System.out.println(score);
		long currentTime = System.currentTimeMillis();
	    int elapsedTime = (int)(currentTime - startofGame)/1000;
		Boolean BOK = Dialog.show("Game Over", "Gameover: " + score , "OK", "New Game");
		if(!BOK) {
			newGame();
		}else
			Display.getInstance().exitApplication(); // close the application
	}

	private void newGame() {
		this.score = 0;
		int num = 500;
		for(int i = 0; i < pillars.length; i++) {
			num +=500;
			pillars[i].setX(num);
		}
		this.start = false;
		bird.setY(700);
		
	}

	public void dip() {
		bird.dip();
		bird.setAngle(90);
		downFlag = true;
	}

}
