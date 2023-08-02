package controller.offline_logic.gamelogic.gravitylogic;

import controller.offline_logic.gamestrucure.GameState;
import controller.offline_logic.gamestrucure.gameworldoption.Gravity;
import util.Constant;

public class GravityEffectsHandler {
    private GameState gameState;

    public GravityEffectsHandler(GameState gameState) {
        this.gameState = gameState;
    }
    public void applyEffects() {
        if (gameState.getMario().isDuringJump() == false && gameState.getMario().getOnTopOfBlock() == false) {
            gameState.getMario().setVY(gameState.getMario().getVY()+ (-Gravity.MARIO_GAME*1/ Constant.FPS));
//
        }
    }
}
