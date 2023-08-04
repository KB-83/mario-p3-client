package model.response;


import controller.connection.ResponseVisitor;
import model.Chat;
import model.Massage;

import java.util.ArrayList;
import java.util.List;

public class NewPMResponse extends Response {
    private Massage massage;
    private List<Chat> newChat;
    public NewPMResponse() {
    }

    public Massage getMassage() {
        return massage;
    }

    public void setMassage(Massage massage) {
        this.massage = massage;
    }

    public List<Chat> getNewChat() {
        return newChat;
    }

    public void setNewPrivateChat(List<Chat> newChat) {
        this.newChat = newChat;
    }

    @Override
    public void visit(ResponseVisitor responseVisitor) {
        responseVisitor.visit(this);
    }

}
