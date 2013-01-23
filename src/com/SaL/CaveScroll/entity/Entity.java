package com.SaL.CaveScroll.entity;

import java.util.Random;

import com.SaL.CaveScroll.graphics.Screen;
import com.SaL.CaveScroll.level.Level;



public abstract class  Entity {
	public int x,y,xp,yp;
	private boolean removed = false;
	protected Level level;
	protected final Random random = new Random();
	
	public void update() {

	}

	public void render(Screen screen) {

	}

	public void remove() {

		// Remove from level
		removed = true;
	}

	public boolean isRemoved() {

		return removed;

	}

}
