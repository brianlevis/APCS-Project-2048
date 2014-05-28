package com.brian.TFE;

import com.brian.TFE.graphics.Colors;
import com.brian.TFE.graphics.tile.NumberTile;
import com.brian.TFE.graphics.tile.ScoreTile;
import com.brian.TFE.graphics.tile.Tile;
import com.brian.TFE.graphics.tile.VoidTile;

public class GameManager {

	private final int xOffset = 50;
	private final int yOffset = 220;

	private final int TILE_SIZE = 100;
	private final int TILE_GAP = 15;

	Colors list = new Colors();

	public GameManager() {
		Tile GRID = new VoidTile(485, xOffset - 20, yOffset - 20, list.getColor("GRID"));
		for (int i = 0; i < 16; i++)
			new VoidTile(100, (i % 4) * (TILE_SIZE + TILE_GAP) + xOffset, (i / 4) * (TILE_SIZE + TILE_GAP) + yOffset,
					list.getColor("GRID_CELL"));
		Tile NEW_GAME = new Tile(30, 130, 30, 130, 0xff8f7a66, "New Game");
	}

	public void update() {

	}

}
