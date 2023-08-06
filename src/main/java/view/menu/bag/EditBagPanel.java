package view.menu.bag;

import controller.LocalController;
import model.request.SelectBagRequest;
import util.Constant;
import view.menu.MarioPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditBagPanel extends JPanel implements ActionListener {
    private LocalController localController;
    private BagPanel bagPanel;
    private SuitcasePanel suitcase;
    private JPanel buttonPanel;
    private JButton edit = MarioPanel.createButton("edit");
    private JButton delete = MarioPanel.createButton("delete");
    private JButton select = MarioPanel.createButton("select");
    private String[] items = new String[5];

    public EditBagPanel(LocalController localController,BagPanel bagPanel) {
        this.localController = localController;
        this.bagPanel = bagPanel;
        setPreferredSize(new Dimension(Constant.PANEL_WIDTH/3,400));
        suitcase = new SuitcasePanel(new ImageIcon[5]);
        setUI();

    }

    private void setUI(){
        setLayout(new BorderLayout());
        add(suitcase, BorderLayout.CENTER);
        add(select, BorderLayout.NORTH);
        buttonPanel = new JPanel(new FlowLayout());
        add(buttonPanel, BorderLayout.SOUTH);
        buttonPanel.add(edit);
        buttonPanel.add(delete);
        edit.addActionListener(this);
        select.addActionListener(this);
        delete.addActionListener(this);

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
        else if (e.getSource() == delete) {
            //ham puk kon ham null kon bara server
            items = new String[5];
            suitcase.setItems(items);
            bagPanel.setSelectedBag(null);
            bagPanel.getSouthPanel().setVisible(false);
        }
        else if (e.getSource() == select) {
            localController.sendRequest(new SelectBagRequest(items));
        }
    }

    public String[] getItems() {
        return items;
    }
}
