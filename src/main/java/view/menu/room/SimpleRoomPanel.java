package view.menu.room;

import controller.LocalController;
import model.Chat;
import model.dto.RoomDTO;
import model.request.RoomGameStartRequest;
import util.Config;
import view.menu.MainChatPanel;
import view.menu.MarioPanel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SimpleRoomPanel extends MarioPanel {
    private LocalController localController;
    private JPanel userListPanel;
    private JScrollPane userScrollPane;
    private JPanel buttonPanel;
    private JButton chatButton;
    private JPanel buttonContainer;
    private MainChatPanel chatPanel;
    private JButton backButton;
    JPanel mainPanel;

    public SimpleRoomPanel(LocalController localController) {
        this.localController = localController;
        setUI();
    }


    @Override
    public void setUI() {
        setLayout(new BorderLayout());

        // Custom JPanel for the background
        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setBackground(BORDER_COLOR_B);
        backgroundPanel.setLayout(new BorderLayout());

        backButton = createButton(" < ");
        backButton.addActionListener(this);

        // Wrap the back button in a panel
        JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        backButtonPanel.add(backButton);
        backButtonPanel.setOpaque(false); // Make the panel transparent to show the background image

        // Set the preferred size of the panel to control the width
        int backButtonMaxWidth = 100;
        backButtonPanel.setPreferredSize(new Dimension(backButtonMaxWidth, backButton.getPreferredSize().height));

        backgroundPanel.add(backButtonPanel, BorderLayout.NORTH);

        // Main Panel for the center content
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setOpaque(false); // Make the panel transparent to show the background image

        // User List Panel on the left
        userListPanel = new JPanel();
        userListPanel.setLayout(new BoxLayout(userListPanel, BoxLayout.Y_AXIS));


        userScrollPane = new JScrollPane();
        userListPanel.add(userScrollPane);
        mainPanel.add(userListPanel, createGridBagConstraints(0, 0, 1, 1, GridBagConstraints.BOTH, 0.5, 1.0));

        // Right Panel for room title and buttons
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        Border roundedBorder = BorderFactory.createLineBorder(Color.DARK_GRAY, 3, true);
        rightPanel.setBorder(roundedBorder);

        // Room title (label) at the top-center of the panel
        JLabel roomTitleLabel = new JLabel("Game Room Name");
        roomTitleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        roomTitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        rightPanel.add(roomTitleLabel);
        rightPanel.add(Box.createVerticalStrut(20));


        // Buttons Panel in the center of the right panel
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        // Buttons for Start Game and Chat
        chatButton = createButton("Chat");


        // Add buttons to the button panel
        buttonPanel.add(chatButton);

        // Add the button panel to the right panel
        rightPanel.add(buttonPanel);
        mainPanel.add(rightPanel, createGridBagConstraints(2, 0, 1, 1, GridBagConstraints.BOTH, 0.5, 1.0));


        // Add the main panel to the background panel
        backgroundPanel.add(mainPanel, BorderLayout.CENTER);

        // Add the background panel to the outer container
        add(backgroundPanel);


        // Add action listeners
        chatButton.addActionListener(this);
        backButton.addActionListener(this);
    }

    // Helper method to create GridBagConstraints
    private GridBagConstraints createGridBagConstraints(int gridx, int gridy, int gridwidth, int gridheight,
                                                        int fill, double weightx, double weighty) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.gridwidth = gridwidth;
        gbc.gridheight = gridheight;
        gbc.fill = fill;
        gbc.weightx = weightx;
        gbc.weighty = weighty;
        gbc.insets = new Insets(10, 10, 10, 10);
        return gbc;
    }

    @Override
    public void setOffline(boolean offline) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
    public void setRoom(RoomDTO room) {
//        chatPanel = mainChatPanel;//without back button
        if (chatPanel == null) {
            //test
            chatPanel = new MainChatPanel(localController, localController.getFrame().getPanelsManagerCard());
            chatPanel.getBackButton().setVisible(false);
        }
        chatPanel.setChat(room.getRoomChat().getMassages(),room.getRoomChat().getOpponentUsername());
        mainPanel.add(chatPanel, createGridBagConstraints(1, 0, 1, 1, GridBagConstraints.BOTH, 0.5, 1.0));
        JList<String> userList = new JList<>(room.getRoomUsers().toArray(new String[0]));
        userList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        userScrollPane.setViewportView(userList);
        repaint();
        revalidate();
    }
    public void updateChat(Chat chat) {
        chatPanel.setChat(chat.getMassages(),chat.getOpponentUsername());
    }
}
