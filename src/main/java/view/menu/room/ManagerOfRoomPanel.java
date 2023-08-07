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

public class ManagerOfRoomPanel extends MarioPanel {
    private String token;
    private LocalController localController;
    private DefaultListModel<String> userListModel;
    private JPanel userListPanel;
    private JScrollPane userScrollPane;
    private JPanel buttonPanel;
    private JButton startGameButton;
    private JButton chatButton;
    private JPanel buttonContainer;
    private MainChatPanel chatPanel;
    private JButton inviteFriendOk;
    private JComboBox<String> inviteFriendComboBox;
    private JButton inviteFriendButton;
    private JButton addCoOwnerOK;
    private JComboBox<String> addCoOwnerComboBox;
    private JButton addCoOwnerButton;
    private JButton backButton;
    JPanel mainPanel;

    public ManagerOfRoomPanel(LocalController localController) {
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
        userListModel = new DefaultListModel<>();
        JList<String> userList = new JList<>(userListModel);
        userList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        userScrollPane = new JScrollPane(userList);
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
        startGameButton = createButton("Start Game");
        chatButton = createButton("Chat");
        inviteFriendButton = createButton("Invite Friend");
        addCoOwnerButton = createButton("Add Co-Owner");

        // Initialize inviteFriendOk button and inviteFriendComboBox
        inviteFriendOk = createButton("OK");
        String[] friends = {"Friend1", "Friend2", "Friend3"};
        inviteFriendComboBox = new JComboBox<>(friends);

        // Initialize addCoOwnerOK button and addCoOwnerComboBox
        addCoOwnerOK = createButton("OK");
        String[] users = {"User1", "User2", "User3"};
        addCoOwnerComboBox = new JComboBox<>(users);

        // Add buttons to the button panel
        buttonPanel.add(startGameButton);
        buttonPanel.add(chatButton);
        buttonPanel.add(inviteFriendButton);
        buttonPanel.add(inviteFriendComboBox);
        buttonPanel.add(inviteFriendOk);
        buttonPanel.add(addCoOwnerButton);
        buttonPanel.add(addCoOwnerComboBox);
        buttonPanel.add(addCoOwnerOK);

        // Add the button panel to the right panel
        rightPanel.add(buttonPanel);
        mainPanel.add(rightPanel, createGridBagConstraints(2, 0, 1, 1, GridBagConstraints.BOTH, 0.5, 1.0));


        // Add the main panel to the background panel
        backgroundPanel.add(mainPanel, BorderLayout.CENTER);

        // Add the background panel to the outer container
        add(backgroundPanel);


        // Add action listeners
        startGameButton.addActionListener(this);
        chatButton.addActionListener(this);
        inviteFriendButton.addActionListener(this);
        inviteFriendOk.addActionListener(this);
        addCoOwnerButton.addActionListener(this);
        addCoOwnerOK.addActionListener(this);
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
        if (e.getSource() == inviteFriendButton) {
            inviteFriendComboBox.setVisible(true);
            inviteFriendOk.setVisible(true);
            addCoOwnerComboBox.setVisible(false);
            addCoOwnerOK.setVisible(false);
        } else if (e.getSource() == addCoOwnerButton) {
            inviteFriendComboBox.setVisible(false);
            inviteFriendOk.setVisible(false);
            addCoOwnerComboBox.setVisible(true);
            addCoOwnerOK.setVisible(true);
        } else if (e.getSource() == inviteFriendOk) {
            inviteFriendComboBox.setVisible(false);
            inviteFriendOk.setVisible(false);
        } else if (e.getSource() == addCoOwnerOK) {
            addCoOwnerComboBox.setVisible(false);
            addCoOwnerOK.setVisible(false);
        }
        else if (e.getSource() == startGameButton) {
            localController.sendRequest(new RoomGameStartRequest(true,token));
        }
    }
    public void setRoom(RoomDTO room) {
        if (chatPanel == null) {
            chatPanel = new MainChatPanel(localController, localController.getFrame().getPanelsManagerCard());
            chatPanel.getBackButton().setVisible(false);
        }
        token = room.getRoomChat().getOpponentUsername();
        chatPanel.setChat(room.getRoomChat().getMassages(),token);
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

