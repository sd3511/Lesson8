package gui_app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class MyWindow extends JFrame {
    private String textInput = "Здесь будут ваши сообщения";

    public String[] getBuddyAnswers() {
        return buddyAnswers;
    }

    public void setBuddyAnswers(String[] buddyAnswers) {
        this.buddyAnswers = buddyAnswers;
    }

    private String[] buddyAnswers = {"Повтори, повтори", "Я тебя не понимаю", "Да прекращай разговаривать и иди за пивом", "Неужели тебе больше нечего сказать???", "Ха ха ха", "Грубовато", "Да иди ты"};

    public String getTextInput() {
        return textInput;
    }

    public void setTextInput(String textInput) {
        this.textInput = textInput;
    }


    public MyWindow() {
        setTitle("The Chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(700, 250, 500, 500);
        setResizable(false);


        JPanel panelDown = new JPanel();
        JPanel panelUp = new JPanel();

        final JTextArea textArea = new JTextArea(getTextInput(), 25, 47);
        textArea.setEditable(false);
        textArea.setLineWrap(true);

        final JLabel label = new JLabel("Введите ваше сообщение");
        final JTextField textField = new JTextField(20);
        JButton btnSend = new JButton("Отправить");
        JScrollPane scrollPane = new JScrollPane(textArea, 20, 31);

        btnSend.addActionListener(new ActionListener() {
                                      public void actionPerformed(ActionEvent e) {

                                          if (textField.getText().equals("")){

                                          }
                                          else {if (textArea.getText().equals(getTextInput())) {
                                              textArea.setText("");
                                          }
                                          textArea.append("Вы: " + textField.getText() + "\n");
                                          textField.setText("");
                                          textArea.append("Ваш собеседник: " + getBuddyAnswers()[(int) (Math.random() * getBuddyAnswers().length)] + "\n");
                                      }}
                                  }
        );

        textField.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                    if (textField.getText().equals("")){

                    }
                    else {if (textArea.getText().equals(getTextInput())) {
                        textArea.setText("");
                    }
                    textArea.append("Вы: " + textField.getText() + "\n");
                    textField.setText("");
                    textArea.append("Ваш собеседник: " + getBuddyAnswers()[(int) (Math.random() * getBuddyAnswers().length)] + "\n");
                }}
            }

            public void keyPressed(KeyEvent e) {

            }

            public void keyReleased(KeyEvent e) {

            }
        });


        panelDown.add(label);
        panelDown.add(textField);
        panelDown.add(btnSend);
        panelUp.add(scrollPane);


        add(BorderLayout.SOUTH, panelDown);
        add(BorderLayout.WEST, panelUp);

        setVisible(true);

    }
}
