package view.menu;

import util.Config;
import util.Name;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOverDialog extends JDialog {
    private JLabel scoreLabel;
    private JLabel diamondsLabel;
    private JLabel massage;
    private JButton okButton;
    public GameOverDialog(Frame parent,PanelsManagerCard panelsManagerCard) {
        super(parent, "Game Over", true);

        // Create a panel to hold the score and diamonds information
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(200,200));
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);

        // Create JLabels to display the score and diamonds information
        massage = new JLabel();


        diamondsLabel = new JLabel();
        ImageIcon diamondIcon = new ImageIcon(Config.IMAGES.get(Name.DIAMOND+"ORG"));
        diamondsLabel.setIcon(diamondIcon);

        scoreLabel = new JLabel();

        okButton= new JButton("OK");

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelsManagerCard.getCardLayout().show(panelsManagerCard,MainMenu.class.getSimpleName());
                setVisible(false);
            }
        });


        // Add the labels to the panel
        panel.add(massage);
        panel.add(diamondsLabel);
        panel.add(scoreLabel);
        panel.add(okButton);

        // Set the content pane of the dialog
        setContentPane(panel);

        // Pack and set the dialog position relative to the parent frame
        pack();
        setLocationRelativeTo(parent);
    }

    public void showDialog(int score, int diamonds,String massage) {
        this.massage.setText(massage);
        scoreLabel.setText("Score: " + score);
        diamondsLabel.setText("Diamonds: " + diamonds);
        revalidate();
        pack();
        setVisible(true);
    }
    
}