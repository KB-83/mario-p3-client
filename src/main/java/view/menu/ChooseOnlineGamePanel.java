package view.menu;

import controller.LocalController;
import model.request.GroupGameRequest;
import model.request.GroupSurvivalRequest;
import view.menu.bag.BagPanel;
import view.menu.room.CreateRoomPanel;
import view.menu.room.EnterRoomPanel;
import view.menu.room.RoomManagerCard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ChooseOnlineGamePanel extends MarioPanel{
    private JButton scoreGame = createStyledButton("score game");
    private JButton groupGame = createStyledButton("group game");
    private JButton createRoom = createStyledButton("create room");
    private JButton enterRoom = createStyledButton("enter room");
    private JButton bagSetting = createStyledButton("bag setting");
    private JButton back = createStyledButton("back");
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


        scoreGame.addActionListener(this);
        createRoom.addActionListener(this);
        enterRoom.addActionListener(this);
        bagSetting.addActionListener(this);
        groupGame.addActionListener(this);
        back.addActionListener(this);

        add(scoreGame);
        add(groupGame);
        add(createRoom);
        add(enterRoom);
        add(bagSetting);
        add(back);

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
        else if (e.getSource() == enterRoom) {
            panelsManagerCard.getRoomManager().getCardLayout().show(panelsManagerCard.getRoomManager(), EnterRoomPanel.class.getSimpleName());
            panelsManagerCard.getCardLayout().show(panelsManagerCard, RoomManagerCard.class.getSimpleName());
        }
        else if (e.getSource() == createRoom) {
            panelsManagerCard.getRoomManager().getCardLayout().show(panelsManagerCard.getRoomManager(), CreateRoomPanel.class.getSimpleName());
            panelsManagerCard.getCardLayout().show(panelsManagerCard, RoomManagerCard.class.getSimpleName());
        }
        else if (e.getSource() == bagSetting) {
            panelsManagerCard.getCardLayout().show(panelsManagerCard, BagPanel.class.getSimpleName());
            panelsManagerCard.getBagPanel().requestFocus();
        }
        else if(e.getSource() == back) {
            panelsManagerCard.getCardLayout().show(panelsManagerCard, MainMenu.class.getSimpleName());
            panelsManagerCard.getBagPanel().requestFocus();
        }
        else if (e.getSource() == groupGame) {
            GroupGameRequest groupGameRequest = new GroupGameRequest();
            localController.sendRequest(groupGameRequest);
        }
    }

}
