package controller.offline_logic.modelstructure.backgroundobject.pipe;

import controller.offline_logic.modelstructure.entity.enemy.Plant;

public class SimplePlantPipe extends Pipe{
    private Plant plant;

    public SimplePlantPipe() {
    }

    public Plant getPlant() {
        return plant;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
    }
}
