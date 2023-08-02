package controller.offline_logic.gamelogic.gamestatelogic;

import controller.offline_logic.gamelogic.collisionlogic.PlayerCollisionHandler;
import controller.offline_logic.gamelogic.playerlogic.PlayerLifeChecker;
import controller.offline_logic.gamelogic.playerlogic.PlayerMovementHandler;
import controller.offline_logic.gamestrucure.GameState;

public class PlayerController {
    private PlayerMovementHandler playerMovementHandler;
    private PlayerLifeChecker playerLifeChecker;
    private PlayerCollisionHandler playerCollisionHandler;

    public PlayerController(GameState gameState) {
        playerMovementHandler = new PlayerMovementHandler(gameState);
        playerLifeChecker = new PlayerLifeChecker(gameState);
        playerCollisionHandler = new PlayerCollisionHandler(gameState,playerLifeChecker);
    }
    public void update(){
        playerCollisionHandler.applyCollisionEffects();
        playerMovementHandler.updatePlayerPosition();
        playerLifeChecker.checkIfHurt();
    }


    public PlayerMovementHandler getPlayerMovementHandler() {
        return playerMovementHandler;
    }

    public void setPlayerMovementHandler(PlayerMovementHandler playerMovementHandler) {
        this.playerMovementHandler = playerMovementHandler;
    }

    public PlayerLifeChecker getPlayerLifeChecker() {
        return playerLifeChecker;
    }

    public void setPlayerLifeChecker(PlayerLifeChecker playerLifeChecker) {
        this.playerLifeChecker = playerLifeChecker;
    }

    public PlayerCollisionHandler getPlayerCollisionHandler() {
        return playerCollisionHandler;
    }

    public void setPlayerCollisionHandler(PlayerCollisionHandler playerCollisionHandler) {
        this.playerCollisionHandler = playerCollisionHandler;
    }
}
