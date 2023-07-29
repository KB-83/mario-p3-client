import controller.ClientController;
import util.Config;

public class Main {
    public static void main(String[] args) {

        Config.loadConfigs();
        new ClientController();

    }
}
