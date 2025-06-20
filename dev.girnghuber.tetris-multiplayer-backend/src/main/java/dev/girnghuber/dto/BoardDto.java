package dev.girnghuber.dto;

import dev.girnghuber.game.Board;
import dev.girnghuber.game.Cell;

public class BoardDto {
    private final String player;
    private final CellDto[][] cells;

    public BoardDto(Board board, String playerName) {
        this.player = playerName;
        Cell[][] boardCells = board.getCells();
        this.cells = new CellDto[boardCells.length][boardCells[0].length];

        for (int i = 0; i < boardCells.length; i++) {
            for (int j = 0; j < boardCells[i].length; j++) {
                CellDto cellDto = new CellDto(boardCells[i][j], j, i);
                cells[i][j] = cellDto;
            }
        }
    }

    public String getPlayer() {
        return player;
    }

    public CellDto[][] getCells() {
        return cells;
    }
}
