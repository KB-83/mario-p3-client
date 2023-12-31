package controller.offline_logic.gamelogic.enemieslogic;

import controller.offline_logic.gamelogic.collisionlogic.EnemyCollisionHandler;
import controller.offline_logic.gamestrucure.GameState;
import controller.offline_logic.modelstructure.entity.enemy.Enemy;
import controller.offline_logic.modelstructure.entity.enemy.Spiny;
import util.Constant;

public class SpinyController extends EnemyController{
    private EnemyCollisionHandler enemyCollisionHandler;
    private EnemyMovementHandler enemyMovementHandler;
    private Spiny spiny;
    private GameState gameState;
    // picksel/fps ^ 2
    private final int A = 1;
    private final int V = 100;
    public SpinyController(GameState gameState , Enemy enemy){
        super(gameState,enemy);
        setEnemyLifeChecker(new SpinyLifeChecker(gameState,(Spiny) enemy));
        enemyMovementHandler = new EnemyMovementHandler(gameState);
        enemyCollisionHandler = new EnemyCollisionHandler(gameState,enemy);
        spiny = (Spiny) enemy;
        this.gameState = gameState;
    }
    public void update() {
        enemyMovementHandler.updateEnemiesPosition();
        enemyCollisionHandler.applyCollisionEffects();
        checkDistance();

    }
    public void checkDistance() {
        if (Math.abs(spiny.getWorldX() - gameState.getMario().getWorldX())<= 4 * Constant.BACKGROUND_TILE_SIZE){
            if (spiny.getWorldX() > gameState.getMario().getWorldX()){
                if (spiny.getVX() > 0){
                    spiny.setVX(-spiny.getVX());
                }
                spiny.setVX(-A*(Constant.FPS)+spiny.getVX());
            }
            else if (spiny.getWorldX() < gameState.getMario().getWorldX()){
                if (spiny.getVX() < 0){
                    spiny.setVX(-spiny.getVX());
                }
                spiny.setVX(A+spiny.getVX());
            }
        }
        else {
            if (Math.abs(spiny.getVX()) > V) {
                if (spiny.getVX() > 0) {
                    spiny.setVX(V);
                }
                else {
                    spiny.setVX(-V);
                }
            }
        }
    }
}
