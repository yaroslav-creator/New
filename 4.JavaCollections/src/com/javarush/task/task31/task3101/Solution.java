package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/*
Проход по дереву файлов

1. На вход метода main подаются два параметра.
Первый - path - путь к директории,
второй - resultFileAbsolutePath - имя (полный путь) существующего файла, который будет содержать результат.

2. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:

2.1. Отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке.
2.2. Переименовать resultFileAbsolutePath в 'allFilesContent.txt'
(используй метод FileUtils.renameFile, и, если понадобится, FileUtils.isExist).

2.3. В allFilesContent.txt последовательно записать содержимое всех файлов из п. 2.2.1.
После каждого тела файла записать "\n".

Все файлы имеют расширение txt.
В качестве разделителя пути используй "/".

*/
public class Solution {
    public static void main(String[] args) throws IOException {

//        String directoryPath = "C:\\Users\\Ярослав\\Documents\\Файлы JavaRush\\Test";
//        File source = new File( "C:\\Users\\Ярослав\\Documents\\Файлы JavaRush\\Test\\3101.txt" );
        String directoryPath = args[0];
        File source = new File( args[1] );

        File destination = new File( source.getParent() + "/allFilesContent.txt" );

        FileUtils.renameFile( source, destination );

        BufferedWriter fileWriter = new BufferedWriter( new FileWriter( destination ) );
        List<File> files = new ArrayList<>();

        Files.walkFileTree( Paths.get( directoryPath ), new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.toFile().length() > 50) {
                    FileUtils.deleteFile( file.toFile() );
                } else
                    files.add( file.toFile() );
                return FileVisitResult.CONTINUE;
            }
        } );

        files.sort( ((o1, o2) -> o1.getName().compareToIgnoreCase( o2.getName() )) );

        for (File file : files) {
            BufferedReader fileReader = new BufferedReader( new FileReader( file ) );
            while (fileReader.ready()) {
                fileWriter.write( fileReader.readLine() );
                fileWriter.newLine();
            }
            fileReader.close();
        }
        fileWriter.close();
    }

    public static class FileUtils {

        public static void deleteFile(File file) {
            if (!file.delete()) System.out.println( "Can not delete file with name " + file.getName() );
        }

        public static void renameFile(File source, File destination) {
            if (!source.renameTo( destination ))
                System.out.println( "Can not rename file with name " + source.getName() );
        }
    }
}
