import controller.connection.RequestHandler;
import model.request.ReceiveGame;
import model.request.ReceiveItem;
import model.request.Request;

public class TestMain {
    public static void main(String[] args) {
        RequestHandler rrh= RequestHandler.getInstance();
        Request receiveGame = new ReceiveGame();
        Request receiveItem = new ReceiveItem();
        receiveItem.visit(rrh);
        receiveGame.visit(rrh);
    }
}
