package controller.offline_logic.gamelogic.enemieslogic;

import controller.offline_logic.gamelogic.collisionlogic.EnemyCollisionHandler;
import controller.offline_logic.gamestrucure.GameState;
import controller.offline_logic.gamestrucure.gameworldoption.Gravity;
import controller.offline_logic.modelstructure.entity.enemy.Enemy;
import util.Constant;

public class EnemyMovementHandler {
    private GameState gameState;

    public EnemyMovementHandler(GameState gameState) {
        this.gameState = gameState;
    }
    public void updateEnemiesPosition() {
        if (gameState.getCurrentSection().getEnemies() == null){
            return;
        }
        for (Enemy enemy: gameState.getCurrentSection().getEnemies()) {
//            enemy.setEnemyCollisionHandler(new EnemyCollisionHandler(gameState.getCurrentSection(),enemy));
            //todo : change enemy collision handler if section changed?
            if (!enemy.getClass().getSimpleName().equals("Plant")){
//                enemy.getEnemyCollisionHandler().setSection(gameState);
//                enemy.getEnemyCollisionHandler().applyCollisionEffects();
                if (enemy.getOnTopOfBlock() == false) {
                    enemy.setVY(enemy.getVY()+(1.0/Constant.FPS* Gravity.MARIO_GAME));
                }
                else {
                        enemy.setVY(0);
                }
            }
            // todo : if the v is low it would be cast low so works as a constant
            enemy.setWorldX((int) (enemy.getWorldX()+(1.0/ Constant.FPS * enemy.getVX())));
            enemy.setWorldY((int) (enemy.getWorldY()+(1.0/Constant.FPS * enemy.getVY())));

        }
    }
}
