package dev.girnghuber.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import dev.girnghuber.game.GameState;

import java.util.ArrayList;
import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class GameStateDto {
    public String gameId;
    public List<BoardDto> boards = new ArrayList<>();

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

    public String getGameId() {
        return gameId;
    }

    public List<BoardDto> getBoards() {
        return boards;
    }
}
