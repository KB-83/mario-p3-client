package controller.listener;

import controller.LocalController;
import view.menu.ItemShopPanel;

public class ItemShopPanelListener {
    private LocalController localController;
    private ItemShopPanel itemShopPanel;

    public ItemShopPanelListener(LocalController localController, ItemShopPanel itemShopPanel) {
        this.localController = localController;
        this.itemShopPanel = itemShopPanel;
    }
}
