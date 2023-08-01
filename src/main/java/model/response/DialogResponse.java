package model.response;

import controller.connection.ResponseVisitor;

public class DialogResponse extends Response{
    private String massage;

    public DialogResponse() {
    }
    @Override
    public void visit(ResponseVisitor responseVisitor) {
        responseVisitor.visit(this);
    }

    public DialogResponse(String massage) {
        this.massage = massage;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

}
