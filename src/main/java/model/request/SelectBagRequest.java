package model.request;

public class SelectBagRequest extends Request{
    private String[] bag;
    public SelectBagRequest() {
    }

    public SelectBagRequest(String[] bag) {
        this.bag = bag;
    }

    public String[] getBag() {
        return bag;
    }

    public void setBag(String[] bag) {
        this.bag = bag;
    }
}
