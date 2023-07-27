package com.csus.csc133;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.Transform;

public class Bird extends GameObject{
	private GameModel gm;
	private int size;
	private int x;
	private double y;
	private double angle;
	Random rand = new Random();

	public Bird(GameModel gm, int size, int x, double y) {
		super(gm, size, x, y);
		this.gm = gm;
		this.setSize(size);
		this.setX(x);
		this.setY(y);
		this.setAngle(0);
	}
	
	double motion = 0;
	boolean hopFlag = false;
	public GameModel getGm() {
		return gm;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void hop() {
		//motion plus to y in frame and minused by 1 each time 
		motion = 10;
		angle = -30;
		hopFlag = true;
	}
	int random = rand.nextInt(255);
	int random1 = rand.nextInt(255);
	int random2= rand.nextInt(255);
	protected void paint(Graphics g) {
	    Transform originalTransform = g.getTransform().copy();

	    int centerX = getX() + getSize() / 2;
	    int centerY = (int) getY() + getSize() / 2;
	    if(hopFlag) {
	    	Transform rotation = Transform.makeIdentity();
	    	rotation.rotate((float) Math.toRadians(angle), centerX, centerY);
	    	g.setTransform(rotation);
	    }

	    g.setColor(ColorUtil.YELLOW);
	    g.fillArc(getX(), (int) getY(), getSize(), getSize(), 0, 360);
	    g.setColor(ColorUtil.rgb(255, 0, 0));
	    g.fillArc(getX(), (int) getY(), getSize(), getSize(), 340, 40);
	    int[] xPoints = {getX() + getSize() - 5, getX() + getSize() - 5, getX() + getSize() + 25};
	    int[] yPoints = {(int) getY() + getSize() / 2 - 12, (int) getY() + getSize() / 2 + 12, (int) getY() + getSize() / 2};

	    g.fillPolygon(xPoints, yPoints, 3); // Draw the triangle

	    g.setColor(ColorUtil.BLUE);
	    g.fillArc(getX() + getSize() / 2, (int) getY() + getSize() / 4, 10, 10, 0, 360);
	    g.setColor(ColorUtil.WHITE);
	    g.fillArc(getX() + getSize() / 2, (int) getY() + getSize() / 4 + 2, 5, 5, 0, 360);

	    g.setTransform(originalTransform);
	}


	@Override
	public void move() {
		setY(getY() - motion);
		if(getY() <  0) {
			setY(0);
		}else if(getY() > 1481) {
			gm.gameOver();
		}
		
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	public void dip() {
		motion = -10;
		
	}
}
