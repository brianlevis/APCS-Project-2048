package com.brian.TFE;

import com.brian.TFE.graphics.tile.NumberTile;
import com.brian.TFE.graphics.tile.ScoreTile;
import com.brian.TFE.graphics.tile.Tile;
import com.brian.TFE.graphics.tile.VoidTile;

public class GameManager {
	
	private Tile BACKGROUND_TILE = new Tile();
	
	private Tile VOID_TILE = new VoidTile();
	private Tile MENU_TILE = new Tile();
	
	private ScoreTile SCORE_TILE = new ScoreTile();
	private ScoreTile BEST_TILE = new ScoreTile();
	
	private Tile TWO_TILE = new NumberTile();
	private Tile FOUR_TILE = new NumberTile();
	private Tile EIGHT_TILE = new NumberTile();
	private Tile SIXTEEN_TILE = new NumberTile();
	private Tile THIRTY_TWO_TILE = new NumberTile();
	private Tile SIXTY_FOUR_TILE = new NumberTile();
	private Tile ONE_HUNDRED_TWENTY_EIGHT_TILE = new NumberTile();
	private Tile TWO_HUNDRED_FIFTY_SIX_TILE = new NumberTile();
	private Tile FIVE_HUNDRED_TWELVE_TILE = new NumberTile();
	private Tile ONE_THOUSAND_TWENTY_FOUR_TILE = new NumberTile();
	private Tile TWO_THOUSAND_FORTY_EIGHT_TILE = new NumberTile();

	public GameManager() {
	}

}
