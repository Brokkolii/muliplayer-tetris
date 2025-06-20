package dev.girnghuber.resource;

import dev.girnghuber.dto.GameStateDto;
import dev.girnghuber.game.GameState;
import dev.girnghuber.services.GameService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Objects;

@Path("/api/game")
public class GameResource {

    @Inject
    GameService gameService;

    @POST
    @Path("/create")
    @Produces(MediaType.TEXT_PLAIN)
    public Response createGame() {
        String playerName = "Brokkolii"; // TODO: get from auth or something
        GameState game = gameService.createGame(playerName);
        return Response.ok(game.getId()).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGame(@PathParam("id") String id) {
        GameState game = gameService.getGame(id);
        if (Objects.isNull(game)) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        GameStateDto gameDto = new GameStateDto(game);
        return Response.ok(gameDto).build();
    }
}
