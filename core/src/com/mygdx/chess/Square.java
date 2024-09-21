package com.mygdx.chess;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.chess.piece.ChessPiece;

public class Square extends Rectangle {

    Main main;
    public ChessPiece piece;
    public Color color;

    public Square(Main main, Color color, float x, float y, float s) {
        this.main = main;
        this.color = color;
        setSize(s, s);
        setPosition(x, y);
    }

    public boolean checkInside(int mx, int my) {
        Main.mouse.set(mx, my, 1, 1);
        return this.overlaps(Main.mouse);
    }

    public void drawMouseOver() {
        main.getSr().setColor(0.8f, 0.8f, 0.706f, 1);
        main.getSr().rect(getX(), getY(), getWidth(), getHeight());
    }

    public void draw() {
        main.getSr().setColor(color);
        main.getSr().rect(getX(), getY(), getWidth(), getHeight());
    }

    public void drawPieceValidMoves() {
        if (piece != null) {
            piece.drawValidSquares(piece.getValidSquares());
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

    public void clearPiece() {
        this.piece = null;
    }

    public boolean hasPiece() {
        return this.piece != null;
    }
}
