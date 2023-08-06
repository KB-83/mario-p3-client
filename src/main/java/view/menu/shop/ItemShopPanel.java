package view.menu.shop;

import controller.LocalController;
import controller.listener.ItemShopPanelListener;
import util.Config;
import util.Name;
import view.menu.MainMenu;
import view.menu.MarioPanel;
import view.menu.PanelsManagerCard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ItemShopPanel extends MarioPanel {
    private ItemShopPanelListener listener;
    private PanelsManagerCard panelsManagerCard;
    private JLabel coinsLabel;
    private JLabel diamondsLabel;
    private int coins;
    private int diamonds;
    private JPanel topPanel;
    private JPanel centerPanel;
    private JScrollPane scrollPane;
    private JPanel southPanel;
    private JButton buyButton;
    private JButton backButton;
    private JButton buyCoinButton;
    private ExchangeDialog exchangeDialog;
    private BuyDialog buyDialog;

    public ItemShopPanel(LocalController localController,PanelsManagerCard panelsManagerCard) {
        this.panelsManagerCard = panelsManagerCard;
        listener = new ItemShopPanelListener(localController,this);
        exchangeDialog = new ExchangeDialog();
        buyDialog = new BuyDialog(localController);
        setUI();

    }

    private JPanel createItemPanel(String address, String itemName) {
        JPanel itemPanel = new JPanel(new BorderLayout());
        ImageIcon itemImage = new ImageIcon(Config.IMAGES.get(address));
        JLabel itemLabel = new JLabel(itemImage);
        itemPanel.add(itemLabel, BorderLayout.CENTER);

        JPanel namePanel = new JPanel();
        namePanel.setBackground(MarioPanel.MENU_COLOR);
        JLabel nameLabel = new JLabel(itemName);
        namePanel.add(nameLabel);

        itemPanel.add(namePanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(MarioPanel.MENU_COLOR);
        JButton minusButton = createButton(" - ");
        JLabel quantityLabel = createStyledLabel("0",false);
        JButton plusButton = createButton(" + ");

        minusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int quantity = Integer.parseInt(quantityLabel.getText());
                if (quantity > 0) {
                    quantity--;
                    quantityLabel.setText(Integer.toString(quantity));
                }
            }
        });

        plusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int quantity = Integer.parseInt(quantityLabel.getText());
                quantity++;
                quantityLabel.setText(Integer.toString(quantity));
            }
        });

        buttonPanel.add(minusButton);
        buttonPanel.add(quantityLabel);
        buttonPanel.add(plusButton);

        itemPanel.add(buttonPanel, BorderLayout.SOUTH);
        itemPanel.setBackground(MarioPanel.LIGHT_COLOR);
        return itemPanel;
    }


    @Override
    public void setUI() {

        setLayout(new BorderLayout());

        // Create top panel for currencies
        topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.setBackground(MarioPanel.LIGHT_COLOR);

        backButton = createButton(" < ");
        backButton.addActionListener(this);
        topPanel.add(backButton);

        ImageIcon coinIcon = new ImageIcon();
        coinIcon.setImage(Config.IMAGES.get(Name.COIN));


        coinsLabel = createStyledLabel("Coins: " + coins,false);
        coinsLabel.setIcon(coinIcon);


        topPanel.add(coinsLabel);

        ImageIcon diamondIcon = new ImageIcon(); // Replace with your diamond image
        diamondIcon.setImage(Config.IMAGES.get(Name.DIAMOND));
        diamondsLabel = createStyledLabel("Diamonds: " + diamonds,false);
        diamondsLabel.setIcon(diamondIcon);
        topPanel.add(diamondsLabel);

        buyCoinButton = createButton("buy coin");
        buyCoinButton.setFocusable(false);
        buyCoinButton.addActionListener(this);
        topPanel.add(buyCoinButton);


        add(topPanel, BorderLayout.NORTH);

        // Create center panel for item display
        centerPanel = new JPanel(new GridLayout(0, 3, 10, 10));
        centerPanel.setBackground(MarioPanel.DARK_COLOR);
        scrollPane = new JScrollPane(centerPanel);
        add(scrollPane, BorderLayout.CENTER);

        // Add items to the center panel
        //todo as a setting comes from server
        String[] itemNames = {Name.HAMMER, Name.HEALTH_POTION, "InvisibilityPotion", "InvisibilityPotion", "SpeedBomb"};
        for (int i = 1; i <= itemNames.length; i++) {
            centerPanel.add(createItemPanel(itemNames[i - 1], itemNames[i - 1]));
        }

        // Create south panel for buy button
        southPanel = new JPanel();
        buyButton = createStyledButton("Buy");
        buyButton.addActionListener(this);


        southPanel.add(buyButton);
        add(southPanel, BorderLayout.SOUTH);
    }

    public void setInfo(int coins,int diamonds) {
        this.coins = coins;
        this.diamonds = diamonds;
        coinsLabel.setText("Coins: " + coins);
        diamondsLabel.setText("Diamonds: " + diamonds);
    }

    @Override
    public void setOffline(boolean offline) {
//        buyButton.setEnabled(!offline);
//        buyCoinButton.setEnabled(!offline);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backButton) {
            panelsManagerCard.getCardLayout().show(panelsManagerCard, MainMenu.class.getSimpleName());
            panelsManagerCard.getMainMenu().requestFocus();
        }
        if (e.getSource() == buyCoinButton) {
            exchangeDialog.setVisible(true);
//            listener.buyCoin();
        }
        if (e.getSource() == buyButton) {
            listener.buyRequest();
        }
    }

    public JPanel getCenterPanel() {
        return centerPanel;
    }

    public BuyDialog getBuyDialog() {
        return buyDialog;
    }
}
