package controller.listener;

import controller.LocalController;
import view.menu.OfflineAskPanel;

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
