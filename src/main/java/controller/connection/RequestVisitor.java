package controller.connection;

import model.request.GetGameStateRequest;
import model.request.ReceiveItem;

// Visitor interface
public interface RequestVisitor {
    void visit(GetGameStateRequest request);
    void visit(ReceiveItem request);

}

