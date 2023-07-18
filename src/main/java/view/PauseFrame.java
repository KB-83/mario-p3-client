package view;

import view.Frame;

import javax.swing.*;
import java.awt.*;

public class PauseFrame extends JFrame {
    private JButton saveGameAndExit;
    private JButton soundButton;
    private view.Frame frame;

    public PauseFrame(Frame frame) {
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setResizable(false);
        this.frame = frame;
        setTitle("pause panel");
        setSize(200,100);
        setLayout(new FlowLayout());

        saveGameAndExit = new JButton("save and exit");
        soundButton = new JButton("Mute/unMute");

        saveGameAndExit.addActionListener(e -> {
//            frame.getGraphicManager().getLogicManager().getUser().getCurrentGameState().
//                    getGameStateController().saveAndPauseRequest();
            setVisible(false);
        });

        soundButton.addActionListener(e -> {
            setVisible(false);
//            frame.getGraphicManager().getUser().getCurrentGameState().setPaused(false);
//            frame.getGraphicManager().getUser().getCurrentGameState().getGameStateController().muteRequest();
        });
        add(soundButton);
        add(saveGameAndExit);
        setLocationRelativeTo(null);


    }
}