package view.menu.bag;

import controller.LocalController;
import util.Name;
import view.menu.ChooseOnlineGamePanel;
import view.menu.MainMenu;
import view.menu.MarioPanel;
import view.menu.PanelsManagerCard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class BagPanel extends MarioPanel {
    private PanelsManagerCard panelsManagerCard;
    private EditBagPanel selectedEditBagPanel;
    private JPanel mainPanel;
    private JPanel southPanel;
    private JButton backButton;
    private JPanel centerPanel;
    private final String[] items = {Name.SPEED_BOMB, Name.DAMAGE_BOMB, Name.SWARD,
            Name.HEALTH_POTION,Name.SPEED_POTION,Name.INVISIBILITY_POTION};
    private EditBagPanel[] editBagPanels = new EditBagPanel[3];
    public BagPanel(LocalController localController, PanelsManagerCard panelsManagerCard) {
        this.panelsManagerCard = panelsManagerCard;
        setUI(localController);
    }

    public void setUI(LocalController localController) {
        setPreferredSize(new Dimension(800, 600));

        mainPanel = new JPanel(new BorderLayout());
        add(mainPanel);

        backButton = createButton("Back");
        backButton.addActionListener(this);
        mainPanel.add(backButton, BorderLayout.NORTH);

        centerPanel = new JPanel(new GridLayout(1, 3));
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        for (int i = 0; i < 3; i++) {
            editBagPanels[i] = new EditBagPanel(localController,this);
            centerPanel.add(editBagPanels[i]);
        }

        southPanel = new JPanel(new GridLayout(1, items.length));
        mainPanel.add(southPanel, BorderLayout.SOUTH);

        for (int i = 0; i < 6; i++) {
            JPanel item = new ItemPanel(this,items[i]);
            southPanel.add(item);
        }

        southPanel.setVisible(false);

    }

    @Override
    public void setUI() {

    }

    @Override
    public void setOffline(boolean offline) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            panelsManagerCard.getCardLayout().show(panelsManagerCard, ChooseOnlineGamePanel.class.getSimpleName());
            panelsManagerCard.getItemShopPanel().requestFocus();
        }

    }

    public EditBagPanel getSelectedBag() {
        return selectedEditBagPanel;
    }

    public void setSelectedBag(EditBagPanel selectedEditBagPanel) {
        this.selectedEditBagPanel = selectedEditBagPanel;
    }

    public JPanel getSouthPanel() {
        return southPanel;
    }
}
