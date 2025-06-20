package dev.girnghuber.game;

import dev.girnghuber.enums.GameStatus;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GameState {
    private final String gameId;
    private final Map<String, Board> boards = new ConcurrentHashMap<>();
    private GameStatus status;

    public GameState(String gameId) {
        this.gameId = gameId;
        this.status = GameStatus.CREATED;
    }

    public String getId() {
        return this.gameId;
    }

    public Map<String, Board> getBoards() {
        return  this.boards;
    }

    public void addPlayer(String playerName) {
        if (status == GameStatus.CREATED) {
            Board board = new Board();
            this.boards.put(playerName, board);
        } else {
            throw new IllegalStateException("Can only add players before game has started!");
        }
    }

    public void start() {
        if (status == GameStatus.CREATED) {
            status = GameStatus.STARTED;
        } else {
            throw new IllegalStateException("Game has already started!");
        }
    }

}
