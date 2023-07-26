package view.Notification;

import javax.swing.*;
import java.awt.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Notification extends JDialog{
    private Frame frame;
    private JPanel panel;
    private JLabel reasonLabel;
    private JLabel infoLabel;

    public Notification(Frame frame) {
        super(frame);
        this.frame = frame;
        setUndecorated(true);
        setSize(300, 100);
        panel = new JPanel(new BorderLayout());

        // Create the notification reason label
        reasonLabel = new JLabel("New Notification");
        reasonLabel.setFont(reasonLabel.getFont().deriveFont(Font.BOLD, 16));
        reasonLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(reasonLabel, BorderLayout.NORTH);

        infoLabel = new JLabel();
        infoLabel.setFont(infoLabel.getFont().deriveFont(Font.PLAIN, 14));
        infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(infoLabel, BorderLayout.CENTER);

        getContentPane().add(panel);

        // Register mouse listener to hide the notification dialog when clicked
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int button = e.getButton();
                if (SwingUtilities.isRightMouseButton(e)) {
                    // click with two fingers on mac means right-click
                    setVisible(false);
                } else if (SwingUtilities.isLeftMouseButton(e)) {
                    System.out.println("left pressed");
                }
            }
        });

        // Set the reason for the notification


        // Show the notification dialog at the bottom-right corner of the main frame

    }

    public void showNotification(String reason, String info) {
        reasonLabel.setText(reason);
        if (info.length() > 40) {
            info = info.substring(0, 40) + "...";
        }
        infoLabel.setText(info);
        int x = frame.getX() + frame.getWidth() - getWidth() - 10;
        int y = frame.getY() + frame.getHeight() - getHeight() - 10;
        setLocation(x, y);
        setVisible(true);
    }
}
