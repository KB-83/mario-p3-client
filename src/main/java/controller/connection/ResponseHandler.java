package controller.connection;

import controller.LocalController;
import model.response.*;
import util.Config;
import util.Saver;
import model.dto.ClientDTO;
import util.Loop;
import view.Notification.CustomDialogPanel;
import view.menu.GamePanel;
import view.menu.MainMenu;
import view.menu.PanelsManagerCard;
import view.menu.room.RoomManagerCard;
import view.menu.room.SimpleRoomPanel;

import javax.swing.*;

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
            localController.getController().setClient(response.getClient());
            response.getClient().setClientController(localController.getController());
            localController.clientCleared(response.getClient());
            panelsManagerCard.getCardLayout().show(panelsManagerCard, MainMenu.class.getSimpleName());
            panelsManagerCard.getStartPanel().requestFocus();
            //save mikonim
            ClientDTO clientDTO = new ClientDTO(response.getClient().getUsername(),response.getClient().getPassword(),response.getClient().getChats());
            Saver.getSaver().saveUser(clientDTO);
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
        System.out.println("here,client,game start response delivered");
        Loop loop = new Loop(localController,response.getGameStateDTO(),response.getPlayerDTO(),panelsManagerCard.getGamePanel(),60);
        localController.setClientCurrentGameLoop(loop);
        loop.start();
        panelsManagerCard.getGamePanel().setGameStateDTO(response.getGameStateDTO(),response.getPlayerDTO());
        panelsManagerCard.getGamePanel().setOnlineKeyListener(localController);
        panelsManagerCard.getCardLayout().show(panelsManagerCard, GamePanel.class.getSimpleName());
        panelsManagerCard.getGamePanel().requestFocus();
    }

    @Override
    public void visit(GameStateStatusResponse response) {
        //bayad gamestate game panel ro in konim.
        panelsManagerCard.getGamePanel().setGameStateDTO(response.getGameStateDTO(),response.getPlayerDTO());
    }

    @Override
    public void visit(NewPMResponse response) {
        localController.getController().getClient().setChats(response.getNewChat());

//        if (ChatPanel baz bood)
        if (!response.getMassage().getSenderUsername().equals(localController.getController().getClient().getUsername())) {
            localController.getFrame().getNotification().showNotification("NEW PM",response.getMassage().getContext());
            panelsManagerCard.getMainChatPanel().setChat(localController.getController().getChatByOpponentName(response.getMassage().getSenderUsername()).getMassages(),response.getMassage().getSenderUsername());
        }
    }

    @Override
    public void visit(BuyResponse response) {
        if (response.getBill() != null) {
            System.out.println(response.getBill().getCoinCost());
            System.out.println(response.getBill().getDiamondCost());
            System.out.println(response.getBill().getBuyRequest().getHammer());
        }
        else {
            System.out.println(response.getMessage());
        }
        System.out.println("buy response returned");
    }

    @Override
    public void visit(GameOverResponse response) {
        // next line is very important
        localController.getClientCurrentGameLoop().kill();
        panelsManagerCard.getGamePanel().getGameOverDialog().showDialog(response.getScore(),response.getDiamond(), response.getMassage());
    }

    @Override
    public void visit(RoomResponse response) {
        System.out.println(response.getRoomToken());
        CustomDialogPanel.showDialog(localController.getFrame().getPanelsManagerCard().getRoomManager(),"token: "+response.getRoomToken() ,CustomDialogPanel.DEFAULT_ICON);
    }

    @Override
    public void visit(DialogResponse response) {
        CustomDialogPanel.showDialog(localController.getFrame().getPanelsManagerCard().getRoomManager(),response.getMassage(),CustomDialogPanel.DEFAULT_ICON);
    }

    @Override
    public void visit(EnterRoomResponse response) {
        //show room panel
        panelsManagerCard.getRoomManager().getCardLayout().show(panelsManagerCard.getRoomManager(), SimpleRoomPanel.class.getSimpleName());
        panelsManagerCard.getCardLayout().show(panelsManagerCard, RoomManagerCard.class.getSimpleName());
    }

    @Override
    public void visit(RoomUpdateResponse response) {
//        if(managere) {}
        panelsManagerCard.getRoomManager().getManagerPanel().setRoom(response.getRoomDTO());
        panelsManagerCard.getRoomManager().getSimpleRoomPanel().setRoom(response.getRoomDTO());
    }

    @Override
    public void visit(RoomChatUpdateResponse response) {
        panelsManagerCard.getRoomManager().getManagerPanel().updateChat(response.getChat());
        panelsManagerCard.getRoomManager().getSimpleRoomPanel().updateChat(response.getChat());
    }
}
