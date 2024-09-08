package com.mygdx.chess;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class GameScreen implements Screen {

    private final Main main;
    private final ScreenViewport viewport;
    private final Stage stage;

    public GameScreen(Main main) {
        this.main = main;
        this.viewport = new ScreenViewport();
        this.stage = new Stage();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        main.getSr().setProjectionMatrix(viewport.getCamera().combined);
        viewport.apply(true);
        main.getSr().begin();
        float mult = 0.04f;
        float xstart = Gdx.graphics.getWidth()*mult;
        float ystart = Gdx.graphics.getWidth()*mult;
        float xend = Gdx.graphics.getWidth()*(1-mult);
        float yend = Gdx.graphics.getHeight()*(1-mult);
        float xdiff = (xend - xstart)*0.125f;
        float ydiff = (yend - ystart)*0.125f;
        for (int i = 0; i < 9; i++) {
            main.getSr().line(xstart + i*xdiff, ystart, xstart + i*xdiff, yend);
            main.getSr().line(xstart, ystart + i*ydiff, xend, ystart + i*ydiff);
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

    }

    public Stage getStage() {
        return this.stage;
    }
}
