package controller.listener;

import controller.LocalController;
import model.request.EnterRoomRequest;
import view.menu.room.EnterRoomPanel;

public class EnterRoomPanelListener {
    private LocalController localController;
    private EnterRoomPanel enterRoomPanel;

    public EnterRoomPanelListener(LocalController localController, EnterRoomPanel enterRoomPanel) {
        this.localController = localController;
        this.enterRoomPanel = enterRoomPanel;
    }
    public void enterRoom() {
        localController.sendRequest(new EnterRoomRequest(enterRoomPanel.getRoomToken().getText(),
                enterRoomPanel.getType().getSelectedItem().equals("player")));
    }
}
