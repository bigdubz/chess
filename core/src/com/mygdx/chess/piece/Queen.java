package com.mygdx.chess.piece;

import com.mygdx.chess.Main;

public class Queen extends ChessPiece {

    public Queen(Main main, int color) {
        super(main, color, color == 0 ? "wq" : "bq");
    }

    @Override
    protected void move(String square) {

    }
}
