package controller.listener;

import controller.LocalController;
import view.menu.MainMenu;
import view.menu.StartPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartPanelListener {
    private LocalController localController;
    private StartPanel startPanel;

    public StartPanelListener(LocalController localController, StartPanel startPanel) {
        this.localController = localController;
        this.startPanel = startPanel;
    }

    public void getLogin() {
//                UserRequestHandler userRequestHandler = new UserRequestHandler(cardPanel.getFrame().getGraphicManager().getLogicManager());
//                if (userRequestHandler.loginRequest(loginName.getText(), loginPass.getText())){
        startPanel.getCardPanel().getCardLayout().show(startPanel.getCardPanel(), MainMenu.class.getSimpleName());
        startPanel.getCardPanel().getMainMenu().requestFocus();
        }

        public void getSignIn() {
//                UserRequestHandler userRequestHandler = new UserRequestHandler(cardPanel.getFrame().getGraphicManager().getLogicManager());
//                if (userRequestHandler.signInRequest(signName.getText(),signPass.getText())){
            startPanel.getCardPanel().getCardLayout().show(startPanel.getCardPanel(), MainMenu.class.getSimpleName());
            startPanel.getCardPanel().requestFocus();
//                }
        }
//
}
