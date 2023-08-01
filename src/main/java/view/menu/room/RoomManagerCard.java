package view.menu.room;

import controller.LocalController;
import view.Frame;
import view.menu.*;

import java.awt.*;
import java.awt.event.ActionEvent;

public class RoomManagerCard extends MarioPanel{
    private Frame frame;
    private ManagerOfRoomPanel managerOfRoomPanel;
    private SimpleRoomPanel simpleRoomPanel;
    private CreateRoomPanel createRoomPanel;
    private EnterRoomPanel enterRoomPanel;
    //layout
    private CardLayout cardLayout;
    public RoomManagerCard(Frame frame, LocalController localController){
        this.frame = frame;
        setDependencies(localController);

    }

    public void setDependencies(LocalController localController) {
        cardLayout = new CardLayout();
        managerOfRoomPanel = new ManagerOfRoomPanel(localController);
        createRoomPanel = new CreateRoomPanel(localController);
        enterRoomPanel = new EnterRoomPanel(localController);
        simpleRoomPanel = new SimpleRoomPanel(localController);

        setUI();

    }

    public void addPanels() {
//        Config config = getClassConfig(this.getClass());
//
        add(managerOfRoomPanel, managerOfRoomPanel.getClass().getSimpleName());
        add(createRoomPanel,createRoomPanel.getClass().getSimpleName());
        add(enterRoomPanel,enterRoomPanel.getClass().getSimpleName());
        add(simpleRoomPanel,simpleRoomPanel.getClass().getSimpleName());

        revalidate();

    }

    // panels will be added later
    //info

    @Override
    public void setUI() {
        setLayout(cardLayout);
        setFocusable(false);
        setPreferredSize(new Dimension(1248, 720));

        addPanels();
    }

    @Override
    public void setOffline(boolean offline) {

    }

//    public void setCurrentUser(User user){
//        mainMenu.setUser();
//        shopPanel.setUser();
//        profilePanel.setUser();
//        newGamePanel.setUser();
//        lastGamesPanel.setUser();
//        gamePanel.setCurrentUser(user);
//    }

    public Frame getFrame() {
        return frame;
    }
    public CardLayout getCardLayout() {
        return cardLayout;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public ManagerOfRoomPanel getManagerPanel() {
        return managerOfRoomPanel;
    }

    public CreateRoomPanel getCreateRoomPanel() {
        return createRoomPanel;
    }

    public EnterRoomPanel getEnterRoomPanel() {
        return enterRoomPanel;
    }

    public SimpleRoomPanel getSimpleRoomPanel() {
        return simpleRoomPanel;
    }
}
