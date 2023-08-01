package view.menu.room;

import controller.LocalController;
import controller.listener.CreateRoomPanelListener;
import view.menu.MarioPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
public class CreateRoomPanel extends MarioPanel {
    private CreateRoomPanelListener listener;
    private JTextField roomNameField;
    private JTextField passwordField;
    private JButton createRoomButton;
    private JLabel roomNameLabel = createStyledLabel("Room Name: ",true);
    private JLabel roomPassLabel = createStyledLabel("Password (optional): ",true);
    private JButton backButton;
    private JPanel backButtonPanel;
    private JPanel mainPanel;
    private JPanel roomNamePanel;
    private JPanel passwordPanel;

    public CreateRoomPanel(LocalController localController) {
        listener = new CreateRoomPanelListener(localController,this);
        setUI();

    }



    @Override
    public void setUI() {
        setLayout(new BorderLayout());
        setBackground(MarioPanel.DARK_COLOR);

        backButton = createButton("< ");
        backButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        backButtonPanel.setOpaque(false);
        backButtonPanel.add(backButton);
        backButton.addActionListener(this);
        add(backButtonPanel, BorderLayout.NORTH);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setOpaque(false);

        roomNameField = createStyledTextField("", true, 12);
        roomNameLabel = createStyledLabel("Room Name:",false);
        roomNamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        roomNamePanel.setOpaque(false);
        roomNamePanel.add(roomNameLabel);
        roomNamePanel.add(roomNameField);

        passwordField = createStyledTextField("", true, 12);
        roomPassLabel = createStyledLabel("Password:",false);
        passwordPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        passwordPanel.setOpaque(false);
        passwordPanel.add(roomPassLabel);
        passwordPanel.add(passwordField);

        createRoomButton = createButton("Create Room");
        createRoomButton.addActionListener(this);

        mainPanel.add(roomNamePanel);
        mainPanel.add(passwordPanel);
        mainPanel.add(createRoomButton);

        add(mainPanel, BorderLayout.CENTER);
    }
    @Override
    public void setOffline(boolean offline) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == createRoomButton) {
            listener.createRoom();
        }
        if (e.getSource() == backButton) {
            listener.backButton();
        }
    }

    public JTextField getRoomNameField() {
        return roomNameField;
    }

    public void setRoomNameField(JTextField roomNameField) {
        this.roomNameField = roomNameField;
    }

    public JTextField getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(JTextField passwordField) {
        this.passwordField = passwordField;
    }
}
