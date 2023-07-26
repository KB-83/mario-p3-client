package view.menu;

import controller.LocalController;
import model.Massage;
import model.request.SendPMRequest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class PrivateChatPanel extends MarioPanel {
    private PanelsManagerCard panelsManagerCard;
    private LocalController localController;
    private JPanel messagesPanel;
    private JPanel topPanel;
    private JButton backButton;
    private JPanel titlePanel;
    private JLabel titleLabel;
    private JScrollPane scrollPane;
    private JPanel inputPanel;
    private JTextField messageField;
    private JButton sendButton;
    public PrivateChatPanel(LocalController localController,PanelsManagerCard panelsManagerCard) {
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

    private void addMessage(String message,boolean isOwner) {
        JPanel messagePanel = new JPanel(new BorderLayout());

        JLabel messageLabel = new JLabel(breakMessageIntoLines(message));
        messageLabel.setMaximumSize(new Dimension(100, 20));
        messageLabel.setOpaque(true);
        messageLabel.setBorder(BorderFactory.createEmptyBorder(30, 20, 30, 20));
        messageLabel.setHorizontalAlignment(SwingConstants.RIGHT);


        JPanel labelWrapperPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        if (!isOwner){
            messageLabel.setBackground(Color.green);
            labelWrapperPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        }
        labelWrapperPanel.add(messageLabel);

        messagePanel.add(labelWrapperPanel, BorderLayout.LINE_END);
        messagesPanel.add(messagePanel);
        messagesPanel.add(Box.createVerticalStrut(20));
        messagesPanel.revalidate();
        messagesPanel.repaint();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JScrollBar verticalScrollBar = ((JScrollPane) messagesPanel.getParent().getParent()).getVerticalScrollBar();
                verticalScrollBar.setValue(verticalScrollBar.getMaximum());
            }
        });
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
                    String message = messageField.getText();
                    if (!message.isEmpty()) {
                        addMessage(message,true);
                        localController.sendRequest(new SendPMRequest(titleLabel.getText(),messageField.getText()));
                        messageField.setText("");
                    }
                }
            }
        });
        inputPanel.add(messageField);

        sendButton = new JButton("Send");
        sendButton.addActionListener(this);
        sendButton.setPreferredSize(new Dimension(100, 40));
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = messageField.getText();
                if (!message.isEmpty()) {
                    addMessage(message,true);
                }
            }
        });
        inputPanel.add(sendButton);

        // Add components to the main panel
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);
    }
    public void setChat(ArrayList<Massage> massages, String opponentName) {

        messagesPanel = new JPanel();
        messagesPanel.setLayout(new BoxLayout(messagesPanel, BoxLayout.Y_AXIS));
        messagesPanel.setBackground(Color.WHITE);
        scrollPane.setViewportView(messagesPanel);

        titleLabel.setText(opponentName);
        for (Massage massage : massages) {
            if (massage.getContext() != null) {
                addMessage(massage.getContext(),massage.isOwnersPM());
            }
        }
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
            panelsManagerCard.getCardLayout().show(panelsManagerCard,ChatPanel.class.getSimpleName());
        }
        if (e.getSource() == sendButton) {
            localController.sendRequest(new SendPMRequest(titleLabel.getText(),messageField.getText()));
            messageField.setText("");
        }

    }
}
