package view.menu;


import controller.Camera;
import model.dto.game.GameStateDTO;
import view.GameHUI;

import java.awt.*;
import java.awt.event.ActionEvent;


public class GamePanel extends MarioPanel {
    private PanelsManagerCard cardPanel;
    private Graphics2D g2;
    private GameStateDTO gameStateDTO;
    private Camera camera = new Camera();
    private GameHUI gameHUI;
//    private Loop gameloop;

    public GamePanel(PanelsManagerCard cardPanel) {

        this.cardPanel = cardPanel;
//        this.camera = new Camera();
        this.gameHUI = new GameHUI();
        setFocusable(true);
    }

    @Override
    public void setUI() {

    }

    @Override
    public void setOffline(boolean offline) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }


    public GameStateDTO getGameStateDTO() {
        return gameStateDTO;
    }

    public void setGameStateDTO(GameStateDTO gameStateDTO) {
        this.gameStateDTO = gameStateDTO;
        camera.setGameStateDTO(gameStateDTO);
//        gameHUI.setGuiGameState(gameStateDTO);
    }

    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }
//    public void setKeyListener(GameState gameState) {
//        if (getKeyListeners().length == 0) {
//            addKeyListener(new PlayerListener(new PlayerRequestHandler(gameState)));
//        }
//    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2 = (Graphics2D) g;
        if (camera.getGameStateDTO() != null) {
            camera.paintCamera(g2);
            gameHUI.paintHui(g2);
        }
    }

}
