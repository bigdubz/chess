package com.mygdx.chess;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.chess.piece.ChessPiece;

public class Square extends Rectangle {

    Main main;
    ChessPiece piece;

    public Square(Main main, float x, float y, float s) {
        this.main = main;
        setSize(s, s);
        setPosition(x, y);
    }

    public boolean checkInside(int mx, int my) {
        Main.mouse.set(mx, my, 1, 1);
        return this.overlaps(Main.mouse);
    }

    // TEMPORARIO
    public void draw() {
        main.getSr().setColor(0.4f, 0.4f, 0.4f, 1);
        main.getSr().rect(getX(), getY(), getWidth(), getHeight());
    }

    public void drawPieceValidMoves() {
        if (piece != null) {
            piece.drawValidMoves();
        }
    }

    public String getName() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                String sq = Main.lets[j] + Main.nums[i];
                if (Main.startc + j*Main.squareSize == getX() && Main.startc + i*Main.squareSize == getY()) {
                    return sq;
                }
            }
        }
        return "smd";
    }

    public void setPiece(ChessPiece piece) {
        this.piece = piece;
    }

    public void drawAsValidMove() {
        main.getSr().setColor(0.4f, 0.4f, 0.4f, 1);
        main.getSr().circle(getX() + getWidth()*0.5f, getY() + getHeight()*0.5f, 20);
    }

    public void clearPiece() {
        this.piece = null;
    }

    public boolean hasPiece() {
        return this.piece != null;
    }
}
