package controller.connection;

import model.request.ReceiveGame;
import model.request.ReceiveItem;
import model.response.GameStartResponse;
import model.response.SignInLoginResponse;

public interface ResponseVisitor {
    void visit(SignInLoginResponse response);
    void visit(GameStartResponse response);

}
