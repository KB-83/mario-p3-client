package controller;

import model.dto.backgroundobject.block.BlockDTO;
import model.dto.backgroundobject.pipe.PipeDTO;
import model.dto.entity.EnemyDTO;
import model.dto.entity.ItemDTO;
import model.dto.entity.PlayerDTO;
import model.dto.entity.power.BulletDTO;
import model.dto.game.GameStateDTO;
import util.Config;


import java.awt.*;

public class Camera {
    // world button column which it have to start painting from
    private GameStateDTO gameStateDTO;
    private int startPaintingX ,endPaintingX;
    private int minasXLength;
    private PlayerDTO playerDTO;
    // Assuming you have loaded the font file and created the Font object
    private Font cartoonFont = new Font("Comic Sans MS", Font.PLAIN, 20);


    public Camera() {
        startPaintingX = 0;
        // need to be change
//        endPaintingX = Constant.PANEL_WIDTH;
        endPaintingX = 1248;
        minasXLength = 0;
    }
    public void paintCamera(Graphics2D g2) {
        updateCameraLocation();
        //paint Background
        //todo : make it behine

            for (int i = 0; i< gameStateDTO.getCurrentSection().getBackGroundTiles().length; i++){
                for (int j = startPaintingX/48;j< endPaintingX/48;j++){
                    int num = 0;
                    try {
                        num = gameStateDTO.getCurrentSection().getBackGroundTiles()[i][j];
                    }
                    catch (ArrayIndexOutOfBoundsException e){
                        //todo : there is a bug in section changing which i dont know.
                        System.out.println(gameStateDTO.getCurrentSection().getBackGroundTiles()[0].length+"  array out of bound");
                    }

                    Image image = Config.IMAGES.get("backgroundTile"+num);
                g2.drawImage(image, (j* 48)-minasXLength,
                        i * 48,48,
                        48,null);


            }
        }

//        drawing enemies
//        System.out.println("camera 44   "+);
        if (gameStateDTO.getCurrentSection().getEnemies() != null) {
            for (int i = 0;i < gameStateDTO.getCurrentSection().getEnemies().length;i++) {
                EnemyDTO enemy =  gameStateDTO.getCurrentSection().getEnemies()[i];
                Image image = Config.IMAGES.get(enemy.getType().toLowerCase());
                g2.drawImage(image, enemy.getX() - minasXLength, enemy.getY(), 48, 48, null);

            }

        }
//        }
//        //paint blocks
//        //todo: add all of this things to an array of background objects then you can add flag and bla bla ...
        for (BlockDTO blockDTO : gameStateDTO.getCurrentSection().getBlocks()) {
//            if(checkBound(block.getX(), block.getY())) {
//                // draw blocks
//            }
            Image image = Config.IMAGES.get(blockDTO.getType().toLowerCase());
            g2.drawImage(image,(blockDTO.getCol()*48)- minasXLength,
                    blockDTO.getRow()*48, null);
        }
////         drawing pipes
//        todo check i something is null
//        todo : clean camera class and functionize it
        if(gameStateDTO.getCurrentSection().getPipes() != null) {
            for (PipeDTO pipeDTO : gameStateDTO.getCurrentSection().getPipes()) {
//            if(checkBound(pipe.getX(), pipe.getY())) {
//                // draw pipes
//            }
                Image image = Config.IMAGES.get("pipe");
                g2.drawImage(image, (pipeDTO.getCol() * 48) - minasXLength,
                        pipeDTO.getRow() * 48,
                        48 * 2, 48 * 3, null);
            }
        }
        //item
        if (gameStateDTO.getCurrentSection().getItems() != null) {
            for (ItemDTO itemDTO : gameStateDTO.getCurrentSection().getItems()) {
                if (!itemDTO.isLock()) {
                    Image image = Config.IMAGES.get(itemDTO.getType().toLowerCase());
                    g2.drawImage(image, itemDTO.getX() - minasXLength, itemDTO.getY(),
                            48, 48, null);
                }
            }
        }

//         drying player
        Image image;
        if (playerDTO.getImage() != null) {
            image = Config.IMAGES.get(playerDTO.getImage().toLowerCase());
        }
        else {
            image = Config.IMAGES.get("marioright1");
        }
        g2.drawImage(image, playerDTO.getCameraX(),
                playerDTO.getCameraY()
                , 48, playerDTO.getHeight(),
                null );


        //draying other players

        for (PlayerDTO playerDTO1 : gameStateDTO.getPlayerDTOS()) {
            if (playerDTO1.getImage() != null) {
                image = Config.IMAGES.get(playerDTO1.getImage().toLowerCase());
            }
            else {
                image = Config.IMAGES.get("marioright1");
            }

            g2.setFont(cartoonFont);

            if (playerDTO.getName() != null &&playerDTO.getName().equals(playerDTO1.getName())) {
                g2.drawImage(image, playerDTO1.getCameraX(),
                        playerDTO1.getCameraY()
                        , 48, playerDTO1.getHeight(),
                        null);
                g2.setColor(Color.BLACK);
                g2.drawString(playerDTO1.getName(),playerDTO1.getCameraX(), playerDTO1.getCameraY() - 50);

            }
            else if (playerDTO1.getName() != null){
                g2.drawImage(image, playerDTO1.getX() - minasXLength,
                        playerDTO1.getY()
                        , 48, playerDTO1.getHeight(),
                        null);
                g2.setColor(Color.BLACK);
                g2.drawString(playerDTO1.getName(),playerDTO1.getX() - minasXLength, playerDTO1.getY() - 50);

                g2.setColor(Color.WHITE);
                g2.drawRoundRect(playerDTO1.getX(),playerDTO1.getY() - 30,100,15,5,5);
                g2.setColor(new Color(playerDTO1.getTeamColor()));
                g2.fillRoundRect(playerDTO1.getX(),playerDTO1.getY() - 30,
                        playerDTO1.getRemainingLifePercent(),15,5,5);
            }
        }
        g2.setColor(Color.BLACK);
        g2.drawString(String.valueOf(gameStateDTO.getCurrentSection().getTime()),100,100);
        //draw chckPoint test
//        if(gameStateDTO.getCurrentGuiSection().getGuiCheckPoint() != null) {
//            g2.drawImage(gameStateDTO.getCurrentGuiSection().getGuiCheckPoint().getCurrentImage(), gameStateDTO.getCurrentGuiSection().getGuiCheckPoint().getWorldX() - minasXLength,
//                    gameStateDTO.getCurrentGuiSection().getGuiCheckPoint().getWorldY(), gameStateDTO.getCurrentGuiSection().getGuiCheckPoint().getWidth(),
//                    gameStateDTO.getCurrentGuiSection().getGuiCheckPoint().getHeight(),
//                    null);
//        }
//        dryingBullet
//        BulletDTO bulletDTO = playerDTO.getGuiBullet();
//        if (!guiBullet.isLock()){
//            g2.drawImage(guiBullet.getCurrentImage(),guiBullet.getWorldX() - minasXLength,guiBullet.getWorldY(),
//                    guiBullet.getWidth(),guiBullet.getHeight(),null);
//        }
        //dryingSward
//        GuiSward guiSward = gameStateDTO.getGuiPlayer().getGuiSward();
//        if (!guiSward.isLock()){
//            g2.drawImage(guiSward.getCurrentImage(),guiSward.getWorldX() - minasXLength,guiSward.getWorldY(),
//                    guiSward.getWidth(),guiSward.getHeight(),null);
//        }
        if (playerDTO.getRemainingLifePercent() >= 0) {
            g2.setColor(Color.WHITE);
            g2.drawRoundRect(playerDTO.getX(),playerDTO.getY() - 30,100,15,5,5);
            g2.setColor(new Color(playerDTO.getTeamColor()));
            g2.fillRoundRect(playerDTO.getX(),playerDTO.getY() - 30,
                    playerDTO.getRemainingLifePercent(),15,5,5);
        }
    }
    private boolean checkBound (int x , int y) {
        if(x < endPaintingX && x > startPaintingX) {
            return true;
        }
        return false;
    }
    public void updateCameraLocation(){
        if (gameStateDTO != null) {
//            startPaintingX = playerDTO.getX() - Constant.PANEL_WIDTH;
            startPaintingX = playerDTO.getX() - 1248;
            if (startPaintingX < 0 ) {
                startPaintingX = 0;
            }//- game panel size;
            // todo: player camera x doesnt need to be initialize in logic player im goinig to creat it in graphic
//            endPaintingX = startPaintingX + 2 * Constant.PANEL_WIDTH;//+ 2 gamePanel Size
            endPaintingX = startPaintingX + (2 * 1248);//+ 2 gamePanel Size
            if (endPaintingX > gameStateDTO.getCurrentSection().getBackGroundTiles()[0].length * 48){
                endPaintingX = gameStateDTO.getCurrentSection().getBackGroundTiles()[0].length * 48;
            }
            minasXLength = playerDTO.getX() - playerDTO.getCameraX();
        }
    }

    public GameStateDTO getGameStateDTO() {
        return gameStateDTO;
    }

    public void setGameStateDTO(GameStateDTO gameStateDTO) {
        this.gameStateDTO = gameStateDTO;
    }

    public int getStartPaintingX() {
        return startPaintingX;
    }

    public void setStartPaintingX(int startPaintingX) {
        this.startPaintingX = startPaintingX;
    }

    public int getEndPaintingX() {
        return endPaintingX;
    }

    public void setEndPaintingX(int endPaintingX) {
        this.endPaintingX = endPaintingX;
    }
    // world button row which it have to start painting from

    public int getMinasXLength() {
        return minasXLength;
    }

    public void setMinasXLength(int minasXLength) {
        this.minasXLength = minasXLength;
    }

    public PlayerDTO getPlayerDTO() {
        return playerDTO;
    }

    public void setPlayerDTO(PlayerDTO playerDTO) {
        this.playerDTO = playerDTO;
    }


//    private int endY;
}