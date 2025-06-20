package dev.girnghuber.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import dev.girnghuber.game.Cell;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
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
