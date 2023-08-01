package model.request;

public class CreateRoomRequest extends Request{
    private String username;
    private String roomPassword;
    private String roomName;

    public CreateRoomRequest(String username, String roomPassword, String roomName) {
        this.username = username;
        this.roomPassword = roomPassword;
        this.roomName = roomName;
    }

    public CreateRoomRequest() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRoomPassword() {
        return roomPassword;
    }

    public void setRoomPassword(String roomPassword) {
        this.roomPassword = roomPassword;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
}
