package model.response;

import controller.connection.ResponseVisitor;

public class RoomCloseResponse extends Response{
    private String massage;
    public RoomCloseResponse() {
    }

    public RoomCloseResponse(String massage) {
        this.massage = massage;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    @Override
    public void visit(ResponseVisitor responseVisitor) {
        responseVisitor.visit(this);
    }
}
