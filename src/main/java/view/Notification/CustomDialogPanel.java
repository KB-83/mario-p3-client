package view.Notification;

import util.Config;
import view.menu.MarioPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomDialogPanel extends JDialog {
    private JLabel messageLabel;
    private JButton okButton;
    public static final ImageIcon DEFAULT_ICON = new ImageIcon(Config.IMAGES.get("marioRight1"));

    private CustomDialogPanel(JPanel parentPanel) {
        super((JFrame) SwingUtilities.getWindowAncestor(parentPanel), true); // "true" makes the dialog modal

        // Create components

        messageLabel = MarioPanel.createStyledLabel("", false);
        messageLabel.setHorizontalAlignment(JLabel.CENTER);

        okButton = MarioPanel.createButton("OK");
        okButton.setOpaque(true);
        okButton.setBackground(MarioPanel.DARK_COLOR);

        // Set layout
        setLayout(new BorderLayout());

        // Add components to the dialog panel
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBackground(MarioPanel.LIGTH_COLOR);
        contentPanel.add(messageLabel, BorderLayout.CENTER);
        add(contentPanel, BorderLayout.CENTER);
        add(okButton, BorderLayout.SOUTH);

        // Set size and position
        int dialogWidth = 300;
        int dialogHeight = 200;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - dialogWidth) / 2;
        int y = (screenSize.height - dialogHeight) / 2;
        setBounds(x, y, dialogWidth, dialogHeight);

        // Add ActionListener for the OK button to close the dialog when clicked
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the dialog
            }
        });
        messageLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    String labelText = messageLabel.getText().replace("token: ","");
                    copyToClipboard(labelText);
//                    JOptionPane.showMessageDialog(frame, "Text copied to clipboard: " + labelText);
                }
            }
        });
    }

    public static void showDialog(JPanel panel, String message, ImageIcon icon) {
        CustomDialogPanel customDialogPanel = new CustomDialogPanel(panel);
        customDialogPanel.messageLabel.setText(message);
        customDialogPanel.messageLabel.setIcon(icon);
        customDialogPanel.setVisible(true);
    }
    private static void copyToClipboard(String text) {
        StringSelection stringSelection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }
}
