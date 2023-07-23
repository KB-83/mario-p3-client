package view.menu;

import controller.LocalController;
import model.request.MarathonRequest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ChooseOnlineGamePanel extends MarioPanel{
    private JButton scoreGame = new JButton("score game");
    private JButton createRoom = new JButton("create room");
    private JButton enterRoom = new JButton("enter room");
    private PanelsManagerCard panelsManagerCard;
    private LocalController localController;
    public ChooseOnlineGamePanel(LocalController localController, PanelsManagerCard panelsManagerCard) {
        this.panelsManagerCard = panelsManagerCard;
        this.localController = localController;
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
        scoreGame.addActionListener(this);
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
        if (e.getSource() == scoreGame) {
            MarathonRequest marathonRequest = new MarathonRequest();
            localController.sendRequest(marathonRequest);
        }
    }

}
