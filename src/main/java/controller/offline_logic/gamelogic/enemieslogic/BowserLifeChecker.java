package controller.offline_logic.gamelogic.enemieslogic;

import controller.offline_logic.gamestrucure.GameState;
import controller.offline_logic.modelstructure.entity.enemy.Bowser;
import controller.offline_logic.tools.ObjectRemover;

public class BowserLifeChecker extends EnemyLifeChecker{
    private GameState gameState;
    private Bowser bowser;

    public BowserLifeChecker(GameState gameState, Bowser bowser) {
        this.gameState = gameState;
        this.bowser = bowser;
    }


    @Override
    public void kickedBybullet() {

    }

    @Override
    public void kickedBySward() {
        kill();
    }

    @Override
    public void kill() {
        gameState.getCurrentSection().setEnemies(ObjectRemover.removeObjectFromArray(gameState.getCurrentSection().getEnemies(), bowser));
    }

    @Override
    public void heatByHead() {

    }
}
