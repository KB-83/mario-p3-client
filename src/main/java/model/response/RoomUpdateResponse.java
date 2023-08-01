package model.response;

import controller.connection.ResponseVisitor;
import model.dto.RoomDTO;

public class RoomUpdateResponse extends Response{
    private RoomDTO roomDTO;

    public RoomDTO getRoomDTO() {
        return roomDTO;
    }
    @Override
    public void visit(ResponseVisitor responseVisitor) {
        responseVisitor.visit(this);
    }


    public void setRoomDTO(RoomDTO roomDTO) {
        this.roomDTO = roomDTO;
    }

}
