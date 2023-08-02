package view.menu;

import controller.LocalController;
import model.Client;
import util.Constant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGamePanel extends MarioPanel {
    LocalController localController;
    private PanelsManagerCard panelsManagerCard;
//    User user;
    private ButtonGroup bg = new ButtonGroup();
    private JButton back = new JButton("<-");
    private JButton ok =new  JButton("ok");
    private JButton delete =new  JButton("delete");

    JRadioButton[] lastGamesList = new JRadioButton[3];
    NewGamePanel(LocalController localController,PanelsManagerCard panelsManagerCard) {
        this.localController = localController;
        this.panelsManagerCard = panelsManagerCard;
        setUI();
    }
    // TODO: you can change and use config

    private void setButtons(){
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelsManagerCard.getCardLayout().show(panelsManagerCard,"mainMenu");
                panelsManagerCard.getMainMenu().requestFocus();
            }
        });
        back.setBounds(0,0,50,50);
        add(back);
        /////todo
        ok.setBounds(Constant.PANEL_WIDTH/2 - 25,550,50,50);
        delete.setBounds(Constant.PANEL_WIDTH/2 + 30,550,70,50);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                for (int i = 0;i<lastGamesList.length;i++) {
//                    if (lastGamesList[i] != null && lastGamesList[i].isSelected()) {
//                        user.userManager.newGameRequest(lastGamesList[i].getText(), "newGame   ");
//                        lastGamesList[i].setSelected(false);
//                        setLastGamesOptions();
//                        saveInfo();
//                        card.cardLayout.show(card,"mainMenu");
//                        break;
//                    }
//                }
            }
        });
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
                localController.getUserRequestHandler().newGameRequest(gameName);

            }
        });
        add(delete);
        add(ok);
    }
    public void setUserClearedDependencies(Client client) {
//        int x = 200;
//        for (int i = 0;i < client.getGames().length; i++){
//            if(lastGamesList[i] != null){
//                this.remove(lastGamesList[i]);
//            }
//            JRadioButton gameButton = new JRadioButton();
//            lastGamesList[i] = gameButton;
//            gameButton.setText(client.getGames()[i].getName());
//            gameButton.setBounds(x,500,250,30);
//            bg.add(gameButton);
//            this.add(gameButton);
//            x += 300;
//        }
    }

    // TODO: change save and load paradime

    private void saveInfo() {
//        File file = new File(user.getUserName() + ".json");
//        FileWriter fileWriter = null;
//        try {
//            fileWriter = new FileWriter(file);
//            user.userManager.objectMapper.writeValue(fileWriter, user);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }

    @Override
    public void setUI() {
        setLayout(null);
        setBackground(Color.red);
        setButtons();
        JRadioButton gameButton = new JRadioButton("default");
        lastGamesList[0] = gameButton;
        gameButton.setBounds(200,500,250,30);
        bg.add(gameButton);
        this.add(gameButton);
    }

    @Override
    public void setOffline(boolean offline) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
