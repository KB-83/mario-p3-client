package controller.offline_logic.modelstructure.entity.enemy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import controller.offline_logic.gamelogic.enemieslogic.KoopaController;

public class Koopa extends Enemy{
    @JsonIgnore
    private KoopaController koopaController;
    private boolean isWaitingToDie;
    public Koopa() {
        setVX(100);
        isWaitingToDie = false;
    }

    public KoopaController getKoopaController() {
        return koopaController;
    }

    public void setKoopaController(KoopaController koopaController) {
        this.koopaController = koopaController;
    }

    public boolean isWaitingToDie() {
        return isWaitingToDie;
    }

    public void setWaitingToDie(boolean waitingToDie) {
        isWaitingToDie = waitingToDie;
    }
}
