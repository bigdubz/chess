package com.mygdx.chess.piece;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.chess.GameScreen;
import com.mygdx.chess.Main;
import com.mygdx.chess.Square;

public abstract class ChessPiece extends Actor {


    private final Sprite sprite;
    protected final int color;
    int numMoves;
    Square square;

    public ChessPiece(Main main, int color, String image, Square square) {
        ((GameScreen)main.getScreen()).getStage().addActor(this);
        this.color = color;
        this.sprite = new Sprite(new Texture(Gdx.files.internal(image + ".png")));
        this.square = square;
        this.setPosition(this.square);
    }

    @Override
    public void draw(Batch batch, float delta) {
        sprite.draw(batch);
    }

    protected abstract void move(String square); // square por ejemplo "B3"

    public void setSquare(Square square) {
        this.square = square;
        this.square.setPiece(this);
        this.setPosition(this.square);
    }

    public abstract void drawValidMoves();

    public int getClr() {
        return color;
    }

    private void setPosition(Square square) {
        this.setPosition(square.x, square.y);
        this.sprite.setCenter(square.x + square.width*0.5f, square.y + square.height*0.5f);
    }
}
