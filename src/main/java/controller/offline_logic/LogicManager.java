package controller.offline_logic;


import model.Client;

public class LogicManager {
    private Client client;
    public LogicManager() {

    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}
