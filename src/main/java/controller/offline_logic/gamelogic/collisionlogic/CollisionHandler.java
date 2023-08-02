package controller.offline_logic.gamelogic.collisionlogic;

public interface CollisionHandler {
    public void checkBlocksCollision();

    public void checkPipesCollision();
    public void checkEnemiesCollision();

    public void checkBackgroundTilesCollision();
    public void checkPlayerCollision();
}
