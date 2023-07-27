package com.csus.csc133;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Font;
import com.codename1.ui.Graphics;
import com.codename1.ui.Label;
import com.codename1.ui.Transform;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Border;

public class Viewmap extends Container implements Observer {

    private GameModel gm;
    private Container scoreContainer;
    private Label scoreLabel;
    private Transform theVTM;

    public Viewmap(GameModel gm) {
        this.gm = gm;
        this.setTheVTM(Transform.makeIdentity());
        getStyle().setBorder(Border.createLineBorder(2, 0xff0000));
     // Create the score label and set its text
        scoreLabel = new Label("Score: " + gm.score);
        scoreLabel.getAllStyles().setAlignment(CENTER);
        scoreLabel.getAllStyles().setFgColor(0x000000);
        scoreLabel.getAllStyles().setFont(Font.createSystemFont(Font.STYLE_ITALIC, Font.STYLE_BOLD, Font.SIZE_LARGE));
        scoreLabel.setPreferredW(300);
        
        scoreContainer = new Container(new FlowLayout(Component.CENTER));
        scoreContainer.add(scoreLabel);

        // Set the layout manager to FlowLayout for center alignment
        setLayout(new LayeredLayout());
        // Add the score container to the layered container with a higher z-index
        add(scoreContainer);
    }

    public void paint(Graphics g) {
        super.paint(g);
        // Set the color and stroke for drawing game objects
        g.setColor(0x000000); // Set color to black
        
        GameObjectCollection.Iterator iterator = gm.getCollection();
        while (iterator.hasNext()) {
            GameObject gameObject = iterator.getNext();
            // Call the paint method of each game object to draw it on the screen
            gameObject.paint(g);
        }
        Random rand = new Random();
        if(!gm.start) {
	        g.setColor(ColorUtil.rgb(rand.nextInt(255),rand.nextInt(255) , rand.nextInt(255)));
	        // F
	        int[] xF = {500, 500, 550, 550, 700, 700, 550, 550, 700, 700};
	        int[] yF = {100, 500, 500, 300, 300, 250, 250, 150, 150, 100};
	        g.fillPolygon(xF, yF, 10);
	        g.setColor(ColorUtil.rgb(rand.nextInt(255),rand.nextInt(255) , rand.nextInt(255)));
	        // L
	        int[] xL = {750, 800, 800, 950, 950, 750, 750, 750, 750, 750};
	        int[] yL = {100, 100, 450, 450, 500, 500, 100, 100, 150, 150};
	        g.fillPolygon(xL, yL, 10);
	        g.setColor(ColorUtil.rgb(rand.nextInt(255),rand.nextInt(255) , rand.nextInt(255)));
	        // A
	        int[] xA = {1000, 1050, 1100, 1150, 1200, 1250, 1150, 1050, 1000};
	        int[] yA = {500,   500,  300, 300,   500, 500, 100, 100, 500};
	        g.fillPolygon(xA, yA, 9);
	        g.setColor(ColorUtil.rgb(rand.nextInt(255),rand.nextInt(255) , rand.nextInt(255)));
	        // P
	        int[] xP = {1300, 1500, 1500, 1350, 1350, 1300, 1300};
	        int[] yP = {100,  100,  300,  300,  500,  500,  100};
	        g.fillPolygon(xP, yP, 7);
	
	        // P
	        int[] Px = {1550, 1750, 1750, 1600, 1600, 1550, 1550};
	        int[] Py = {100,  100,  300,  300,  500,  500,  100};
	        //g.drawPolygon(Px, Py, 7);
	        g.setColor(ColorUtil.rgb(rand.nextInt(255),rand.nextInt(255) , rand.nextInt(255)));
	        // Y
	        int[] Yx = {1550, 1650, 1750, 1750, 1680, 1680, 1620, 1620, 1550};
	        int[] Yy = {100,  200,  100,  150,  225,  500,  500, 225, 150, 100};
	        g.fillPolygon(Yx, Yy, 9);
        }
    }

    @Override
    public void update(Observable observable, Object data) {
        // Repaint the container when an update occurs
        this.repaint();
        scoreLabel.setText("Score: " + gm.score);
    }

	public Transform getTheVTM() {
		return theVTM;
	}

	public void setTheVTM(Transform theVTM) {
		this.theVTM = theVTM;
	}
}

