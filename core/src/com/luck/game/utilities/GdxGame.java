package com.luck.game.utilities;

import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.ObjectMap;

import aurelienribon.tweenengine.TweenManager;

public class GdxGame extends Game{
	public PooledEngine engine= new PooledEngine();

	public InputMultiplexer input=new InputMultiplexer();
	
	public ObjectMap<String,GdxScreen> screens=new ObjectMap<String,GdxScreen>();
	public GdxScreen currenscreen;
	
	public TweenManager tweenmanager=new TweenManager();
	
	public AssetManager assetManager=new AssetManager();
	
	@Override
	public void create() {
		Gdx.input.setInputProcessor(input);
		
	}

	@Override
	public void render() {
		tweenmanager.update(Gdx.graphics.getDeltaTime());
		currenscreen.render(Gdx.graphics.getDeltaTime());
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		engine.update(Gdx.graphics.getDeltaTime());
	}
	@Override
	public void dispose() {
		
	}

}
