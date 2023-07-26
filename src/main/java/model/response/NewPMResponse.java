package model.response;


import controller.connection.ResponseVisitor;
import model.Massage;
import model.PrivateChat;

import java.util.ArrayList;

public class NewPMResponse extends Response {
    private Massage massage;
    private String sender;
    private ArrayList<PrivateChat> newPrivateChat;


    public NewPMResponse(Massage massage, String sender) {
        this.massage = massage;
        this.sender = sender;
    }

    public NewPMResponse() {
    }

    public Massage getMassage() {
        return massage;
    }

    public void setMassage(Massage massage) {
        this.massage = massage;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    @Override
    public void visit(ResponseVisitor responseVisitor) {
        responseVisitor.visit(this);
    }

    public ArrayList<PrivateChat> getNewPrivateChat() {
        return newPrivateChat;
    }

    public void setNewPrivateChat(ArrayList<PrivateChat> newPrivateChat) {
        this.newPrivateChat = newPrivateChat;
    }
}
