package model.request;

import controller.connection.RequestVisitor;

public class ReceiveItem extends Request{
    @Override
    public void visit(RequestVisitor visitor) {
        visitor.visit(this);
    }
}
