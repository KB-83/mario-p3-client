package controller.offline_logic.gamelogic.enemieslogic;

import controller.offline_logic.gamestrucure.GameState;
import controller.offline_logic.modelstructure.entity.enemy.Spiny;
import controller.offline_logic.tools.ObjectRemover;
import util.Sound;

public class SpinyLifeChecker extends EnemyLifeChecker{
    private GameState gameState;
    private Spiny spiny;
    private Sound sound = new Sound("KICK");

    public SpinyLifeChecker(GameState gameState, Spiny spiny) {
        this.gameState = gameState;
        this.spiny = spiny;
    }

    @Override
    public void kickedBybullet() {
        kill();
    }

    @Override
    public void kickedBySward() {
        kill();
    }

    @Override
    public void kill() {
        sound.setSound("KICK");
        sound.play();
        gameState.getCurrentSection().setEnemies(ObjectRemover.removeObjectFromArray(gameState.getCurrentSection().getEnemies(), spiny));
    }

    @Override
    public void heatByHead() {

    }
}
