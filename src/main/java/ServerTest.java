import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9000);
        while (true) {
            Socket socket = serverSocket.accept();
        }
    }
}