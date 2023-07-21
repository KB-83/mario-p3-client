package controller.connection;

import model.request.ReceiveGame;
import model.request.ReceiveItem;

// Visitor interface
public interface RequestVisitor {
    void visit(ReceiveGame request);
    void visit(ReceiveItem request);

}

