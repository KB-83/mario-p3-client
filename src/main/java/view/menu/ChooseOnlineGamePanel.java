package view.menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ChooseOnlineGamePanel extends MarioPanel{
    JButton scoreGame = new JButton("score game");
    JButton createRoom = new JButton("create room");
    JButton enterRoom = new JButton("enter room");
    public ChooseOnlineGamePanel() {
        setUI();

        }


    @Override
    public void setUI() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(Box.createVerticalGlue());

        scoreGame.setAlignmentX(Component.CENTER_ALIGNMENT);
        createRoom.setAlignmentX(Component.CENTER_ALIGNMENT);
        enterRoom.setAlignmentX(Component.CENTER_ALIGNMENT);

        Dimension dimension = new Dimension(150,40);
        scoreGame.setPreferredSize(dimension);
        createRoom.setPreferredSize(dimension);
        enterRoom.setPreferredSize(dimension);

        scoreGame.setFocusable(false);
        createRoom.setFocusable(false);
        enterRoom.setFocusable(false);

        add(scoreGame);
        add(createRoom);
        add(enterRoom);

        add(Box.createVerticalGlue());
    }

    @Override
    public void setOffline(boolean offline) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
