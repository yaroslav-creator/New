package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.util.Random;

/* 
Генератор паролей

хотел сделать через регулярки, долго мучился, оставлю это здесь:
(?=.*[0-9]) - строка содержит хотя бы одно число;
(?=.*[a-z]) - строка содержит хотя бы одну латинскую букву в нижнем регистре;
(?=.*[A-Z]) - строка содержит хотя бы одну латинскую букву в верхнем регистре;
[0-9a-zA-Z]{8,} - строка состоит не менее, чем из 8 вышеупомянутых символов.
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {

        ByteArrayOutputStream baos = new ByteArrayOutputStream(  );
        Random random = new Random(  );

        for (int i = 0; i < 3; i++) {

            //digits
            baos.write(48 + random.nextInt(10));
            //low case
            baos.write(97 + random.nextInt(26));
        }

        for (int i = 0; i < 2; i++) {
            baos.write(65 + random.nextInt(26));
        }
        return baos;
    }
}

//int length = 16;
//Random r = new Random();
//String s = r.ints(48, 122)
//            .filter(i -> (i < 57 || i > 65) && (i < 90 || i > 97))
//            .mapToObj(i -> (char) i)
//            .limit(length)
//            .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
//            .toString();