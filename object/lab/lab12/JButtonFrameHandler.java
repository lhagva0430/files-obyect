/*
    Introduction to OOP with Java (5th Ed), McGraw-Hill
    Wu/Otani
    Chapter 14 Sample Program: 2 товч бүхий фрейм үүсгэх
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * GUI объектуудыг байрлуулах фрейм үүсгэж, event барих 
 */
class JButtonFrameHandler extends JFrame implements ActionListener
{
    private static final int FRAME_WIDTH    = 300;
    private static final int FRAME_HEIGHT   = 200;
    private static final int FRAME_X_ORIGIN = 150;
    private static final int FRAME_Y_ORIGIN = 250;

    /** Swing товч */
    private JButton cancelButton;
    private JButton okButton;

    public static void main(String[] args) {
        JButtonFrameHandler frame = new JButtonFrameHandler();
        frame.setVisible(true);
    }

    public JButtonFrameHandler() {

        Container contentPane = getContentPane( );

        //фреймийн хэмжээг тодорхойлох
        setSize      (FRAME_WIDTH, FRAME_HEIGHT);
        setResizable (false);
        setTitle     ("Program JButtonFrameHandler");
        setLocation  (FRAME_X_ORIGIN, FRAME_Y_ORIGIN);

        //content pane үүсгэх
        contentPane.setLayout(new FlowLayout());
        //contentPane.setBackground(Color.white);

        //Фреймийн content pane дээр 2 товч нэмэх
        okButton = new JButton("OK");
        contentPane.add(okButton);

        cancelButton = new JButton("CANCEL");
        contentPane.add(cancelButton);

        //Фреймийг дээрх 2 товчны action listener болгох
        cancelButton.addActionListener(this);
        okButton.addActionListener(this);

        //Фреймийг хаах товч дарахад фреймийг хаах
        setDefaultCloseOperation( EXIT_ON_CLOSE );
   }

    public void actionPerformed(ActionEvent event) {
        JButton clickedButton = (JButton) event.getSource();

        String  buttonText = clickedButton.getText();

        this.setTitle("Та " + buttonText + " товч дарлаа");
    }

}