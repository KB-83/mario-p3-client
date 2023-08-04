package util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Config extends Properties {
    private static final String CONFIGS_ADDRESS = "src/main/resources/config/address.properties";
    private static final Config DEFAULT_CONFIG = new Config(CONFIGS_ADDRESS);
    public final static HashMap<String, Image> IMAGES = new HashMap<>();

    public static Config getConfig(String name) {
        if ("mainConfig".equals(name))
            return DEFAULT_CONFIG;
        return new Config(DEFAULT_CONFIG.getProperty(name));
    }
    //singleton

    private Config(String address) {
        super();
        try {
            Reader fileReader = new FileReader(address);
            this.load(fileReader);
        } catch (IOException e) {
            System.err.println(address);
            e.printStackTrace();
        }
    }
    public int getPropertyAsInt(String name){
        return Integer.parseInt(super.getProperty(name));
    }
    public boolean getPropertyAsBoolean(String name) {
        return Boolean.parseBoolean(super.getProperty(name));
    }
    public static void loadConfigs() {
        loadImages("images");
    }
    private  static Map<String, String> loadImages(String name) {
        Config config = getConfig(name);
        Map<String, String> imageMap = new HashMap<>();

        for (String key : config.stringPropertyNames()) {
                String imagePath = config.getProperty(key);
                imageMap.put(key, imagePath);
            try {
                BufferedImage bufferedImage = ImageIO.read(Config.class.getResourceAsStream("/image"+imagePath));


                BufferedImage resizedImage = new BufferedImage(48, 48, bufferedImage.getType());
                resizedImage.getGraphics().drawImage(bufferedImage, 0, 0, 48, 48, null);
                IMAGES.put(key, resizedImage);
                IMAGES.put(key+"ORG", bufferedImage);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return imageMap;
    }

    // ...
}
