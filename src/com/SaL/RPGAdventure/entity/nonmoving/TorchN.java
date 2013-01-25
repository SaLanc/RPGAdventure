package com.SaL.RPGAdventure.entity.nonmoving;

import com.SaL.RPGAdventure.entity.Entity;



public class TorchN extends Entity {
	public boolean removed = false;
	private int anim = 0;
	
	public TorchN(int x, int y){
        this.x = x;
        this.y = y;
	}
	public void update() {
		if (anim < 60)
			anim++;
		else
			anim = 0;
	}

	public void remove() {

		// Remove from level
		removed = true;
	}

	public boolean isRemoved() {

		return removed;

	}

}
