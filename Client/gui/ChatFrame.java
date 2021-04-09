package InternetChat.Client.gui;

import InternetChat.Client.gui.api.Receiver;
import InternetChat.Client.gui.api.Transmitter;

import javax.swing.*;
import java.awt.*;

public class ChatFrame extends JFrame {
    private final JTextArea textArea;

    public ChatFrame(Transmitter transmitter) {
        setTitle("Chat v1.0");
        setBounds(0, 0, 500 , 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());
        textArea = new JTextArea();
        textArea.setEditable(false);
        top.add(textArea, BorderLayout.CENTER);


        JPanel bottom = new JPanel();
        bottom.setLayout(new BorderLayout());

        JTextField inputField = new JTextField();
        bottom.add(inputField, BorderLayout.CENTER);
        JButton submitButton = new JButton("Отправить");
        inputField.addActionListener(new SubmitBtnListenerClick(inputField, submitButton, transmitter));
        submitButton.addActionListener(new SubmitBtnListenerEnter(inputField, submitButton, transmitter));


        bottom.add(submitButton, BorderLayout.EAST);

        add(top, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);
        setVisible(true);

    }


    public Receiver getReceiver() {
        return (message) -> {
            if (!message.isBlank()) {

                textArea.append(message);
                textArea.append("\n");
            }
        };
    }


}
