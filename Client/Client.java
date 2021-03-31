package JavaTwoLwssonSix.NewChat.Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public Client() {
        try {
            Socket socket = new Socket("127.0.0.1", 8080);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            new Thread(() -> {

                while (true) {
                    try {
                        Scanner scanner = new Scanner(System.in);
                        String world = scanner.nextLine();
                        out.writeUTF(world);
                    } catch (IOException e) {
                        System.out.println("Server down...");
                        System.out.println("500 ошибка - сервер недоступен");
                        break;
                    }
                }
            }).start();


            while (true) {
                try {
                    String message = in.readUTF();
                    System.out.println(message);
                } catch (IOException e) {
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
