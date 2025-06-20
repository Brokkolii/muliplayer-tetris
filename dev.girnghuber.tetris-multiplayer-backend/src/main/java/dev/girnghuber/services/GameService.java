package dev.girnghuber.services;

import dev.girnghuber.game.GameState;
import io.quarkus.runtime.Startup;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@ApplicationScoped
@Startup
public class GameService {
    private final Map<String, GameState> games = new ConcurrentHashMap<>();

    public GameState createGame(String playerName) {
        String gameId = UUID.randomUUID().toString();
        GameState game = new GameState(gameId);
        game.addPlayer(playerName);
        games.put(gameId, game);
        return game;
    }

    public GameState getGame(String id) {
        return this.games.get(id);
    }
}
