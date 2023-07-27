package model.request;

public class BuyRequest extends Request{
    private int hammer,speedPotion,healthPotion, inVisibilityPotion,speedBomb,damageBomb,sward;

    public BuyRequest() {
    }

    public BuyRequest(int hammer, int speedPotion, int healthPotion, int inVisibilityPotion, int speedBomb, int damageBomb, int sward) {
        this.hammer = hammer;
        this.speedPotion = speedPotion;
        this.healthPotion = healthPotion;
        this.inVisibilityPotion = inVisibilityPotion;
        this.speedBomb = speedBomb;
        this.damageBomb = damageBomb;
        this.sward = sward;
    }

    public int getHammer() {
        return hammer;
    }

    public void setHammer(int hammer) {
        this.hammer = hammer;
    }

    public int getSpeedPotion() {
        return speedPotion;
    }

    public void setSpeedPotion(int speedPotion) {
        this.speedPotion = speedPotion;
    }

    public int getHealthPotion() {
        return healthPotion;
    }

    public void setHealthPotion(int healthPotion) {
        this.healthPotion = healthPotion;
    }

    public int getInVisibilityPotion() {
        return inVisibilityPotion;
    }

    public void setInVisibilityPotion(int inVisibilityPotion) {
        this.inVisibilityPotion = inVisibilityPotion;
    }

    public int getSpeedBomb() {
        return speedBomb;
    }

    public void setSpeedBomb(int speedBomb) {
        this.speedBomb = speedBomb;
    }

    public int getDamageBomb() {
        return damageBomb;
    }

    public void setDamageBomb(int damageBomb) {
        this.damageBomb = damageBomb;
    }

    public int getSward() {
        return sward;
    }

    public void setSward(int sward) {
        this.sward = sward;
    }
}
