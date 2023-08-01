package model.response;


import controller.connection.ResponseVisitor;
import model.Chat;
import model.Massage;

import java.util.ArrayList;

public class NewPMResponse extends Response {
    private Massage massage;
    private ArrayList<Chat> newChat;
    public NewPMResponse() {
    }

    public Massage getMassage() {
        return massage;
    }

    public void setMassage(Massage massage) {
        this.massage = massage;
    }

    public ArrayList<Chat> getNewChat() {
        return newChat;
    }

    public void setNewPrivateChat(ArrayList<Chat> newChat) {
        this.newChat = newChat;
    }

    @Override
    public void visit(ResponseVisitor responseVisitor) {
        responseVisitor.visit(this);
    }

}
