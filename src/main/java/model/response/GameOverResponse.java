package model.response;

import controller.connection.ResponseVisitor;

public class GameOverResponse extends Response{
    private int score;
    private int diamond;
    private String massage;

    public GameOverResponse() {
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getDiamond() {
        return diamond;
    }

    public void setDiamond(int diamond) {
        this.diamond = diamond;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    @Override
    public void visit(ResponseVisitor responseVisitor) {
        responseVisitor.visit(this);
    }
}
