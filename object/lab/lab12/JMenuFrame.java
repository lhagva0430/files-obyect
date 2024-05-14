/*    Introduction to OOP with Java (5th Ed), McGraw-Hill    Wu/Otani
    Chapter 14 Sample Program: 2 цэс бүхий цэсийн мөр үүсгэх
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *   File , Edit гэсэн цэсүүдийг агуулсан цэсний мөр(MenuBar) бүхий фрейм үүсгэх жишээ. 
 *   Найман MenuItem объекттой. menu item сонгогдоход дарагдсан командын нэрийг
 *   харуулна. 
 */
class JMenuFrame extends JFrame implements ActionListener {

//----------------------------------
//    Гишүүн өгөгдөл
//----------------------------------

    /**
     * Фреймийн өргөн
     */
    private static final int FRAME_WIDTH    = 300;

    /**
     * Фреймийн өндөр
     */
    private static final int FRAME_HEIGHT   = 250;

    /**
     * фреймийн Х координатаас эхлэх цэг
     */
    private static final int FRAME_X_ORIGIN = 150;

    /**
     * фреймийн У координатаас эхлэх цэг
     */
    private static final int FRAME_Y_ORIGIN = 250;

    /**
     * Сонгогдсон командыг харуулахад зохиулагдсан гишүүн өгөгдөл
     */
    private JLabel   response;

    /**
     * File цэс
     */
    private JMenu    fileMenu;

    /**
     * Edit цэс
     */
    private JMenu    editMenu;


//----------------------------------
//      Main функц
//----------------------------------
    public static void main(String[] args) {
        JMenuFrame frame = new JMenuFrame();
        frame.setVisible(true);
    }

//----------------------------------
//    Байгуулагч
//----------------------------------

    /**
     * Default байгуулагч
     */
    public JMenuFrame() {
        
        Container contentPane;

        //фреймийн утгуудыг олгох
        setTitle     ("JMenuFrame"); //Фреймийн гарчиг
        setSize      (FRAME_WIDTH, FRAME_HEIGHT); //фреймийн хэмжээ
        setResizable (false);  //хэмжээг нь өөрчилж болох эсэх
        setLocation  (FRAME_X_ORIGIN, FRAME_Y_ORIGIN); //фреймийн байрлал

        contentPane = getContentPane( );
        contentPane.setLayout(new FlowLayout());

        //Цэс болон цэс доторх командуудыг үүсгэх
        createFileMenu();
        createEditMenu();

        //Цэсийн мөрөнд дээрхийг нэмэх
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        //дарагдсан командыг харуулах label  
        response = new JLabel("Цэс тестлэх жишээ" );
        response.setSize(250, 50);
        contentPane.add(response);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

//-------------------------------------------------
//      Нийтийн харагдалттай методууд:
//
//          void    actionPerformed   (   ActionEvent        )
//
//------------------------------------------------

    /**
     * хийгдсэн үйлдлийг барих стандарт метод
     * @param: ActionEvent объект төрөлтэй event параметр
     */
    public void actionPerformed(ActionEvent event) {
        String  menuName;

        menuName = event.getActionCommand();  //дарагдсан командын нэрийг авна

        if (menuName.equals("Quit")) {
           System.exit(0);

        } else {
           response.setText("'" + menuName + "'" + " цэс сонгогдлоо");
        }
    }

//-------------------------------------------------
//      Хувийн харагдалттай методууд:
//
//          void   createFileMenu   (           )
//          void   createEditMenu   (           )
//
//------------------------------------------------

    /**
     * File цэс болон түүн доторх команд цэсүүдийг үүсгэх
     *
     */
    private void createFileMenu( ) {
        JMenuItem    item;

        fileMenu = new JMenu("File");

        item = new JMenuItem("New");        //New
        item.addActionListener( this );
        fileMenu.add( item );

        item = new JMenuItem("Open...");    //Open...
        item.addActionListener( this );
        fileMenu.add( item );

        item = new JMenuItem("Save");       //Save
        item.addActionListener( this );
        fileMenu.add( item );

        item = new JMenuItem("Save As..."); //Save As...
        item.addActionListener( this );
        fileMenu.add( item );

        fileMenu.addSeparator();           //хөндлөн тусгаарлагч шугамыг нэмэх

        item = new JMenuItem("Quit");       //Quit
        item.addActionListener( this );
        fileMenu.add( item );
    }

    /**
     * Edit цэс болон түүн доторх команд цэсүүдийг үүсгэх
     *
     */
    private void createEditMenu( ) {
        JMenuItem    item;

        editMenu = new JMenu("Edit");

        item = new JMenuItem("Cut");      //Cut
        item.addActionListener( this );
        editMenu.add( item );

        item = new JMenuItem("Copy");    //Copy
        item.addActionListener( this );
        editMenu.add( item );

        item = new JMenuItem("Paste");    //Paste
        item.addActionListener( this );
        editMenu.add( item );
    }

}
