package view.menu;

import controller.LocalController;
import model.request.GroupSurvivalRequest;
import model.request.MarathonRequest;
import model.request.SurvivalRequest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class OnlineGamePanel extends MarioPanel{
    private JButton marathon = createStyledButton("marathon");
    private JButton survival = createStyledButton("survival");
    private JButton groupSurvival = createStyledButton("group survival");
    private PanelsManagerCard panelsManagerCard;
    private LocalController localController;
    public OnlineGamePanel(LocalController localController, PanelsManagerCard panelsManagerCard) {
        this.panelsManagerCard = panelsManagerCard;
        this.localController = localController;
        setUI();
    }


    @Override
    public void setUI() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(Box.createVerticalGlue());

        marathon.setAlignmentX(Component.CENTER_ALIGNMENT);
        survival.setAlignmentX(Component.CENTER_ALIGNMENT);
        groupSurvival.setAlignmentX(Component.CENTER_ALIGNMENT);

        Dimension dimension = new Dimension(150,40);
        marathon.setPreferredSize(dimension);
        survival.setPreferredSize(dimension);
        groupSurvival.setPreferredSize(dimension);

        marathon.setFocusable(false);
        marathon.addActionListener(this);
        survival.setFocusable(false);
        survival.addActionListener(this);
        groupSurvival.setFocusable(false);
        groupSurvival.addActionListener(this);

        add(marathon);
        add(survival);
        add(groupSurvival);

        add(Box.createVerticalGlue());
    }

    @Override
    public void setOffline(boolean offline) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == marathon) {
            MarathonRequest marathonRequest = new MarathonRequest();
            localController.sendRequest(marathonRequest);
        }
        else if (e.getSource() == survival) {
            SurvivalRequest survivalRequest = new SurvivalRequest();
            localController.sendRequest(survivalRequest);
        }
        else if (e.getSource() == groupSurvival) {
            GroupSurvivalRequest groupSurvivalRequest = new GroupSurvivalRequest();
            localController.sendRequest(groupSurvivalRequest);
        }
    }
}
