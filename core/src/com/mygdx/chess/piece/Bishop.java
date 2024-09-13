package com.mygdx.chess.piece;

import com.mygdx.chess.Main;
import com.mygdx.chess.Square;

public class Bishop extends ChessPiece {

    public Bishop(Main main, int color, Square square) {
        super(main, color, color == 0 ? "wb" : "bb", square);
    }

    @Override
    protected void move(String square) {

    }
}
