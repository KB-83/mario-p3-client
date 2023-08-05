package view.menu.bag;

import util.Name;
import view.menu.MarioPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class BagPanel extends MarioPanel {
    private EditBagPanel selectedEditBagPanel;
    private JPanel mainPanel;
    private JPanel southPanel;
    private JButton backButton;
    private JPanel centerPanel;
    private final String[] items = {Name.SPEED_BOMB, Name.DAMAGE_BOMB, Name.SWARD,
            Name.HEALTH_POTION,Name.SPEED_POTION,Name.INVISIBILITY_POTION};
    private EditBagPanel[] editBagPanels = new EditBagPanel[3];
    public BagPanel() {
        setUI();
    }

    @Override
    public void setUI() {
        setPreferredSize(new Dimension(800, 600));

        mainPanel = new JPanel(new BorderLayout());
        add(mainPanel);

        backButton = createButton("Back");
        mainPanel.add(backButton, BorderLayout.NORTH);

        centerPanel = new JPanel(new GridLayout(1, 3));
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        for (int i = 0; i < 3; i++) {
            editBagPanels[i] = new EditBagPanel(this);
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
    public void setOffline(boolean offline) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

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
