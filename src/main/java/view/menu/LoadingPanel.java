package view.menu;

import controller.LocalController;
import controller.listener.LoadingPanelListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoadingPanel extends MarioPanel{
    private LoadingPanelListener listener;
    private static final int CIRCLE_RADIUS = 30;
    private static final int CIRCLE_DIAMETER = CIRCLE_RADIUS * 2;
    private static final int ARC_START_ANGLE = 90;
    private static final int ARC_EXTENT_ANGLE = 360;
    private static final int ANIMATION_DELAY = 100;
    private long startTime;
    private Timer timer;

    private boolean isLoading;
    private int rotationAngle;
    private int arcExtentAngle;

    private JLabel connectingLabel;

    public LoadingPanel(LocalController localController,PanelsManagerCard panelsManagerCard) {
        listener = new LoadingPanelListener(localController,this);
        rotationAngle = 0;
        arcExtentAngle = 0;
        setUI();
        setLoading(true);
    }

    private void setupUI() {

    }

    public void setLoading(boolean isLoading) {
        this.isLoading = isLoading;
        if (isLoading) {
            startAnimation();
        } else {
            stopAnimation();
        }
        repaint();
    }

    private void startAnimation() {
        startTime = System.currentTimeMillis();
        timer = new Timer(ANIMATION_DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (System.currentTimeMillis() - startTime > 600) {
                    rotationAngle = 0;
                    arcExtentAngle = 0;
                    repaint();
                    timer.stop();
                }
                arcExtentAngle = (arcExtentAngle + 10) % (ARC_EXTENT_ANGLE + 1);
                repaint();
            }
        });
        timer.setInitialDelay(0);
        timer.setRepeats(true);
        timer.start();
    }

    private void stopAnimation() {
        timer.stop();

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (isLoading) {
            int x = (getWidth() - CIRCLE_DIAMETER) / 2;
            int y = (getHeight() - CIRCLE_DIAMETER) / 2;

            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(MarioPanel.DARK_COLOR);
            g2d.setStroke(new BasicStroke(3));
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.rotate(Math.toRadians(rotationAngle), getWidth() / 2, getHeight() / 2);
            g2d.drawArc(x, y, CIRCLE_DIAMETER, CIRCLE_DIAMETER, ARC_START_ANGLE, arcExtentAngle);
            g2d.dispose();

            int labelY = y + CIRCLE_DIAMETER + 10;
            int labelHeight = connectingLabel.getPreferredSize().height;
            int labelX = (getWidth() - connectingLabel.getPreferredSize().width) / 2;
            connectingLabel.setBounds(labelX, labelY, connectingLabel.getPreferredSize().width, labelHeight);
        }
    }
    @Override
    public void setUI() {
//        setOpaque(false);
        setBackground(MarioPanel.LIGTH_COLOR);
        setLayout(new BorderLayout());
        connectingLabel = createStyledLabel("Connecting...",false);
        connectingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(connectingLabel, BorderLayout.SOUTH);
    }

    @Override
    public void setOffline(boolean offline) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
