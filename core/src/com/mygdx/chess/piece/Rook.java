package com.mygdx.chess.piece;

import com.badlogic.gdx.utils.Array;
import com.mygdx.chess.Main;
import com.mygdx.chess.Square;


public class Rook extends ChessPiece {

    public Rook(Main main, int color, Square square) {
        super(main, color, color == 0 ? "wr" : "br", square);
    }

    @Override
    public Array<Square> getValidSquares() {
        return getRookValidSquares();
    }
}
