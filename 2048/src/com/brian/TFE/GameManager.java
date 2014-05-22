package com.brian.TFE;

import com.brian.TFE.graphics.tile.NumberTile;
import com.brian.TFE.graphics.tile.ScoreTile;
import com.brian.TFE.graphics.tile.Tile;
import com.brian.TFE.graphics.tile.VoidTile;

public class GameManager {

	public GameManager() {
		Tile background = new VoidTile(100, 0xffff00ff);
		for(int i = 0; i < 16; i++) new VoidTile(100, 0xffff00ff);
	}

}
