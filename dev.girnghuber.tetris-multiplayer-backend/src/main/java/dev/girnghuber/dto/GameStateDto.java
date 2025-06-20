package dev.girnghuber.dto;

import dev.girnghuber.game.GameState;

import java.util.ArrayList;
import java.util.List;

public class GameStateDto {
    private final String gameId;
    private final List<BoardDto> boards = new ArrayList<>();

    public GameStateDto(GameState gameState) {
        this.gameId = gameState.getId();

        gameState.getBoards().forEach((key, value) -> {
            BoardDto boardDto = new BoardDto(value, key);
            this.boards.add(boardDto);
        });
    }

    public String getGameId() {
        return gameId;
    }

    public List<BoardDto> getBoards() {
        return boards;
    }
}
