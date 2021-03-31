package JavaTwoLwssonSix.NewChat.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;



public class Server {
    public Server() {
        try {
            System.out.println("===Запускаем сервер===");
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("===Ожидаем подключения клиента===");
            Socket accept = serverSocket.accept();
            System.out.println("Клиент подключился: " + accept);


            DataInputStream in = new DataInputStream(accept.getInputStream());
            DataOutputStream out = new DataOutputStream(accept.getOutputStream());


            new Thread(() -> {

                while (true) {
                    try {
                        Scanner scanner = new Scanner(System.in);
                        String world = scanner.nextLine();
                        out.writeUTF(world);
                    } catch (IOException e) {
                        System.out.println("499 ошибка - клиентская часть недоступна");
                        break;
                    }
                }
            }).start();


            while (true) {
                try {
                    String message = in.readUTF();
                    if (message.equals("exit")) {
                     break;
                    }
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
