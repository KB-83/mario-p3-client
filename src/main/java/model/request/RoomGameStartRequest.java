package model.request;

import controller.ClientController;
import controller.connection.RequestVisitor;

public class RoomGameStartRequest extends Request{
    private boolean isFromRoomManager;

    public RoomGameStartRequest() {
    }

    public RoomGameStartRequest(boolean isFromRoomManager) {
        this.isFromRoomManager = isFromRoomManager;
    }

    public boolean isFromRoomManager() {
        return isFromRoomManager;
    }

    public void setFromRoomManager(boolean fromRoomManager) {
        isFromRoomManager = fromRoomManager;
    }
}
