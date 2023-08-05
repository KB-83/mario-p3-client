package controller.listener;

import controller.LocalController;
import controller.offline_logic.requsethandler.PlayerRequestHandler;
import model.request.PlayerActionRequest;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerListener implements KeyListener {
    private LocalController controller ;
    private boolean isOfflineMode;
    private PlayerRequestHandler playerRequestHandler;//offline
    private final PlayerActionRequest request;
    private boolean isUpPressed, isDownPressed;
    private boolean isDuringSwardChecking;
    private Timer swardRequestTimer;
    private Timer letPlayerPressBothKeys;
    private boolean isDuringLetPlayerPressBothKeys;
    private long startPressingUpAndDown;
    private long lastSwardRequest;
    public PlayerListener(LocalController controller){
        request = new PlayerActionRequest();
        this.controller = controller;
        isDuringSwardChecking = false;
        isOfflineMode = false;
        setTimers();
    }

    public PlayerListener(PlayerRequestHandler playerRequestHandler) {
        request = new PlayerActionRequest();
        this.playerRequestHandler = playerRequestHandler;
        isDuringSwardChecking = false;
        isOfflineMode = true;
        setTimers();
    }

    private void setTimers() {
        letPlayerPressBothKeys = new Timer(100, new ActionListener() {
            int i = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                if (i<1){
                    isDuringLetPlayerPressBothKeys = true;
                    i++;
                }
                else {
                    i = 0;
                    isDuringLetPlayerPressBothKeys = false;
                    letPlayerPressBothKeys.stop();
                    if(isDownPressed && isUpPressed){
                        isDuringSwardChecking = true;
                        startSwardRequestTimer();
                    }
                    else if (isUpPressed) {
                        if (isOfflineMode) {
                            playerRequestHandler.jumpRequest();
                        }
                        else {
                            request.setType("jump");
                            controller.sendRequest(request);
                        }
                    }
                    else if (isDownPressed){
                        if (isOfflineMode) {
                            playerRequestHandler.SeatRequest();
                        }
                        else {
                            request.setType("seat");
                            controller.sendRequest(request);
                        }
                    }

                }
            }
        });

    }
    private void startSwardRequestTimer(){
        startPressingUpAndDown = System.currentTimeMillis();
        swardRequestTimer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isUpPressed && isDownPressed && System.currentTimeMillis() - startPressingUpAndDown >= 1000){

                    if (isOfflineMode) {
                        playerRequestHandler.SwardRequest();
                    }
                    else {
                        request.setType("sward");
                        controller.sendRequest(request);
                    }
                    swardRequestTimer.stop();
                    swardRequestTimer = null;
                    isDuringSwardChecking = false;
                    lastSwardRequest = System.currentTimeMillis();
                }
                else if (!(isUpPressed && isDownPressed)){
                    swardRequestTimer.stop();
                    swardRequestTimer = null;
                    isDuringSwardChecking = false;
                }
            }
        });
        swardRequestTimer.start();

    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (isDuringSwardChecking){
            return;
        }
        if(e.getKeyCode() == KeyEvent.VK_UP){
            isUpPressed = true;
            letPlayerPressBothKeys.start();
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN){
            isDownPressed = true;
            if(!isDuringLetPlayerPressBothKeys) {
                letPlayerPressBothKeys.start();
            }
        }
        else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            if (isOfflineMode) {
                playerRequestHandler.RightRequest();
            }
            else {
                request.setType(RequestType.RIGHT.getType());
                controller.sendRequest(request);
            }
        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT){
            if (isOfflineMode) {
                playerRequestHandler.LeftRequest();
            }
            else {
                request.setType(RequestType.LEFT.getType());
                controller.sendRequest(request);
            }
        }
        else if(e.getKeyCode() == KeyEvent.VK_SHIFT){
            if (isOfflineMode) {
                playerRequestHandler.BulletRequest();
            }
            else {
                request.setType(RequestType.BULLET.getType());
                controller.sendRequest(request);
            }
        }
        else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            if (isOfflineMode) {
//                playerRequestHandler.();
            }
                                    else{
                request.setType(RequestType.PAUSE.getType());
                controller.sendRequest(request);
            }
        }
        else if (e.getKeyCode() == KeyEvent.VK_D) {
            if (isOfflineMode) {}
            else {
                request.setType(RequestType.DAMAGE_BOMB.getType());
                controller.sendRequest(request);
            }
        }
        else if (e.getKeyCode() == KeyEvent.VK_H) {
            if (isOfflineMode) {}
            else {
                request.setType(RequestType.HEALTH_POTION.getType());
                controller.sendRequest(request);
            }
        }
        else if (e.getKeyCode() == KeyEvent.VK_B) {
            if (isOfflineMode) {}
            else {
                request.setType(RequestType.SPEED_POTION.getType());
                controller.sendRequest(request);
            }
        }
        else if (e.getKeyCode() == KeyEvent.VK_I) {
            if (isOfflineMode) {}
            else {
                request.setType(RequestType.INVISIBILITY_POTION.getType());
                controller.sendRequest(request);
            }
        }
        else if (e.getKeyCode() == KeyEvent.VK_S) {
            if (isOfflineMode) {}
            else {
                request.setType(RequestType.SPEED_POTION.getType());
                controller.sendRequest(request);
            }
        }
        else if (e.getKeyCode() == KeyEvent.VK_W) {
            if (isOfflineMode) {}
            else {
                request.setType(RequestType.HAMMER.getType());
                controller.sendRequest(request);
            }
        }
        //Todo : add swan timer request too

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP || System.currentTimeMillis() - lastSwardRequest < 500){
            isUpPressed = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            isDownPressed = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            if (isOfflineMode) {
                playerRequestHandler.rightDoneRequest();
            }
            else {
                request.setType(RequestType.RIGHT_DONE.getType());
                controller.sendRequest(request);
            }
        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT){
            if (isOfflineMode) {
                playerRequestHandler.leftDoneRequest();
            }
            else {
                request.setType(RequestType.LEFT_DONE.getType());
                controller.sendRequest(request);
            }
        }
//        else if(e.getKeyCode() == KeyEvent.VK_SHIFT){
//            playerRequestHandler.BulletRequest();
//        }
//        else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
//            playerRequestHandler.PauseRequest();
//        }
    }
}
