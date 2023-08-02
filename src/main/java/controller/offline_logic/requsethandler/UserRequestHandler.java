package controller.offline_logic.requsethandler;

import controller.LocalController;
import controller.offline_logic.LogicManager;
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


public class UserRequestHandler {
    private LocalController localController;
    private Client client;
    public UserRequestHandler(LocalController localController){
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
            PlayerDTO playerDTO = DTOCreator.createPlayerDTO(gameState.getMario());//todo : test it
            Loop loop = new Loop(localController,gameStateDTO,playerDTO,gameState,panelsManagerCard.getGamePanel(),60);
            localController.setClientCurrentGameLoop(loop);
            loop.start();
            panelsManagerCard.getGamePanel().setGameStateDTO(gameStateDTO,playerDTO);
            panelsManagerCard.getGamePanel().setKeyListener(localController);
            panelsManagerCard.getCardLayout().show(panelsManagerCard, GamePanel.class.getSimpleName());
            panelsManagerCard.getGamePanel().requestFocus();


            return gameState;
        }
        return null;
    }

//    public void lastGameRequest (String gameName) {
//        GameState gameState = null;
//        for (GameState gameState1 :logicManager.getUser().getSavedGames()){
//            if (gameName.equals(gameState1.getName())){
//                gameState = gameState1;
//                break;
//            }
//        }
//        if (gameState == null){
//            System.out.println("oops this game does not exist.");
//            System.out.println("our developers are working on it.");
//            System.out.println("please wait for 2 hours...");
//            return;
//        }
//        // todo set game default
//        if (gameState != null) {
//            user.setCurrentGameState(gameState);
//            new GameStateController().createGameState(gameState,logicManager);
//            // todo: (lines start whit blue)next line is really dirty you can send it as a request to graphic
//            logicManager.getGraphicManager().getFrame().getPanelsManagerCard().getGamePanel().setKeyListener(gameState);
//            //todo ; this also
//            logicManager.getGraphicManager().getFrame().getPanelsManagerCard().getGamePanel().setGuiGameState(GuiGameCreator.createGameState(gameState,null));
//        }
//    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
