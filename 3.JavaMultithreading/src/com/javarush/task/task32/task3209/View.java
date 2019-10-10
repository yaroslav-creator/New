package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;
import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {

    private Controller controller;

    //это будет панель с двумя вкладками.
    private JTabbedPane tabbedPane = new JTabbedPane();

    //это будет компонент для визуального редактирования html.
    private JTextPane htmlTextPane = new JTextPane();

    //это будет компонент для редактирования html в виде текста, он будет отображать код html (теги и их содержимое).
    private JEditorPane plainTextPane = new JEditorPane();
    private UndoManager undoManager = new UndoManager();
    private UndoListener undoListener = new UndoListener( undoManager );


    //Instantiates a new View.
    // Создание нового вида(представления вида программы)- т.е ОКНА ПРОГРАММЫ

    //конструктор класса View. Он должен устанавливать внешний вид и поведение (look and feel) нашего
    // приложения такими же, как это определено в системе. Конструктор не должен кидать исключений,
    // только логировать их с помощью ExceptionHandler.В конструкторе класса View, через класс UIManager,
    // должен устанавливаться внешний вид и поведение (look and feel).
    public View() {
        try {
            UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName() );

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            ExceptionHandler.log( e );
        }
    }


    //Gets controller.
    public Controller getController() {
        return controller;
    }

    // Set controller.
    public void setController(Controller controller) {
        this.controller = controller;
    }

    //метод наследуется от интерфейса ActionListener и будет вызваться при выборе пунктов меню,
    // у которых наше представление указано в виде слушателя событий.
    @Override
    public void actionPerformed(ActionEvent e) {

        //Получи из события команду с помощью метода getActionCommand(). Это будет обычная строка.
        // По этой строке ты можешь понять какой пункт меню создал данное событие.
            switch (e.getActionCommand()) {
                case "Новый"://Если это команда "Новый", вызови у контроллера метод createNewDocument().
                    controller.createNewDocument();
                    break;
                case "Открыть"://"Открыть", вызови метод openDocument().
                   controller.openDocument();
                    break;
                case "Сохранить":
                    controller.saveDocument();
                    break;
                case "Сохранить как...":
                    controller.saveDocumentAs();
                    break;
                case "Выход":
                    controller.exit();
                    break;
                case "О программе":
                    showAbout();
                    break;
            }
    }

    public void init() {
        initGui(); //Вызывать инициализацию графического интерфейса

        //Создает нового слушателя событий нашего окна.
        FrameListener frameListener = new FrameListener( this );

        //Добавляет слушателя событий нашего окна.
        addWindowListener( frameListener );

        //установить местоположение относительно центра
        setLocationRelativeTo( null );

        //Показывает наше окно.
        setVisible( true );

    }

    public void exit() {
        controller.exit();
    }

    //Метод отвечает за инициализацию меню редактора.
    public void initMenuBar() {

        //Создавать новый объект типа JMenuBar. Это и будет наша панель меню.

        JMenuBar menuBar = new JMenuBar();

        //С помощью MenuHelper инициализировать меню в следующем порядке:

        MenuHelper.initFileMenu( this, menuBar );  // Файл
        MenuHelper.initEditMenu( this, menuBar );  // Редактировать
        MenuHelper.initStyleMenu( this, menuBar ); // Стиль
        MenuHelper.initAlignMenu( this, menuBar ); // Выравнивание
        MenuHelper.initColorMenu( this, menuBar ); // Цвет
        MenuHelper.initFontMenu( this, menuBar );  // Шрифт
        MenuHelper.initHelpMenu( this, menuBar );  // Помощь

        //добавляться новосозданное меню в верхнюю часть панели контента текущего фрейма,
        // используя метод getContentPane().
        getContentPane().add( menuBar, BorderLayout.NORTH );
    }

    //Метод отвечает за инициализацию панелей редактора.
    public void initEditor() {
        //Устанавливат значение "text/html" в качестве типа контента для компонента
        htmlTextPane.setContentType( "text/html" );

        //Создавает новый локальный компонент JScrollPane на базе htmlTextPane.
        //Добавляет вкладку в панель tabbedPane с именем "HTML" и компонентом из предыдущего пункта.
        tabbedPane.addTab( "HTML", new JScrollPane( htmlTextPane ) );

        //Добавляет еще одну вкладку в tabbedPane с именем "Текст" и компонентом из предыдущего пункта.
        tabbedPane.addTab( "Текст", new JScrollPane( plainTextPane ) );

        //Устанавливает предпочтительный размер панели tabbedPane.
        tabbedPane.setPreferredSize( new Dimension( 800, 800 ) );

        //Создавает объект класса TabbedPaneChangeListener и
        // устанавливает его в качестве слушателя изменений в tabbedPane.
        tabbedPane.addChangeListener( new TabbedPaneChangeListener( this ) );

        //Добавлять по центру панели контента текущего фрейма нашу панель с вкладками.
        getContentPane().add( tabbedPane, BorderLayout.CENTER );
    }

    //Метод будет инициализировать графический интерфейс.
    public void initGui() {
        initMenuBar();
        initEditor();
        pack();
    }

    //Этот метод вызывается, когда произошла смена выбранной вкладки.
    public void selectedTabChanged() {

        //Если выбрана вкладка с индексом 0 (html вкладка), значит нам нужно получить текст
        // из plainTextPane и установить его в контроллер с помощью метода setPlainText.
        switch (tabbedPane.getSelectedIndex()) {
            case 0:
                controller.setPlainText( plainTextPane.getText() );
                break;
        //Если выбрана вкладка с индексом 1 (вкладка с html текстом), то необходимо получить текст
        // у контроллера с помощью метода getPlainText() и установить его в панель plainTextPane
            case 1:
                plainTextPane.setText( controller.getPlainText() );
                break;
        }
        resetUndo();//Сбросить правки (вызвать метод resetUndo представления).
    }

    public boolean canUndo() {
        return undoManager.canUndo();
    }

    public boolean canRedo() {
        return undoManager.canRedo();
    }

    //Метод отмены действий - отменяет последнее действие.

    public void undo() {
        try {
            undoManager.undo();

        } catch (CannotUndoException e) {
            ExceptionHandler.log( e );
        }
    }

    // Метод возврата действий - возвращает ранее отмененное действие.
    public void redo() {
        try {
            undoManager.redo();

        } catch (CannotRedoException e) {
            ExceptionHandler.log( e );
        }
    }

    public UndoListener getUndoListener() {
        return undoListener;
    }

    //метод void resetUndo(), который должен сбрасывать все правки в менеджере undoManager.

    public void resetUndo() {
        undoManager.discardAllEdits();
    }

    public boolean isHtmlTabSelected() {

        return tabbedPane.getSelectedIndex() == 0;
    }

    //метод, определяющий текущую вкладку.

    public void selectHtmlTab() {

        tabbedPane.setSelectedIndex( 0 );
        resetUndo();
    }

    //Метод, получает документ у контроллера и устанавливает его в панель редактирования htmlTextPane.
    public void update() {

        htmlTextPane.setDocument( controller.getDocument() );
    }

    //Метод,показывает диалоговое окно с информацией о программе.
    public void showAbout() {
        JOptionPane.showMessageDialog( this, "HTMLEditor", "About", JOptionPane.INFORMATION_MESSAGE );
    }


}
