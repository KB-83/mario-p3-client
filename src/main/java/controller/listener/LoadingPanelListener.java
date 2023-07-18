package controller.listener;

import controller.LocalController;
import view.menu.LoadingPanel;

public class LoadingPanelListener {
    private LocalController localController;
    private LoadingPanel loadingPanel;

    public LoadingPanelListener(LocalController localController, LoadingPanel loadingPanel) {
        this.localController = localController;
        this.loadingPanel = loadingPanel;
    }
}
