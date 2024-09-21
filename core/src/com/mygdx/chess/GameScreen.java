package com.mygdx.chess;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class GameScreen implements Screen {

    private final Main main;
    private final ScreenViewport viewport;
    private final Stage stage;
    private Square selectedSq;



    public GameScreen(Main main) {
        this.main = main;
        this.viewport = new ScreenViewport();
        this.stage = new Stage();
    }

    private void makeSquares() {
        Color[] color = new Color[]{Helper.c1, Helper.c2};
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Main.squares.add(
                        new Square(main, color[(j + i)%2], Main.startc + j*Main.squareSize,
                                Main.startc + i*Main.squareSize, Main.squareSize)
                );
            }
        }
    }

    private void addPieces() {
        for (Square square : Main.squares) {
            String sq = square.getName();
            int type = 0;
            int color = sq.charAt(1) == '8' || sq.charAt(1) == '7' ? 1 : 0;

            if (sq.charAt(1) != '2' && sq.charAt(1) != '7') {
                if (sq.charAt(0) == 'A' || sq.charAt(0) == 'H') {
                    type = 3;
                } else if (sq.charAt(0) == 'B' || sq.charAt(0) == 'G') {
                    type = 1;
                } else if (sq.charAt(0) == 'C' || sq.charAt(0) == 'F') {
                    type = 2;
                } else if (sq.charAt(0) == 'D') {
                    type = 4;
                } else if (sq.charAt(0) == 'E') {
                    type = 5;
                }
            }

            if (sq.charAt(1) == '1' || sq.charAt(1) == '2' || sq.charAt(1) == '7' || sq.charAt(1) == '8') {
                square.setPiece(Helper.createPiece(main, type, color, square));
            }
        }
    }

    @Override
    public void show() {
        this.makeSquares();
        this.addPieces();
    }

    @Override
    public void render(float delta) {
        Square mouseSq = Helper.getSquare(Gdx.input.getX(), main.getSize() - Gdx.input.getY());

        // dibuja todas
        main.getSr().setProjectionMatrix(viewport.getCamera().combined);
        viewport.apply(true);
        main.getSr().begin(ShapeRenderer.ShapeType.Filled);

        for (Square sq : Main.squares) {
            sq.draw();
        }

        if (selectedSq != null && selectedSq.hasPiece()) {
            if (selectedSq.color == Helper.c1) {
                main.getSr().setColor(Helper.c6);
            } else {
                main.getSr().setColor(Helper.c5);
            }
            main.getSr().rect(selectedSq.x, selectedSq.y, selectedSq.width, selectedSq.height);
        }

        if (mouseSq != null) {
            if (Gdx.input.isButtonJustPressed(0)) {
                if (selectedSq != null && selectedSq.hasPiece()) {
                    if (!selectedSq.piece.getValidSquares().contains(mouseSq, true)) {
                        selectedSq = mouseSq;
                    }
                } else {
                    selectedSq = mouseSq;
                }
            }
        }

        // Hacer un movimiento
        if (mouseSq != null && selectedSq != null && selectedSq.hasPiece() && selectedSq.piece.checkTurn()) {
            selectedSq.drawPieceValidMoves();
            if (selectedSq.hasPiece() && selectedSq.piece.getValidSquares().contains(mouseSq, true) &&
                    Gdx.input.isButtonJustPressed(0)) {
                main.turn = (main.turn + 1)%2;
                selectedSq.piece.move(mouseSq);
            }
        }
        main.getSr().end();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        this.stage.dispose();
    }

    public Stage getStage() {
        return this.stage;
    }
}
