package controller.connection;

import controller.ClientController;
import model.dto.game.GameStateDTO;
import model.response.GameStartResponse;
import model.response.SignInLoginResponse;
import view.menu.GamePanel;
import view.menu.MainMenu;
import view.menu.PanelsManagerCard;

public class ResponseHandler implements ResponseVisitor{
    private static ResponseHandler responseHandler;
    private PanelsManagerCard panelsManagerCard;
    private ResponseHandler(PanelsManagerCard panelsManagerCard) {
        this.panelsManagerCard = panelsManagerCard;
    }
    public static ResponseHandler getInstance(PanelsManagerCard panelsManagerCard) {
        if (responseHandler == null) {
            responseHandler = new ResponseHandler(panelsManagerCard);
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
        panelsManagerCard.getGamePanel().setGameStateDTO(response.getGameStateDTO());
        panelsManagerCard.getCardLayout().show(panelsManagerCard, GamePanel.class.getSimpleName());
        panelsManagerCard.getGamePanel().requestFocus();
    }
}
