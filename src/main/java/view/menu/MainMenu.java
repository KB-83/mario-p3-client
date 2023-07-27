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
    private JButton tryAgain = new JButton("try to connect again");
    private JButton profile = new JButton("profile");
    private JButton logout = new JButton("logout");
    private JButton onlineGame = new JButton("play online");

    MainMenu(PanelsManagerCard cardPanel) {

        this.cardPanel = cardPanel;
        setUI();
    }

    @Override
    public void setUI() {
        setLayout(new GridBagLayout());
        setButtonsBounds();
        setButtonsListeners();
    }


    @Override
    public void setOffline(boolean offline) {
        profile.setEnabled(!offline);
        onlineGame.setEnabled(!offline);
    }



    private void setButtonsBounds() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 5, 5, 5); // Add some padding

        // Add the buttons one by one
        constraints.gridx = 0;
        constraints.gridy = 0;
        add(onlineGame, constraints);

        constraints.gridy++;
        add(startNewGame, constraints);

        constraints.gridy++;
        add(continueLastGames, constraints);

        constraints.gridy++;
        add(shop, constraints);

        constraints.gridy++;
        add(chatRoom, constraints);

        constraints.gridy++;
        add(profile, constraints);

        constraints.gridy++;
        add(logout, constraints);

        // Place "try again" button to the right of the other buttons
        constraints.gridy++;
        add(tryAgain, constraints);
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
        onlineGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardPanel.getCardLayout().show(cardPanel,ChooseOnlineGamePanel.class.getSimpleName());
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
