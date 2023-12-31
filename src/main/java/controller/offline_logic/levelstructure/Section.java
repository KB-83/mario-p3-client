package controller.offline_logic.levelstructure;

import com.fasterxml.jackson.annotation.JsonIgnore;
import controller.offline_logic.modelstructure.backgroundobject.CheckPoint;
import controller.offline_logic.modelstructure.backgroundobject.block.Block;
import controller.offline_logic.modelstructure.backgroundobject.pipe.Pipe;
import controller.offline_logic.modelstructure.entity.enemy.Enemy;
import controller.offline_logic.modelstructure.entity.item.Item;
import controller.offline_logic.modelstructure.worldtiles.BackgroundMap;
import util.Constant;

public class Section {
    private int length;
    private int time;
    private Block[] blocks = new Block[0];
    private Enemy[] enemies = new Enemy[0];
    private Pipe[] pipes = new Pipe[0];
    private Pipe spawnPipe;
    @JsonIgnore
    private BackgroundMap backgroundMap;
    private CheckPoint checkPoint;
    @JsonIgnore
    private Item[] items = new Item[0];
    public Section(){
    }

    public Section(int levelNum,int sectionNum,int cols) {
        backgroundMap = new BackgroundMap();
        backgroundMap.loadMap(levelNum,sectionNum,cols, Constant.PANEL_ROWS);

    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Block[] getBlocks() {
        return blocks;
    }

    public void setBlocks(Block[] blocks) {
        this.blocks = blocks;
    }

    public Enemy[] getEnemies() {
        return enemies;
    }

    public void setEnemies(Enemy[] enemies) {
        this.enemies = enemies;
    }

    public Pipe[] getPipes() {
        return pipes;
    }

    public void setPipes(Pipe[] pipes) {
        this.pipes = pipes;
    }

    public BackgroundMap getBackgroundMap() {
        return backgroundMap;
    }

    public void setBackgroundMap(BackgroundMap backgroundMap) {
        this.backgroundMap = backgroundMap;
    }

    public Pipe getSpawnPipe() {
        return spawnPipe;
    }

    public void setSpawnPipe(Pipe spawnPipe) {
        this.spawnPipe = spawnPipe;
    }

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public CheckPoint getCheckPoint() {
        return checkPoint;
    }

    public void setCheckPoint(CheckPoint checkPoint) {
        this.checkPoint = checkPoint;
    }
}
