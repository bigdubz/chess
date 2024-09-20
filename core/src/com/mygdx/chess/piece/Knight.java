package com.mygdx.chess.piece;

import com.badlogic.gdx.utils.Array;
import com.mygdx.chess.Main;
import com.mygdx.chess.Square;

public class Knight extends ChessPiece {

    public Knight(Main main, int color, Square square) {
        super(main, color, color == 0 ? "wh" : "bh", square);
    }

    @Override
    public Array<Square> getValidSquares() {
        return null;
    }
}
