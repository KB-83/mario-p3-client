package model.request;

public class BuyRequest extends Request{
    private int hammer,speedPotion,healthPotion, invisibilityPotion,speedBomb,damageBomb,sward;

    public BuyRequest() {
    }

    public BuyRequest(int hammer, int speedPotion, int healthPotion, int invisibilityPotion, int speedBomb, int damageBomb, int sward) {
        this.hammer = hammer;
        this.speedPotion = speedPotion;
        this.healthPotion = healthPotion;
        this.invisibilityPotion = invisibilityPotion;
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

    public int getInvisibilityPotion() {
        return invisibilityPotion;
    }

    public void setInvisibilityPotion(int invisibilityPotion) {
        this.invisibilityPotion = invisibilityPotion;
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
