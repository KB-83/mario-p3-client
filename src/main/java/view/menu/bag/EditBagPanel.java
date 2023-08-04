package view.menu.bag;

import util.Constant;
import view.menu.MarioPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditBagPanel extends JPanel implements ActionListener {
    BagPanel bagPanel;
    SuitcasePanel suitcase;
    JPanel buttonPanel;
    JButton edit = MarioPanel.createButton("edit");
    JButton button2 = MarioPanel.createButton("Button 2");
    String[] items = new String[5];

    public EditBagPanel(BagPanel bagPanel) {
        this.bagPanel = bagPanel;
        setPreferredSize(new Dimension(Constant.PANEL_WIDTH/3,400));
        suitcase = new SuitcasePanel(new ImageIcon[5]);
        setUI();

    }

    private void setUI(){
        setLayout(new BorderLayout());
        add(suitcase, BorderLayout.CENTER);
        buttonPanel = new JPanel(new FlowLayout());
        add(buttonPanel, BorderLayout.SOUTH);
        buttonPanel.add(edit);
        buttonPanel.add(button2);
        edit.addActionListener(this);

    }
    public void addItem(String itemType) {
        for (int i = 0; i<items.length;i++) {
            if(items[i] == null) {
                items[i] = itemType;
                suitcase.setItems(items);
                return;
            }
        }

    }
    public void removeItem(String itemType) {
        for (int i = 0; i < items.length ;i++) {
            if (items[i] != null && items[i].equals(itemType)) {
                items[i] = null;
                suitcase.setItems(items);
                return;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == edit) {
            bagPanel.setSelectedBag(this);
            bagPanel.getSouthPanel().setVisible(true);
        }
    }
}
