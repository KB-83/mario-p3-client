package model.request;

public class NewPrivateChatRequest extends Request{
    private String opponentName;

    public NewPrivateChatRequest() {
    }

    public NewPrivateChatRequest(String opponentName) {
        this.opponentName = opponentName;
    }

    public String getOpponentName() {
        return opponentName;
    }

    public void setOpponentName(String opponentName) {
        this.opponentName = opponentName;
    }
}
