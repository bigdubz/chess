package com.mygdx.chess.piece;

import com.mygdx.chess.Main;

public class Bishop extends ChessPiece {

    public Bishop(Main main, int color) {
        super(main, color, color == 0 ? "wb" : "bb");
    }

    @Override
    protected void move(String square) {

    }
}
