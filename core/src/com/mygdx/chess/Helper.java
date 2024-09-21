package com.mygdx.chess;

import com.badlogic.gdx.graphics.Color;
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
    public static Color c1 = new Color(0.46f, 0.59f, 0.34f, 1);
    public static Color c2 = new Color(0.93f, 0.93f, 0.82f, 1);
    public static Color c3 = new Color(0.4f, 0.51f, 0.29f, 1);
    public static Color c4 = new Color(0.8f, 0.8f, 0.71f, 1);
    public static Color c5 = new Color(0.97f, 0.97f, 0.41f, 1);
    public static Color c6 = new Color(0.73f, 0.8f, 0.17f, 1);

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

    public static Square getSquare(String name) {
        for (Square sq : Main.squares) {
            if (sq.getName().equals(name)) {
                return sq;
            }
        }
        return null;
    }

    public static int indexOf(String[] letters, String target) {
        for (int index = 0; index < letters.length; index++) {
            if (letters[index].equals(target)) {
                return index;
            }
        }
        return -1;
    }
}
