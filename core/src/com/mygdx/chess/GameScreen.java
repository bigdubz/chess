package com.mygdx.chess;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class GameScreen implements Screen {

    private final Main main;
    private final ScreenViewport viewport;
    private final Stage stage;

    // red

    public GameScreen(Main main) {
        this.main = main;
        this.viewport = new ScreenViewport();
        this.stage = new Stage();
        this.makeSquares();
    }

    private void makeSquares() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Main.squares.add(
                        new Square(main, Main.startc + j*Main.squareSize,
                                Main.startc + i*Main.squareSize, Main.squareSize)
                );
            }
        }
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        main.getSr().setProjectionMatrix(viewport.getCamera().combined);
        viewport.apply(true);
        main.getSr().begin();
        for (int i = 0; i < 9; i++) {
            main.getSr().line(Main.startc + i*Main.squareSize, Main.startc,
                    Main.startc + i*Main.squareSize, Main.endc);
            main.getSr().line(Main.startc, Main.startc + i*Main.squareSize,
                    Main.endc, Main.startc + i*Main.squareSize);
        }
        main.getSr().end();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        this.stage.dispose();
    }

    public Stage getStage() {
        return this.stage;
    }
}
