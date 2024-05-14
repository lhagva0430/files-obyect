/*
    Introduction to OOP with Java (5th Ed), McGraw-Hill

    Wu/Otani

    Chapter 14 Sample Program: JCheckBox-н хэрэглээ
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class JCheckBoxSample extends JFrame implements ActionListener {

    private static final int FRAME_WIDTH    = 300;

    private static final int FRAME_HEIGHT   = 200;

    private static final int FRAME_X_ORIGIN = 150;

    private static final int FRAME_Y_ORIGIN = 250;

    private JCheckBox[] checkBox;
    
    public static void main(String[] args) {
        JCheckBoxSample frame = new JCheckBoxSample();
        frame.setVisible(true);
    }

    public JCheckBoxSample() {
        Container   contentPane;
        JPanel      checkPanel, okPanel;

        JButton     okButton;
        String[]    btnText = {"English", "Mongolian", "Russian", "Japan"};

        setSize      (FRAME_WIDTH, FRAME_HEIGHT);
        setTitle     ("Program CheckBoxSample"); //фреймийн гарчиг
        setLocation  (FRAME_X_ORIGIN, FRAME_Y_ORIGIN);

        contentPane = getContentPane( );
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(new BorderLayout());

        //4 checkboxe үүсгэж байрлуулах
        checkPanel = new JPanel(new GridLayout(0,1));
        checkPanel.setBorder(BorderFactory.createTitledBorder("Мэддэг хэлүүдээ сонгоно уу"));
        checkBox = new JCheckBox[btnText.length];

        for (int i = 0; i < checkBox.length; i++) {
            checkBox[i] = new JCheckBox(btnText[i]);
            checkPanel.add(checkBox[i]);
        }

        //OK товч үүсгэж байрлуулах
        okPanel = new JPanel(new FlowLayout());
        okButton = new JButton("OK");
        okButton.addActionListener(this);
        okPanel.add(okButton);

        contentPane.add(checkPanel, BorderLayout.CENTER);
        contentPane.add(okPanel, BorderLayout.SOUTH);

        //Exit дарахад фреймийг хаах
        setDefaultCloseOperation( EXIT_ON_CLOSE );
    }

    public void actionPerformed(ActionEvent event) {

        StringBuffer skill = new StringBuffer("Таны мэддэг хэлүүд:\n");

        for (int i = 0; i < checkBox.length; i++) {

            if (checkBox[i].isSelected()) {
                skill.append(checkBox[i].getText() + "\n");
            }
        }

        JOptionPane.showMessageDialog(this, skill.toString()); //мессеж диалог цонх харуулах
    }
}