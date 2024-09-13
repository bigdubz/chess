package com.mygdx.chess;

import com.mygdx.chess.piece.*;

public class Helper {

    /*
        números de los tipos:
            0 - peón
            1 - caballo
            2 - alfil
            3 - torre
            4 - reina
            5 - rey

        números de los colores:
            0 - blanco
            1 - negro
     */

    public static ChessPiece createPiece(Main main, int type, int color, Square square) {
        switch (type) {
            case 1:
                return new Knight(main, color, square);
            case 2:
                return new Bishop(main, color, square);
            case 3:
                return new Rook(main, color, square);
            case 4:
                return new Queen(main, color, square);
            case 5:
                return new King(main, color, square);
            default:
                return new Pawn(main, color, square);
        }
    }

    public static Square getSquare(int mx, int my) {
        for (Square sq : Main.squares) {
            if (sq.checkInside(mx, my))
                return sq;
        }
        return null;
    }
}
