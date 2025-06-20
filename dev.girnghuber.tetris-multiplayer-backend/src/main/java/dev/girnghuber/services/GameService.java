package dev.girnghuber.services;

import dev.girnghuber.game.Board;
import dev.girnghuber.game.GameState;
import io.quarkus.runtime.Startup;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@ApplicationScoped
@Startup
public class GameService {
    private final Map<String, GameState> games = new ConcurrentHashMap<>();
    private final Map<String, ScheduledExecutorService> gameTickExecuters = new ConcurrentHashMap<>();

    @Inject BoardService boardService;

    public GameState createGame(String playerName) {
        String gameId = UUID.randomUUID().toString();
        GameState game = new GameState(gameId);
        game.addPlayer(playerName);
        games.put(gameId, game);
        return game;
    }

    public void startGame(String id) {
        GameState game = getGame(id);
        game.start();
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        gameTickExecuters.put(game.getId(), executor);
        executor.scheduleAtFixedRate(() -> {
            nextGameTick(game);
        }, 0, 100, TimeUnit.MILLISECONDS);
    }

    public void stopGame(String id) {
        ScheduledExecutorService executor = gameTickExecuters.get(id);
        executor.shutdownNow();
    }

    public void nextGameTick(GameState game) {
        Collection<Board> boards = game.getBoards().values();
        boards.forEach(boardService::nextTick);
    }

    public GameState getGame(String id) {
        return this.games.get(id);
    }
}
