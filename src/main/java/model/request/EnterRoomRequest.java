package model.request;

public class EnterRoomRequest extends Request{
    private String token;
    private boolean isPlayer;

    public EnterRoomRequest() {
    }

    public EnterRoomRequest(String token, boolean isPlayer) {
        this.token = token;
        this.isPlayer = isPlayer;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isPlayer() {
        return isPlayer;
    }

    public void setPlayer(boolean player) {
        isPlayer = player;
    }
}
