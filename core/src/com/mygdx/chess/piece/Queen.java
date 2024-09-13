package com.mygdx.chess.piece;

import com.mygdx.chess.Main;
import com.mygdx.chess.Square;

public class Queen extends ChessPiece {

    public Queen(Main main, int color, Square square) {
        super(main, color, color == 0 ? "wq" : "bq", square);
    }

    @Override
    protected void move(String square) {

    }
}
