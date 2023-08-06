package model.response;


import controller.connection.ResponseVisitor;
import model.Client;

public class ClientUpdateResponse extends Response{
    private int coin;
    private int diamond;
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



}
