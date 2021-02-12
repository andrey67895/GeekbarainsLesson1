package Chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyChat extends JFrame {
    private static final JLabel textInChat = new JLabel();
    private static final JTextField field = new JTextField(16);
    private static final JButton button = new JButton("Отправить!");
    private static final JPanel panel = new JPanel();
    private static final JPanel panel2 = new JPanel();
    private static final Font fontBoldSerif = new Font("Serif", Font.BOLD, 20);
    private static final int macCountInChat = 10;
    private static String allTextChat = "В чате максимально отображается 10 сообщений!";
    private static int countChat = 0;

    public MyChat() {
        setBounds(500, 500, 400, 300);
        setTitle("DEMO: Чат - давайте пообщаемся");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        panel.setSize(300, 300);
        field.setFont(fontBoldSerif);
        field.setBackground(new Color(184, 200, 205));
        button.setBackground(new Color(171, 228, 239));
        panel.add(field);
        panel.add(button);
        panel2.add(textInChat);
        add(panel, BorderLayout.NORTH);
        add(panel2, BorderLayout.CENTER);
        textInChat.setText("В чате максимально отображается 10 сообщений!");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getTextInChat();
            }
        });
        field.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getTextInChat();
            }
        });

        setVisible(true);
    }

    private static void getTextInChat() {
        String newChatText = field.getText();
        System.out.println("Your message: " + newChatText);
        allTextChat = (allTextChat + "<br>" + "Ваше сообщение: " + newChatText);
        textInChat.setText("<html>" + allTextChat + "</html>");
        field.setText("");
        countChat++;
        if (countChat == macCountInChat) {
            countChat = 0;
            allTextChat = "В чате максимально отображается 10 сообщений!";
        }
    }
}
