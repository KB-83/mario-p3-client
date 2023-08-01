package model.request;

import model.Massage;

public class SendPMRequest extends Request{
    private Massage massage;

    public SendPMRequest() {
    }

    public SendPMRequest(Massage massage) {
        this.massage = massage;
    }

    public Massage getMassage() {
        return massage;
    }

    public void setMassage(Massage massage) {
        this.massage = massage;
    }
}
