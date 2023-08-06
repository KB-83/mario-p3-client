package model.request;

public class SearchTableRequest extends Request{
    private int max,min;
    private String username;
    private boolean isUserName;

    public SearchTableRequest() {
    }

    public SearchTableRequest(int max, int min, String username, boolean isUserName) {
        this.max = max;
        this.min = min;
        this.username = username;
        this.isUserName = isUserName;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isUserName() {
        return isUserName;
    }

    public void setUserName(boolean userName) {
        isUserName = userName;
    }
}
