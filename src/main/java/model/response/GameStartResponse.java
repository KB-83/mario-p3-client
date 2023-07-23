package model.response;

import controller.connection.ResponseVisitor;
import model.dto.game.GameStateDTO;

public class GameStartResponse extends Response{
    private GameStateDTO gameStateDTO;
    public GameStartResponse() {
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
}
