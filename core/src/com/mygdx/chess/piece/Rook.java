package com.mygdx.chess.piece;

import com.mygdx.chess.Main;

public class Rook extends ChessPiece {

    public Rook(Main main, int color) {
        super(main, color, color == 0 ? "wr" : "br");
    }

    @Override
    protected void move(String square) {

    }
}
