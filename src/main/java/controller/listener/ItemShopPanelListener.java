package controller.listener;

import controller.LocalController;
import model.request.BuyRequest;
import util.Name;
import view.menu.shop.ItemShopPanel;

import javax.swing.*;
import java.awt.*;

public class ItemShopPanelListener {
    private LocalController localController;
    private ItemShopPanel itemShopPanel;
    public ItemShopPanelListener(LocalController localController, ItemShopPanel itemShopPanel) {
        this.localController = localController;
        this.itemShopPanel = itemShopPanel;
    }
    public void buyCoin() {
        // tedad almas va seke hasho midim midam gpt bezaneh badan
//        localController.getController().showbuyframe
    }
    public void buyRequest() {
        BuyRequest buyRequest = new BuyRequest();
        for (Component itemComponent : itemShopPanel.getCenterPanel().getComponents()) {
            if (itemComponent instanceof JPanel) {
                JPanel itemPanel = (JPanel) itemComponent;
                JLabel nameLabel = (JLabel) ((JPanel) itemPanel.getComponent(1)).getComponent(0);
                JLabel quantityLabel = (JLabel) ((JPanel) itemPanel.getComponent(2)).getComponent(1);

                String itemName = nameLabel.getText();
                int itemQuantity = Integer.parseInt(quantityLabel.getText());
                switch (itemName) {
                    case Name.HAMMER :
                        buyRequest.setHammer(buyRequest.getHammer() + itemQuantity);
                        break;
                    case Name.SWARD :
                        buyRequest.setSward(buyRequest.getSward() + itemQuantity);
                        break;
                    case Name.HEALTH_POTION :
                        buyRequest.setHealthPotion(buyRequest.getHealthPotion() + itemQuantity);
                        break;
                    case Name.INVISIBILITY_POTION :
                        buyRequest.setInVisibilityPotion(buyRequest.getInVisibilityPotion() + itemQuantity);
                        break;
                    case Name.SPEED_POTION :
                        buyRequest.setSpeedPotion(buyRequest.getSpeedPotion() + itemQuantity);
                        break;
                    case Name.DAMAGE_BOMB :
                        buyRequest.setDamageBomb(buyRequest.getDamageBomb() + itemQuantity);
                        break;
                    case Name.SPEED_BOMB :
                        buyRequest.setSpeedBomb(buyRequest.getSpeedBomb() + itemQuantity);
                        break;
                }
            }
        }
        localController.sendRequest(buyRequest);
    }
}
