package model.response;

import controller.connection.ResponseVisitor;

public class EnterRoomResponse extends Response {
    public EnterRoomResponse() {
    }
    @Override
    public void visit(ResponseVisitor responseVisitor) {
        responseVisitor.visit(this);
    }
}
