package dev.girnghuber.game;

import dev.girnghuber.enums.CellType;

public class Cell {
    private CellType type;

    // Constructor
    public Cell(CellType type) {
        this.type = type;
    }

    public static Cell empty() {
        return new Cell(CellType.EMPTY);
    }

    public CellType getType() {
        return this.type;
    }

    public boolean isEmpty() {
        return this.type == CellType.EMPTY;
    }

    public void setType(CellType type) {
        this.type = type;
    }

    public void setEmpty() {
        this.type = CellType.EMPTY;
    }
}
