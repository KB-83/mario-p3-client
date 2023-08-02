package controller.offline_logic.gamelogic.enemieslogic;

import controller.offline_logic.gamestrucure.GameState;
import controller.offline_logic.modelstructure.entity.enemy.Goomba;
import controller.offline_logic.tools.ObjectRemover;
import util.Sound;

public class GoombaLifeChecker extends EnemyLifeChecker{
    private Sound sound = new Sound("KICK");
    private GameState gameState;
    private Goomba goomba;

    public GoombaLifeChecker(GameState gameState, Goomba goomba) {
        this.gameState = gameState;
        this.goomba = goomba;
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
        gameState.getCurrentSection().setEnemies(ObjectRemover.removeObjectFromArray(gameState.getCurrentSection().getEnemies(), goomba));
    }

    @Override
    public void heatByHead() {
        kill();
    }
}
