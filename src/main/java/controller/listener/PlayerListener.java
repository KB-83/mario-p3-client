package controller.listener;

import controller.LocalController;
import model.request.PlayerActionRequest;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerListener implements KeyListener {
    private LocalController controller;
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
                        request.setType("jump");
                        controller.sendRequest(request);
                    }
                    else if (isDownPressed){
                        request.setType("seat");
                        controller.sendRequest(request);
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
                    request.setType("sward");
                    controller.sendRequest(request);
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
            request.setType("right");
            controller.sendRequest(request);
        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT){
            request.setType("left");
            controller.sendRequest(request);
        }
        else if(e.getKeyCode() == KeyEvent.VK_SHIFT){
            request.setType("bullet");
            controller.sendRequest(request);
        }
        else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            request.setType("pause");
            controller.sendRequest(request);
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
            request.setType("rightD");
            controller.sendRequest(request);
        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT){
            request.setType("leftD");
            controller.sendRequest(request);
        }
//        else if(e.getKeyCode() == KeyEvent.VK_SHIFT){
//            playerRequestHandler.BulletRequest();
//        }
//        else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
//            playerRequestHandler.PauseRequest();
//        }
    }
}
