package model.response;


import controller.connection.ResponseVisitor;
import model.Chat;

public class RoomChatUpdateResponse extends Response {
    private Chat chat;

    public RoomChatUpdateResponse() {
    }

    @Override
    public void visit(ResponseVisitor responseVisitor) {
        responseVisitor.visit(this);
    }

    public RoomChatUpdateResponse(Chat chat) {
        this.chat = chat;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }
}
