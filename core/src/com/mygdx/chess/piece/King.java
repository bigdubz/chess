package com.mygdx.chess.piece;

import com.mygdx.chess.Main;
import com.mygdx.chess.Square;

public class King extends ChessPiece {

    public King(Main main, int color, Square square) {
        super(main, color, color == 0 ? "wk": "bk", square);
    }

    @Override
    protected void move(String square) {

    }
}
