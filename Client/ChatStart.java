package InternetChat.Client;

import InternetChat.Client.gui.ChatFrame;

public class ChatStart {
    public static void run() {
        run("localhost", 8080);
    }

    public static void run(String host, int port) {
        new Chat(host, port);
    }
}
