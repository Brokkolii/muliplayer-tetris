package dev.girnghuber.dto;

import dev.girnghuber.game.Cell;

public class CellDto {
    public int row;
    public int column;
    public String piece;

    public CellDto(){}

    public CellDto(Cell cell, int y, int x) {
        if (!cell.isEmpty()) {
            this.piece = cell.getType().toString();
        }
        this.row = y + 1;
        this.column = x + 1;
    }
}
