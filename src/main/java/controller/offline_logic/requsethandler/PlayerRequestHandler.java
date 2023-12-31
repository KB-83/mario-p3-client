package controller.offline_logic.requsethandler;

import controller.offline_logic.gamestrucure.GameState;
import controller.offline_logic.gamestrucure.gameworldoption.Gravity;
import controller.offline_logic.modelstructure.backgroundobject.pipe.*;
import controller.offline_logic.modelstructure.entity.Bullet;
import controller.offline_logic.modelstructure.entity.Sward;
import controller.offline_logic.modelstructure.entity.player.JumpV0;
import controller.offline_logic.modelstructure.entity.player.Player;
import util.Sound;
import util.Constant;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class PlayerRequestHandler{
    private Player player;
    private GameState gameState;
    private int counter;
    private ActionListener jumpActionListener;
    private Timer jumpTimer;
    private double jumpStartTime;
    private Sound sound;
    private int jumpStartY;
    //todo: behtareh inaro be logic game pass bede

    public PlayerRequestHandler(GameState gameState) {
        this.player = gameState.getMario();
        player.setPlayerRequestHandler(this);
        this.gameState = gameState;
        sound = new Sound("BULLET");
        setActonListeners();

    }

    public void jumpRequest(){
        if(gameState.isPaused() || player.isDuringJump()){
            return;
        }
        player.setDuringJump(true);
        jumpTimer = new Timer(1000/Constant.FPS,jumpActionListener);
        setPlayerImageByState("JumpRight");
        setJumpDependencies();
        jumpTimer.start();
    }
    private void setJumpDependencies(){
        jumpStartTime = System.currentTimeMillis();
        jumpStartY = player.getWorldY();
    }
    public void RightRequest(){
        if(gameState.isPaused()){
            return;
        }
        // todo : make section v=changing mechanisem alright
//        if(player.getWorldX() >= Constant.PANEL_WIDTH){
//            gameState.getGameStateController().nextSection();
//            return;
//        }
        // todo : check next line
        player.setCameraY(player.getWorldY());
        if(counter < 2){
            setPlayerImageByState("Right1");
            counter++;
        }
        else if(counter < 4) {
            setPlayerImageByState("Right2");
            counter++;
        }
        else {
            counter = 0;
        }
        player.setVX(400);

    }
    public void rightDoneRequest(){
        player.setVX(0);
    }
    public void LeftRequest(){
        if(gameState.isPaused()){
            return;
        }
        if(counter < 2){
            setPlayerImageByState("Left1");
            counter++;
        }
        else if(counter < 4) {
            setPlayerImageByState("Left2");
            counter++;
        }
        else {
            counter = 0;
        }
        //todo : improve it
        player.setVX(-400);
    }
    public void leftDoneRequest(){
        player.setVX(0);
    }

    public void SeatRequest(){
        if(gameState.isPaused() || player.isDuringJump()){
            return;
        }
        //todo ; just a test
        if (player.getPlayerController().getPlayerCollisionHandler().isOnTopOfTelePipe() != null) {
            Pipe pipe = player.getPlayerController().getPlayerCollisionHandler().isOnTopOfTelePipe();
            String s = pipe.getClass().getSimpleName();
            sound.setSound("TELE_PIPE");
            sound.play();
            if (s.equals("TelePlantPipe")) {
                gameState.getGameStateController().changeSection(((TelePlantPipe) pipe).getTeleSection(),gameState.getSectionNumber());
            }
            else if(s.equals("SimpleTelePipe")) {
                gameState.getGameStateController().changeSection(((SimpleTelePipe) pipe).getTeleSection(),gameState.getSectionNumber());
            }
            else if(s.equals("SimpleSpawnPipe")) {
                gameState.getGameStateController().changeSection(((SimpleSpawnPipe) pipe).getSection(),gameState.getSectionNumber());
            }
            else if(s.equals("SpawnPlantPipe")) {
                gameState.getGameStateController().changeSection(((SpawnPlantPipe) pipe).getSection(),gameState.getSectionNumber());
            }
        }
        player.setWorldY(player.getWorldY()+10);
        player.setCameraY(player.getCameraY()+10);
    }
    public void SwardRequest(){
        if(gameState.isPaused()){
            return;
        }
//        && System.currentTimeMillis() - player.getSward().getLastTime() >= 5000 && gameState.getCoins() >=3
        if ( player.getOnTopOfBlock() && System.currentTimeMillis() - player.getSward().getLastTime() >= 5000 && gameState.getCoins() >=3){
            gameState.setCoins(gameState.getCoins()-3);
            Sward sward = player.getSward();
            sward.setImageAddress("Right");
            sward.setWorldX(player.getWorldX());
            sward.setGoingRight(true);
            if (player.getImageAddress().contains("Left")){
                sward.setGoingRight(false);
                sward.setImageAddress("Left");
                sward.setWorldX(player.getWorldX() - Constant.BACKGROUND_TILE_SIZE);
            }
            sward.setLock(false);
            if (player.getHeight() == Constant.BACKGROUND_TILE_SIZE){
                sward.setWorldY(player.getWorldY()+24);
            }
            else {
                //todo ; change it
                sward.setWorldY(player.getWorldY() + (72));
            }
            sward.setStartX(sward.getWorldX());
            sward.getTimer().start();
            sound.setSound("BULLET");
            sound.play();
        }
    }
    public void BulletRequest(){
        if(gameState.isPaused()){
            return;
        }
//        3000 is cool down
        if (player.isFire() && player.getOnTopOfBlock()  && System.currentTimeMillis() - player.getBullet().getLastTime() >= 3000){
            Bullet bullet = player.getBullet();
            bullet.setGoingRight(true);
            if (player.getImageAddress().contains("Left")){
                bullet.setGoingRight(false);
            }
            bullet.setLock(false);
            bullet.setWorldX(player.getWorldX());
            bullet.setWorldY(player.getWorldY() + (Constant.BACKGROUND_TILE_SIZE/2));
            bullet.setStartX(bullet.getWorldX());
            bullet.getTimer().start();
            sound.setSound("BULLET");
            sound.play();
        }
    }
    //todo : maybe pause request is for a user not a player
//    public void PauseRequest(){
//        gameState.setPaused(!gameState.isPaused());
//        if (gameState.isPaused()){
//            gameState.getClient().getLogicManager().getGraphicManager().getFrame().getPauseFrame().setVisible(true);
//            gameState.getClient().getLogicManager().getGraphicManager().getFrame().getPanelsManagerCard().getGamePanel().requestFocus();
//        }
//        else {
//
//            gameState.getClient().getLogicManager().getGraphicManager().getFrame().getPauseFrame().setVisible(false);
//            gameState.getClient().getLogicManager().getGraphicManager().getFrame().getPanelsManagerCard().getGamePanel().requestFocus();
//        }
//    }
    public void setActonListeners() {
        //jumpActionListener
        jumpActionListener = new ActionListener() {
            double deltaY = 0.1;
            double t = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                if (player.isDuringJump() && !gameState.isPaused()){
                    t = ( System.currentTimeMillis() - jumpStartTime) / 1000;
                    player.setVY ((-(Gravity.MARIO_GAME) * (t)) + JumpV0.MARIO.returnV0());
                    deltaY = -(((Gravity.MARIO_GAME/2)) * Math.pow(t, 2)) + (JumpV0.MARIO.returnV0() * t);
                }
                else {
                    player.setVY(0);
                    deltaY = 0;
                    t = 0;
                    // here means jump completed
                    setPlayerImageByState("Right1");
                    jumpTimer.stop();
                    player.setDuringJump(false);
                }

            }};

    }
    private void setPlayerImageByState(String s) {
        if (player.isFire()){
            player.setImageAddress("fireMario"+s);
        }
        else if (player.isMega()){
            player.setImageAddress("megaMario"+s);
        }
        else {
            player.setImageAddress("mario"+s);
        }
    }



    public Timer getJumpTimer() {
        return jumpTimer;
    }
}