package view.menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LastGamesPanel extends MarioPanel {
    private PanelsManagerCard cardPanel;
//    User user;
    private ButtonGroup bg = new ButtonGroup();
    private JButton back = new JButton("<-");
    private JButton ok =new  JButton("ok");

    private JRadioButton[] lastGamesList = new JRadioButton[3];
    LastGamesPanel(PanelsManagerCard cardPanel) {
        this.cardPanel = cardPanel;
        setUI();
        loadConfig();
    }
    @Override
    public void setUI() {

    }

    @Override
    public void setOffline(boolean offline) {

    }


    public void loadConfig() {
        setLayout(null);
        setBackground(Color.red);
        setInitialButtons();
    }
    public void setUser() {
//        this.user = this.card.gM.lM.userManager.currentUser;
    }
    private void setInitialButtons(){
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardPanel.getCardLayout().show(cardPanel,"mainMenu");
                cardPanel.getMainMenu().requestFocus();
            }
        });
        back.setBounds(0,0,50,50);
        add(back);
        //test
        setLastGamesButtons();
    }
    public void setLastGamesButtons(){
//        ok.setBounds(Constant.PANEL_WIDTH/2,550,50,50);
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//
                String gameName = "";
                for (JRadioButton button : lastGamesList){
                    if (button != null && button.isSelected()){
                        gameName = button.getText();
                        break;
                    }
                }
                if (gameName.equals("")){
                    System.out.println("select a game!");
                    return;
                }
//                UserRequestHandler userRequestHandler = cardPanel.getFrame().getGraphicManager().getLogicManager().getUser().getUserRequestHandler();
                cardPanel.getCardLayout().show(cardPanel,"gamePanel");
                cardPanel.getGamePanel().requestFocus();
//                cardPanel.getFrame().getGraphicManager().getUser().getUserRequestHandler().lastGameRequest(gameName);
            }
        });
        add(ok);

    }
//    public void setUserClearedDependencies(User user) {
//        int x = 200;
//        if (user.getSavedGames() == null) {
//            return;
//        }
//        for (int i = 0;i < user.getSavedGames().length; i++){
//            if(lastGamesList[i] != null){
//                this.remove(lastGamesList[i]);
//            }
//            JRadioButton gameButton = new JRadioButton();
//            lastGamesList[i] = gameButton;
//            gameButton.setText(user.getSavedGames()[i].getName());
//            gameButton.setBounds(x,500,250,30);
//            bg.add(gameButton);
//            this.add(gameButton);
//            x += 300;
//        }
//    }

    private void saveInfo(){
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
