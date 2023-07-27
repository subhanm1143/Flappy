package com.csus.csc133;

import com.codename1.ui.Graphics;
import com.codename1.ui.Transform;

public abstract class GameObject {
	private GameModel gm;
	private int size;
	private int x;
	private double y;
	private Transform transform;
	private static Transform theVTM = Transform.makeIdentity();
	
	
	public GameObject(GameModel gm, int size, int x, double y) {

		this.setTransform(Transform.makeIdentity());
		this.gm = gm;
		this.size = size;
		this.x = x;
		this.y = y;
	}
	//Abstract methods
	public abstract void move();
	protected abstract void paint(Graphics g);
	
	public static void setupVTM(Transform theVTM) {
		GameObject.getTheVTM().setIdentity();
	    GameObject.getTheVTM().translate(200, 200);
	    GameObject.getTheVTM().scale(2, 2);
	}
	public static Transform getTheVTM() {
		return theVTM;
	}
	public Transform getTransform() {
		return transform;
	}
	public void setTransform(Transform transform) {
		this.transform = transform;
	}
}
