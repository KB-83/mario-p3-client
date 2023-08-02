package controller.offline_logic.gamestrucure;

import com.fasterxml.jackson.annotation.JsonIgnore;
import controller.offline_logic.gamelogic.collisionlogic.BulletCollisionHandler;
import controller.offline_logic.gamelogic.collisionlogic.SwardCollisionHandler;
import controller.offline_logic.levelstructure.Level;
import controller.offline_logic.levelstructure.Section;
import controller.offline_logic.gamelogic.gamestatelogic.GameStateController;
import controller.offline_logic.modelstructure.backgroundobject.CheckPoint;
import controller.offline_logic.modelstructure.entity.player.Mario;
import model.Client;
import util.Sound;
import util.Loop;

public class GameState {
    //M-S-GS-O-T
    //marathon-survival-group_survival-offline-team
    private String type;
    private String name;
    @JsonIgnore
    private GameStateController gameStateController;
    @JsonIgnore
    private Client client;
    private Level[] levels;
    @JsonIgnore
    private Level currentLevel;
    @JsonIgnore
    private Section currentSection;
    private Mario mario;
    // 0 : mini //  1 : mega // 2 : fire
    private int marioState;
    @JsonIgnore
    private Loop gameloop;
    @JsonIgnore
    private boolean isMute;
    @JsonIgnore
    private  SwardCollisionHandler swardCollisionHandler;
    @JsonIgnore
    private BulletCollisionHandler bulletCollisionHandler;
    @JsonIgnore
    private Sound sound;
    private int levelNumber;
    private int sectionNumber;
    private int coins;
    private int score;
    private int remainingHeart;
    private int remainingTime;
    @JsonIgnore
    private boolean isPaused;
    @JsonIgnore
    private CheckPoint waitingCheckpoint;
    // todo : test

    public GameState() {
    }
    public GameState(GameStateController gameStateController) {
        this.gameStateController = gameStateController;
        sound = new Sound("MAIN2");
        swardCollisionHandler = new SwardCollisionHandler(this);
        bulletCollisionHandler = new BulletCollisionHandler(this);
        setType("O");
    }
    public void setDefaultDependencies(){
        sound = new Sound("MAIN2");
        swardCollisionHandler = new SwardCollisionHandler(this);
        bulletCollisionHandler = new BulletCollisionHandler(this);
    }
//    public GameState(User user , Game game , Player player,GameStateController gameStateController) {
//        currentUser = user;
//        currentLevel = game.getLevels()[0];
//        currentSection = currentLevel.getSections()[0];
//        levels = game.getLevels();
//        this.player = player;
//        levelNumber = 1;
//        sectionNumber = 1;
//        coins = 0;
//        score = 0;
//        remainingHeart = game.getHearts();
//        remainingTime = currentSection.getTime();
//        isPaused = false;
//        playerItemEater = new PlayerItemEater(this);
//    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }


    public Level getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(Level currentLevel) {
        this.currentLevel = currentLevel;
    }

    public Section getCurrentSection() {
        return currentSection;
    }

    public void setCurrentSection(Section currentSection) {
        this.currentSection = currentSection;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getRemainingHeart() {
        return remainingHeart;
    }

    public void setRemainingHeart(int remainingHeart) {
        this.remainingHeart = remainingHeart;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }

    public boolean isPaused() {
        return isPaused;
    }

    public void setPaused(boolean paused) {
        isPaused = paused;
    }

    public int getSectionNumber() {
        return sectionNumber;
    }

    public void setSectionNumber(int sectionNumber) {
        this.sectionNumber = sectionNumber;
    }

    public Loop getGameloop() {
        return gameloop;
    }

    public void setGameLoop(Loop gameloop) {
        this.gameloop = gameloop;
    }

    public GameStateController getGameStateController() {
        return gameStateController;
    }

    public void setGameStateController(GameStateController gameStateController) {
        this.gameStateController = gameStateController;
    }
    public GameState(SwardCollisionHandler swardCollisionHandler) {
        this.swardCollisionHandler = swardCollisionHandler;
    }

    public Sound getSound() {
        return sound;
    }

    public void setSound(Sound sound) {
        this.sound = sound;
    }

    public int getMarioState() {
        return marioState;
    }

    public void setMarioState(int marioState) {
        this.marioState = marioState;
    }

    public CheckPoint getWaitingCheckpoint() {
        return waitingCheckpoint;
    }

    public void setWaitingCheckpoint(CheckPoint waitingCheckpoint) {
        this.waitingCheckpoint = waitingCheckpoint;
    }

    public Level[] getLevels() {
        return levels;
    }

    public void setLevels(Level[] levels) {
        this.levels = levels;
    }

    public Mario getMario() {
        return mario;
    }

    public void setMario(Mario mario) {
        this.mario = mario;
    }
    public SwardCollisionHandler getSwardCollisionHandler() {
        return swardCollisionHandler;
    }

    public void setSwardCollisionHandler(SwardCollisionHandler swardCollisionHandler) {
        this.swardCollisionHandler = swardCollisionHandler;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BulletCollisionHandler getBulletCollisionHandler() {
        return bulletCollisionHandler;
    }

    public void setBulletCollisionHandler(BulletCollisionHandler bulletCollisionHandler) {
        this.bulletCollisionHandler = bulletCollisionHandler;
    }

    public void setGameloop(Loop gameloop) {
        this.gameloop = gameloop;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
