package com.SaL.CaveScroll.entity.mob;

import com.SaL.CaveScroll.graphics.Sprite;
import com.SaL.CaveScroll.input.KeyBoard;
	
	public class Player extends Mob {

		private KeyBoard input;
		private Sprite sprite;
		private int anim = 0;
		private boolean walking = false;

		public Player(KeyBoard input) {

			this.input = input;
//			this.x = level.xSpawn + 1;
//			this.y = level.ySpawn + 1;
//			sprite = Sprite.player_Forward;

		}

		public Player(int x, int y, KeyBoard input) {

			this.x = x;
			this.y = y;
			this.input = input;
		}

		public void update() {

			int xa = 0, ya = 0;
			if (anim < 7500) anim++;
			else anim = 0;
			if (input.up) ya--;
			if (input.down) ya++;
			if (input.left) xa++;
			if (input.right) xa--;

			if (xa != 0 || ya != 0) {
				move(xa, ya);
				walking = true;
			} else {
				walking = false;
			}
		}
}
