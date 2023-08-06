package view.menu;

import controller.LocalController;
import view.menu.bag.BagPanel;
import view.menu.room.CreateRoomPanel;
import view.menu.room.EnterRoomPanel;
import view.menu.room.RoomManagerCard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ChooseOnlineGamePanel extends MarioPanel{
    private JButton scoreGame = createStyledButton("score game");
    private JButton createRoom = createStyledButton("create room");
    private JButton enterRoom = createStyledButton("enter room");
    private JButton bagSetting = createStyledButton("bag setting");
    private PanelsManagerCard panelsManagerCard;
    private LocalController localController;
    public ChooseOnlineGamePanel(LocalController localController, PanelsManagerCard panelsManagerCard) {
        this.panelsManagerCard = panelsManagerCard;
        this.localController = localController;
        setUI();
    }


    @Override
    public void setUI() {
        setBackground(MarioPanel.MENU_COLOR);
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
        createRoom.addActionListener(this);
        enterRoom.setFocusable(false);
        enterRoom.addActionListener(this);
        bagSetting.setFocusable(false);
        bagSetting.addActionListener(this);

        add(scoreGame);
        add(createRoom);
        add(enterRoom);
        add(bagSetting);

        add(Box.createVerticalGlue());
    }

    @Override
    public void setOffline(boolean offline) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == scoreGame) {
            panelsManagerCard.getCardLayout().show(panelsManagerCard,OnlineGamePanel.class.getSimpleName());
        }
        if (e.getSource() == enterRoom) {
            panelsManagerCard.getRoomManager().getCardLayout().show(panelsManagerCard.getRoomManager(), EnterRoomPanel.class.getSimpleName());
            panelsManagerCard.getCardLayout().show(panelsManagerCard, RoomManagerCard.class.getSimpleName());
        }
        if (e.getSource() == createRoom) {
            panelsManagerCard.getRoomManager().getCardLayout().show(panelsManagerCard.getRoomManager(), CreateRoomPanel.class.getSimpleName());
            panelsManagerCard.getCardLayout().show(panelsManagerCard, RoomManagerCard.class.getSimpleName());
        }
        if (e.getSource() == bagSetting) {
            panelsManagerCard.getCardLayout().show(panelsManagerCard, BagPanel.class.getSimpleName());
            panelsManagerCard.getBagPanel().requestFocus();
        }
    }

}
