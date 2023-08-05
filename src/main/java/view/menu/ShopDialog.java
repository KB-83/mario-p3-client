package view.menu;

import util.Config;
import util.Name;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShopDialog extends JDialog {

    private int diamonds = 10;
    private int coinsToBuy = 0;
    private int diamondConversionRate = 1200;

    private JLabel diamondsLabel;
    private JLabel coinsToBuyLabel;
    private JButton plusButton;
    private JButton minusButton;
    private JButton buyButton;



    public ShopDialog() {
//        super(frame,"shop",true);
        setLayout(new GridBagLayout());
        setUI();
        setLocationRelativeTo(null);
    }


    public void setUI() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(300,300));
        setResizable(false);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 5, 5, 5);

        diamondsLabel = new JLabel("Diamonds: " + diamonds);
        ImageIcon diamondIcon = new ImageIcon(Config.IMAGES.get(Name.DIAMOND));
        diamondsLabel.setIcon(diamondIcon);
        constraints.gridx = 0;
        constraints.gridy = 0;
        mainPanel.add(diamondsLabel, constraints);

        coinsToBuyLabel = new JLabel("Coins to buy: " + coinsToBuy);
        ImageIcon coinIcon = new ImageIcon(Config.IMAGES.get(Name.COIN));
        coinsToBuyLabel.setIcon(coinIcon);
        constraints.gridy = 1;
        mainPanel.add(coinsToBuyLabel, constraints);


        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

        plusButton = new JButton("+");
        plusButton.setPreferredSize(new Dimension(50, 30));
        plusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (diamonds > 0) {
                    diamonds--;
                    coinsToBuy += diamondConversionRate;
                    updateLabels();
                }
            }
        });
        buttonPanel.add(plusButton);

        constraints.gridy = 3; // Set the gridy for the button panel
        mainPanel.add(buttonPanel, constraints);

        minusButton = new JButton("-");
        minusButton.setPreferredSize(new Dimension(50, 30)); // Set preferred size for the "-" button
        minusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (coinsToBuy >= diamondConversionRate) {
                    diamonds++;
                    coinsToBuy -= diamondConversionRate;
                    updateLabels();
                }
            }
        });
        buttonPanel.add(minusButton);

        buyButton = new JButton("BuyRequest");
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dispose(); // Hide the dialog after the buy operation is performed
            }
        });
        mainPanel.add(buyButton, constraints);

        add(mainPanel);

        pack();
    }
    private void updateLabels() {
        diamondsLabel.setText("Diamonds: " + diamonds);
        coinsToBuyLabel.setText("Coins to buy: " + coinsToBuy);
    }

}
