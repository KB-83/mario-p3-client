package view.menu;

import controller.LocalController;
import model.Client;
import model.dto.ClientDTO;
import model.dto.score.ScoreBoardDTO;
import model.dto.score.ScoreDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ScoreBardPanel extends MarioPanel{
    LocalController localController;
    private JTable table;
    private JButton backButton;

    public ScoreBardPanel(LocalController localController) {
        this.localController = localController;
        setUI();
    }

    @Override
    public void setUI() {
        setLayout(new BorderLayout());

        // Create the table to display the data


        table = new JTable();

        // Create a scroll pane for the table
        JScrollPane scrollPane = new JScrollPane(table);

        // Create the back button
        backButton = new JButton("Back");

        // Add components to the panel
        add(scrollPane, BorderLayout.CENTER);
        add(backButton, BorderLayout.NORTH);
    }

    @Override
    public void setOffline(boolean offline) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public void setScoreBoard(ScoreBoardDTO scoreBoardDTO) {
        String[] columnNames = {"Place", "Name","Score","Grade"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        for (ScoreDTO score : scoreBoardDTO.getScoreDTOS()) {
            Object[] rowData = {score.getPlace(), score.getUsername(), score.getScore(), score.getGrade()};
            model.addRow(rowData);
        }
        table.setModel(model);

    }
}
