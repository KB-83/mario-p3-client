package controller.listener;

import controller.LocalController;
import model.request.RoomRequest;
import util.Config;
import view.Notification.CustomDialogPanel;
import view.menu.room.CreateRoomPanel;

import javax.swing.*;
import java.awt.*;

public class CreateRoomPanelListener {
    private LocalController localController;
    private CreateRoomPanel createRoomPanel;

    public CreateRoomPanelListener(LocalController localController, CreateRoomPanel createRoomPanel) {
        this.localController = localController;
        this.createRoomPanel = createRoomPanel;
    }
    public void createRoom() {

        String roomName = createRoomPanel.getRoomNameField().getText();
        String password = createRoomPanel.getPasswordField().getText();
        RoomRequest roomRequest = new RoomRequest(localController.getController().getClient().getUsername(),password,roomName);
        localController.sendRequest(roomRequest);

        // Add room information to the map
//        roomInfoMap.put(roomCounter, password);

        // Increment room ID counter
//        roomCounter++;

        // Show the room ID to the user
        //send room reques

    }
}
