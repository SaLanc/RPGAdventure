package com.SaL.RPGAdventure.level.map;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.SaL.RPGAdventure.level.Level;
import com.SaL.RPGAdventure.level.World1;
import com.SaL.RPGAdventure.level.tile.Tile;

public class SpawnHouse extends Level{
	
	public SpawnHouse(String path) {

		super(path);
	}

	protected void loadLevel(String path) {
		Level.xSpawn = 5;
		Level.ySpawn = 6;
		Level.levelType = Tile.woodfloor;

		try {
			BufferedImage image = ImageIO.read(World1.class.getResource(path));
			World1.width = image.getWidth();
			World1.height= image.getHeight();
			tiles = new int[width * height];
			image.getRGB(0, 0, width, height, tiles, 0, width);

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Excetions! could not load level file!");
		}

	}

}
