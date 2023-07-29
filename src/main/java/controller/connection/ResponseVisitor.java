package controller.connection;

import model.response.*;

public interface ResponseVisitor {
    void visit(SignInLoginResponse response);
    void visit(GameStartResponse response);
    void visit(GameStateStatusResponse response);
    void visit(NewPMResponse response);
    void visit(BuyResponse response);
    void visit(GameOverResponse response);

}
