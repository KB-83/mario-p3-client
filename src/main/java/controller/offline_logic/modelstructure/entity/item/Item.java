package controller.offline_logic.modelstructure.entity.item;

import com.fasterxml.jackson.annotation.JsonIgnore;
import controller.offline_logic.gamelogic.itemlogic.ItemController;
import controller.offline_logic.modelstructure.entity.Entity;

public abstract class Item extends Entity {
    @JsonIgnore
    private boolean isLock;
    @JsonIgnore
    private ItemController itemController;
    public Item() {
        isLock = true;
        setOnTopOfBlock(true);
    }

    public ItemController getItemController() {
        return itemController;
    }

    public void setItemController(ItemController itemController) {
        this.itemController = itemController;
    }

    public boolean isLock() {
        return isLock;
    }

    public void setLock(boolean lock) {
        isLock = lock;
    }

}
