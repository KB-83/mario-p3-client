package model.dto.game;

import com.fasterxml.jackson.annotation.JsonIgnore;
import model.dto.entity.PlayerDTO;

import java.util.ArrayList;

public class GameStateDTO {
    private SectionDTO currentSection;
    private ArrayList<PlayerDTO> playerDTOS;
    @JsonIgnore
    private int sectionNumber, levelNumber;

    public GameStateDTO() {
    }

    public SectionDTO getCurrentSection() {
        return currentSection;
    }

    public void setCurrentSection(SectionDTO currentSection) {
        this.currentSection = currentSection;
    }

    public ArrayList<PlayerDTO> getPlayerDTOS() {
        return playerDTOS;
    }

    public void setPlayerDTOS(ArrayList<PlayerDTO> playerDTOS) {
        this.playerDTOS = playerDTOS;
    }

    public int getSectionNumber() {
        return sectionNumber;
    }

    public void setSectionNumber(int sectionNumber) {
        this.sectionNumber = sectionNumber;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }
}
