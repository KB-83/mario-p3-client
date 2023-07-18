package view.menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends MarioPanel {

    private PanelsManagerCard cardPanel;
    //    User user;
    private JButton startNewGame = new JButton("start new game");
    private JButton continueLastGames = new JButton("continue last games");
    private JButton shop = new JButton("shop");
    private JButton chatRoom = new JButton("chat room");
    private JButton profile = new JButton("profile");
    private JButton logout = new JButton("logout");

    MainMenu(PanelsManagerCard cardPanel) {

        this.cardPanel = cardPanel;
        setUI();
        setUI();
    }

    @Override
    public void setUI() {
        setLayout(null);
        setFocusable(false);
        setBackground(new Color(112, 107, 107, 124));
        setButtonsBounds();
        setButtonsListeners();

        add(startNewGame);
        add(continueLastGames);
        add(shop);
        add(chatRoom);
        add(profile);
        add(logout);
        revalidate();
    }

    @Override
    public void setOffline(boolean offline) {
        profile.setEnabled(!offline);
    }



    private void setButtonsBounds() {


        startNewGame.setBounds(26 * 48/2 -75,300,150,40);
        continueLastGames.setBounds(26 * 48/2 - 75,300 +50,150,40);
        shop.setBounds(26 * 48/2 - 75,300 +100,150,40);
        chatRoom.setBounds(26 * 48/2 - 75,300 +250,150,40);
        profile.setBounds(26 * 48/2 - 75,300 + 150,150,40);
        logout.setBounds(26 * 48/2 - 75,300 +200,150,40);

        startNewGame.setFocusable(false);
        continueLastGames.setFocusable(false);
        shop.setFocusable(false);
        profile.setFocusable(false);
        chatRoom.setFocusable(false);
        logout.setFocusable(false);

    }
    private void setButtonsListeners(){
        startNewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardPanel.getCardLayout().show(cardPanel,"newGamePanel");
                cardPanel.getNewGamePanel().requestFocus();
            }
        });
        chatRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardPanel.getCardLayout().show(cardPanel,ChatPanel.class.getSimpleName());
                cardPanel.getChatPanel().requestFocus();
            }
        });

        continueLastGames.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardPanel.getCardLayout().show(cardPanel,"lastGamesPanel");
                cardPanel.getLastGamesPanel().requestFocus();
            }
        });
        profile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardPanel.getCardLayout().show(cardPanel,"profilePanel");
                cardPanel.getProfilePanel().requestFocus();
            }
        });
        shop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardPanel.getCardLayout().show(cardPanel,ItemShopPanel.class.getSimpleName());
                cardPanel.getItemShopPanel().requestFocus();
            }
        });
//
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Todo : send save info request
//                saveInfo();
//                card.gM.lM.userManager.currentUser = null;
                cardPanel.getCardLayout().show(cardPanel,"startPanel");
                cardPanel.getStartPanel().requestFocus();
            }
        });
//    }
//    public void setUser() {
//        this.user = this.card.gM.lM.userManager.currentUser;
//        this.repaint();
//    }
//    private void saveInfo(){
//        File file = new File(user.getUserName() + ".json");
//        FileWriter fileWriter = null;
//        try {
//            fileWriter = new FileWriter(file);
//            user.userManager.objectMapper.writeValue(fileWriter,user);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
