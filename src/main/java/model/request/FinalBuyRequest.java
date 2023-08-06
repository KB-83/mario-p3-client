package model.request;

import model.response.BuyResponse;

public class FinalBuyRequest extends Request{
    private BuyResponse buyResponse;

    public FinalBuyRequest() {
    }

    public FinalBuyRequest(BuyResponse buyResponse) {
        this.buyResponse = buyResponse;
    }

    public BuyResponse getBuyResponse() {
        return buyResponse;
    }

    public void setBuyResponse(BuyResponse buyResponse) {
        this.buyResponse = buyResponse;
    }
}
