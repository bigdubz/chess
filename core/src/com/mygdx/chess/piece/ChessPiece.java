package com.mygdx.chess.piece;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.chess.Main;

public abstract class ChessPiece extends Actor {


    Sprite image;
    Main main;
    int color;

    public ChessPiece(Main main, int color) {
        this.main = main;
        this.color = color;
    }

    protected abstract void move(String square); // square ie "B3"
}
