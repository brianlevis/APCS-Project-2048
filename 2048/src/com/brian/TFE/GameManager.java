package com.brian.TFE;

import java.util.Random;

import com.brian.TFE.graphics.Colors;
import com.brian.TFE.graphics.tile.Location;
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
	private boolean hasTileMoved = false;

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
			if (NumberTile.numberTiles.size() == 16) {
				reset();
				newTile();
				newTile();
			}
			if (hasTileMoved) {
				newTile();
				hasTileMoved = false;
			}

		} else if (direction == -1) keyReleased = true;
	}

	public NumberTile getTile(int xGrid, int yGrid) {
		for (NumberTile tile : NumberTile.numberTiles)
			if (tile.xGrid == xGrid && tile.yGrid == yGrid) return tile;
		return null;
	}

	public NumberTile getNextTile(int xGrid, int yGrid, int direction) {
		switch (direction) {
			case 0:
				for (int i = yGrid - 1; i >= 0; i--)
					if (getTile(xGrid, i) != null) return getTile(xGrid, i);
				break;
			case 1:
				for (int i = xGrid + 1; i < 4; i++)
					if (getTile(i, yGrid) != null) return getTile(i, yGrid);
				break;
			case 2:
				for (int i = yGrid + 1; i < 4; i++)
					if (getTile(xGrid, i) != null) return getTile(xGrid, i);
				break;
			case 3:
				for (int i = xGrid - 1; i >= 0; i--)
					if (getTile(i, yGrid) != null) return getTile(i, yGrid);
				break;
		}
		return null;
	}

	public Location getLastSpace(int xGrid, int yGrid, int direction) {
		Location location = new Location();
		switch (direction) {
			case 0:
				for (int i = yGrid - 1; i >= 0; i--)
					if (getTile(xGrid, i) == null) location.setLocation(xGrid, i);
				break;
			case 1:
				for (int i = xGrid + 1; i < 4; i++)
					if (getTile(i, yGrid) == null) location.setLocation(i, yGrid);
				break;
			case 2:
				for (int i = yGrid + 1; i < 4; i++)
					if (getTile(xGrid, i) == null) location.setLocation(xGrid, i);
				break;
			case 3:
				for (int i = xGrid - 1; i >= 0; i--)
					if (getTile(i, yGrid) == null) location.setLocation(i, yGrid);
				break;
		}
		if (location.xPosition < 0 || location.yPosition < 0) return null;
		else return location;
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

	public void placeTile(int xGrid, int yGrid, int number) {
		new NumberTile(xGrid, yGrid, number);
	}

	public void removeTile(NumberTile tile) {
		NumberTile.numberTiles.remove(tile);
		Tile.tiles.remove(tile);
	}

	public void doubleTile(NumberTile tile) {
		removeTile(tile);
		new NumberTile(tile.xGrid, tile.yGrid, tile.number * 2);
	}

	public void moveTile(NumberTile tile, int xGrid, int yGrid) {
		tile.setPosition(xGrid, yGrid);
		hasTileMoved = true;
	}

	public void moveTile(NumberTile tile, int direction) {
		if (tile == null) return;
		NumberTile nextTile = getNextTile(tile.xGrid, tile.yGrid, direction);
		Location lastSpace = getLastSpace(tile.xGrid, tile.yGrid, direction);
		if (nextTile != null && tile.number == nextTile.number) {
			moveTile(tile, nextTile.xGrid, nextTile.yGrid);
			removeTile(nextTile);
			doubleTile(tile);
			return;
		}
		if (lastSpace != null) moveTile(tile, lastSpace.xPosition, lastSpace.yPosition);
	}

	public void makeMove(int direction) {
		for (int i = 0; i < 16; i++) {
			int x = 0, y = 0;
			switch (direction) {
				case 0:
					x = i / 4;
					y = i % 4;
					break;
				case 1:
					x = 3 - i % 4;
					y = i / 4;
					break;
				case 2:
					x = i / 4;
					y = 3 - i % 4;
					break;
				case 3:
					x = i % 4;
					y = i / 4;
					break;
			}

			moveTile(getTile(x, y), direction);

		}

	}

	public void reset() {
		System.out.println("Resetting...");
		// done to avoid throwing a ConcurrentModificationException
		int n = NumberTile.numberTiles.size();
		for (int i = 0; i < n; i++) {
			System.out.print("Removing NumberTile...");
			removeTile(NumberTile.numberTiles.get(0));
			System.out.println("Success!");
		}
	}
}