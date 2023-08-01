package view.menu;

import controller.LocalController;
import model.Massage;
import model.request.SendPMRequest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class MainChatPanel extends MarioPanel implements ActionListener {
    private PanelsManagerCard panelsManagerCard;
    private LocalController localController;
    private JPanel messagesPanel;
    private JPanel topPanel;
    private JPanel titlePanel;
    private JLabel titleLabel;
    private JScrollPane scrollPane;
    private JPanel inputPanel;
    private JTextField messageField;
    private JButton sendButton;
    private JButton backButton;
    private String username;

    public MainChatPanel(LocalController localController, PanelsManagerCard panelsManagerCard) {
        this.panelsManagerCard = panelsManagerCard;
        this.localController = localController;
        setUI();
    }

    private String breakMessageIntoLines(String message) {
        final int LINE_LENGTH = 32;
        StringBuilder sb = new StringBuilder("<html>");
        int len = message.length();

        for (int i = 0; i < len; i += LINE_LENGTH) {
            sb.append(message.substring(i, Math.min(i + LINE_LENGTH, len)));
            sb.append("<br>");
        }

        sb.append("</html>");
        return sb.toString();
    }

    private void addMessage(String message, boolean isOwner, String senderName) {
        JPanel messagePanel = new JPanel(new BorderLayout());

        JLabel messageLabel = new JLabel(breakMessageIntoLines(message));
        messageLabel.setMaximumSize(new Dimension(100, 20));
        messageLabel.setOpaque(true);
        messageLabel.setBorder(BorderFactory.createEmptyBorder(30, 20, 30, 20));
        messageLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        // Create a circular icon with the sender's first initial
        ImageIcon circularIcon = createCircularIcon(senderName.substring(0, 1), 30);
        JLabel senderLabel = new JLabel(senderName, circularIcon, JLabel.LEFT);
        senderLabel.setVerticalTextPosition(JLabel.CENTER);
        senderLabel.setHorizontalTextPosition(JLabel.RIGHT);
        senderLabel.setFont(new Font("Arial", Font.BOLD, 16));

        if (!isOwner) {
            messagePanel.add(senderLabel, BorderLayout.LINE_START);
            messageLabel.setBackground(Color.green);
        }

        JPanel labelWrapperPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        labelWrapperPanel.add(messageLabel);

        messagePanel.add(labelWrapperPanel, BorderLayout.LINE_END);
        messagesPanel.add(messagePanel);
        messagesPanel.add(Box.createVerticalStrut(20));
        messagesPanel.revalidate();
        messagesPanel.repaint();

        SwingUtilities.invokeLater(() -> {
            JScrollBar verticalScrollBar = ((JScrollPane) messagesPanel.getParent().getParent()).getVerticalScrollBar();
            verticalScrollBar.setValue(verticalScrollBar.getMaximum());
        });
    }

    public void setChat(ArrayList<Massage> messages, String groupName) {
        username = localController.getController().getClient().getUsername();
        messagesPanel.removeAll(); // Clear existing messages
        titleLabel.setText(groupName);
        for (Massage message : messages) {
            if (message.getContext() != null) {
                addMessage(message.getContext(), message.getSenderUsername().equals(username), message.getSenderUsername());
            }
        }
    }

    @Override
    public void setUI() {
        setLayout(new BorderLayout());

        // Top Panel
        topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(Color.darkGray);
        topPanel.setPreferredSize(new Dimension(600, 60));

        backButton = new JButton("<-");
        backButton.addActionListener(this);
        backButton.setPreferredSize(new Dimension(50, 30));
        topPanel.add(backButton, BorderLayout.WEST);

        titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titlePanel.setOpaque(false);

        titleLabel = new JLabel();
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(Color.WHITE);
        titlePanel.add(titleLabel);

        topPanel.add(titlePanel, BorderLayout.CENTER);

        // Messages Panel
        messagesPanel = new JPanel();
        messagesPanel.setLayout(new BoxLayout(messagesPanel, BoxLayout.Y_AXIS));
        messagesPanel.setBackground(Color.WHITE);

        scrollPane = new JScrollPane(messagesPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Input Panel
        inputPanel = new JPanel();
        inputPanel.setBackground(Color.WHITE);
        inputPanel.setPreferredSize(new Dimension(600, 60));

        messageField = new JTextField();
        messageField.setPreferredSize(new Dimension(400, 40));
        messageField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (LocalController.isOnline) {
                        String message = messageField.getText();
                        if (!message.isEmpty()) {
                            addMessage(message, true, username);
                            localController.sendRequest(new SendPMRequest(new Massage(username, titleLabel.getText(),messageField.getText())));
                            messageField.setText("");
                        }
                    }
                }
            }
        });
        inputPanel.add(messageField);

        sendButton = new JButton("Send");
        sendButton.addActionListener(this);
        sendButton.setPreferredSize(new Dimension(100, 40));
        sendButton.addActionListener(e -> {
            String message = messageField.getText();
            if (!message.isEmpty()) {
                addMessage(message, true, username);
            }
        });
        inputPanel.add(sendButton);

        // Add components to the main panel
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);
    }

    private ImageIcon createCircularIcon(String text, int size) {
        BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.GREEN);
        g2d.fillOval(0, 0, size - 1, size - 1);
        g2d.setColor(Color.WHITE);
        Font font = new Font("Arial", Font.BOLD, size / 2);
        g2d.setFont(font);
        FontMetrics fm = g2d.getFontMetrics();
        int x = (size - fm.stringWidth(text)) / 2;
        int y = (fm.getAscent() + (size - (fm.getAscent() + fm.getDescent())) / 2);
        g2d.drawString(text, x, y);
        g2d.dispose();
        return new ImageIcon(image);
    }

    @Override
    public void setOffline(boolean offline) {
        if (offline) {
            sendButton.setEnabled(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            panelsManagerCard.getCardLayout().show(panelsManagerCard, ChatPanel.class.getSimpleName());
        }
        if (e.getSource() == sendButton) {
            localController.sendRequest(new SendPMRequest(new Massage(username,titleLabel.getText(), messageField.getText())));
            messageField.setText("");
        }
    }
}




