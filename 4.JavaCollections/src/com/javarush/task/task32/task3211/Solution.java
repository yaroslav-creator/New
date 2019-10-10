package com.javarush.task.task32.task3211;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* 
Целостность информации
*/

public class Solution {
    public static void main(String... args) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(new String("test string"));
        oos.flush();
        System.out.println(compareMD5(bos, "5a47d12a2e3f9fecf2d9ba1fd98152eb")); //true

    }

    public static boolean compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5) throws Exception {


        byte[] bytes = new byte[0];

        try {
            MessageDigest messageDigest = MessageDigest.getInstance( "MD5" );
            messageDigest.update( byteArrayOutputStream.toByteArray() );
            bytes = messageDigest.digest();

        }catch (NoSuchAlgorithmException e ) {
            e.printStackTrace();
        }
        BigInteger bigInt = new BigInteger( 1,bytes );
        String result = String.format("%032x", bigInt);
        System.out.println(result);

        return result.equals( md5 );
    }
}
