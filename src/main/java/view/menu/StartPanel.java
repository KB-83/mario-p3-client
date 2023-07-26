package view.menu;


import controller.LocalController;
import controller.listener.StartPanelListener;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class StartPanel extends MarioPanel {
    private StartPanelListener startPanelListener;
    private PanelsManagerCard cardPanel;
    private JButton login, signIn, exit, getSignIn,getLogin,tryAgain;
    private Image image;
    private JTextArea loginName = new JTextArea("username");
    private JTextArea loginPass = new JTextArea("pass");
    private JTextArea signName = new JTextArea("username");
    private JTextArea signPass = new JTextArea("pass");

    public StartPanel(LocalController localController,PanelsManagerCard cardPanel){
        this.startPanelListener = new StartPanelListener(localController,this);
        this.cardPanel = cardPanel;
        setUI();
    }
    @Override
    public void setUI() {
        setFocusable(true);
        setLayout(null);
        setTextAreas();
        setButtons();
        add(signName);
        add(signPass);
        add(loginName);
        add(loginPass);
        revalidate();

    }

    @Override
    public void setOffline(boolean offline) {
        signIn.setEnabled(!offline);
    }

    // all design
    private void setButtons() {
//        // TODO: you can change and use config
//
//
        signIn = new JButton("sign in");
        login = new JButton("login");
        exit = new JButton("exit");
        getLogin = new JButton("ok");
        getSignIn = new JButton("ok");
        tryAgain = new JButton("try to connect again");

        signIn.addActionListener(this);
        login.addActionListener(this);
        getLogin.addActionListener(this);
        getSignIn.addActionListener(this);
        exit.addActionListener(this);
        tryAgain.addActionListener(this);
//
        signIn.setBounds(3 * 48 - 50 , 460,100,40);
        login.setBounds(3 * 48 - 50, 520,100,40);
        exit.setBounds(3 * 48 - 50,580,100,40);
        getSignIn.setBounds(3 * 48 + 280 + 30, 460,50,40);
        getLogin.setBounds(3 * 48 + 280 + 30, 520,50,40);
        tryAgain.setBounds(1000,20,150,40);
//
        signIn.setFocusable(false);
        login.setFocusable(false);
        exit.setFocusable(false);
        getSignIn.setFocusable(false);
        getLogin.setFocusable(false);
        tryAgain.setFocusable(false);
//
        getLogin.setVisible(false);
        getSignIn.setVisible(false);

        this.add(signIn);
        this.add(login);
        this.add(exit);
        this.add(getLogin);
        this.add(getSignIn);
        this.add(tryAgain);
        this.revalidate();
    }
    private void setTextAreas() {
        // TODO: you can change and use config

        LineBorder lineBorder = new LineBorder(Color.white, 8, true);
        loginName.setBorder(lineBorder);
        loginName.setForeground(Color.LIGHT_GRAY);
        loginPass.setBorder(lineBorder);
        loginPass.setForeground(Color.LIGHT_GRAY);
        signName.setBorder(lineBorder);
        signName.setForeground(Color.LIGHT_GRAY);
        signPass.setBorder(lineBorder);
        signPass.setForeground(Color.LIGHT_GRAY);

        loginName.setBounds(3*48 + 50 + 30,520,100,40);
        loginPass.setBounds(3*48 + 50 + 30 + 100 + 30,520,100,40);
        signName.setBounds(3*48 + 50 + 30,460,100,40);
        signPass.setBounds(3*48 + 50 + 30 +100 + 30,460,100,40);
        loginName.setVisible(false);
        loginPass.setVisible(false);
        signName.setVisible(false);
        signPass.setVisible(false);
    }


    public PanelsManagerCard getCardPanel() {
        return cardPanel;
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        g.drawImage(image,0,0,1248,720,null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == getLogin) {
            startPanelListener.getLogin();
        }
        else if (e.getSource() == getSignIn) {
            startPanelListener.getSignIn();
        }
        else if (e.getSource() == exit) {
            System.exit(0);
        }
        else if (e.getSource() == signIn) {
            loginName.setVisible(false);
            loginPass.setVisible(false);
            getLogin.setVisible(false);
            signName.setVisible(true);
            signPass.setVisible(true);
            getSignIn.setVisible(true);
        }
        else if (e.getSource() == login) {
            loginName.setVisible(true);
            loginPass.setVisible(true);
            getLogin.setVisible(true);
            signName.setVisible(false);
            signPass.setVisible(false);
            getSignIn.setVisible(false);
        }
        else if (e.getSource() == tryAgain) {
            startPanelListener.tryAgain();
        }
    }

    public JTextArea getLoginName() {
        return loginName;
    }

    public void setLoginName(JTextArea loginName) {
        this.loginName = loginName;
    }

    public JTextArea getLoginPass() {
        return loginPass;
    }

    public void setLoginPass(JTextArea loginPass) {
        this.loginPass = loginPass;
    }

    public JTextArea getSignName() {
        return signName;
    }

    public JTextArea getSignPass() {
        return signPass;
    }
}
