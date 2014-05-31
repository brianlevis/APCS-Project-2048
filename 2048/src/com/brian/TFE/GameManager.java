package com.brian.TFE;

import java.util.Random;

import com.brian.TFE.graphics.Colors;
import com.brian.TFE.graphics.tile.NumberTile;
import com.brian.TFE.graphics.tile.ScoreTile;
import com.brian.TFE.graphics.tile.Tile;
import com.brian.TFE.graphics.tile.VoidTile;
import com.brian.TFE.input.Keyboard;

public class GameManager {

	Random random = new Random();

	private Keyboard keyboard;

	private final int xOffset = 50;
	private final int yOffset = 220;

	public static final int TILE_SIZE = 100;

	private final int TILE_GAP = 10;
	private final int TILE_BORDER = 15;

	private boolean keyReleased = true;

	public GameManager(Keyboard keyboard) {
		this.keyboard = keyboard;
		new VoidTile(TILE_SIZE * 4 + TILE_GAP * 3 + TILE_BORDER * 2, xOffset - TILE_BORDER, yOffset - TILE_BORDER,
				Colors.getColor("GRID"));
		for (int i = 0; i < 16; i++)
			new VoidTile(100, (i % 4) * (TILE_SIZE + TILE_GAP) + xOffset, (i / 4) * (TILE_SIZE + TILE_GAP) + yOffset,
					Colors.getColor("GRID_CELL"));
		@SuppressWarnings("unused")
		Tile NEW_GAME = new Tile(50, 120, 30, 130, Colors.getColor("NEW_GAME"), "New Game");
		@SuppressWarnings("unused")
		ScoreTile SCORE = new ScoreTile(80, 100, 200, 50, Colors.getColor("SCORE"), "SCORE");
		@SuppressWarnings("unused")
		ScoreTile BEST = new ScoreTile(80, 150, 310, 50, Colors.getColor("SCORE"), "BEST");
		for (int i = 0; i < 10; i++)
			newTile();
	}

	public void update() {
		System.out.println(keyboard.direction);
		int direction = keyboard.direction;
		if (direction >= 0 && keyReleased) {
			keyReleased = false;
			makeMove(direction);
		} else if (direction == -1) keyReleased = true;
	}

	public boolean isOccupied(int xPosition, int yPosition) {
		for (NumberTile tile : NumberTile.numberTiles)
			if (tile.xGrid == xPosition && tile.yGrid == yPosition) return true;
		return false;
	}

	public void newTile() {
		int x, y;
		do {
			int number = random.nextInt(16);
			x = number % 4;
			y = number / 4;
		} while (isOccupied(x, y));
		int tile = 2;
		if (random.nextInt(10) == 9) tile = 4;
		placeTile(x, y, tile);
	}

	public void placeTile(int xPosition, int yPosition, int tile) {
		new NumberTile(xPosition * (TILE_SIZE + TILE_GAP) + xOffset, yPosition * (TILE_SIZE + TILE_GAP) + yOffset,
				xPosition, yPosition, tile);
	}

	public void makeMove(int direction) {
		for (int i = 0; i < 4; i++) {
			
		}
	}
}
