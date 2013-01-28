package com.SaL.RPGAdventure.level.map;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.SaL.RPGAdventure.level.Level;

import com.SaL.RPGAdventure.level.tile.indoortiles.IndoorTiles;

public class SpawnHouse extends Level{
	
	public SpawnHouse(String path) {

		super(path);
	}

	protected void loadLevel(String path) {
		Level.xSpawn = 2;
		Level.ySpawn = 2;
		Level.levelType = IndoorTiles.woodfloor;

		try {
			BufferedImage image = ImageIO.read(SpawnHouse.class.getResource(path));
			SpawnHouse.width = image.getWidth();
			SpawnHouse.height= image.getHeight();
			tiles = new int[width * height];
			image.getRGB(0, 0, width, height, tiles, 0, width);

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Excetions! could not load level file!");
		}

	}

}
