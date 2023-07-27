package controller.listener;

import controller.LocalController;
import model.request.BuyRequest;
import view.menu.ItemShopPanel;

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
                    case "hammer" :
                        buyRequest.setHammer(buyRequest.getHammer() + itemQuantity);
                        break;
                    case "sward" :
                        buyRequest.setSward(buyRequest.getSward() + itemQuantity);
                        break;
                    case "healthpotion" :
                        buyRequest.setHealthPotion(buyRequest.getHealthPotion() + itemQuantity);
                        break;
                    case "invisiblepotion" :
                        buyRequest.setInVisibilityPotion(buyRequest.getInVisibilityPotion() + itemQuantity);
                        break;
                    case "speedpotion" :
                        buyRequest.setSpeedPotion(buyRequest.getSpeedPotion() + itemQuantity);
                        break;
                    case "damagebomb" :
                        buyRequest.setDamageBomb(buyRequest.getDamageBomb() + itemQuantity);
                        break;
                    case "speedbomb" :
                        buyRequest.setSpeedBomb(buyRequest.getSpeedBomb() + itemQuantity);
                        break;
                }
            }
        }
        localController.sendRequest(buyRequest);
    }
}
