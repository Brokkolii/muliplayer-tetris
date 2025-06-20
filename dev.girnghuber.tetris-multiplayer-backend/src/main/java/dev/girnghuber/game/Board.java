package dev.girnghuber.game;

import dev.girnghuber.enums.CellType;
import dev.girnghuber.enums.PieceType;
import dev.girnghuber.game.pieces.Piece;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

public class Board {
    public static final int WIDTH = 10;
    public static final int HEIGHT = 24;

    private final Cell[][] cells;
    private Piece fallingPiece;
    private PieceType nextPieceType;

    public Board() {
        this.cells = new Cell[HEIGHT][WIDTH];


        // initialize empty board
        for(int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                cells[y][x] = Cell.empty();
            }
        }

        nextPieceType = PieceType.getRandom();
    }

    public Cell[][] getCells() {
        return this.cells;
    }

    public Cell getCell(int y, int x) {
        return this.cells[y][x];
    }

    public void setCellType(CellType type, int y, int x) {
        this.cells[y][x].setType(type);
    }

    public void clearCell(int y, int x)  {
        this.cells[y][x].setEmpty();
    }

    private Stream<Cell> streamAllCells() {
        return Arrays.stream(cells).flatMap(Arrays::stream);
    }

    public void setFallingPiece(Piece piece) {
        this.fallingPiece = piece;
    }

    public boolean hasFallingPiece() {
        return !Objects.isNull(fallingPiece);
    }

    public PieceType getNextPieceType() {
        PieceType nextPieceType = this.nextPieceType;
        this.nextPieceType = PieceType.getRandom();
        return nextPieceType;
    }

    public Piece getFallingPiece() {
        return this.fallingPiece;
    }
}
