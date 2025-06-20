package dev.girnghuber.game.pieces;

import dev.girnghuber.enums.PieceType;
import dev.girnghuber.enums.Rotation;

public class JPiece extends Piece {
    public JPiece() {
        this.y = 22;
        this.x = 5;
        this.rotation = Rotation.DEG_0;
    }

    @Override
    public PieceType getType() {
        return PieceType.J;
    }

    @Override
    public int[][] getCellCoords() {
        int[] cell1 = {y, x + 1};
        int[] cell2 = {y - 1, x + 1 };
        int[] cell3 = {y - 2, x };
        int[] cell4 = {y - 2, x + 1};
        return new int[][]{ cell1, cell2, cell3, cell4 };
    }
}