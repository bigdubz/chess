package com.mygdx.chess.piece;

import com.badlogic.gdx.utils.Array;
import com.mygdx.chess.Main;
import com.mygdx.chess.Square;

public class Bishop extends ChessPiece {

    public Bishop(Main main, int color, Square square) {
        super(main, color, color == 0 ? "wb" : "bb", square);
    }

    @Override
    public Array<Square> getValidSquares() {
        return getBishopValidSquares();
    }
}
