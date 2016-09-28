package com.luck.game.utilities;

import java.util.HashMap;

import aurelienribon.tweenengine.TweenManager;

import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.ObjectMap;

public class GdxGame extends Game{
	public PooledEngine engine= new PooledEngine();

	public InputMultiplexer input=new InputMultiplexer();
	
	public ObjectMap<Integer,GdxScreen> screens=new ObjectMap<Integer,GdxScreen>();
	public GdxScreen currentScreen;
	
	public TweenManager tweenmanager=new TweenManager();
	
	public AssetManager assetManager=new AssetManager();
	
	@Override
	public void create() {
		Assets.load();
		Gdx.input.setInputProcessor(input);
	}

	@Override
	public void render() {
		tweenmanager.update(Gdx.graphics.getDeltaTime());
		currentScreen.render(Gdx.graphics.getDeltaTime());
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		engine.update(Gdx.graphics.getDeltaTime());
		
		Assets.assetManager.update();
	}
	@Override
	public void dispose() {
		Assets.assetManager.dispose();
	}
	public void addScreen(int screenname, GdxScreen screen) {
		screens.put(screenname, screen);
	}

	public void changeScreen(int changescreen){
		if (currentScreen != null) {
			currentScreen.hide();
		}
		GdxScreen screen = screens.get(changescreen);
		if (screen != null) {
			screen.show();
			currentScreen = screen;
		} 
	}
}
