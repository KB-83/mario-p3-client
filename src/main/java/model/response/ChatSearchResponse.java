package model.response;

import controller.connection.ResponseVisitor;

import java.util.ArrayList;

public class ChatSearchResponse extends Response{
    private ArrayList<String> usernames;

    public ChatSearchResponse() {
    }

    public ArrayList<String> getUsernames() {
        return usernames;
    }

    public void setUsernames(ArrayList<String> usernames) {
        this.usernames = usernames;
    }

    @Override
    public void visit(ResponseVisitor responseVisitor) {
        responseVisitor.visit(this);
    }
}
