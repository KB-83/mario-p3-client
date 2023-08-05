package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import controller.connection.ResponseHandler;
import model.request.Request;
import model.response.Response;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class NetworkController extends Thread{
    private ClientController controller;
    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;
    private final ObjectMapper MAPPER = new ObjectMapper();
    private final int PORT_NUM = 9001;
    private static boolean isOnline;
    public NetworkController(ClientController controller) {
        this.controller = controller;
    }
    public boolean connectToServer() {
        try {
            socket = new Socket("localhost", PORT_NUM);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(),true);
        }catch (IOException e) {
            return false;
        }
        return true;
    }
    public void sendRequest(Request request) {
        try {
            writer.println(MAPPER.writeValueAsString(request));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    public void run() {
        isOnline = true;
        while (isOnline) {
            receiveResponse();
        }
    }
    private void receiveResponse() {
        try {
            String s = reader.readLine();
            Response response = MAPPER.readValue(s,Response.class);
            response.visit(ResponseHandler.getInstance(controller.getLocalController()));
        } catch (JsonProcessingException e) {
            System.out.println("json mapping problem");
            throw new RuntimeException(e);
        } catch (IOException | IllegalArgumentException e) {
            isOnline = false;
            System.out.println("client "+ socket.getInetAddress().toString()+" disconnected");
        }
    }

    public static boolean isOnline() {
        return isOnline;
    }
}
