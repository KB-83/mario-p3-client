package controller.offline_logic.modelstructure.entity.enemy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import controller.offline_logic.gamelogic.enemieslogic.GoombaController;

public class Goomba extends Enemy{
    @JsonIgnore
    private GoombaController goombaController;
    public Goomba() {
        setImageAddress("/image/enemies/Goompa.png");
        setVX(100);
    }

    public GoombaController getGoombaController() {
        return goombaController;
    }

    public void setGoombaController(GoombaController goombaController) {
        this.goombaController = goombaController;
    }
}
