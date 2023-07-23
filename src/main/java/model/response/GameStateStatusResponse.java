package model.response;

import controller.connection.ResponseVisitor;
import model.dto.entity.player.PlayerDTO;
import model.dto.game.GameStateDTO;

public class GameStateStatusResponse extends Response{
    private GameStateDTO gameStateDTO;
    private PlayerDTO playerDTO;

    public GameStateStatusResponse() {
    }

    @Override
    public void visit(ResponseVisitor responseVisitor) {
        responseVisitor.visit(this);
    }

    public GameStateDTO getGameStateDTO() {
        return gameStateDTO;
    }

    public void setGameStateDTO(GameStateDTO gameStateDTO) {
        this.gameStateDTO = gameStateDTO;
    }

    public PlayerDTO getPlayerDTO() {
        return playerDTO;
    }

    public void setPlayerDTO(PlayerDTO playerDTO) {
        this.playerDTO = playerDTO;
    }
}
