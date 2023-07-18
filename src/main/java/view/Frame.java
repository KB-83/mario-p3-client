package view;

import controller.LocalController;
import view.menu.PanelsManagerCard;

import javax.swing.*;

public class Frame extends JFrame {
    private LocalController controller;
    private PanelsManagerCard panelsManagerCard;
    private CheckPointFrame checkPointFrame;
    private PauseFrame pauseFrame;
    public Frame(LocalController localController){
        this.controller = localController;
        setDependencies(localController);
    }
    private void setDependencies(LocalController localController){

        this.panelsManagerCard = new PanelsManagerCard(this,localController);
        this.checkPointFrame = new CheckPointFrame(this);
        this.pauseFrame = new PauseFrame(this);
        setFocusable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        add(panelsManagerCard);
        pack();// check
        setLocationRelativeTo(null);
        revalidate();
        setVisible(true);

    }
    public void paintAll(){
        this.panelsManagerCard.repaint();
    }
    //test


    public PanelsManagerCard getPanelsManagerCard() {
        return panelsManagerCard;
    }

    public void setPanelsManagerCard(PanelsManagerCard panelsManagerCard) {
        this.panelsManagerCard = panelsManagerCard;
    }
    public CheckPointFrame getCheckPointFrame() {
        return checkPointFrame;
    }

    public void setCheckPointFrame(CheckPointFrame checkPointFrame) {
        this.checkPointFrame = checkPointFrame;
    }

    public PauseFrame getPauseFrame() {
        return pauseFrame;
    }

    public void setPauseFrame(PauseFrame pauseFrame) {
        this.pauseFrame = pauseFrame;
    }
}
