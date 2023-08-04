package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import controller.ClientController;
import model.dto.entity.PlayerDTO;
import model.dto.game.GameStateDTO;

import java.util.ArrayList;
import java.util.List;

public class Client {
    @JsonIgnore
    private GameStateDTO currentGameStateDTO;
    @JsonIgnore
    private PlayerDTO playerDTO;
    @JsonIgnore
    private ClientController clientController;
    private String username;
    private String password;
    private List<Chat> chats;

    //    todo : maybe in feature going to add multiplie players
//    private Player[] players;
    private int coin;
    private int score;
    private int diamond;

    public Client() {

    }

    public Client(String username, String password,ClientController clientController) {
        this.clientController = clientController;
        this.username = username;
        this.password = password;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


    public ClientController getClientController() {
        return clientController;
    }

    public void setClientController(ClientController clientController) {
        this.clientController = clientController;
    }

    public GameStateDTO getCurrentGameStateDTO() {
        return currentGameStateDTO;
    }

    public void setCurrentGameStateDTO(GameStateDTO currentGameStateDTO) {
        this.currentGameStateDTO = currentGameStateDTO;
    }

    public PlayerDTO getPlayerDTO() {
        return playerDTO;
    }

    public void setPlayerDTO(PlayerDTO playerDTO) {
        this.playerDTO = playerDTO;
    }

    public int getDiamond() {
        return diamond;
    }

    public void setDiamond(int diamond) {
        this.diamond = diamond;
    }

    public List<Chat> getChats() {
        return chats;
    }

    public void setChats(List<Chat> chats) {
        this.chats = chats;
    }

}
