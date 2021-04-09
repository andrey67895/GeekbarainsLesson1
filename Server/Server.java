package InternetChat.Server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class Server {

    private final AuthServer authServer;
    private final Set<ClientHandler> loggedClients;
    public Server() {
        authServer = new AuthServer();
        loggedClients = new HashSet<>();
        try {
            ServerSocket socket = new ServerSocket(8080);
            System.out.println("Сервер запускается");
            while (true) {
                System.out.println("Сервер ждет подключения клиента");
                Socket clientSocket = socket.accept();
                new ClientHandler(clientSocket, this);
            }

        } catch (IOException e) {
           throw new ChatServerException("Ошибка при работе сервера", e);
        }
    }


    public AuthServer getAuthServer() {
        return authServer;
    }

    public void breadcast(String message) {
        for (ClientHandler clientHandler : loggedClients) {
                clientHandler.sendMessage(message);
        }
    }

    public void subscribe(ClientHandler clientHandler) {
        loggedClients.add(clientHandler);
    }

    public void unsubscribe(ClientHandler clientHandler) {
        loggedClients.add(clientHandler);

    }

    public boolean isLoggedIn (String name) {

        
      return loggedClients.stream()
                     .filter(client -> client.getName().equals(name))
                        .findFirst().isPresent();
    }
}
