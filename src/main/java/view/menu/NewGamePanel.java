package view.menu;

import controller.LocalController;
import model.Client;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGamePanel extends MarioPanel {
    private LocalController localController;
    private PanelsManagerCard panelsManagerCard;
    private ButtonGroup bg = new ButtonGroup();
    private JButton ok = createStyledButton("ok");
    private JButton delete = createStyledButton("delete");
    private JRadioButton[] lastGamesList = new JRadioButton[3];
    private JButton back = createButton(" < ");

    NewGamePanel(LocalController localController, PanelsManagerCard panelsManagerCard) {
        this.localController = localController;
        this.panelsManagerCard = panelsManagerCard;
        setUI();
    }

    private void setButtons() {
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add your delete action code here
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
    }

    public void setUserClearedDependencies(Client client) {
        // Add your user dependencies setup code here
    }

    @Override
    public void setUI() {
        setLayout(new BorderLayout());
        setBackground(MarioPanel.LIGHT_COLOR);
        setButtons();

        // Create a panel for the back button and add it to the top (north)
        JPanel backButtonPanel = new JPanel();
        backButtonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        backButtonPanel.setBackground(MarioPanel.LIGHT_COLOR);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelsManagerCard.getCardLayout().show(panelsManagerCard, MainMenu.class.getSimpleName());
                panelsManagerCard.getMainMenu().requestFocus();
            }
        });
        backButtonPanel.add(back);

        add(backButtonPanel, BorderLayout.NORTH);

        // Add lastGamesList radio buttons to the center
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        centerPanel.setBackground(MarioPanel.MENU_COLOR);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);

        int x = 0;
        for (int i = 0; i < lastGamesList.length; i++) {
            JRadioButton gameButton = new JRadioButton("default");
            gameButton.setFont(MarioPanel.FONT);
            lastGamesList[i] = gameButton;
            bg.add(gameButton);

            constraints.gridx = x;
            constraints.gridy = 0;
            constraints.anchor = GridBagConstraints.WEST;
            centerPanel.add(gameButton, constraints);

            x++;
        }

        add(centerPanel, BorderLayout.CENTER);

        // Add buttons to the bottom (south)
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(MarioPanel.LIGHT_COLOR);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(delete);
        buttonPanel.add(ok);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    @Override
    public void setOffline(boolean offline) {
        // Add your setOffline code here if needed
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Add your actionPerformed code here if needed
    }
}
