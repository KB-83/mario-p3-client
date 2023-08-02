package controller.offline_logic.gamelogic.enemieslogic;

import controller.offline_logic.gamelogic.collisionlogic.EnemyCollisionHandler;
import controller.offline_logic.gamestrucure.GameState;
import controller.offline_logic.modelstructure.entity.enemy.Enemy;
import controller.offline_logic.modelstructure.entity.enemy.Koopa;

public class EnemyController {
    private EnemyCollisionHandler enemyCollisionHandler;
    private EnemyMovementHandler enemyMovementHandler;
    private EnemyLifeChecker enemyLifeChecker;
    private Enemy enemy;

    public EnemyController(GameState gameState , Enemy enemy){
        this.enemy = enemy;
        enemyMovementHandler = new EnemyMovementHandler(gameState);
        enemyCollisionHandler = new EnemyCollisionHandler(gameState,enemy);
    }
    public void update() {
        enemyMovementHandler.updateEnemiesPosition();
        enemyCollisionHandler.applyCollisionEffects();
        enemyLifeChecker.checkLife(enemy);
    }

    public EnemyCollisionHandler getEnemyCollisionHandler() {
        return enemyCollisionHandler;
    }

    public void setEnemyCollisionHandler(EnemyCollisionHandler enemyCollisionHandler) {
        this.enemyCollisionHandler = enemyCollisionHandler;
    }

    public EnemyMovementHandler getEnemyMovementHandler() {
        return enemyMovementHandler;
    }

    public void setEnemyMovementHandler(EnemyMovementHandler enemyMovementHandler) {
        this.enemyMovementHandler = enemyMovementHandler;
    }

    public EnemyLifeChecker getEnemyLifeChecker() {
        return enemyLifeChecker;
    }

    public void setEnemyLifeChecker(EnemyLifeChecker enemyLifeChecker) {
        this.enemyLifeChecker = enemyLifeChecker;
    }
}
