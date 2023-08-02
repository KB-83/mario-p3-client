package controller.offline_logic.gamelogic.enemieslogic;

import controller.offline_logic.gamelogic.collisionlogic.EnemyCollisionHandler;
import controller.offline_logic.gamestrucure.GameState;
import controller.offline_logic.modelstructure.entity.enemy.Enemy;

public class KoopaController extends EnemyController{
    private EnemyCollisionHandler enemyCollisionHandler;
    private EnemyMovementHandler enemyMovementHandler;
    public KoopaController(GameState gameState , Enemy enemy){
        super(gameState,enemy);
        setEnemyLifeChecker(new KoopaLifeChecker(gameState,enemy));
        enemyMovementHandler = new EnemyMovementHandler(gameState);
        enemyCollisionHandler = new EnemyCollisionHandler(gameState,enemy);
    }
    public void update() {
        enemyMovementHandler.updateEnemiesPosition();
        enemyCollisionHandler.applyCollisionEffects();
    }
}
