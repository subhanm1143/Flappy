package com.csus.csc133;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;

public class Pillar extends GameObject{

	private GameModel gm;
	private int size;
	private int x;
	private int y;

	public Pillar(GameModel gm, int size, int x, int y) {
		super(gm, size, x, y);
		this.gm = gm;
		this.setSize(size);
		this.setX(x);
		this.setY(y);
	}

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

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	Random rand = new Random();
	int opening = rand.nextInt(1081);

	//End of getter and setters move method
	public void move() {
		setX(getX() - 3);
		if(getX() <= 0) {
			setX(2048);
  			opening = rand.nextInt(1081);
		}
		if(getX() >= 300 && getX() <= 302) {
			gm.score++;
		}
		
	}
	int timer = 0;
	int rand1 = rand.nextInt();
	int rand2 = rand.nextInt();
	int rand3 = rand.nextInt();
	protected void paint(Graphics g) {
		if(timer % 10 == 0) {
			 rand1 = rand.nextInt();
			 rand2 = rand.nextInt();
			 rand3 = rand.nextInt();
			timer++;
		}
		//Top Part of Pillar
		g.setColor(ColorUtil.rgb(rand1,rand2,rand3)); 
		g.fillRect(getX(), getY(), 100, opening);
		g.fillRect(getX() - 20, getY() + opening - 10, 20, 10);
		g.fillRect(getX() + 100, getY() + opening - 10, 20, 10);
		//Bottom Portion
		g.setColor(ColorUtil.rgb(rand2,rand3,rand1)); 
		g.fillRect(getX(), getY() + opening + 300, 100, 1500);
		g.fillRect(getX() - 20, getY() + opening + 300, 20, 10);
		g.fillRect(getX() + 100, getY() + opening + 300, 20, 10);
		// + 300 is the opening
		
	}
}
