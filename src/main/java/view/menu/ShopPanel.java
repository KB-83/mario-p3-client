package view.menu;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ShopPanel extends MarioPanel {

    private PanelsManagerCard cardPanel;
    private List<JRadioButton> buttonList = new ArrayList<>();

    private JRadioButton mario = new JRadioButton("Mario");
    private JRadioButton luigi = new JRadioButton("Luigi");
    private JRadioButton princess = new JRadioButton("Princess");
    private JRadioButton uniqueGirl = new JRadioButton("UniqueGirl");
    private JRadioButton poker = new JRadioButton("Poker");
    private JButton back = new JButton("<-");
    private JButton buy =  new JButton("buy");
    private Image playerImage;
    private Image coinImage;
    int price;
    ShopPanel(PanelsManagerCard cardPanel) {
        this.cardPanel = cardPanel;
        setUI();

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setFont(new Font("monospaced", Font.BOLD, 30));
//        g2.drawString(String.valueOf(user.getCoins()),530,55);
        g2.drawImage(coinImage,465,20,48,48,null);
        if(playerImage!=null){
            g2.drawImage(playerImage,300,200,200,200,null);
            g2.drawString("price:"+price,500,400);
        }
    }

    @Override
    public void setUI() {
        setLayout(null);
        setBackground(Color.red);
        buttonList.add(mario);
        buttonList.add(luigi);
        buttonList.add(princess);
        buttonList.add(uniqueGirl);
        buttonList.add(poker);
        setButtons();
    }

    @Override
    public void setOffline(boolean offline) {

    }

    private void setButtons() {
        ButtonGroup bg=new ButtonGroup();
        mario.setBounds(100,100,100,30);
        luigi.setBounds(100,200,100,30);
        princess.setBounds(100,300,100,30);
        uniqueGirl.setBounds(100,400,100,30);
        poker.setBounds(100,500,100,30);
        back.setBounds(0,0,50,50);
        buy.setBounds(500,500,50,30);
        bg.add(mario);
        bg.add(luigi);
        bg.add(princess);
        bg.add(uniqueGirl);
        bg.add(poker);
        for (JRadioButton button:buttonList){
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    repaint();
                }
            });
        }
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                mario.setSelected(true);
//                loadImage();
                cardPanel.getCardLayout().show(cardPanel,"mainMenu");
                cardPanel.getMainMenu().requestFocus();
            }
        });
        buy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (JRadioButton jRadioButton : buttonList) {
                    if(jRadioButton.isSelected()) {
//                        user.userManager.buyRequest(jRadioButton.getText());
                        saveInfo();
                        break;
                    }
                }
            }
        });
        add(buy);
        add(back);
        add(mario);
        add(luigi);
        add(princess);
        add(uniqueGirl);
        add(poker);

    }
    public void setUser() {
//        this.user = this.card.gM.lM.userManager.currentUser;
        this.repaint();
    }
    private void saveInfo(){
        // TODO: change save and load paradime
//        File file = new File(user.getUserName() + ".json");
//        FileWriter fileWriter = null;
//        try {
//            fileWriter = new FileWriter(file);
//            user.userManager.objectMapper.writeValue(fileWriter,user);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
