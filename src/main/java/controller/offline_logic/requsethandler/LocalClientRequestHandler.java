package controller.offline_logic.requsethandler;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import controller.LocalController;
import controller.offline_logic.gamelogic.gamestatelogic.GameStateController;
import controller.offline_logic.gamestrucure.Game;
import controller.offline_logic.gamestrucure.GameState;
import controller.offline_logic.tools.DTOCreator;
import model.Client;
import model.dto.entity.PlayerDTO;
import model.dto.game.GameStateDTO;
import util.Loader;
import util.Loop;
import view.menu.GamePanel;
import view.menu.PanelsManagerCard;

import java.io.File;
import java.io.IOException;


public class LocalClientRequestHandler {
    private LocalController localController;
    private Client client;
    public LocalClientRequestHandler(LocalController localController){
        this.localController = localController;
    }
//    public boolean loginRequest(String username, String password){
//        Client user = Loader.getLoader().loadUser(username);
//        if (user != null){
//            if (user.getPassword().equals(password)) {
//                user.setUserRequestHandler(this);
//                user.setLogicManager(logicManager);
//                this.user = user;
//                logicManager.setUser(user);
//                logicManager.getGraphicManager().setUser(user);
//                return true;
//            }
//            System.out.println("password is incorrect.");
//        }
//        return false;
//    }
//    public boolean signInRequest(String username, String password){
//        User user = new User(username,password);
//        boolean b = Saver.getSaver().saveUser(user,true);
//        if (!b){
//            return false;
//        }
//        this.user = user;
//        user.setUserRequestHandler(this);
//        user.setLogicManager(logicManager);
//        // todo: load default gameAs a Config
//        Game game = new Game();
//        game.setName("default");
//        Level level = new Level();
////        todo : uncomment next line if nessesary
////        level.setSections(new Section[]{new Section(1,1,)});
//        game.setLevels(new Level[]{level});
//
//        Game[] games = {game};
//        user.setGames(games);
//        // todo : dont add game here
//        logicManager.setUser(user);
////      todo: do the things
//
//        return true;
//    }
    public GameState newGameRequest(String gameName) {
//        Loader game ro load mikone
        Game game = Loader.getLoader().loadGame(gameName);

        // todo set game default
        if (game != null) {
            PanelsManagerCard panelsManagerCard = localController.getFrame().getPanelsManagerCard();
            GameState gameState = new GameStateController().createGameState(game);
            GameStateDTO gameStateDTO = DTOCreator.createGameStateDTO(gameState);
            PlayerRequestHandler playerRequestHandler = new PlayerRequestHandler(gameState);
            PlayerDTO playerDTO = DTOCreator.createPlayerDTO(gameState.getMario());//todo : test it
            Loop loop = new Loop(localController,gameStateDTO,playerDTO,gameState,panelsManagerCard.getGamePanel(),60);
            localController.setClientCurrentGameLoop(loop);
            loop.start();
            panelsManagerCard.getGamePanel().setGameStateDTO(gameStateDTO,playerDTO);
            panelsManagerCard.getGamePanel().setOfflineKeyListener(gameState.getMario().getPlayerRequestHandler());
            panelsManagerCard.getCardLayout().show(panelsManagerCard, GamePanel.class.getSimpleName());
            panelsManagerCard.getGamePanel().requestFocus();


            return gameState;
        }
        return null;
    }
    //todo : chizi ke bayad data base save konam
    public void lastGameRequest (String clientName,String gameName) {
        String gameAddress = "/Users/kajal/Documents/AP/project/ProjectP3/mario_p3-client" +
                "/src/main/resources/local_database/gamestate/"+clientName+"/"+gameName+".json";
        GameState gameState = null;
        try {
            //test
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(gameAddress);
            gameState = objectMapper.readValue(file, GameState.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        new GameStateController().createGameState(gameState);
        GameStateDTO gameStateDTO = DTOCreator.createGameStateDTO(gameState);
        PlayerRequestHandler playerRequestHandler = new PlayerRequestHandler(gameState);
        PlayerDTO playerDTO = DTOCreator.createPlayerDTO(gameState.getMario());//todo : test it

        PanelsManagerCard panelsManagerCard = localController.getFrame().getPanelsManagerCard();
        Loop loop = new Loop(localController,gameStateDTO,playerDTO,gameState,panelsManagerCard.getGamePanel(),60);
        localController.setClientCurrentGameLoop(loop);
        loop.start();
        panelsManagerCard.getGamePanel().setGameStateDTO(gameStateDTO,playerDTO);
        panelsManagerCard.getGamePanel().setOfflineKeyListener(gameState.getMario().getPlayerRequestHandler());
        panelsManagerCard.getCardLayout().show(panelsManagerCard, GamePanel.class.getSimpleName());
        panelsManagerCard.getGamePanel().requestFocus();
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
