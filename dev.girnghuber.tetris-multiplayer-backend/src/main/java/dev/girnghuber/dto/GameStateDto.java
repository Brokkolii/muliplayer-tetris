package dev.girnghuber.dto;

import dev.girnghuber.game.GameState;

import java.util.ArrayList;
import java.util.List;

public class GameStateDto {
    public final String gameId;
    public final List<BoardDto> boards = new ArrayList<>();

    public GameStateDto(){
        this.gameId = "-";
    }

    public GameStateDto(GameState gameState) {
        this.gameId = gameState.getId();

        gameState.getBoards().forEach((key, value) -> {
            BoardDto boardDto = new BoardDto(value, key);
            this.boards.add(boardDto);
        });
    }
}
