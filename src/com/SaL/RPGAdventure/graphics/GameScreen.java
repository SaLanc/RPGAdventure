package com.SaL.RPGAdventure.graphics;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.SaL.RPGAdventure.Game;
import com.SaL.RPGAdventure.entity.mob.Player;
import com.SaL.RPGAdventure.input.KeyBoard;
import com.SaL.RPGAdventure.level.map.SpawnHouse;

public class GameScreen extends Screen {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public GameScreen(){
		level = new SpawnHouse("/textures/maps/spawnroom.png");
		Game.width = width;
		Game.height = height;
		player = new Player(Game.key);
	}
	
	public void update(KeyBoard key) {
		level.update();
	}

	public void render() {

		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		screen.clear();
		int xScroll = player.x - (width / 2);
		int yScroll = player.y - (height / 2);

		level.render(xScroll, yScroll, screen);
		player.render(screen);
		level.overrender(xScroll, yScroll, screen);

		for (int i = 0; i < pixels.length; i++) {
			pixelsimage[i] = screen.pixels[i];
		}

		Graphics g = bs.getDrawGraphics();
		g.fillRect(0, 0, getWidth(), getHeight());
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.dispose();
		bs.show();
	}

}
