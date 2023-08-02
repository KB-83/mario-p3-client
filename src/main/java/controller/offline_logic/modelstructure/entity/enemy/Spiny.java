package controller.offline_logic.modelstructure.entity.enemy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import controller.offline_logic.gamelogic.enemieslogic.SpinyController;

public class Spiny extends Enemy {
    @JsonIgnore
    private SpinyController spinyController;
    public Spiny() {
        setVX(100);
    }

    public SpinyController getSpinyController() {
        return spinyController;
    }

    public void setSpinyController(SpinyController spinyController) {
        this.spinyController = spinyController;
    }
}
