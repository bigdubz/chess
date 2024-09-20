package com.mygdx.chess.piece;

import com.badlogic.gdx.utils.Array;
import com.mygdx.chess.Helper;
import com.mygdx.chess.Main;
import com.mygdx.chess.Square;

public class Pawn extends ChessPiece {

    public Pawn(Main main, int color, Square square) {
        super(main, color, color == 0 ? "wp" : "bp", square);
    }

    @Override
    public Array<Square> getValidSquares() {
        Array<Square> valid = new Array<>();
        String thisName = this.square.getName();

        String n1 = "", n2 = "";
        try {
            n1 = Main.nums[Integer.parseInt("" + thisName.charAt(1)) + dir - 1];
        } catch (IndexOutOfBoundsException ignored) {}
        try {
            n2 = Main.nums[Integer.parseInt("" + thisName.charAt(1)) + 2*dir - 1];
        } catch (IndexOutOfBoundsException ignored) {}

        Square s1 = Helper.getSquare(thisName.charAt(0) + n1);
        Square s2 = Helper.getSquare(thisName.charAt(0) + n2);
        if (s1 != null && !s1.hasPiece()) {
            valid.add(s1);
            if (numMoves == 0 && s2 != null && !s2.hasPiece()) {
                valid.add(s2);
            }
        }

        String l1 = "", l2 = "";
        try {
            l1 = Main.lets[Helper.indexOf(Main.lets, "" + thisName.charAt(0)) + 1];
        } catch (IndexOutOfBoundsException ignored) {}
        try {
            l2 = Main.lets[Helper.indexOf(Main.lets, "" + thisName.charAt(0)) - 1];
        } catch (IndexOutOfBoundsException ignored) {}
        Square s3 = Helper.getSquare(l1 + n1);
        Square s4 = Helper.getSquare(l2 + n1);
        if (s3 != null && s3.hasPiece() && s3.piece.color != this.color) {
            valid.add(s3);
        }
        if (s4 != null && s4.hasPiece() && s4.piece.color != this.color) {
            valid.add(s4);
        }

        return valid;
    }
}
