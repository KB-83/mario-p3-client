package controller.offline_logic.gamelogic.enemieslogic;

import controller.offline_logic.gamestrucure.GameState;
import controller.offline_logic.modelstructure.entity.enemy.Enemy;
import controller.offline_logic.modelstructure.entity.enemy.Koopa;
import controller.offline_logic.tools.ObjectRemover;
import util.Constant;
import util.Sound;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KoopaLifeChecker extends EnemyLifeChecker{
    private GameState gameState;
    private Koopa koopa;
    private Timer waitingTimer;
    private long shotTime;
    private Sound sound = new Sound("KICK");
    public KoopaLifeChecker(GameState gameState, Enemy enemy) {
        this.koopa = (Koopa) enemy;
        this.gameState = gameState;
        setTimer();
    }
    private void setTimer(){
        waitingTimer = new Timer(1000/ Constant.FPS, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (System.currentTimeMillis() - shotTime <= 3000) {
                    koopa.setWaitingToDie(true);
                }
                else {
                    koopa.setVX(150);
                    koopa.setWaitingToDie(false);
                    waitingTimer.stop();
                }
            }
        });
    }


    public void kickedBybullet(){
        if (koopa.isWaitingToDie()){
            kill();
        }
        else {
            koopa.setVX(0);
            koopa.setWorldX(koopa.getWorldX() + 100);
            shotTime = System.currentTimeMillis();
            waitingTimer.start();
        }
    }

    @Override
    public void kickedBySward() {
        kill();
    }

    @Override
    public void kill() {
        sound.setSound("KICK");
        sound.play();
        gameState.getCurrentSection().setEnemies(ObjectRemover.removeObjectFromArray(gameState.getCurrentSection().getEnemies(), koopa));
        waitingTimer.stop();
    }

    @Override
    public void heatByHead() {
        if (koopa.isWaitingToDie()){
            kill();
        }
        else {
            koopa.setVX(0);
            koopa.setWorldX(koopa.getWorldX() + 100);
            shotTime = System.currentTimeMillis();
            waitingTimer.start();
        }
    }
}
