package util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import controller.ClientController;
import model.dto.ClientDTO;

import java.io.File;
import java.io.IOException;

public class Loader {
    private static Loader loader;
    private ObjectMapper objectMapper = new ObjectMapper();
    private Loader(){
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }
    public static Loader getLoader() {
        if (loader == null) {
            loader = new Loader();
        }return loader;
    }
    public ClientDTO loadLocalClient (String userName,String password, ClientController clientController) {
        File file = new File("src/main/resources/local_database/user/"+userName+".json");
        ClientDTO client = null;
        if (!file.exists()) {
            System.out.println("you have to sign in online first");
            return null;
        }
        try {
            client = objectMapper.readValue(file, ClientDTO.class);
            } catch (IOException e) {
            System.out.println("json mapping for this user is not right.\nsource: Loader class loadUser method.");
            e.printStackTrace();
        }
        if (password.equals(client.getPassword())){
//           clientController.sendResponse(new SignInLoginResponse(client,true,""));
           //show panels
        return client;}
        else {
            System.out.println("password is wrong");
            return null;
        }
    }
//    public Game loadGame(String name) {
//        File file = new File("src/main/resources/game/"+name+".json");
//        Game game = null;
//        try {
//            game = objectMapper.readValue(file, Game.class);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        return game;
//    }

}
