/*
    Introduction to OOP with Java (5th Ed), McGraw-Hill

    Wu/Otani

    Chapter 14 Sample Program: Панелиудыг зохион байгуулах
*/

import javax.swing.*;
import java.awt.*;

/**
 * Энэ жишээгээр зөвхөн хэрэглэгчийн интерфейсийг хэрхэн гаргахыг харуулав. (Үйлдэл хийгдэхгүй)
 */
class NestedPanels extends JFrame {

    private static final int FRAME_WIDTH    = 250;
    private static final int FRAME_HEIGHT   = 270;
    private static final int FRAME_X_ORIGIN = 150;
    private static final int FRAME_Y_ORIGIN = 250;
    private final String ENTER = "Enter";
    private final String CANCEL = "Cancel";

    /** хоосон тэмдэгт агуулах тогтмол */
    private final String BLANK = "";

    /** текст оруулах талбар */
    private JTextField guessEntry;

    /** текст харуулах талбар */
    private JLabel     hint;

    public static void main(String[] args) {
        NestedPanels frame = new NestedPanels();
        frame.setVisible(true);
    }

    /**
     * байгуулагч функц
     */
    public NestedPanels( ) {
        JPanel  guessPanel, hintPanel,
                controlPanel, buttonPanel;

        JButton enterBtn, cancelBtn;

        Container contentPane;

        //фреймийн утгуудыг олгох
        setSize      (FRAME_WIDTH, FRAME_HEIGHT);
        setTitle     ("Program NestedPanels");
        setLocation  (FRAME_X_ORIGIN, FRAME_Y_ORIGIN);

        contentPane = getContentPane( );

        contentPane.setLayout(new GridLayout(3, 1));
        
        // эхний панелийг үүсгэх
        guessPanel = new JPanel();
        guessPanel.setBorder(BorderFactory.createTitledBorder("Your Guess"));
        guessPanel.add(guessEntry = new JTextField(10));
        // 2 дахь буюу доод хэсгийн панелийг үүсгэх
        hintPanel = new JPanel();
        hintPanel.setBorder(BorderFactory.createTitledBorder("Hint"));
        hintPanel.add(hint = new JLabel("Let's Play HiLo"));

        controlPanel = new JPanel(new BorderLayout());
        buttonPanel  = new JPanel();
        buttonPanel.add(enterBtn = new JButton(ENTER));
        buttonPanel.add(cancelBtn = new JButton(CANCEL));
        controlPanel.add(buttonPanel, BorderLayout.SOUTH);

        contentPane.add(guessPanel);
        contentPane.add(hintPanel);
        contentPane.add(controlPanel);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}