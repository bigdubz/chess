package com.mygdx.chess.piece;

import com.badlogic.gdx.utils.Array;
import com.mygdx.chess.Main;
import com.mygdx.chess.Square;

public class Queen extends ChessPiece {

    public Queen(Main main, int color, Square square) {
        super(main, color, color == 0 ? "wq" : "bq", square);
    }

    @Override
    public Array<Square> getValidSquares() {
        Array<Square> valid = new Array<>();
        valid.addAll(getRookValidSquares());
        valid.addAll(getBishopValidSquares());
        return valid;
    }
}
