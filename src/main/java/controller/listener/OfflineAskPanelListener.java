package controller.listener;

import controller.LocalController;
import view.menu.GamePanel;
import view.menu.ItemShopPanel;
import view.menu.LoadingPanel;
import view.menu.OfflineAskPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OfflineAskPanelListener {
    private LocalController localController;
    private OfflineAskPanel offlineAskPanel;

    public OfflineAskPanelListener(LocalController localController, OfflineAskPanel offlineAskPanel) {
        this.localController = localController;
        this.offlineAskPanel = offlineAskPanel;
    }
    public void tryAgain() {
        localController.tryToConnectAgain();
    }
    public void playOffline(){
        localController.showLoginPanel(false);
        LocalController.isOnline = false;
    }
}
