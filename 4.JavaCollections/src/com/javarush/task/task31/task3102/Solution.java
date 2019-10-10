package com.javarush.task.task31.task3102;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {

        List<String> list = new ArrayList<>(  );

        Files.walkFileTree( Paths.get( root ), new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                list.add( file.toFile().getAbsolutePath() );
                return FileVisitResult.CONTINUE;
            }
        } );
        return list;

    }

    public static void main(String[] args) throws IOException {
        List<Path> collection = Files.walk(Paths.get("C:\\Users\\Ярослав\\Documents\\Файлы JavaRush"))
                .filter(Files::isRegularFile).collect( Collectors.toList());

        for (Path path: collection){
            System.out.println(path.toString());
        }
    }
}
