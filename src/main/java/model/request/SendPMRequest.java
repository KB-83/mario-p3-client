package model.request;

public class SendPMRequest extends Request{
    private String opponentUserName;
    private String Context;

    public SendPMRequest(String opponentUserName, String context) {
        this.opponentUserName = opponentUserName;
        Context = context;
    }

    public SendPMRequest() {
    }

    public String getOpponentUserName() {
        return opponentUserName;
    }

    public void setOpponentUserName(String opponentUserName) {
        this.opponentUserName = opponentUserName;
    }

    public String getContext() {
        return Context;
    }

    public void setContext(String context) {
        Context = context;
    }
}
