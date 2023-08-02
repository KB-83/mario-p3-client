package controller.offline_logic.modelstructure.backgroundobject.pipe;

import controller.offline_logic.levelstructure.TeleSection;

public class SimpleTelePipe extends Pipe{
    private TeleSection teleSection;

    public SimpleTelePipe() {
    }

    public TeleSection getTeleSection() {
        return teleSection;
    }

    public void setTeleSection(TeleSection teleSection) {
        this.teleSection = teleSection;
    }
}
