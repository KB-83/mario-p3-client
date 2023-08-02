package util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import controller.offline_logic.gamestrucure.GameState;
import model.Client;
import model.dto.ClientDTO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Saver {
    private static Saver saver;
    private ObjectMapper objectMapper = new ObjectMapper();
    private Saver(){
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }
    public static Saver getSaver() {
        if (saver == null) {
            saver = new Saver();
        }return saver;
    }
    public boolean saveUser(ClientDTO client) {
        File file = new File("src/main/resources/local_database/user/"+client.getUsername()+".json");

        try {
            FileWriter fileWriter = new FileWriter(file);
            objectMapper.writeValue(fileWriter,client);
        } catch (IOException e) {
            System.out.println("json mapping for this user is not right.\nsource: Saver class saveUser method.");
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public void saveGameState(GameState gameState, String clientName) {
        File file = new File("src/main/resources/local_database/gamestate/"+clientName+"/"+gameState.getName()+".json");

        try {
            FileWriter fileWriter = new FileWriter(file);
            objectMapper.writeValue(fileWriter,gameState);
        } catch (IOException e) {
            System.out.println("json mapping for this user is not right.\nsource: Saver class saveUser method.");
            e.printStackTrace();
        }
    }

}
