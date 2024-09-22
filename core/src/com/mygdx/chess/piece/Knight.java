package com.mygdx.chess.piece;

import com.badlogic.gdx.utils.Array;
import com.mygdx.chess.Helper;
import com.mygdx.chess.Main;
import com.mygdx.chess.Square;

public class Knight extends ChessPiece {

    public Knight(Main main, int color, Square square) {
        super(main, color, color == 0 ? "wh" : "bh", square);
    }

    @Override
    public Array<Square> getValidSquares() {
        Array<Square> valid = new Array<>();
        String thisName = this.square.getName();
        int col = Integer.parseInt("" + thisName.charAt(1)) - 1;
        int row = Helper.indexOf(Main.lets, "" + thisName.charAt(0));

        // ((2, 1), (1, 2), (-2, 1), (1, -2), (2, -1), (-1, 2), (-1, -2), (-2, -1))
        int[] xs = new int[]{2, 1, -2, 1, 2, -1, -1, -2};
        int[] ys = new int[]{1, 2, 1, -2, -1, 2, -2, -1};

        Square sq;

        for (int i = 0; i < xs.length; i++) {
            if (row + xs[i] > 7 || row + xs[i] < 0 || col+ys[i] > 7 || col+ys[i] < 0)
                continue;
            sq = Helper.getSquare(Main.lets[row+xs[i]]+Main.nums[col+ys[i]]);
            if (sq != null && sq.hasPiece()) {
                if (sq.piece.color != color) {
                    valid.add(sq);
                }
                continue;
            }
            if (sq != null)
                valid.add(sq);
        }

        return valid;
    }
}
