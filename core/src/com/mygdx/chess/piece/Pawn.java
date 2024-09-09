package com.mygdx.chess.piece;

import com.mygdx.chess.Main;

public class Pawn extends ChessPiece {

    public Pawn(Main main, int color) {
        super(main, color, color == 0 ? "wp" : "bp");
    }

    @Override
    protected void move(String square) {

    }
}
