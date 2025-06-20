package dev.girnghuber.game.pieces;

import dev.girnghuber.enums.PieceType;
import dev.girnghuber.enums.Rotation;

public abstract class Piece {
    protected int x;
    protected int y;
    protected Rotation rotation;

    public abstract PieceType getType();

    // TODO: implement rotation for each child
    public abstract int[][] getCellCoords();

    public void moveDown() {
        this.y--;
    }

    public void moveLeft() {
        this.x--;
    }

    public void moveRight() {
        this.x++;
    }
}
