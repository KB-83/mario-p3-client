package view.menu.room;

import controller.LocalController;
import controller.listener.EnterRoomPanelListener;
import view.menu.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class EnterRoomPanel extends MarioPanel{
    private EnterRoomPanelListener listener;
    private LocalController localController;
    private JTextField roomToken = createStyledTextField("token",true,17);
    private JButton enter = createStyledButton("enter");
    private JButton back = createStyledButton("back");
    private final JComboBox<String> type = createStyledComboBox(new String[]{"player","viewer"});

    EnterRoomPanel(LocalController localController) {
        this.localController = localController;
        listener = new EnterRoomPanelListener(localController,this);
        setUI();
    }

    @Override
    public void setUI() {
        setBackground(MarioPanel.MENU_COLOR);
        setLayout(new GridBagLayout());
        setButtonsBounds();
    }

    @Override
    public void setOffline(boolean offline) {
    }

    private void setButtonsBounds() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 5, 5, 5); // Add some padding
            // Add the buttons one by one
        constraints.gridx = 0;
        constraints.gridy = 0;
        add(roomToken, constraints);

        constraints.gridy++;
        add(type, constraints);

        constraints.gridy++;
        add(enter, constraints);
        enter.addActionListener(this);

        constraints.gridy++;
        add(back, constraints);
        back.addActionListener(this);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == enter) {
            listener.enterRoom();
        }
        else if (e.getSource() == back) {
            PanelsManagerCard panelsManagerCard = localController.getFrame().getPanelsManagerCard();
            panelsManagerCard.getCardLayout().show(panelsManagerCard,ChooseOnlineGamePanel.class.getSimpleName());
        }
    }

    public JTextField getRoomToken() {
        return roomToken;
    }

    public JComboBox<String> getType() {
        return type;
    }
}
