package model.request;

public class RoomGameStartRequest extends Request{
    private boolean isFromRoomManager;
    private String token;

    public RoomGameStartRequest() {
    }

    public RoomGameStartRequest(boolean isFromRoomManager, String token) {
        this.isFromRoomManager = isFromRoomManager;
        this.token = token;
    }

    public boolean isFromRoomManager() {
        return isFromRoomManager;
    }

    public void setFromRoomManager(boolean fromRoomManager) {
        isFromRoomManager = fromRoomManager;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
