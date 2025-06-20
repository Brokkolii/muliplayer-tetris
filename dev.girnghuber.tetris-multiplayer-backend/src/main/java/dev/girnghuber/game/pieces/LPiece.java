package dev.girnghuber.game.pieces;

import dev.girnghuber.enums.PieceType;
import dev.girnghuber.enums.Rotation;

public class LPiece extends Piece {
    public LPiece() {
        this.y = 22;
        this.x = 5;
        this.rotation = Rotation.DEG_0;
    }

    @Override
    public PieceType getType() {
        return PieceType.L;
    }

    @Override
    public int[][] getCellCoords() {
        int[] cell1 = {y, x};
        int[] cell2 = {y - 1, x };
        int[] cell3 = {y - 2, x };
        int[] cell4 = {y - 2, x + 1};
        return new int[][]{ cell1, cell2, cell3, cell4 };
    }
}