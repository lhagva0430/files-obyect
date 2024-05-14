/*
    Introduction to OOP with Java (5th Ed), McGraw-Hill

    Wu/Otani

    Chapter 14 Sample Program: JRadioButton сонголтын цэс үүсгэх
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class JRadioButtonSample extends JFrame
                           implements ActionListener,
                                      ItemListener    {

    private static final int FRAME_WIDTH    = 300;

    private static final int FRAME_HEIGHT   = 200;

    private static final int FRAME_X_ORIGIN = 150;

    private static final int FRAME_Y_ORIGIN = 250;

    /**
     * JCheckBox объектыг агуулах хүснэгт
     */
    private JRadioButton[] radioButton;

    public static void main(String[] args) {
        JRadioButtonSample frame = new JRadioButtonSample();
        frame.setVisible(true);
    }

    //байгуулагч функц
    public JRadioButtonSample() {
        Container   contentPane;
        JPanel      radioPanel, okPanel;
        ButtonGroup languageGroup;

        JButton     okButton;
        String[]    btnText = {"Java", "C++", "Smalltalk", "Ada"};

        setSize      (FRAME_WIDTH, FRAME_HEIGHT);
        setTitle     ("Program JRadioButton");
        setLocation  (FRAME_X_ORIGIN, FRAME_Y_ORIGIN);

        contentPane = getContentPane( );
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(new BorderLayout());

        //4 radio button үүсгэж байрлуулах
        radioPanel = new JPanel(new GridLayout(0,1));
        radioPanel.setBorder(BorderFactory.createTitledBorder("Сонгоно уу"));

        languageGroup = new ButtonGroup();
        radioButton = new JRadioButton[btnText.length];

        for (int i = 0; i < radioButton.length; i++) {
            radioButton[i] = new JRadioButton(btnText[i]);
            radioButton[i].addItemListener(this);
            languageGroup.add(radioButton[i]);
            radioPanel.add(radioButton[i]);
        }

        radioButton[0].setSelected(true);

        //OK товч үүсгэж байрлуулах
        okPanel = new JPanel(new FlowLayout());
        okButton = new JButton("OK");
        okButton.addActionListener(this);
        okPanel.add(okButton);

        contentPane.add(radioPanel, BorderLayout.CENTER);
        contentPane.add(okPanel, BorderLayout.SOUTH);

        //Exit дарахад фреймийг хаах
        setDefaultCloseOperation( EXIT_ON_CLOSE );
    }

    public void actionPerformed(ActionEvent event) {

        String favorite = null;

        int i = 0;
        while (favorite == null) {
            if (radioButton[i].isSelected()) {
                favorite = radioButton[i].getText();
            }

            i++;
        }

        JOptionPane.showMessageDialog(this, "Таны сонгосон хэл: " + favorite);
    }

    public void itemStateChanged(ItemEvent event) {

        JRadioButton source = (JRadioButton) event.getSource();

        String state;

        if (event.getStateChange() == ItemEvent.SELECTED) {
            state = "сонгогдлоо";
        } else {
            state = "сонгогдохоо болилоо";
        }

        JOptionPane.showMessageDialog(this, "JRadioButton '" +
                                            source.getText() +
                                            "' " + state);
    }
}