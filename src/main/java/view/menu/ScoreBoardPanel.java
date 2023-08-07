package view.menu;

import controller.LocalController;
import model.dto.score.ScoreBoardDTO;
import model.dto.score.ScoreDTO;
import model.request.SearchTableRequest;
import view.Notification.CustomDialogPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ScoreBoardPanel extends MarioPanel{
    LocalController localController;
    private JTable table;
    private JButton backButton;
    private JButton searchScoreButton;
    private JButton searchUsernameButton;
    private JTextField usernameField;
    private JTextField minScoreField;
    private JTextField maxScoreField;
    private String[] columnNames = {"Place", "Name","Score","Grade"};

    public ScoreBoardPanel(LocalController localController) {
        this.localController = localController;
        setUI();
    }

    @Override
    public void setUI() {
        setLayout(new BorderLayout());

        // Create the table to display the data
        table = createTable();
        table.setFocusable(false);
        table.setEnabled(false);

        // Create a scroll pane for the table
        JScrollPane scrollPane = new JScrollPane(table);

        // Create the back button
        backButton = createButton(" < ");
        backButton.addActionListener(this);

        // Create the search button
        searchScoreButton = createButton("Search");
        searchUsernameButton = createButton("Search");
        searchScoreButton.addActionListener(this);
        searchUsernameButton.addActionListener(this);

        // Create text fields for username and score range
        usernameField = new JTextField();
        minScoreField = new JTextField();
        maxScoreField = new JTextField();

        // Create a panel to hold the text fields
        JPanel textFieldPanel = new JPanel(new GridLayout(1, 5));
        JLabel userName = new JLabel("Username:");
        userName.setHorizontalAlignment(JLabel.RIGHT);
        textFieldPanel.add(userName);
        textFieldPanel.add(usernameField);

        textFieldPanel.add(searchUsernameButton);

        JLabel minScore = new JLabel("Min Score:");
        minScore.setHorizontalAlignment(JLabel.RIGHT);
        textFieldPanel.add(minScore);
        textFieldPanel.add(minScoreField);

        JLabel maxScore = new JLabel("Max Score:");
        maxScore.setHorizontalAlignment(JLabel.RIGHT);
        textFieldPanel.add(maxScore);
        textFieldPanel.add(maxScoreField);


        textFieldPanel.add(searchScoreButton);

        // Create a GridPanel to hold the buttons and text fields
        JPanel gridPanel = new JPanel(new GridLayout(2, 1));
        JPanel buttonPanel = new JPanel(new GridLayout(1, 6));
        buttonPanel.add(backButton);
        gridPanel.add(buttonPanel);
        gridPanel.add(textFieldPanel);

        // Add components to the panel
        add(scrollPane, BorderLayout.CENTER);
        add(gridPanel, BorderLayout.NORTH);
    }

    @Override
    public void setOffline(boolean offline) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchScoreButton) {
            String minScoreString = minScoreField.getText();
            String maxScoreString = maxScoreField.getText();
            if (minScoreString.isEmpty() || maxScoreString.isEmpty()) {
                CustomDialogPanel.showDialog(this,"fill it!",CustomDialogPanel.DEFAULT_ICON);
                return;
            }
            int min = Integer.parseInt(minScoreString);
            int max = Integer.parseInt(maxScoreString);
            localController.sendRequest(new SearchTableRequest(max,min,null,false));
        }
        else if(e.getSource() == searchUsernameButton) {
            String username = usernameField.getText();
            if (username.isEmpty()) {
                CustomDialogPanel.showDialog(this,"fill it!",CustomDialogPanel.DEFAULT_ICON);
                return;
            }
            localController.sendRequest(new SearchTableRequest(0,0,username,true));
        }
        else if (e.getSource() == backButton) {
            PanelsManagerCard panelsManagerCard = localController.getFrame().getPanelsManagerCard();
            panelsManagerCard.getCardLayout().show(panelsManagerCard,MainMenu.class.getSimpleName());
        }

    }
    public void setScoreBoard(ScoreBoardDTO scoreBoardDTO) {
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        for (ScoreDTO score : scoreBoardDTO.getScoreDTOS()) {
            Object[] rowData = {score.getPlace(), score.getUsername(), score.getScore(), score.getGrade()};
            model.addRow(rowData);
        }
        table.setModel(model);

    }
}
