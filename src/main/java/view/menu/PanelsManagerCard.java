package view.menu;

import controller.LocalController;
import view.Frame;
import view.menu.bag.BagPanel;
import view.menu.room.RoomManagerCard;
import view.menu.shop.ItemShopPanel;

import java.awt.*;
import java.awt.event.ActionEvent;

public class PanelsManagerCard extends MarioPanel {
    private Frame frame;
    private OfflineAskPanel offlineAskPanel;
    private ChatPanel chatPanel ;
    private MainChatPanel mainChatPanel;
    private ItemShopPanel itemShopPanel;
    private GamePanel gamePanel;
    private StartPanel startPanel;
    private LoadingPanel loadingPanel;
    private OnlineGamePanel onlineGamePanel;
    private MainMenu mainMenu;
    private RoomManagerCard roomManagerCard;
    private NewGamePanel newGamePanel;
    private LastGamesPanel lastGamesPanel;
    private ChooseOnlineGamePanel chooseOnlineGamePanel;
    private ScoreBoardPanel scoreBoardPanel;
    //layout
    private CardLayout cardLayout;
    private BagPanel bagPanel;
    public PanelsManagerCard(Frame frame, LocalController localController){
        this.frame = frame;
        setDependencies(localController);

    }

    public void setDependencies(LocalController localController) {
        // other panels going to be added here
        loadingPanel = new LoadingPanel(localController,this);
        offlineAskPanel = new OfflineAskPanel(localController,this);
        gamePanel = new GamePanel(this);
        startPanel = new StartPanel(localController,this);
        chatPanel = new ChatPanel(localController,this);
        mainChatPanel = new MainChatPanel(localController,this);
        itemShopPanel = new ItemShopPanel(localController,this);
        mainMenu = new MainMenu(localController,this);
        cardLayout = new CardLayout();
        chooseOnlineGamePanel = new ChooseOnlineGamePanel(localController,this);
        onlineGamePanel = new OnlineGamePanel(localController,this);
        roomManagerCard = new RoomManagerCard(frame,localController);
        newGamePanel = new NewGamePanel(localController,this);
        lastGamesPanel = new LastGamesPanel(localController,this);
        scoreBoardPanel = new ScoreBoardPanel(localController);
        bagPanel = new BagPanel(localController,this);

        setUI();

    }

    public void addPanels() {
//        Config config = getClassConfig(this.getClass());
//



        //adding panels order is important
        add(loadingPanel , loadingPanel.getClass().getSimpleName());
        add(offlineAskPanel, offlineAskPanel.getClass().getSimpleName());
        add(chatPanel , chatPanel.getClass().getSimpleName());
        add(itemShopPanel , itemShopPanel.getClass().getSimpleName());
        add(startPanel , startPanel.getClass().getSimpleName());
        add(chooseOnlineGamePanel,chooseOnlineGamePanel.getClass().getSimpleName());
        add(gamePanel, gamePanel.getClass().getSimpleName());
        add(onlineGamePanel,onlineGamePanel.getClass().getSimpleName());
        add(roomManagerCard, roomManagerCard.getClass().getSimpleName());
        add(mainChatPanel, mainChatPanel.getClass().getSimpleName());
        add(newGamePanel,newGamePanel.getClass().getSimpleName());
        add(bagPanel,bagPanel.getClass().getSimpleName());
//        add(newGamePanel,"newGamePanel");
//        add(lastGamesPanel,"lastGamesPanel");
        add(mainMenu,mainMenu.getClass().getSimpleName());
        add(lastGamesPanel,lastGamesPanel.getClass().getSimpleName());
        add(scoreBoardPanel, scoreBoardPanel.getClass().getSimpleName());
//        add(profilePanel,"profilePanel");
//        add(shopPanel,"shopPanel");


        revalidate();

    }

    // panels will be added later
    //info

    @Override
    public void setUI() {
        setLayout(cardLayout);
        setFocusable(false);
        setPreferredSize(new Dimension(1248, 720));

        addPanels();
    }

    @Override
    public void setOffline(boolean offline) {
        startPanel.setOffline(offline);
        itemShopPanel.setOffline(offline);
        mainMenu.setOffline(offline);
        mainMenu.setOffline(offline);
    }

    public void paintComponent(Graphics g) {
        gamePanel.repaint();
//        shopPanel.repaint();
//        profilePanel.repaint();
//        newGamePanel.repaint();
//        lastGamesPanel.repaint();
    }
//    public void setCurrentUser(User user){
//        mainMenu.setUser();
//        shopPanel.setUser();
//        profilePanel.setUser();
//        newGamePanel.setUser();
//        lastGamesPanel.setUser();
//        gamePanel.setCurrentUser(user);
//    }

    public Frame getFrame() {
        return frame;
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public StartPanel getStartPanel() {
        return startPanel;
    }

    public MainMenu getMainMenu() {
        return mainMenu;
    }

    public NewGamePanel getNewGamePanel() {
        return newGamePanel;
    }

    public LastGamesPanel getLastGamesPanel() {
        return lastGamesPanel;
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public OfflineAskPanel getConnectPanel() {
        return offlineAskPanel;
    }

    public ChatPanel getChatPanel() {
        return chatPanel;
    }

    public ItemShopPanel getItemShopPanel() {
        return itemShopPanel;
    }

    public OfflineAskPanel getOfflineAskPanel() {
        return offlineAskPanel;
    }

    public LoadingPanel getLoadingPanel() {
        return loadingPanel;
    }

    public OnlineGamePanel getOnlineGamePanel() {
        return onlineGamePanel;
    }

    public RoomManagerCard getRoomManager() {
        return roomManagerCard;
    }

    public ChooseOnlineGamePanel getChooseOnlineGamePanel() {
        return chooseOnlineGamePanel;
    }

    public MainChatPanel getMainChatPanel() {
        return mainChatPanel;
    }

    public void setMainChatPanel(MainChatPanel mainChatPanel) {
        this.mainChatPanel = mainChatPanel;
    }

    public BagPanel getBagPanel() {
        return bagPanel;
    }

    public RoomManagerCard getRoomManagerCard() {
        return roomManagerCard;
    }

    public ScoreBoardPanel getScoreBardPanel() {
        return scoreBoardPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
