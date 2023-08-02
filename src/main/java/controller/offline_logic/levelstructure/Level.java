package controller.offline_logic.levelstructure;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import controller.offline_logic.datahandler.CustomLevelLoader;
import controller.offline_logic.datahandler.CustomLevelSaver;

@JsonDeserialize(using = CustomLevelLoader.class)
@JsonSerialize(using = CustomLevelSaver.class)

public class Level {
    private Section[] sections;

    public Level() {
    }

    public Level(Section[] sections) {
        this.sections = sections;
    }

    public Section[] getSections() {
        return sections;
    }

    public void setSections(Section[] sections) {
        this.sections = sections;
    }
}
