package dev.girnghuber.game.pieces;

import dev.girnghuber.enums.PieceType;
import dev.girnghuber.enums.Rotation;

public class TPiece extends Piece {
    public TPiece() {
        this.y = 21;
        this.x = 3;
        this.rotation = Rotation.DEG_0;
    }

    @Override
    public PieceType getType() {
        return PieceType.T;
    }

    @Override
    public int[][] getCellCoords() {
        int[] cell1 = {y, x};
        int[] cell2 = {y, x + 1};
        int[] cell3 = {y, x + 2};
        int[] cell4 = {y - 1, x + 1};
        return new int[][]{ cell1, cell2, cell3, cell4 };
    }
}