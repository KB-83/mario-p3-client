package controller.listener;

import controller.LocalController;
import model.Client;
import model.dto.ClientDTO;
import model.request.LoginRequest;
import model.request.SignInRequest;
import util.Loader;
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
        if (LocalController.isOnline) {
            localController.sendRequest(new LoginRequest(startPanel.getLoginName().getText(),
                    startPanel.getLoginPass().getText()));
        }
        else {
            ClientDTO clientDTO = Loader.getLoader().loadLocalClient(startPanel.getLoginName().getText(),startPanel.getLoginPass().getText(),localController.getController());

            if(clientDTO != null) {
                Client client = new Client();
                client.setPrivateChats(clientDTO.getPrivateChats());
                client.setPassword(clientDTO.getPassword());
                client.setUsername(clientDTO.getUsername());
                localController.getController().setClient(client);
                client.setClientController(localController.getController());
                localController.clientCleared(client);
                localController.getFrame().getPanelsManagerCard().getCardLayout().show(localController.getFrame().getPanelsManagerCard(), MainMenu.class.getSimpleName());
                localController.getFrame().getPanelsManagerCard().getStartPanel().requestFocus();
            }
        }
        }

        public void getSignIn() {
        localController.sendRequest(new SignInRequest(startPanel.getSignName().getText(),startPanel.getSignPass().getText()));
//                UserRequestHandler userRequestHandler = new UserRequestHandler(cardPanel.getFrame().getGraphicManager().getLogicManager());
//                if (userRequestHandler.signInRequest(signName.getText(),signPass.getText())){
//                }
        }
        public void tryAgain() {
            localController.tryToConnectAgain();
        }
//
}
