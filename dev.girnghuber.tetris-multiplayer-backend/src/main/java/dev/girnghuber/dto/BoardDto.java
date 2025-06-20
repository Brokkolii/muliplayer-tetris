package dev.girnghuber.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import dev.girnghuber.game.Board;
import dev.girnghuber.game.Cell;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class BoardDto {
    public String player;
    public CellDto[][] cells;

    public BoardDto(){}

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
