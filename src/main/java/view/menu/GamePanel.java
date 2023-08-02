package view.menu;


import controller.Camera;
import controller.LocalController;
import controller.listener.PlayerListener;
import controller.offline_logic.requsethandler.PlayerRequestHandler;
import controller.offline_logic.requsethandler.UserRequestHandler;
import model.dto.entity.PlayerDTO;
import model.dto.game.GameStateDTO;
import view.GameHUI;

import java.awt.*;
import java.awt.event.ActionEvent;


public class GamePanel extends MarioPanel {
    private PanelsManagerCard cardPanel;
    private Graphics2D g2;
    private GameStateDTO gameStateDTO;
    private final Camera camera = new Camera();
    private final GameOverDialog gameOverDialog;
    private GameHUI gameHUI;
//    private Loop gameloop;

    public GamePanel(PanelsManagerCard cardPanel) {
        gameOverDialog = new GameOverDialog(cardPanel.getFrame(),cardPanel);
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

    public void setGameStateDTO(GameStateDTO gameStateDTO, PlayerDTO playerDTO) {
        this.gameStateDTO = gameStateDTO;
        this.
        camera.setGameStateDTO(gameStateDTO);
        camera.setPlayerDTO(playerDTO);
//        gameHUI.setGuiGameState(gameStateDTO);
    }

    public Camera getCamera() {
        return camera;
    }
    public void setOnlineKeyListener(LocalController localController) {
        if (getKeyListeners().length == 0) {
            addKeyListener(new PlayerListener(localController));
        }
    }
    public void setOfflineKeyListener(PlayerRequestHandler playerRequestHandler) {
        if (getKeyListeners().length == 0) {
            addKeyListener(new PlayerListener(playerRequestHandler));
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2 = (Graphics2D) g;
        if (camera.getGameStateDTO() != null && camera.getPlayerDTO() != null) {
            camera.paintCamera(g2);
            gameHUI.paintHui(g2);
        }
    }

    public GameOverDialog getGameOverDialog() {
        return gameOverDialog;
    }
}
