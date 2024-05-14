/*
    Introduction to OOP with Java (5th Ed), McGraw-Hill

    Wu/Otani

    Chapter 14 Sample Program: Event listener for button click events

    File: ButtonHandler.java

*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class ButtonHandler implements ActionListener {
    public ButtonHandler() {
    }
    public void actionPerformed(ActionEvent event) {
        JButton clickedButton = (JButton) event.getSource();
        JRootPane rootPane = clickedButton.getRootPane( );
        Frame     frame    = (JFrame) rootPane.getParent();
        String  buttonText = clickedButton.getText();
        frame.setTitle("You clicked " + buttonText);
    }
}
