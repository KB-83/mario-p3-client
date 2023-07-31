package view.menu.room;

import view.menu.MarioPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class CreateRoomPanel extends MarioPanel {
    private JTextField roomNameField;
    private JTextField passwordField;
    private JButton createRoomButton;
    private static Map<Integer, String> roomInfoMap = new HashMap<>();

    public CreateRoomPanel() {
        // Create UI elements
        roomNameField = new JTextField(15);
        passwordField = new JTextField(15);
        createRoomButton = new JButton("Create Room");

        // Add action listener to the button
        createRoomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createRoom();
            }
        });

        // Add elements to the panel
        add(new JLabel("Room Name: "));
        add(roomNameField);
        add(new JLabel("Password (optional): "));
        add(passwordField);
        add(createRoomButton);
    }

    private void createRoom() {
        String roomName = roomNameField.getText();
        String password = passwordField.getText();

        // Add room information to the map
//        roomInfoMap.put(roomCounter, password);

        // Increment room ID counter
//        roomCounter++;

        // Show the room ID to the user
        //send room reques
        JOptionPane.showMessageDialog(this, "Room created!\nRoom ID: " );
    }

    @Override
    public void setUI() {

    }

    @Override
    public void setOffline(boolean offline) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
