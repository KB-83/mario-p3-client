package controller.listener;

import controller.LocalController;
import model.request.LoginRequest;
import model.request.SignInRequest;
import view.menu.MainMenu;
import view.menu.StartPanel;

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
        localController.sendRequest(new LoginRequest(startPanel.getLoginName().getText(),startPanel.getLoginPass().getText()));
        }

        public void getSignIn() {
        localController.sendRequest(new SignInRequest(startPanel.getSignName().getText(),startPanel.getSignPass().getText()));
//                UserRequestHandler userRequestHandler = new UserRequestHandler(cardPanel.getFrame().getGraphicManager().getLogicManager());
//                if (userRequestHandler.signInRequest(signName.getText(),signPass.getText())){
//                }
        }
//
}
