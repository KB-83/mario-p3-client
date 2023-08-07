package model.request;

public class SearchChatRequest extends Request{
    private String username;
    public SearchChatRequest() {
    }

    public SearchChatRequest(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
