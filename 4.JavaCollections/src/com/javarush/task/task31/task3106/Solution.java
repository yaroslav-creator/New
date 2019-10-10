package com.javarush.task.task31.task3106;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) return;

        String resultFileName = args[0];
        int filePartCount = args.length - 1;
        String[] fileNamePart = new String[filePartCount];

        System.arraycopy( args, 1, fileNamePart, 0, filePartCount );
        Arrays.sort( fileNamePart );

        List<FileInputStream> inputStreamList = new ArrayList<>();
        for (int i = 0; i < filePartCount; i++) {
            inputStreamList.add( new FileInputStream( fileNamePart[i] ) );
        }

        try (SequenceInputStream sequenceInputStream = new SequenceInputStream
                ( Collections.enumeration( inputStreamList ) )) {
            ZipInputStream zipInputStream = new ZipInputStream( sequenceInputStream );
            FileOutputStream fileOutputStream = new FileOutputStream( resultFileName );

            byte[] buffer = new byte[1024 * 1024];
            while (zipInputStream.getNextEntry() != null) {
                int count;
                while ((count = zipInputStream.read( buffer )) != -1) {
                    fileOutputStream.write( buffer, 0, count );
                }
            }
            zipInputStream.close();
            fileOutputStream.close();
        }
    }
}
