/*
    Introduction to OOP with Java (5th Ed), McGraw-Hill

    Wu/Otani

    Chapter 14 Sample Program: Message Dialog цонх харуулах
*/

import javax.swing.*;

class ShowMessageDialog {

    public static void main(String[] args) {

        JFrame jFrame;

        jFrame = new JFrame( );
        jFrame.setSize(400,300);
        jFrame.setVisible(true);

        JOptionPane.showMessageDialog(jFrame, "Сайн уу");

        JOptionPane.showMessageDialog(null, "Баяртай");
        
        /*
           NOTE: This program does not terminate even after you close
                 the jFrame window. To automatically terminate the
                 program when the main JFrame window is closed, add
                 the following statement. See Ch14JFrameSubclass1.       
        */
        //jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}