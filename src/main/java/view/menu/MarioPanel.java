package view.menu;

//import util.Config;

import model.Client;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionListener;


public abstract class MarioPanel extends JPanel implements ActionListener {
    public static final Dimension MAX_SIZE = new Dimension(200,40);
    public static final Font FONT = new Font("Arial", Font.BOLD, 16);
    public static final Color DARK_COLOR = new Color(255, 100, 100);
    public static final Color LIGHT_COLOR = new Color(255, 150, 150);
    public static final Color MENU_COLOR = new Color(255,230,230 );
    public static final Color WHITE_COLOR = new Color(240, 240, 240);
    public static final Color BORDER_COLOR = new Color(210, 0, 0);

    public static final Color DARK_COLOR_B = new Color(100, 100, 255); // Blue
    public static final Color LIGHT_COLOR_B = new Color(150, 150, 255); // Light blue
    public static final Color MENU_COLOR_B = new Color(230, 230, 255); // Lighter blue
    public static final Color WHITE_COLOR_B = new Color(240, 240, 255); // Off-white
    public static final Color BORDER_COLOR_B = new Color(0, 0, 210); // Dark blue

    public static final Border BLACK_BORDER = BorderFactory.createLineBorder(Color.BLACK, 2, true);
    public static final Border RED_BORDER = BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(BORDER_COLOR, 2, true),
            BorderFactory.createEmptyBorder(5, 15, 5, 15)
    );

    public abstract void setUI();
    public abstract void setOffline(boolean offline);
    public void clientCleared(Client client){}
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
    public void updateClient(Client client) {
    }
    public static JLabel createStyledLabel(String text, boolean hasBackground) {
        JLabel label = new JLabel(text);
        label.setFont(FONT);
        label.setFocusable(false);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setMaximumSize(MAX_SIZE);

        label.setForeground(Color.BLACK);

        if (hasBackground) {
            label.setOpaque(true);
            label.setBackground(DARK_COLOR);
        }

        return label;
    }
    public static JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(FONT);
        button.setFocusPainted(false);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(MAX_SIZE);
        button.setBorder(BLACK_BORDER);
        button.setBackground(WHITE_COLOR);
        button.setForeground(Color.BLACK);
        return button;
    }
    public static JTable createTable() {
        JTable table = new JTable();
        table.getTableHeader().setFont(FONT); // Set font for column names
        table.setFont(FONT); // Set font for cell values
        table.setFocusable(false);
        table.setEnabled(false); // Disable editing for the entire table
        table.setShowGrid(true); // Show lines between rows
        table.setBackground(LIGHT_COLOR_B);
        table.setForeground(Color.BLACK);
        table.setBorder(BLACK_BORDER);

        // Center align the cell content
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, centerRenderer);

        return table;
    }
    public static JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(FONT);
        button.setFocusPainted(false);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(MAX_SIZE);
        button.setBorder(RED_BORDER);

        button.setOpaque(true);
        button.setBackground(LIGHT_COLOR);
        button.setForeground(Color.WHITE);
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (button.isEnabled()) {
                    button.setBackground(DARK_COLOR);
                }
//                button.setBackground(new Color(135, 170, 235));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
//                button.setBackground(new Color(155, 190, 255));
                button.setBackground(LIGHT_COLOR);
            }
        });

        return button;
    }

    public static JComboBox<String> createStyledComboBox(String[] items) {
        JComboBox<String> comboBox = new JComboBox<>(items);
        comboBox.setFont(FONT);
        comboBox.setFocusable(false);
        comboBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        comboBox.setMaximumSize(MAX_SIZE);
        comboBox.setBorder(RED_BORDER);

        comboBox.setOpaque(true);
        comboBox.setBackground(LIGHT_COLOR);
        comboBox.setForeground(Color.RED);

        return comboBox;
    }

    public static JTextField createStyledTextField(String text, boolean hasBackground, int columns) {
        JTextField textField = new JTextField(text, columns);
        textField.setFont(FONT);
        textField.setForeground(Color.RED);
        if (hasBackground) {
            textField.setOpaque(true);
            textField.setBackground(LIGHT_COLOR);
        }
        return textField;
    }
    private JButton createBackButton() {
        JButton backButton = new JButton("<");
        backButton.setFont(new Font("Arial", Font.BOLD, 16));
        backButton.setFocusPainted(false);
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.setPreferredSize(new Dimension(40, 40));

        // Add your back button action listener here
        // backButton.addActionListener(...);

        return backButton;
    }
}
