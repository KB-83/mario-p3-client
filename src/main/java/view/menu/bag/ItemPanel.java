package view.menu.bag;

import util.Config;
import view.menu.MarioPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ItemPanel extends JPanel implements ActionListener {
    private String type;
    BagPanel bagPanel;
    ImageIcon imageIcon;
    JLabel imageLabel;
    JPanel buttonPanel;

    JButton plus = MarioPanel.createButton(" + ");
    JButton reduce = MarioPanel.createButton(" - ");
    public ItemPanel(BagPanel bagPanel,String type) {
        this.type = type;
        imageIcon = new ImageIcon(Config.IMAGES.get(type+"ORG"));
        this.bagPanel = bagPanel;
        setUI();
    }
    private void setUI() {
        setLayout(new BorderLayout());
        imageLabel = new JLabel(imageIcon);
        add(imageLabel, BorderLayout.CENTER);

        buttonPanel = new JPanel(new FlowLayout());
        add(buttonPanel, BorderLayout.SOUTH);
        buttonPanel.add(plus);
        buttonPanel.add(reduce);
        reduce.addActionListener(this);
        plus.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == plus) {
         bagPanel.getSelectedBag().addItem(type);
        }
        else if (e.getSource() == reduce) {
            bagPanel.getSelectedBag().removeItem(type);
        }
    }
}
