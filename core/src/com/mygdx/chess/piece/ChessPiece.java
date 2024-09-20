package com.mygdx.chess.piece;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;
import com.mygdx.chess.GameScreen;
import com.mygdx.chess.Main;
import com.mygdx.chess.Square;

public abstract class ChessPiece extends Actor {


    private final Sprite sprite;
    protected final int color;
    protected final int dir;
    int numMoves;
    Square square;
    Main main;

    public ChessPiece(Main main, int color, String image, Square square) {
        ((GameScreen)main.getScreen()).getStage().addActor(this);
        this.main = main;
        this.color = color;
        this.dir = this.color == 0 ? 1 : -1;
        this.sprite = new Sprite(new Texture(Gdx.files.internal(image + ".png")));
        this.square = square;
        this.setPosition(this.square);
    }

    @Override
    public void draw(Batch batch, float delta) {
        sprite.draw(batch);
    }

    public void move(Square square) {
        if (square.hasPiece()) {
            square.piece.remove();
        }
        numMoves++;
        this.square.clearPiece();
        this.square = square;
        this.square.setPiece(this);
        this.setPosition(this.square);
    }

    public void setSquare(Square square) {
        this.square = square;
        this.square.setPiece(this);
        this.setPosition(this.square);
    }

    public void drawValidSquares(Array<Square> valid) {
        if (valid == null) return;
        for (Square sq : valid) {
            if (sq.hasPiece()) {
                main.getSr().setColor(0.85f, 0.32f, 0.13f, 1);
                main.getSr().rect(sq.x, sq.y, sq.width, sq.height);
            }
            else {
                main.getSr().setColor(0.8f, 0.8f, 0.71f, 1);
                main.getSr().circle(sq.x + sq.width*0.5f, sq.y + sq.height*0.5f, 20);
            }
        }
    }

    public abstract Array<Square> getValidSquares();

    protected void setPosition(Square square) {
        this.setPosition(square.x, square.y);
        this.sprite.setCenter(square.x + square.width*0.5f, square.y + square.height*0.5f);
    }

    public boolean checkTurn() {
        return main.turn == color;
    }
}
