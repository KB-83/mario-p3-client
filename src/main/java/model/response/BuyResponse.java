package model.response;


import controller.connection.ResponseVisitor;
import model.Bill;

public class BuyResponse extends Response{
    private Bill bill;
    private String message;
    private boolean isAccepted;

    public BuyResponse() {
    }
    

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    @Override
    public void visit(ResponseVisitor responseVisitor) {
        responseVisitor.visit(this);
    }
}
