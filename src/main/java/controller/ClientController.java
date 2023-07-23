package controller;

import model.request.Request;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//this class handle the relations between network requests and local requests
public class ClientController {
    private NetworkController networkController;
    private LocalController localController;

    public ClientController() {
        this.networkController = new NetworkController(this);
        this.localController = new LocalController(this);
        connectToServer();
    }

    public void connectionStartMode(boolean isOnline) {
        if (!isOnline) {
            localController.showAskPanel();
            return;
        }
        networkController.start();
        localController.showLoginPanel(true);
    }
    public void connectToServer() {
        Timer timer = new Timer(7000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connectionStartMode(networkController.connectToServer());
            }
        });
        timer.setRepeats(false);
        timer.start();
    }
    public void sendRequestToServer(Request request) {
        networkController.sendRequest(request);
    }

    public NetworkController getNetworkController() {
        return networkController;
    }

    public LocalController getLocalController() {
        return localController;
    }
}
