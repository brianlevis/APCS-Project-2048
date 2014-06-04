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

	public static final int xOffset = 50;
	public static final int yOffset = 220;

	public static final int TILE_SIZE = 100;

	public static final int TILE_GAP = 10;
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
		newTile();
		newTile();
	}

	public void update() {
		int direction = keyboard.direction;
		if (direction >= 0 && keyReleased) {
			keyReleased = false;
			makeMove(direction);
		} else if (direction == -1) keyReleased = true;
	}

	public NumberTile getTile(int xPosition, int yPosition) {
		for (NumberTile tile : NumberTile.numberTiles)
			if (tile.xPosition == xPosition && tile.yPosition == yPosition) return tile;
		return null;
	}

	public NumberTile getNextTile(int xPosition, int yPosition, int direction) {
		switch (direction) {
			case 0:
				for (int i = yPosition - 1; i >= 0; i--)
					if (getTile(xPosition, i) != null) return getTile(xPosition, i);
				break;
			case 1:
				for (int i = xPosition + 1; i < 4; i++)
					if (getTile(i, yPosition) != null) return getTile(i, yPosition);
				break;
			case 2:
				for (int i = yPosition + 1; i > 4; i++)
					if (getTile(xPosition, i) != null) return getTile(xPosition, i);
				break;
			case 3:
				for (int i = xPosition - 1; i >= 0; i--)
					if (getTile(i, yPosition) != null) return getTile(i, yPosition);
				break;
		}
		return null;
	}

	public void newTile() {
		int x, y;
		do {
			int number = random.nextInt(16);
			x = number % 4;
			y = number / 4;
		} while (getTile(x, y) != null);
		int number = 2;
		if (random.nextInt(10) == 9) number = 4;
		placeTile(x, y, number);
	}

	public void placeTile(int xPosition, int yPosition, int number) {
		new NumberTile(xPosition, yPosition, number);
	}

	public void removeTile(NumberTile tile) {
		NumberTile.numberTiles.remove(tile);
		Tile.tiles.remove(tile);
	}

	public void moveTile(NumberTile tile, int xPosition, int yPosition) {
		tile.xPosition = xPosition;
		tile.yPosition = yPosition;
	}

	public void moveTile(NumberTile tile, int direction) {
		NumberTile nextTile = getNextTile(tile.xPosition, tile.yPosition, direction);
		if(nextTile == null) return;
		switch(direction) {
			case 0:
				
				break;
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
		}
		
	}

	public void changeTile(NumberTile tile, int number) {
		removeTile(tile);
		new NumberTile(tile.xPosition, tile.yPosition, number);
	}

	public void makeMove(int direction) {
		/*
		 * for (int i = 0; i < 16; i++) { int x, y; switch (direction) { case 0:
		 * x = i / 4; y = i % 4; break; case 1: x = i % 4; y = i / 4; break;
		 * case 2: x = i / 4; y = 3 - i / 4; break; case 3: x = i / 4; y = i %
		 * 4; break; }
		 * 
		 * 
		 * }
		 */
	}
}