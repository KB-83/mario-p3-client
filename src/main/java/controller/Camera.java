package controller;

import model.dto.backgroundobject.block.BlockDTO;
import model.dto.backgroundobject.pipe.PipeDTO;
import model.dto.entity.enemy.EnemyDTO;
import model.dto.entity.item.ItemDTO;
import model.dto.entity.player.PlayerDTO;
import model.dto.game.GameStateDTO;
import util.Config;


import java.awt.*;

public class Camera {
    // world button column which it have to start painting from
    private GameStateDTO gameStateDTO;
    private int startPaintingX ,endPaintingX;
    private int minasXLength;
    private PlayerDTO playerDTO;

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
                    int num = gameStateDTO.getCurrentSection().getBackGroundTiles()[i][j];
                    Image image = Config.IMAGES.get("backgroundTile"+num);
                g2.drawImage(image, (j* 48)-minasXLength,
                        i * 48,48,
                        48,null);
            }
        }
//        for (GuiBackgroundTile guiBackGroundTile: guiGameState.getCurrentGuiSection().getGuibackgroundMap().getGuiBackGroundTiles()) {
//            g2.drawImage(GuiBackgroundMap.getImages()[guiBackGroundTile.getNum().getIndex()], (guiBackGroundTile.getCol() * Constant.BACKGROUND_TILE_SIZE)-minasXLength,
//                        guiBackGroundTile.getRow() * Constant.BACKGROUND_TILE_SIZE,Constant.BACKGROUND_TILE_SIZE,
//                        Constant.BACKGROUND_TILE_SIZE,null);
//        }
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
                    blockDTO.getRow()*48,
                    55,55,null);
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
                Image image = Config.IMAGES.get(itemDTO.getType().toLowerCase());
                g2.drawImage(image,itemDTO.getX() - minasXLength ,itemDTO.getY(),
                        48,48,null);
            }
        }

//         drying player
        Image image = Config.IMAGES.get("mario");
        g2.drawImage(image, playerDTO.getCameraX(),
                playerDTO.getCameraY()
                , 48, 48,
                null );
        //draw chckPoint test
//        if(gameStateDTO.getCurrentGuiSection().getGuiCheckPoint() != null) {
//            g2.drawImage(gameStateDTO.getCurrentGuiSection().getGuiCheckPoint().getCurrentImage(), gameStateDTO.getCurrentGuiSection().getGuiCheckPoint().getWorldX() - minasXLength,
//                    gameStateDTO.getCurrentGuiSection().getGuiCheckPoint().getWorldY(), gameStateDTO.getCurrentGuiSection().getGuiCheckPoint().getWidth(),
//                    gameStateDTO.getCurrentGuiSection().getGuiCheckPoint().getHeight(),
//                    null);
//        }
        //dryingBullet
//        GuiBullet guiBullet = gameStateDTO.getGuiPlayer().getGuiBullet();
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
    }
    private boolean checkBound (int x , int y) {
        if(x < endPaintingX && x > startPaintingX) {
            return true;
        }
        return false;
    }
    public void updateCameraLocation(){
//        if (gameStateDTO != null) {
////            startPaintingX = playerDTO.getX() - Constant.PANEL_WIDTH;
//            startPaintingX = playerDTO.getX() - 1248;
//            if (startPaintingX < 0 ) {
//                startPaintingX = 0;
//            }//- game panel size;
//            // todo: player camera x doesnt need to be initialize in logic player im goinig to creat it in graphic
////            endPaintingX = startPaintingX + 2 * Constant.PANEL_WIDTH;//+ 2 gamePanel Size
//            endPaintingX = startPaintingX + 2 * 1248;//+ 2 gamePanel Size
////            if (endPaintingX > gameStateDTO.getCurrentGuiSection().getGuibackgroundMap().getGuiBackGroundTiles()[0].length * Constant.BACKGROUND_TILE_SIZE){
////                endPaintingX = gameStateDTO.getCurrentGuiSection().getGuibackgroundMap().getGuiBackGroundTiles()[0].length * Constant.BACKGROUND_TILE_SIZE;
////            }
//            minasXLength = playerDTO.getX() - playerDTO.getCameraX();
//        }
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