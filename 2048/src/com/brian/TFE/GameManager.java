package com.brian.TFE;

import com.brian.TFE.graphics.tile.NumberTile;
import com.brian.TFE.graphics.tile.ScoreTile;
import com.brian.TFE.graphics.tile.Tile;
import com.brian.TFE.graphics.tile.VoidTile;

public class GameManager {

	public GameManager() {
		Tile BACKGROUND = new VoidTile(100, 75, 75, 0xffff00ff);
		//for(int i = 0; i < 16; i++) new VoidTile(100, 0xffff00ff);
		Tile NEW_GAME = new Tile(30, 80, 100, 100, 0xffff00fe, "New Game");
	}

}
