package com.luck.game.utilities;



public class GameManager {
	public static int SCREEN_LOADING=1;
	public static int SCREEN_MAIN=2;
	public static GdxGame _game;
	
	public static void setGame(GdxGame game){
		_game=game;
	}
	
	public static void changeScreen(int screen){
		_game.changeScreen(screen);
	}
	
}
