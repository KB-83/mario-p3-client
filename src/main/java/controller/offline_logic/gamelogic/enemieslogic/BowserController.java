package controller.offline_logic.gamelogic.enemieslogic;


import controller.offline_logic.gamelogic.collisionlogic.EnemyCollisionHandler;
import controller.offline_logic.gamestrucure.GameState;
import controller.offline_logic.modelstructure.entity.enemy.Bowser;
import controller.offline_logic.modelstructure.entity.enemy.Enemy;


public class BowserController extends EnemyController{
    private EnemyCollisionHandler enemyCollisionHandler;
    private EnemyMovementHandler enemyMovementHandler;
    public BowserController(GameState gameState , Enemy enemy){
        super(gameState,enemy);
        setEnemyLifeChecker(new BowserLifeChecker(gameState,(Bowser) enemy));
        enemyMovementHandler = new EnemyMovementHandler(gameState);
        enemyCollisionHandler = new EnemyCollisionHandler(gameState,enemy);
    }
}
