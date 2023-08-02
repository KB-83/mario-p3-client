package controller.offline_logic.gamelogic.enemieslogic;

import controller.offline_logic.gamelogic.collisionlogic.EnemyCollisionHandler;
import controller.offline_logic.gamestrucure.GameState;
import controller.offline_logic.modelstructure.entity.enemy.Enemy;
import controller.offline_logic.modelstructure.entity.enemy.Goomba;

public class GoombaController extends EnemyController{
    private EnemyCollisionHandler enemyCollisionHandler;
    private EnemyMovementHandler enemyMovementHandler;
    public GoombaController(GameState gameState , Enemy enemy){
        super(gameState,enemy);
        setEnemyLifeChecker(new GoombaLifeChecker(gameState,(Goomba) enemy));
        enemyMovementHandler = new EnemyMovementHandler(gameState);
        enemyCollisionHandler = new EnemyCollisionHandler(gameState,enemy);
    }
}
