package controller;

import controller.offline_logic.requsethandler.UserRequestHandler;
import model.Client;
import model.request.Request;
import util.Loop;
import view.Frame;
import view.menu.LoadingPanel;
import view.menu.OfflineAskPanel;
import view.menu.StartPanel;

public class LocalController {
    public static boolean isOnline = true;
    private ClientController controller;
    private Loop clientCurrentGameLoop;
    private Frame frame;
    private UserRequestHandler userRequestHandler;
    public LocalController(ClientController controller) {
        this.controller = controller;
        this.frame = new Frame(this);
        this.userRequestHandler = new UserRequestHandler(this);
    }
    public void enableOfflineMode(boolean offline) {
        frame.getPanelsManagerCard().setOffline(offline);
    }
    public void showAskPanel() {
        frame.getPanelsManagerCard().getCardLayout().show
                (frame.getPanelsManagerCard(), OfflineAskPanel.class.getSimpleName());
    }
    public void showLoginPanel(boolean isOnline) {
        enableOfflineMode(!isOnline);
        frame.getPanelsManagerCard().getCardLayout().show
                (frame.getPanelsManagerCard(), StartPanel.class.getSimpleName());


    }

    public ClientController getController() {
        return controller;
    }

    public void setController(ClientController controller) {
        this.controller = controller;
    }
    public void sendRequest (Request request) {
        controller.sendRequestToServer(request);
    }

    public Frame getFrame() {
        return frame;
    }
    public void startGameState() {

    }
    public void clientCleared(Client client) {
        //set client
        frame.getPanelsManagerCard().getChatPanel().clientCleared(client);
        userRequestHandler.setClient(client);//test

    }
    public void tryToConnectAgain() {
        frame.getPanelsManagerCard().getCardLayout().show(
                frame.getPanelsManagerCard(), LoadingPanel.class.getSimpleName()
        );
        frame.getPanelsManagerCard().getLoadingPanel().setLoading(true);
        controller.connectToServer();
        isOnline = true;
    }

    public void setClientCurrentGameLoop(Loop clientCurrentGameLoop) {
        this.clientCurrentGameLoop = clientCurrentGameLoop;
    }

    public Loop getClientCurrentGameLoop() {
        return clientCurrentGameLoop;
    }

    public UserRequestHandler getUserRequestHandler() {
        return userRequestHandler;
    }
}
