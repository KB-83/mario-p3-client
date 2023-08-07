package controller.listener;

import controller.LocalController;
import model.request.NewPrivateChatRequest;
import model.request.SearchChatRequest;
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
        if (localController.getController().getChatByOpponentName(opponentName) != null) {
            panelsManagerCard.getMainChatPanel().setChat(localController.getController().getChatByOpponentName(opponentName).getMassages(), opponentName);
            panelsManagerCard.getCardLayout().show(panelsManagerCard, MainChatPanel.class.getSimpleName());
        }
        else {
            localController.sendRequest(new NewPrivateChatRequest(opponentName));
        }
    }
    public void searchUser(String userName) {
        if (userName.equals("")) {
            chatPanel.setChats(localController.getController().returnChatNames());
        }
        else {
            localController.sendRequest(new SearchChatRequest(userName));
        }
    }
}
