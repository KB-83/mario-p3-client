package model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import controller.ClientController;
import model.Chat;
import model.dto.entity.PlayerDTO;
import model.dto.game.GameStateDTO;

import java.util.ArrayList;

public class ClientDTO {
        @JsonIgnore
        private GameStateDTO currentGameStateDTO;
        @JsonIgnore
        private PlayerDTO playerDTO;
        @JsonIgnore
        private ClientController clientController;
        private String username;
        private String password;
        private ArrayList<Chat> chats;
        // vaghti room request miad Setcon shayad asan currunt room bashe
        @JsonIgnore
        private Chat roomChat;
        //    todo : maybe in feature going to add multiplie players
//    private Player[] players;


    public ClientDTO() {
    }

    public ClientDTO(String username, String password,ArrayList<Chat> chats) {
            this.chats = chats;
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


        public ArrayList<Chat> getChats() {
            return chats;
        }

        public void setChats(ArrayList<Chat> chats) {
            this.chats = chats;
        }

    public Chat getRoomChat() {
        return roomChat;
    }

    public void setRoomChat(Chat roomChat) {
        this.roomChat = roomChat;
    }
}
