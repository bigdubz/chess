package com.mygdx.chess.piece;

import com.mygdx.chess.Main;

public class King extends ChessPiece {

    public King(Main main, int color) {
        super(main, color, color == 0 ? "wk": "bk");
    }

    @Override
    protected void move(String square) {

    }
}
