package com.csus.csc133;

import java.io.IOException;

import com.codename1.charts.util.ColorUtil;
import com.codename1.io.File;
import com.codename1.ui.*;
import com.codename1.ui.events.*;
import com.codename1.ui.geom.Point;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.util.ImageIO;
import com.codename1.ui.util.UITimer;

public class Runner extends Form implements Runnable {
    private GameModel gm;
    public Runner() {
        gm = new GameModel();
        Game();
        gm.init();
    }
    
    private void Game() {
        setLayout(new BorderLayout());

        Viewmap map = new Viewmap(gm);
        gm.addObserver(map);
        add(BorderLayout.CENTER, map);
        

        UITimer timer = new UITimer(this);
        timer.schedule(10, true, this);
        this.show();
    }

    
    @Override
    public void run() {
    	if(gm.start)
    		gm.frame();
    }
    @Override
    public void keyPressed(int keyCode) {
    	if(!gm.start) {
    		gm.start = true;
    	}
        if (keyCode == -90) {
            gm.hop();
        }
        if(keyCode == 's') {
			gm.dip();
		}
    }
    @Override
	public void pointerPressed(int x, int y) {
        super.pointerPressed(x, y);
        if(!gm.start) {
    		gm.start = true;
    	}
        gm.hop();
    }
}
