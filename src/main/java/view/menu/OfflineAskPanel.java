package view.menu;

import controller.LocalController;
import controller.listener.OfflineAskPanelListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class OfflineAskPanel extends MarioPanel{
    private OfflineAskPanelListener listener;
    private PanelsManagerCard panelsManagerCard;
    private JButton tryAgain;
    private JButton playOffline;
    private JLabel lostConnection;


    public OfflineAskPanel(LocalController localController, PanelsManagerCard panelsManagerCard) {
        this.panelsManagerCard = panelsManagerCard;
        listener = new OfflineAskPanelListener(localController,this);
        setUI();

    }

    public PanelsManagerCard getPanelsManagerCard() {
        return panelsManagerCard;
    }

    @Override
    public void setUI() {
        setLayout(new BorderLayout());
        JPanel buttonsPanel = new JPanel(new FlowLayout());
        buttonsPanel.setPreferredSize(new Dimension(150,150));

        tryAgain = createButton("try again");
        tryAgain.setVerticalAlignment(JButton.CENTER);
        tryAgain.addActionListener(this);

        playOffline = createButton("play offline");
        playOffline.setVerticalAlignment(JButton.CENTER);
        playOffline.addActionListener(this);


        lostConnection = createStyledLabel("could not connect to server.",true);
        lostConnection.setHorizontalAlignment(JLabel.CENTER);
        lostConnection.setVerticalAlignment(JLabel.BOTTOM);

        buttonsPanel.add(tryAgain);
        buttonsPanel.add(playOffline);

        add(buttonsPanel,BorderLayout.SOUTH);
        add(lostConnection,BorderLayout.CENTER);
    }

    @Override
    public void setOffline(boolean offline) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == tryAgain) {
            listener.tryAgain();
        }
        else if (e.getSource() == playOffline) {
            listener.playOffline();
        }
    }
}
