package controller.listener;

import controller.LocalController;
import view.menu.ChatPanel;

public class ChatPanelListener {
    private LocalController localController;
    private ChatPanel chatPanel;

    public ChatPanelListener(LocalController localController, ChatPanel chatPanel) {
        this.localController = localController;
        this.chatPanel = chatPanel;
    }
}
