package com.mygdx.chess.piece;

import com.mygdx.chess.Main;
import com.mygdx.chess.Square;

public class Pawn extends ChessPiece {

    public Pawn(Main main, int color, Square square) {
        super(main, color, color == 0 ? "wp" : "bp", square);
    }

    @Override
    protected void move(String square) {

    }
}
