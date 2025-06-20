package dev.girnghuber.services;

import dev.girnghuber.enums.CellType;
import dev.girnghuber.enums.PieceType;
import dev.girnghuber.game.Board;
import dev.girnghuber.game.Cell;
import dev.girnghuber.game.pieces.*;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BoardService {
    public void nextTick(Board board) {
        if (!board.hasFallingPiece()) {
            spawnNewPiece(board);
        } else {
            if (fallingPieceCanMoveDown(board)) {
                moveDownFallingPiece(board);
            } else {
                lockFallingPiece(board);
            }

        }
    }

    private void spawnNewPiece(Board board) {
        PieceType nextPieceType = board.getNextPieceType();
        switch (nextPieceType) {
            case I:
                board.setFallingPiece(new IPiece());
            case O:
                board.setFallingPiece(new OPiece());
            case J:
                board.setFallingPiece(new JPiece());
            case L:
                board.setFallingPiece(new LPiece());
            case S:
                board.setFallingPiece(new SPiece());
            case Z:
                board.setFallingPiece(new ZPiece());
            case T:
                board.setFallingPiece(new TPiece());
        }
    }

    private boolean fallingPieceCanMoveDown(Board board) {
        Piece fallingPiece = board.getFallingPiece();
        int[][] cellCoords = fallingPiece.getCellCoords();
        for (int[] cellCoord : cellCoords) {
            int y = cellCoord[0] - 1;
            int x = cellCoord[1];
            Cell cell = board.getCell(y, x);
            if (!cell.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private void moveDownFallingPiece(Board board) {
        board.getFallingPiece().moveDown();
    }

    private void lockFallingPiece(Board board) {
        Piece fallingPiece = board.getFallingPiece();
        int[][] cellCoords = fallingPiece.getCellCoords();
        for (int[] coords : cellCoords) {
            int y = coords[0] - 1;
            int x = coords[1];
            Cell cell = board.getCell(y, x);
            CellType cellType = CellType.valueOf(fallingPiece.getType().name());
            cell.setType(cellType);
        }
    }
}
