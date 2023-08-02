package util;

import controller.ClientController;
import controller.LocalController;
import controller.NetworkController;
import controller.offline_logic.gamestrucure.GameState;
import controller.offline_logic.tools.DTOCreator;
import model.dto.entity.PlayerDTO;
import model.dto.game.GameStateDTO;
import model.request.GetGameStateRequest;
import view.menu.GamePanel;

public class Loop implements Runnable{
    private GameState offlineGameState;
    private GameStateDTO gameState;// to update
    private PlayerDTO player;
    private LocalController controller;
    private GamePanel gamePanel;// to repaint
    private final GetGameStateRequest updateRequest = new GetGameStateRequest();
    private Thread gameThread;
    private int FPS;
    private boolean running;
    private boolean isPaused;
//    this int is to test app rendering
    private int tryFps;

    public Loop(LocalController localController,GameStateDTO gameState,PlayerDTO player, GamePanel gamePanel, int FPS) {
        this.gamePanel = gamePanel;
        this.gameState = gameState;
        this.FPS = FPS;
        this.player = player;
        this.controller = localController;
    }
    //offline loop
    public Loop(LocalController localController, GameStateDTO gameStateDTO,PlayerDTO player,GameState gameState,GamePanel gamePanel,int FPS) {
        this.gamePanel = gamePanel;
        this.gameState = gameStateDTO;
        this.offlineGameState = gameState;
        this.player = player;
        this.FPS = FPS;
        this.controller = localController;
    }

    public void start(){
        if(gameThread == null) {
            gameThread = new Thread(this);
        }
        running = true;
        gameThread.start();
    }

    public void kill() {
        gameThread.stop();
        running = false;
        gameThread = null;
    }
    public void pause() {
        isPaused = true;
    }
    public void resume() {
        isPaused = false;
    }

    public void run() {
        final long drawInterval = 1000000000/FPS;
        long lastTime = System.nanoTime();
        long startfPS = System.nanoTime();
        long delta = 0;
        long currentTime;
        while (running){
            // sorry but it is the best i can design fo pause mechanisem :(
            //todo : improve pause mechanisem
            while (isPaused){}
            currentTime = System.nanoTime();
            delta = (currentTime - lastTime) / drawInterval ;
            if(delta >= 1){
                tryFps++;
//                gameState = controller;
                if (NetworkController.isOnline()) {
                    controller.sendRequest(updateRequest);
                }
                else {
                    offlineGameState.getGameStateController().update();
                    gamePanel.setGameStateDTO(DTOCreator.updateGameStateDTO(gameState,offlineGameState),DTOCreator.updatePlayerDTO(offlineGameState.getMario(),player));
                }
//                gamePanel.setGameStateDTO(gameState,player);
                gamePanel.repaint();
                lastTime = System.nanoTime();
            }
            if (System.nanoTime()-startfPS >= 1000000000){
                startfPS = System.nanoTime();
                tryFps = 0;
            }
        }
    }
}
