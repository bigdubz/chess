package com.mygdx.chess.piece;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.chess.Main;

public abstract class ChessPiece extends Actor {


    private final Sprite sprite;
    private final Main main;
    private final int color;
    int numMoves;

    public ChessPiece(Main main, int color, String image) {
        this.main = main;
        this.color = color;
        this.sprite = new Sprite(new Texture(Gdx.files.internal(image + ".png")));
    }

    @Override
    public void draw(Batch batch, float delta) {
        sprite.draw(batch);
    }

    protected abstract void move(String square); // square por ejemplo "B3"
}
