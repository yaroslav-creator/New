package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {

    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;

    private List<Path> foundFiles = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes( file ); // размер файла: content.length

        boolean isCheck = true;

        if (attrs.isDirectory())
            return FileVisitResult.CONTINUE;

        if (partOfName != null && !file.getFileName().toString().contains( partOfName ))
            isCheck = false;

        if (partOfContent != null) {
            if (!new String( Files.readAllBytes( file ) ).contains( partOfContent ))
                isCheck = false;
        }

        if ((minSize != 0) & content.length < minSize)
            isCheck = false;

        if ((maxSize != 0) & content.length > maxSize)
            isCheck = false;

        if (isCheck)
            foundFiles.add( file );

        return super.visitFile( file, attrs );
    }


    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }
}
