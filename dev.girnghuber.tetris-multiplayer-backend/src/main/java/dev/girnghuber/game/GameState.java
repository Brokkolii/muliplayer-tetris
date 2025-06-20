package dev.girnghuber.game;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GameState {
    private final String gameId;
    private final Map<String, Board> boards = new ConcurrentHashMap<>();

    public GameState(String gameId) {
        this.gameId = gameId;
    }

    public String getId() {
        return this.gameId;
    }

    public Map<String, Board> getBoards() {
        return  this.boards;
    }

    public void addPlayer(String playerName) {
        Board board = new Board();
        this.boards.put(playerName, board);
    }

}
