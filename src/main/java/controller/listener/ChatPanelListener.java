package controller.listener;

import controller.LocalController;
import view.menu.ChatPanel;
import view.menu.MainChatPanel;
import view.menu.PanelsManagerCard;

public class ChatPanelListener {
    private LocalController localController;
    private ChatPanel chatPanel;

    public ChatPanelListener(LocalController localController, ChatPanel chatPanel) {
        this.localController = localController;
        this.chatPanel = chatPanel;

    }
    public void openPrivateChat(String opponentName) {
        PanelsManagerCard panelsManagerCard = localController.getFrame().getPanelsManagerCard();
        panelsManagerCard.getMainChatPanel().setChat(localController.getController().getChatByOpponentName(opponentName).getMassages(),opponentName);
        panelsManagerCard.getCardLayout().show(panelsManagerCard, MainChatPanel.class.getSimpleName());
    }
}
