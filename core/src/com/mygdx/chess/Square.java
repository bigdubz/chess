package com.mygdx.chess;

import com.badlogic.gdx.math.Rectangle;

public class Square extends Rectangle {

    Main main;

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
        main.getSr().rect(getX(), getY(), getWidth(), getHeight());
    }

    public String getSquare() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                String sq = Main.lets[j] + Main.nums[7-i];
                if (Main.startc + j*Main.squareSize == getX() && Main.startc + i*Main.squareSize == getY()) {
                    return sq;
                }
            }
        }
        return "smd";
    }
}
