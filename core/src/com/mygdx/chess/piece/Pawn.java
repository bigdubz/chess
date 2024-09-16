package com.mygdx.chess.piece;

import com.mygdx.chess.Helper;
import com.mygdx.chess.Main;
import com.mygdx.chess.Square;

public class Pawn extends ChessPiece {

    public Pawn(Main main, int color, Square square) {
        super(main, color, color == 0 ? "wp" : "bp", square);
    }

    @Override
    protected void move(String square) {

    }

    // TODO: yo realmente odio esto. necesito buscar otra manera para hecerlo
    // otra manera puede ser creando una red 2D para los quadrados, pero lo haré más tarde
    @Override
    public void drawValidMoves() {
        String name = square.getName();
        int dir = color == 0 ? 1 : -1;
        int number = Integer.parseInt("" + name.charAt(1)) + dir;
        String newName = name.charAt(0) + (number + "");
        Square nextSquare = Helper.getSquare(newName);
        if (nextSquare != null) {
            nextSquare.drawAsValidMove();
        }
        if (numMoves == 0) {
            number = Integer.parseInt("" + name.charAt(1)) + 2*dir;
            newName = name.charAt(0) + (number + "");
            nextSquare = Helper.getSquare(newName);
            if (nextSquare != null) {
                nextSquare.drawAsValidMove();
            }
        }
    }
}
