package com.mygdx.chess.piece;

import com.badlogic.gdx.utils.Array;
import com.mygdx.chess.Helper;
import com.mygdx.chess.Main;
import com.mygdx.chess.Square;

public class King extends ChessPiece {

    public King(Main main, int color, Square square) {
        super(main, color, color == 0 ? "wk": "bk", square);
    }

    @Override
    public Array<Square> getValidSquares() {
        Array<Square> valid = new Array<>();
        String thisName = this.square.getName();

        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (i == 0 && j == 0) continue;
                try {
                    String n = Main.nums[Integer.parseInt("" + thisName.charAt(1)) + j - 1];
                    String l = Main.lets[Helper.indexOf(Main.lets, "" + thisName.charAt(0)) + i];
                    Square s = Helper.getSquare(l + n);
                    if (s != null && (!s.hasPiece() || (s.hasPiece() && s.piece.color != this.color))) {
                        valid.add(s);
                    }
                } catch (IndexOutOfBoundsException ignored) {}
            }
        }
        return valid;
    }
}
