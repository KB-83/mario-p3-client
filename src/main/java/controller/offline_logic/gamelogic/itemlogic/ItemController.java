package controller.offline_logic.gamelogic.itemlogic;

import controller.offline_logic.gamelogic.collisionlogic.ItemCollisionHandler;
import controller.offline_logic.gamestrucure.GameState;
import controller.offline_logic.modelstructure.entity.item.Item;

public class ItemController {
    private ItemCollisionHandler itemCollisionHandler;
    private ItemMovementHandler itemMovementHandler;

    public ItemController(Item item, GameState gameState) {
        itemCollisionHandler = new ItemCollisionHandler(gameState,item);
        itemMovementHandler  = new ItemMovementHandler(gameState);
    }

    public void update(){
        itemMovementHandler.updateItemsPosition();
        itemCollisionHandler.applyCollisionEffects();
    }
}
