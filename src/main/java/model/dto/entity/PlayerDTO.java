package model.dto.entity;

import java.awt.*;

public class PlayerDTO {
    private int x,y;
    private int cameraX, cameraY;
    private String type;
    private int height;
    private String  image;
    private String name;
    private int remainingLifePercent;
    private int teamColor;
    private PowerItemDTO powerItemDTO;
    private boolean isInvisible;
    private String[] selectedBag;

    public PlayerDTO() {
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getCameraX() {
        return cameraX;
    }

    public void setCameraX(int cameraX) {
        this.cameraX = cameraX;
    }

    public int getCameraY() {
        return cameraY;
    }

    public void setCameraY(int cameraY) {
        this.cameraY = cameraY;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRemainingLifePercent() {
        return remainingLifePercent;
    }

    public void setRemainingLifePercent(int remainingLifePercent) {
        this.remainingLifePercent = remainingLifePercent;
    }

    public int getTeamColor() {
        return teamColor;
    }

    public void setTeamColor(int teamColor) {
        this.teamColor = teamColor;
    }
    public PowerItemDTO getPowerItemDTO() {
        return powerItemDTO;
    }

    public void setPowerItemDTO(PowerItemDTO powerItemDTO) {
        this.powerItemDTO = powerItemDTO;
    }

    public String[] getSelectedBag() {
        return selectedBag;
    }

    public void setSelectedBag(String[] selectedBag) {
        this.selectedBag = selectedBag;
    }

    public boolean isInvisible() {
        return isInvisible;
    }

    public void setInvisible(boolean invisible) {
        isInvisible = invisible;
    }
}
