package com.SaL.RPGAdventure.entity;

import java.util.Random;

import com.SaL.RPGAdventure.graphics.Screen;
import com.SaL.RPGAdventure.graphics.Sprite;
import com.SaL.RPGAdventure.level.Level;



public abstract class  Entity {
	//pixel location
	public int x,y;
	//tile center location for 32 size sprite
	public int centerX,centerY;
	private boolean removed = false;
	protected Level level;
	protected final Random random = new Random();
	protected Sprite sprite;
	
    public void init(Level level) {
        this.level = level;
    }
	
	
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
    public void outOfBounds() {
        if (y < 0) return;
        remove();
    }
}
