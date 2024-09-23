package com.mygdx.chess.piece;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;
import com.mygdx.chess.GameScreen;
import com.mygdx.chess.Main;
import com.mygdx.chess.Square;
import com.mygdx.chess.Helper;

public abstract class ChessPiece extends Actor {


    private final Sprite sprite;
    protected final int color;
    protected final int dir;
    int numMoves;
    Square square;
    Main main;

    public ChessPiece(Main main, int color, String image, Square square) {
        ((GameScreen)main.getScreen()).getStage().addActor(this);
        this.main = main;
        this.color = color;
        this.dir = this.color == 0 ? 1 : -1;
        this.sprite = new Sprite(new Texture(Gdx.files.internal(image + ".png")));
        this.square = square;
        this.setPosition(this.square);
    }

    @Override
    public void draw(Batch batch, float delta) {
        sprite.draw(batch);
    }

    public void move(Square square) {
        if (square.hasPiece()) {
            square.piece.remove();
        }
        numMoves++;
        this.square.clearPiece();
        this.square = square;
        this.square.setPiece(this);
        this.setPosition(this.square);
    }

    public void setSquare(Square square) {
        this.square = square;
        this.square.setPiece(this);
        this.setPosition(this.square);
    }

    public void drawValidSquares(Array<Square> valid) {
        if (valid == null) return;
        for (Square sq : valid) {
            if (sq.hasPiece()) {
                main.getSr().setColor(0.85f, 0.32f, 0.13f, 1);
                main.getSr().rect(sq.x, sq.y, sq.width, sq.height);
            }
            else {
                if (sq.color == Helper.c1) {
                    main.getSr().setColor(Helper.c3);
                } else {
                    main.getSr().setColor(Helper.c4);
                }
                main.getSr().circle(sq.x + sq.width*0.5f, sq.y + sq.height*0.5f, 20);
            }
        }
    }

    public abstract Array<Square> getValidSquares();

    protected Array<Square> getRookValidSquares() {
        Array<Square> valid = new Array<>();
        String thisName = this.square.getName();

        int col = Integer.parseInt("" + thisName.charAt(1)) - 1;
        int row = Helper.indexOf(Main.lets, "" + thisName.charAt(0));
        Square sq;

        for (int i = 1; i < 8 - col; i++) {
            sq = Helper.getSquare(Main.lets[row]+Main.nums[col+i]);
            if (sq != null && sq.hasPiece()) {
                if (sq.piece.color != color) {
                    valid.add(sq);
                }
                break;
            }
            if (sq != null)
                valid.add(sq);
        }
        for (int i = 1; i <= col; i++) {
            sq = Helper.getSquare(Main.lets[row]+Main.nums[col-i]);
            if (sq != null && sq.hasPiece()) {
                if (sq.piece.color != color) {
                    valid.add(sq);
                }
                break;
            }
            if (sq != null)
                valid.add(sq);
        }
        for (int i = 1; i < 8 - row; i++) {
            sq = Helper.getSquare(Main.lets[row+i]+Main.nums[col]);
            if (sq != null && sq.hasPiece()) {
                if (sq.piece.color != color) {
                    valid.add(sq);
                }
                break;
            }
            if (sq != null)
                valid.add(sq);
        }
        for (int i = 1; i <= row; i++) {
            sq = Helper.getSquare(Main.lets[row-i]+Main.nums[col]);
            if (sq != null && sq.hasPiece()) {
                if (sq.piece.color != color) {
                    valid.add(sq);
                }
                break;
            }
            if (sq != null)
                valid.add(sq);
        }

        return valid;
    }

    protected Array<Square> getBishopValidSquares() {
        Array<Square> valid = new Array<>();
        String thisName = this.square.getName();
        int col = Integer.parseInt("" + thisName.charAt(1)) - 1;
        int row = Helper.indexOf(Main.lets, "" + thisName.charAt(0));
        Square sq;

        for (int i = 1; i < 8; i++) {
            if (row + i > 7 || col + i > 7) {
                break;
            }
            sq = Helper.getSquare(Main.lets[row+i]+Main.nums[col+i]);
            if (sq != null && sq.hasPiece()) {
                if (sq.piece.color != color) {
                    valid.add(sq);
                }
                break;
            }
            if (sq != null)
                valid.add(sq);
        }
        for (int i = 1; i < 8; i++) {
            if (row - i < 0 || col + i > 7) {
                break;
            }
            sq = Helper.getSquare(Main.lets[row-i]+Main.nums[col+i]);
            if (sq != null && sq.hasPiece()) {
                if (sq.piece.color != color) {
                    valid.add(sq);
                }
                break;
            }
            if (sq != null)
                valid.add(sq);
        }
        for (int i = 1; i < 8; i++) {
            if (row + i > 7 || col - i < 0) {
                break;
            }
            sq = Helper.getSquare(Main.lets[row+i]+Main.nums[col-i]);
            if (sq != null && sq.hasPiece()) {
                if (sq.piece.color != color) {
                    valid.add(sq);
                }
                break;
            }
            if (sq != null)
                valid.add(sq);
        }
        for (int i = 1; i < 8; i++) {
            if (row - i < 0 || col - i < 0) {
                break;
            }
            sq = Helper.getSquare(Main.lets[row-i]+Main.nums[col-i]);
            if (sq != null && sq.hasPiece()) {
                if (sq.piece.color != color) {
                    valid.add(sq);
                }
                break;
            }
            if (sq != null)
                valid.add(sq);
        }

        return valid;
    }

    public void followCursor(int x, int y) {
        this.sprite.setCenter(x, y);
    }

    public void setPosition(Square square) {
        this.setPosition(square.x, square.y);
        this.sprite.setCenter(square.x + square.width*0.5f, square.y + square.height*0.5f);
    }

    public boolean checkTurn() {
        return main.turn == color;
    }
}
