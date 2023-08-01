package model.response;

import controller.connection.ResponseVisitor;

public class RoomResponse extends Response{
    private String roomToken;

    public RoomResponse() {
    }
    @Override
    public void visit(ResponseVisitor responseVisitor) {
        responseVisitor.visit(this);
    }

    public String getRoomToken() {
        return roomToken;
    }

    public void setRoomToken(String roomToken) {
        this.roomToken = roomToken;
    }

}
