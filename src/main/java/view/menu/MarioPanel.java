package view.menu;

//import util.Config;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public abstract class MarioPanel extends JPanel implements ActionListener {
    public abstract void setUI();
    public abstract void setOffline(boolean offline);
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
//    public Config getClassConfig(Class c) {
//        return  Config.getConfig(c.getSimpleName());
//    }

}
