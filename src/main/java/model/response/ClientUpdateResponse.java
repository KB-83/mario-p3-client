package model.response;


import controller.connection.ResponseVisitor;
import model.Chat;
import model.Client;

import java.util.List;

public class ClientUpdateResponse extends Response{
    private int coin;
    private int diamond;
    private List<Chat> chats;
    public ClientUpdateResponse() {
    }
    @Override
    public void visit(ResponseVisitor responseVisitor) {
        responseVisitor.visit(this);
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public int getDiamond() {
        return diamond;
    }

    public void setDiamond(int diamond) {
        this.diamond = diamond;
    }

    public List<Chat> getChats() {
        return chats;
    }

    public void setChats(List<Chat> chats) {
        this.chats = chats;
    }
}
