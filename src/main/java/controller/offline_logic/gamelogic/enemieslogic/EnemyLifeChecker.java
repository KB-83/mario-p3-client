package controller.offline_logic.gamelogic.enemieslogic;

import controller.offline_logic.modelstructure.entity.enemy.Enemy;
import util.Constant;
import util.Sound;

public abstract class EnemyLifeChecker {
    public void checkLife(Enemy enemy){
        if (enemy.getWorldY() >= Constant.PANEL_HEIGHT)
        {
            enemy.getEnemyController().getEnemyLifeChecker().kill();
        }
    };
    public abstract void kickedBybullet();
    public abstract void kickedBySward();
    public abstract void kill();
    public abstract void heatByHead();
}
