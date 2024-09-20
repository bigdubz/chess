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
        Color[] color = new Color[]{new Color(0.46f, 0.59f, 0.34f, 1),
                new Color(0.93f, 0.93f, 0.82f, 1)};
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Main.squares.add(
                        new Square(main, color[(j+i)%2], Main.startc + j*Main.squareSize,
                                Main.startc + i*Main.squareSize, Main.squareSize)
                );
            }
        }
    }

    private void addPieces() {
        for (Square square : Main.squares) {
            String sq = square.getName();
            if (sq.contains("2")) {
                square.setPiece(
                        Helper.createPiece(main, 0, 0, square)
                );
            } else if (sq.equals("A1") || sq.equals("H1")) {
                square.setPiece(
                        Helper.createPiece(main, 3, 0, square)
                );
            } else if (sq.equals("B1") || sq.equals("G1")) {
                square.setPiece(
                        Helper.createPiece(main, 1, 0, square)
                );
            } else if (sq.equals("C1") || sq.equals("F1")) {
                square.setPiece(
                        Helper.createPiece(main, 2, 0, square)
                );
            } else if (sq.equals("D1")) {
                square.setPiece(
                        Helper.createPiece(main, 4, 0, square)
                );
            } else if (sq.equals("E1")) {
                square.setPiece(
                        Helper.createPiece(main, 5, 0, square)
                );
            } else if (sq.contains("7")) {
                square.setPiece(
                        Helper.createPiece(main, 0, 1, square)
                );
            } else if (sq.equals("A8") || sq.equals("H8")) {
                square.setPiece(
                        Helper.createPiece(main, 3, 1, square)
                );
            } else if (sq.equals("B8") || sq.equals("G8")) {
                square.setPiece(
                        Helper.createPiece(main, 1, 1, square)
                );
            } else if (sq.equals("C8") || sq.equals("F8")) {
                square.setPiece(
                        Helper.createPiece(main, 2, 1, square)
                );
            } else if (sq.equals("D8")) {
                square.setPiece(
                        Helper.createPiece(main, 4, 1, square)
                );
            } else if (sq.equals("E8")) {
                square.setPiece(
                        Helper.createPiece(main, 5, 1, square)
                );
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
        main.getSr().setColor(1, 1, 1, 1);

        for (Square sq : Main.squares) {
            sq.draw();
        }

        for (int i = 0; i < 9; i++) {
            main.getSr().line(Main.startc + i*Main.squareSize, Main.startc,
                    Main.startc + i*Main.squareSize, Main.endc);
            main.getSr().line(Main.startc, Main.startc + i*Main.squareSize,
                    Main.endc, Main.startc + i*Main.squareSize);
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
