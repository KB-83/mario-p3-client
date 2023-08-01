package controller.listener;

import controller.LocalController;
import model.request.CreateRoomRequest;
import view.menu.ChooseOnlineGamePanel;
import view.menu.PanelsManagerCard;
import view.menu.room.CreateRoomPanel;

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
        CreateRoomRequest createRoomRequest = new CreateRoomRequest(localController.getController().getClient().getUsername(),password,roomName);
        localController.sendRequest(createRoomRequest);

        // Add room information to the map
//        roomInfoMap.put(roomCounter, password);

        // Increment room ID counter
//        roomCounter++;

        // Show the room ID to the user
        //send room reques

    }
    public void backButton(){
        PanelsManagerCard panelsManagerCard = localController.getFrame().getPanelsManagerCard();
        panelsManagerCard.getCardLayout().show(panelsManagerCard, ChooseOnlineGamePanel.class.getSimpleName());
    }
}
