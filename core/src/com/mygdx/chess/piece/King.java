package com.mygdx.chess.piece;

import com.badlogic.gdx.utils.Array;
import com.mygdx.chess.Main;
import com.mygdx.chess.Square;

public class King extends ChessPiece {

    public King(Main main, int color, Square square) {
        super(main, color, color == 0 ? "wk": "bk", square);
    }


    @Override
    public void move(Square square) {

    }
    @Override
    public Array<Square> getValidSquares() {
        return null;
    }
}
