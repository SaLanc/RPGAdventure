package com.SaL.RPGAdventure.entity.mob;

//import com.SaL.CaveScroll.level.tile.Tile;
import com.SaL.RPGAdventure.graphics.Screen;
import com.SaL.RPGAdventure.graphics.Sprite;
import com.SaL.RPGAdventure.input.KeyBoard;
import com.SaL.RPGAdventure.level.Level;

public class Player extends Mob {

	private KeyBoard input;
	private int anim = 0;
	private boolean walking = false;
	// private boolean falling = false;
	private int xa, ya;

	public Player(KeyBoard input) {

		this.input = input;
		sprite = Sprite.PlayerSouth;
		this.x += Level.xSpawn << 4;
		this.y += Level.ySpawn << 4;

	}

	public void update() {

		xa = 0;
		ya = 0;
		if (anim < 60) anim++;
		else anim = 0;
		if (input.space) {

		}
		if (input.up) ya--;
		if (input.down) ya++;
		if (input.left) xa--;
		if (input.right) xa++;
		if (xa != 0 || ya != 0) {
			move(xa, ya);
			walking = true;
		} else {
			walking = false;
			// falling = false;
		}
	}

	public void render(Screen screen) {

		if (walking) {
			if (dir == 0) {
				sprite = Sprite.PlayerNorth;
				if (anim > 20) {
					sprite = Sprite.PlayerNorth1;
				} else if (anim > 40) {
					sprite = Sprite.PlayerNorth2;
				}
			}else if (dir == 2) {
				sprite = Sprite.PlayerSouth;
				if (anim > 20) {
					sprite = Sprite.PlayerSouth1;
				}else if (anim > 40) {
					sprite = Sprite.PlayerSouth2;
				}
			}else if (dir == 1) {
				sprite = Sprite.PlayerEast;
				if (anim > 20) {
					sprite = Sprite.PlayerEast1;
				}else if (anim > 40) {
					sprite = Sprite.PlayerEast2;
				}
			}else if (dir == 3) {
				sprite = Sprite.PlayerWest;
				if (anim > 20) {
					sprite = Sprite.PlayerWest1;
				}else if (anim > 40) {
					sprite = Sprite.PlayerWest2;
				}
			}

		}
		screen.renderPlayer(x - 7, y - 12, sprite);
	}
}
