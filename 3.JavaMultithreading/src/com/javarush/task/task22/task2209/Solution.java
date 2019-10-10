package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
Составить цепочку слов
C:\Users\Ярослав\Documents\Файлы JavaRush\task2209.txt // РАЗОБРАТЬСЯ ПОДРОБНЕЕ !!!
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
        {fileName = reader.readLine();}

        String content = new String( Files.readAllBytes( Paths.get(fileName)), StandardCharsets.UTF_8);
        String[] words = content.split(" ");

        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {

        StringBuilder result = new StringBuilder();
        if (words == null || words.length == 0) return result;
        if (words.length==1 || words[0].equals("")) return result.append(words[0]);

        ArrayList<String> wordsList = new ArrayList<>();

        wordsList.addAll( Arrays.asList(words));
        while (wordsList.remove("")){
            wordsList.remove("");
        }
        while (finds(wordsList)) {

            Collections.shuffle(wordsList);

        }
        for (String word: wordsList){
            result.append(word).append(" ");
        }
        result.deleteCharAt(result.length()-1);
        return result;
    }

    public static boolean finds(ArrayList<String> wordsList) {
        for (int i = 0; i < wordsList.size() - 1; i++) {
            String word1 = wordsList.get(i).toLowerCase();
            String word2 = wordsList.get(i + 1).toLowerCase();
            if (word1.charAt(word1.length() - 1) != word2.charAt(0)) return true;
        }
        return false;
    }
}