package model.request;

import controller.ClientController;
import controller.connection.RequestVisitor;

public class PlayerActionRequest extends Request{
    private String type;

    public PlayerActionRequest() {
    }

    public PlayerActionRequest(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
