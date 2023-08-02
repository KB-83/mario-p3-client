package controller.offline_logic.modelstructure.entity.enemy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import controller.offline_logic.gamelogic.enemieslogic.EnemyController;
import controller.offline_logic.modelstructure.entity.Entity;


public abstract class Enemy extends Entity {
    @JsonIgnore
    private EnemyController enemyController;
    private boolean isAlive;
    public Enemy() {
        setOnTopOfBlock(true);
    }

    public EnemyController getEnemyController() {
        return enemyController;
    }

    public void setEnemyController(EnemyController enemyController) {
        this.enemyController = enemyController;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
