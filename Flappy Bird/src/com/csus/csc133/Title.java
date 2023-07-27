package com.csus.csc133;

import java.util.Observable;
import java.util.Observer;

import com.codename1.ui.Container;
import com.codename1.ui.Graphics;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.Layout;
import com.codename1.ui.plaf.Border;

public class Title extends Container implements Observer{
	
	private GameModel gm;

	@Override
	public void update(Observable observable, Object data) {
		repaint();
		
	}
	public Title(GameModel gm) {
		this.gm = gm;
		getStyle().setBorder(Border.createLineBorder(2, 0x000000));
		Label welcome = new Label("Subhan Mehmood CSC133 Welcome");
		add(welcome);
	}
}