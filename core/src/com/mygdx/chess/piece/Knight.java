package com.mygdx.chess.piece;

import com.mygdx.chess.Main;

public class Knight extends ChessPiece {

    public Knight(Main main, int color) {
        super(main, color, color == 0 ? "wh" : "bh");
    }

    @Override
    protected void move(String square) {

    }
}
