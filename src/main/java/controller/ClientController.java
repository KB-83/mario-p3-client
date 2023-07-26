package controller;

import model.Client;
import model.PrivateChat;
import model.request.Request;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//this class handle the relations between network requests and local requests
public class ClientController {
    private NetworkController networkController;
    private LocalController localController;
    private Client client;

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
        Timer timer = new Timer(1000, new ActionListener() {
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
    public ArrayList<String> returnChatNames() {
        ArrayList<String> names = new ArrayList<>();
        for (PrivateChat privateChat : client.getPrivateChats()) {
            names.add(privateChat.getOpponentUsername());
        }
        return names;
    }
    public PrivateChat getPrivateChatByOpponentName(String opponentName) {
        for (PrivateChat privateChat : client.getPrivateChats()) {
            if (privateChat.getOpponentUsername().equals(opponentName)) {
                return privateChat;
            }
        }
        return null;
    }

    public NetworkController getNetworkController() {
        return networkController;
    }

    public LocalController getLocalController() {
        return localController;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
