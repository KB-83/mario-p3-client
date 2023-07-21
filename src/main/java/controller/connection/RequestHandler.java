package controller.connection;

import model.request.ReceiveGame;
import model.request.ReceiveItem;

public class RequestHandler implements RequestVisitor {
    private static RequestHandler requestResponseHandler;
    private RequestHandler() {}
    public static RequestHandler getInstance() {
        if (requestResponseHandler == null) {
            requestResponseHandler = new RequestHandler();
        }
        return requestResponseHandler;
    }
    @Override
    public void visit(ReceiveGame request) {

    }

    @Override
    public void visit(ReceiveItem request) {

    }
}
