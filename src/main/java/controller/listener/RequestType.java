package controller.listener;

public enum RequestType {
    RIGHT("right"),
    LEFT("left"),
    RIGHT_DONE("rightD"),
    LEFT_DONE("leftD"),
    JUMP("jump"),
    SEAT("seat"),
    BULLET("bullet"),
    PAUSE("pause"),
    DAMAGE_BOMB("damageBomb"),
    HEALTH_POTION("healthPotion"),
    SPEED_BOMB("speedBomb"),
    INVISIBILITY_POTION("invisibilityPotion"),
    SPEED_POTION("speedPotion"),
    HAMMER("hammer");

    public final String type;

    RequestType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
    @Override
    public String toString() {
        return type;
    }
}

