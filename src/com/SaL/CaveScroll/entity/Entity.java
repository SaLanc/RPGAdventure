package com.SaL.CaveScroll.entity;

import java.util.Random;

import com.SaL.CaveScroll.graphics.Screen;
import com.SaL.CaveScroll.level.Level;



public abstract class  Entity {
	//pixel location
	public int x,y;
	//tile center location for 32 size sprite
	public int centerX,centerY;
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
