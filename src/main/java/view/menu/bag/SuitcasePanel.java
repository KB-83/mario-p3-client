package view.menu.bag;

import util.Config;

import javax.swing.*;
import java.awt.*;

public class SuitcasePanel extends JPanel {
    private ImageIcon[] imageIcons;
    private final Image suitcaseImage = Config.IMAGES.get("suitcaseORG");

    public SuitcasePanel(ImageIcon[] imageIcons) {
        this.imageIcons = imageIcons;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }
    public void setItems(String[] items) {
        imageIcons = new ImageIcon[5];
        int i = 0;
        for (String item : items) {
            if (item != null) {
                imageIcons[i] = new ImageIcon(Config.IMAGES.get(item));
            }
            i++;
        }
        revalidate();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int suitcaseY = 30;
        int suitcaseX = 60;
        g.drawImage(suitcaseImage, suitcaseX, suitcaseY, this);
        int x = 20 + suitcaseX;
        int y = 40 + suitcaseY;
        int width = suitcaseImage.getWidth(null)/6;
        for (ImageIcon icon : imageIcons) {
            if (icon != null) {
                Image image = icon.getImage();
                g.drawImage(image, x, y,width,width, this);
            }
            x += width + (width/30);
        }
    }
}

