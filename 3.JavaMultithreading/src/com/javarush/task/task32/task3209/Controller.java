package com.javarush.task.task32.task3209;

import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

public class Controller {
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public Controller(View view) {
        this.view = view;
    }

    public HTMLDocument getDocument() {
        return document;
    }

    public static void main(String[] args) {

        View view = new View();
        Controller controller = new Controller( view );
        view.setController( controller );
        view.init();
        controller.init();
    }

    //метод инициализации init() контроллера.
    public void init() {
        createNewDocument();//вызывает метод создания нового документа.
    }

    public void exit() {
        System.exit( 0 );
    }

    //Метод, сбрасывает текущий документ.
    public void resetDocument() {
        if (document != null)
            //Удаляет у текущего документа document слушателя правок которые можно отменить/вернуть
            document.removeUndoableEditListener( view.getUndoListener() );

        //Создавает новый документ по умолчанию и присваивать его полю document.
        document = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();
        document.addUndoableEditListener( view.getUndoListener() );
        view.update();
    }

    //Метод будет записывать переданный текст с html тегами в документ document.

    public void setPlainText(String text) {
        resetDocument(); // Сбрось документ.
        //Создаем новый реадер StringReader на базе переданного текста.
        StringReader reader = new StringReader( text );

   //Вызов метод read() из класса HTMLEditorKit, который считывает данные из риадера в документ document.
        try {
            new HTMLEditorKit().read( reader, document, 0 );

          //если возникнет исключительная ситуация, то исключение должно логироваться
         // через метод log у класса ExceptionHandler.
        } catch (Exception e) {
            ExceptionHandler.log( e );
        }
    }

    //Метод, должен получать текст из документа со всеми html тегами.
    public String getPlainText() {
        StringWriter stringWriter = new StringWriter();

 //Запись всего содержимого из док-та document в созданный объект с помощью метода write() класса HTMLEditorKit.
        try {
            new HTMLEditorKit().write( stringWriter, document, 0, document.getLength() );
        } catch (Exception e) {

            //если возникнет исключительная ситуация, то исключение должно логироваться
            // через метод log у класса ExceptionHandler.
            ExceptionHandler.log( e );
        }
        return stringWriter.toString();
    }

    //метод создания нового документа

    public void createNewDocument() {
        view.selectHtmlTab();//Выбор html вкладки у представления.
        resetDocument();     //Сброс текущего документа.
        view.setTitle( "HTML редактор" );//Устанавливать новый заголовок окна, например: "HTML редактор"
        view.resetUndo();               //Сбрасывать правки в Undo менеджере.
        currentFile = null;             //Обнулить переменную currentFile.
    }

    public void openDocument() {
        view.selectHtmlTab();
        //Для открытия или сохранения файла мы будем использовать JFileChooser из библиотеки swing.
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter( new HTMLFileFilter() );

        if (fileChooser.showOpenDialog( view ) == JFileChooser.APPROVE_OPTION) {
            currentFile = fileChooser.getSelectedFile();
            resetDocument();
            view.setTitle( currentFile.getName() );

            try (FileReader fileReader = new FileReader( currentFile )) {
                new HTMLEditorKit().read( fileReader, document, 0 );
                view.resetUndo();

            } catch (Exception e) {
                ExceptionHandler.log( e );
            }
        }
    }

    /* Метод сохранения должен работать также, как saveDocumentAs(), но не запрашивать файл у пользователя, а
    использовать currentFile. Если currentFile равен null, то вызывать метод saveDocumentAs().*/
    public void saveDocument() {
        view.selectHtmlTab();

        if (currentFile != null) {
            view.setTitle( currentFile.getName() );

            try (FileWriter fileWriter = new FileWriter( currentFile )) {
                new HTMLEditorKit().write( fileWriter, document, 0, document.getLength() );

            } catch (Exception e) {
                ExceptionHandler.log( e );
            }
        } else saveDocumentAs();

    }

    //метод для сохранения файла под новым именем

    public void saveDocumentAs() {
        view.selectHtmlTab();//Переключаем представление на html вкладку.

        //Для открытия или сохранения файла мы будем использовать JFileChooser из библиотеки swing.
        JFileChooser fileChooser = new JFileChooser();//Создаем нов. объект для выбора файла JFileChooser.

        //Устанавливаем ему в качестве фильтра объект HTMLFileFilter.
        fileChooser.setFileFilter( new HTMLFileFilter() );

        //Показывать диалоговое окно "Save File" для выбора файла.
        //Если пользователь подтвердит выбор файла:
        if (fileChooser.showSaveDialog( view ) == JFileChooser.APPROVE_OPTION) {
            currentFile = fileChooser.getSelectedFile();//Сохранять выбранный файл в поле currentFile.

            //Устанавливать имя файла в качестве заголовка окна представления.
            view.setTitle( currentFile.getName() );

            //Создавать FileWriter на базе currentFile.
            try (FileWriter fileWriter = new FileWriter( currentFile )) {
                //Переписывать данные из документа document в объекта FileWriter-а
                new HTMLEditorKit().write( fileWriter, document, 0, document.getLength() );

            } catch (Exception e) {
                //Метод saveDocumentAs() в контроллере не должен кидать исключения, а
                // логировать через ExceptionHandler.
                ExceptionHandler.log( e );
            }
        }
    }

}
