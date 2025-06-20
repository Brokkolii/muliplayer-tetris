package dev.girnghuber.dto;

import dev.girnghuber.game.Cell;

public class CellDto {
    private final int row;
    private final int column;
    private String piece;

    public CellDto(Cell cell, int y, int x) {
        if (!cell.isEmpty()) {
            this.piece = cell.getType().toString();
        }
        this.row = y + 1;
        this.column = x + 1;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public String getPiece() {
        return piece;
    }
}
