package controller.connection;

import controller.ClientController;
import controller.LocalController;
import model.dto.game.GameStateDTO;
import model.response.GameStartResponse;
import model.response.GameStateStatusResponse;
import model.response.SignInLoginResponse;
import util.Loop;
import view.menu.GamePanel;
import view.menu.MainMenu;
import view.menu.PanelsManagerCard;

public class ResponseHandler implements ResponseVisitor{
    private static ResponseHandler responseHandler;
    private PanelsManagerCard panelsManagerCard;
    private LocalController localController;
    private ResponseHandler(LocalController localController) {
        this.panelsManagerCard = localController.getFrame().getPanelsManagerCard();
        this.localController = localController;
    }
    public static ResponseHandler getInstance(LocalController localController) {
        if (responseHandler == null) {
            responseHandler = new ResponseHandler(localController);
        }
        return responseHandler;
    }

    @Override
    public void visit(SignInLoginResponse response) {
        if (response.isOk()){
            panelsManagerCard.getCardLayout().show(panelsManagerCard, MainMenu.class.getSimpleName());
            panelsManagerCard.getStartPanel().requestFocus();
        }
        else {
            System.out.println(response.getMassage());
        }
    }

    @Override
    public void visit(GameStartResponse response) {

//        user.setCurrentGameState(gameState);
//        panelsManagerCard.getGamePanel().setKeyListener(gameState);
        //test
        Loop loop = new Loop(localController,response.getGameStateDTO(),response.getPlayerDTO(),panelsManagerCard.getGamePanel(),60);
        loop.start();
        panelsManagerCard.getGamePanel().setGameStateDTO(response.getGameStateDTO(),response.getPlayerDTO());
        panelsManagerCard.getCardLayout().show(panelsManagerCard, GamePanel.class.getSimpleName());
        panelsManagerCard.getGamePanel().requestFocus();
    }

    @Override
    public void visit(GameStateStatusResponse response) {
        //bayad gamestate game panel ro in konim.
        panelsManagerCard.getGamePanel().setGameStateDTO(response.getGameStateDTO(),response.getPlayerDTO());
    }
}
