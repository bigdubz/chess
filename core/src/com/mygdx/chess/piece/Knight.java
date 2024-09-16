package com.mygdx.chess.piece;

import com.mygdx.chess.Main;
import com.mygdx.chess.Square;

public class Knight extends ChessPiece {

    public Knight(Main main, int color, Square square) {
        super(main, color, color == 0 ? "wh" : "bh", square);
    }

    @Override
    protected void move(String square) {

    }

    @Override
    public void drawValidMoves() {

    }
}
