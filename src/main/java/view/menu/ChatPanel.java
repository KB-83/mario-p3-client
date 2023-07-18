package view.menu;

import controller.LocalController;
import controller.listener.ChatPanelListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class ChatPanel extends MarioPanel {
    private ChatPanelListener listener;
    private PanelsManagerCard panelsManagerCard;
    private List<JButton> chats;
    private JPanel contentPanel;
    private JScrollPane scrollPane;
    private JButton backButton;
    private JPanel buttonPanel;

    public ChatPanel(LocalController localController,PanelsManagerCard panelsManagerCard) {
        this.panelsManagerCard = panelsManagerCard;
        listener = new ChatPanelListener(localController,this);
        setUI();
    }

    @Override
    public void setUI() {
        setLayout(new BorderLayout());
        ArrayList<String> names = new ArrayList<>();
        names.add("k");
        names.add("l");
        names.add("pp");
        names.add("k");
        names.add("l");
        names.add("pp");
        names.add("k");
        names.add("l");
        names.add("pp");
        names.add("k");
        names.add("l");
        names.add("pp");

        backButton = new JButton("<-");
        backButton.setHorizontalTextPosition(SwingConstants.LEFT);
        backButton.setHorizontalAlignment(SwingConstants.LEFT);
        backButton.setFocusable(false);
        backButton.addActionListener(this);

        buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.setAlignmentY(0);
        buttonPanel.add(backButton);
        buttonPanel.setBackground(Color.lightGray);

// Add the buttonPanel to the north region of the BorderLayout


        contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(Color.LIGHT_GRAY);
        setChats(names, contentPanel);

        scrollPane = new JScrollPane(contentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);


        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.NORTH);
    }

    @Override
    public void setOffline(boolean offline) {

    }


    private void setChats(List<String> names, JPanel contentPanel) {
        chats = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            JButton jButton = new JButton(names.get(i));
            jButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 100));
            jButton.setFocusable(false);
            chats.add(jButton);
            contentPanel.add(jButton);
        }

        // Calculate the total height of the buttons
        int totalHeight = names.size() * 100; // Assuming each button has a fixed height of 100

        // Set the preferred size of the contentPanel based on the total height
        contentPanel.setPreferredSize(new Dimension(contentPanel.getPreferredSize().width, totalHeight));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backButton) {
            panelsManagerCard.getCardLayout().show(panelsManagerCard,MainMenu.class.getSimpleName());
            panelsManagerCard.getMainMenu().requestFocus();
        }
    }
}






