package controller.connection;

import model.request.GetGameStateRequest;
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
    public void visit(GetGameStateRequest request) {

    }

    @Override
    public void visit(ReceiveItem request) {

    }
}
