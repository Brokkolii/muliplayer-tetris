package dev.girnghuber.game.pieces;

import dev.girnghuber.enums.PieceType;
import dev.girnghuber.enums.Rotation;

public class IPiece extends Piece {
    public IPiece() {
        this.y = 20;
        this.x = 3;
        this.rotation = Rotation.DEG_0;
    }

    @Override
    public PieceType getType() {
        return PieceType.I;
    }

    @Override
    public int[][] getCellCoords() {
        int[] cell1 = {y, x};
        int[] cell2 = {y, x + 1};
        int[] cell3 = {y, x + 2};
        int[] cell4 = {y, x + 3};
        return new int[][]{cell1, cell2, cell3, cell4};
    }
}
