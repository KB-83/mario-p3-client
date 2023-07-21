import controller.ClientController;
import util.Config;
import view.Frame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Config.loadConfigs();
        new ClientController();
//        new Frame();
    }
}
