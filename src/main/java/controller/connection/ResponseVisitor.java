package controller.connection;

import model.response.GameStartResponse;
import model.response.GameStateStatusResponse;
import model.response.SignInLoginResponse;

public interface ResponseVisitor {
    void visit(SignInLoginResponse response);
    void visit(GameStartResponse response);
    void visit(GameStateStatusResponse response);

}
