package com.SaL.RPGAdventure.graphics;

import com.SaL.RPGAdventure.input.KeyBoard;

public class TitleScreen extends Screen

{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public TitleScreen() {
		// TODO Auto-generated constructor stub
	}
	public void update(KeyBoard key){
		setScreen( new GameScreen());
	}
	public void render() {
		
	}

}
