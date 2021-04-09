package InternetChat.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Optional;
import java.util.Set;

public class ClientHandler {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private String name;
    private Server server;


    public ClientHandler(Socket socket, Server server) {
        this.socket = socket;
        this.server = server;
        try {
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            throw new ChatServerException("Проблемы с передачей данных клиента", e);
        }
        new Thread(() -> {
        doAuth();
        listen();
        }) .start();
    }

    public String getName() {
        return name;
    }

    private void listen() {
        receiveMessage();
    }

    private void doAuth() {
        sendMessage("Добро подаловать! Введите логин и пароль! В формате: -auth login password");
        while (true) {
            try {
                String message = in.readUTF();
                if (message.startsWith("-auth")) {
                    String[] credentials = message.split(" ");
                    String login = credentials[1];
                    String password = credentials[2];
                    Optional<AuthServer.Entry> maybeCredentials = this.server.getAuthServer().findEntryByCredentials(login, password);
                    if (maybeCredentials.isPresent()) {
                        AuthServer.Entry credential = maybeCredentials.get();
                        if (!this.server.isLoggedIn(credential.getName())) {
                            name = credential.getName();
                            this.server.breadcast(String.format("Пользователь %s вошел в чат", name));
                            sendMessage(String.format("Пользователь %s вошел в чат", name));
                            this.server.subscribe(this);
                            return;
                        } else {
                            sendMessage(String.format("Пользователь с именем %s уже залогинен", credential.getName()));
                        }

                    } else {
                        sendMessage("Некорректный логин и/или пароль");
                    }
                } else {
                   sendMessage("Некорректная команда авторизации");
                }
            } catch (IOException e) {
                throw new ChatServerException("Проблемы с авторизацией клиента", e);
            }
        }
    }

    public void receiveMessage() {
        while (true) {
            try {
        String message = in.readUTF();
        server.breadcast(message);
            } catch (IOException e) {
                throw new ChatServerException("Ошибка при получении сообщения", e);
            }
        }
    }


    public void sendMessage(String message) {
        try {

                out.writeUTF(message);



        } catch (IOException e) {
            throw new ChatServerException("Ошибка при отправке сообщения", e);
        }
    }

}
