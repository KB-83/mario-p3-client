package view.menu;

import controller.LocalController;
import controller.listener.ChatPanelListener;
import model.Client;

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
    private JButton searchButton;
    private JLabel usernameLabel;
    private JTextField usernameField;
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

        backButton = createButton("< -");
        backButton.setHorizontalTextPosition(SwingConstants.LEFT);
        backButton.setHorizontalAlignment(SwingConstants.LEFT);
        backButton.setFocusable(false);
        backButton.addActionListener(this);

        searchButton = createButton("Search");
        searchButton.addActionListener(this);

        usernameLabel = createStyledLabel("username",false);

        usernameField = createStyledTextField("",false,30);

        buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.setAlignmentY(0);
        buttonPanel.add(backButton);
        buttonPanel.add(usernameLabel);
        buttonPanel.add(usernameField);
        buttonPanel.add(searchButton);
        buttonPanel.setBackground(Color.lightGray);

// Add the buttonPanel to the north region of the BorderLayout


        contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(Color.LIGHT_GRAY);


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
        contentPanel.removeAll();
        chats = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            JButton jButton = new JButton(names.get(i));
            jButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 100));
            jButton.setFocusable(false);
            jButton.addActionListener(this);
            contentPanel.add(jButton);
        }

        // Calculate the total height of the buttons
        int totalHeight = names.size() * 100; // Assuming each button has a fixed height of 100

        // Set the preferred size of the contentPanel based on the total height
        contentPanel.setPreferredSize(new Dimension(contentPanel.getPreferredSize().width, totalHeight));
        revalidate();
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backButton) {
            panelsManagerCard.getCardLayout().show(panelsManagerCard,MainMenu.class.getSimpleName());
            panelsManagerCard.getMainMenu().requestFocus();
        }
        else if (e.getSource() == searchButton) {
            listener.searchUser(usernameField.getText());
        }
        else {
            listener.openPrivateChat(((JButton)e.getSource()).getText());
        }
    }
    public void setChats(ArrayList<String> names) {
        setChats(names, contentPanel);
    }
    public void clientCleared(Client client) {
        setChats(client.getClientController().returnChatNames());
    }
}






