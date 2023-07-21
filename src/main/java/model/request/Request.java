package model.request;

import controller.connection.RequestVisitor;

public abstract class Request {
    public abstract void visit(RequestVisitor visitor);
}

