package com.brian.TFE;

import com.brian.TFE.graphics.Colors;
import com.brian.TFE.graphics.tile.ScoreTile;
import com.brian.TFE.graphics.tile.Tile;
import com.brian.TFE.graphics.tile.VoidTile;

public class GameManager {

	private final int xOffset = 50;
	private final int yOffset = 220;

	private final int TILE_SIZE = 100;
	private final int TILE_GAP = 10;
	private final int TILE_BORDER = 15;

	public GameManager() {
		new VoidTile(TILE_SIZE * 4 + TILE_GAP * 3 + TILE_BORDER * 2, xOffset - TILE_BORDER, yOffset - TILE_BORDER,
				Colors.getColor("GRID"));
		for (int i = 0; i < 16; i++)
			new VoidTile(100, (i % 4) * (TILE_SIZE + TILE_GAP) + xOffset, (i / 4) * (TILE_SIZE + TILE_GAP) + yOffset,
					Colors.getColor("GRID_CELL"));
		Tile NEW_GAME = new Tile(50, 120, 30, 130, Colors.getColor("NEW_GAME"), "New Game");
		ScoreTile SCORE = new ScoreTile(80, 100, 200, 50, Colors.getColor("SCORE"), "SCORE");
		ScoreTile BEST = new ScoreTile(80, 150, 310, 50, Colors.getColor("SCORE"), "BEST");
	}

	public void update() {

	}

	public boolean isOccupied(int xPosition, int yPosition) {
		int i = 0;
		for (Tile tile : Tile.tiles)
			if (tile.name.substring(0, 6) != "TILE_") i++;
		int[] unoccupied = new int[i];
		//for (Tile tile : Tile.tiles)
		//	if (tile.name.substring(0, 6) != "TILE_") unoccupied[];
		return true;
	}

	public void placeTile() {

	}

}
