package InternetChat.Client.gui;

import InternetChat.Client.gui.api.Transmitter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubmitBtnListenerEnter implements ActionListener {
    private final JTextField inputField;
    private final JButton submitButton;
    private final Transmitter transmitter;

    public SubmitBtnListenerEnter(JTextField inputField, JButton submitButton, Transmitter transmitter) {
        this.submitButton = submitButton;
        this.transmitter = transmitter;
        this.inputField = inputField;
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (inputField.getText() == null || inputField.getText().equals("")) {
            inputField.setText("Вы указали пустую строку!");
        } else if (inputField.getText().equals("Вы указали пустую строку!")) {
            inputField.setText("");
        } else {
            transmitter.transmit(inputField.getText());
            inputField.setText("");
        }
    }


}
