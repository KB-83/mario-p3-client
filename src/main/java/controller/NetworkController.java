package controller;

import java.io.IOException;
import java.net.Socket;

public class NetworkController {
    private ClientController controller;
    private Socket socket;
    private final int PORT_NUM = 9000;
    public NetworkController(ClientController controller) {
        this.controller = controller;
    }
    public boolean connectToServer() {
        try {
            socket = new Socket("localhost", PORT_NUM);
        }catch (IOException e) {
            return false;
        }
        return true;
    }
}
