package InternetChat.Client;

import InternetChat.Client.gui.ChatFrame;
import InternetChat.Client.gui.api.Receiver;
import InternetChat.Client.gui.api.Transmitter;


public class Chat {

    private final ChatFrame chatFrame;
    private final ChatCommunication communication;



    public Chat(String host, int port) {
        communication = new ChatCommunication(host, port);
        chatFrame = new ChatFrame(data -> communication.transmit(data));
        new Thread(() -> {
            Receiver receiver = chatFrame.getReceiver();
            while (true)
                receiver.receive(communication.receive());
        }).start();
    }


    private void getMessage() {
       String receive = communication.receive();
    }

}
