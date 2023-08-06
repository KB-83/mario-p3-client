package view.menu.shop;

import controller.LocalController;
import model.request.BuyRequest;
import model.request.FinalBuyRequest;
import model.response.BuyResponse;
import util.Config;
import util.Name;
import view.menu.MarioPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuyDialog extends JDialog implements ActionListener{
    private LocalController localController;
    private BuyResponse buyResponse;
    private JTable table;
    private JButton buy = MarioPanel.createButton("  buy ");
    private JButton cancel = MarioPanel.createButton("cancel");
    private final String[] columnNames = {"Name", "Count"};



    public BuyDialog(LocalController localController) {
        this.localController = localController;
        setLayout(new GridBagLayout());
        setUI();
        setLocationRelativeTo(null);
    }


    public void setUI() {

        setLayout(new BorderLayout());

        table = new JTable();
        table.setFocusable(false);

        JScrollPane scrollPane = new JScrollPane(table);

        JPanel southPanel = new JPanel(new GridLayout(1,2));
        cancel.addActionListener(this);
        buy.addActionListener(this);
        southPanel.add(buy);
        southPanel.add(cancel);

        add(scrollPane, BorderLayout.CENTER);
        add(southPanel,BorderLayout.SOUTH);
        pack();
    }
    public void updateTable(BuyRequest buyRequest,BuyResponse buyResponse) {
        this.buyResponse = buyResponse;

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        model.addRow(new Object[]{Name.DAMAGE_BOMB,buyRequest.getDamageBomb()});
        model.addRow(new Object[]{Name.SPEED_BOMB,buyRequest.getSpeedBomb()});
        model.addRow(new Object[]{Name.HAMMER,buyRequest.getHammer()});
        model.addRow(new Object[]{Name.SWARD,buyRequest.getSward()});
        model.addRow(new Object[]{Name.HEALTH_POTION,buyRequest.getHealthPotion()});
        model.addRow(new Object[]{Name.INVISIBILITY_POTION,buyRequest.getInVisibilityPotion()});
        model.addRow(new Object[]{Name.SPEED_POTION,buyRequest.getSpeedPotion()});

        model.addRow(new Object[]{Name.COIN,buyResponse.getBill().getCoinCost()});
        model.addRow(new Object[]{Name.DIAMOND,buyResponse.getBill().getDiamondCost()});

        table.setModel(model);
        revalidate();
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancel) {
            setVisible(false);
        }
        else if(e.getSource() == buy) {
            localController.sendRequest(new FinalBuyRequest(buyResponse));
            setVisible(false);
            //repaintShop
        }
    }
}
