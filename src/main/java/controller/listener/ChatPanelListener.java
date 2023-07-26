package controller.listener;

import controller.LocalController;
import view.menu.ChatPanel;
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
        panelsManagerCard.getPrivateChatPanel().setChat(localController.getController().getPrivateChatByOpponentName(opponentName).getMassages(),opponentName);
        panelsManagerCard.getCardLayout().show(panelsManagerCard,panelsManagerCard.getPrivateChatPanel().getClass().getSimpleName());
    }
}
