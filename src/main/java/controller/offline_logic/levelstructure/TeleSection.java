package controller.offline_logic.levelstructure;

import controller.offline_logic.modelstructure.backgroundobject.pipe.Pipe;

public class TeleSection extends Section{
    private Section section;
    private Pipe spwanPipe;

    public TeleSection() {
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
}
