package com.mygdx.chess;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

public class Main extends Game {

	GameScreen screen;
	private ShapeRenderer sr;
	private final int s;

	public Main(int s) {
		this.s = s;
	}

	@Override
	public void create() {
		this.sr = new ShapeRenderer();
		this.sr.setAutoShapeType(true);
		this.screen = new GameScreen(this);
		setScreen(this.screen);
	}

	@Override
	public void render() {
		ScreenUtils.clear(0, 0.05f, 0.05f, 1);
		super.render();
	}
	
	@Override
	public void dispose() {
		this.sr.dispose();
		this.screen.dispose();
	}

	public ShapeRenderer getSr() {
		return this.sr;
	}

	public int getSize() {
		return this.s;
	}
}
