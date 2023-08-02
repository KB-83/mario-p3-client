package controller.offline_logic.gamelogic.enemieslogic;

import controller.offline_logic.gamestrucure.GameState;
import controller.offline_logic.modelstructure.entity.enemy.Plant;
import controller.offline_logic.tools.ObjectRemover;
import util.Sound;

public class PlantLifeChecker extends EnemyLifeChecker{
    private GameState gameState;
    private Plant plant;
    private Sound sound = new Sound("KICK");
    public PlantLifeChecker(GameState gameState, Plant plant) {
        this.gameState = gameState;
        this.plant = plant;
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
        gameState.getCurrentSection().setEnemies(ObjectRemover.removeObjectFromArray(gameState.getCurrentSection().getEnemies(), plant));
    }

    @Override
    public void heatByHead() {

    }
}
