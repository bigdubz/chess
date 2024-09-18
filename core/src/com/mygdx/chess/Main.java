package com.mygdx.chess;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;

public class Main extends Game {

	private GameScreen screen;
	private ShapeRenderer sr;
	private final int s;
	public int turn = 0;
	public static Rectangle mouse = new Rectangle();
	public static Array<Square> squares;
	public static String[] lets = {"A", "B", "C", "D", "E", "F", "G", "H", "X", "Y"};
	public static String[] nums = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
	public static float mult = 0.04f;
	public static float startc;
	public static float endc;
	public static float squareSize;

	public Main(int s) {
		this.s = s;
	}

	@Override
	public void create() {
		squares = new Array<>();
		startc = s*mult;
		endc = s*(1-mult);
		squareSize = (endc - startc)*0.125f;
		this.sr = new ShapeRenderer();
		this.sr.setAutoShapeType(true);
		this.screen = new GameScreen(this);
		setScreen(this.screen);
	}

	@Override
	public void render() {
		ScreenUtils.clear(0.5f, 0.5f, 0.5f, 1);
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
