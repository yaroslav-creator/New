package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        List<Word> wordList = detectAllWords( crossword, "home", "same" );
        for (Word word : wordList) {
            System.out.println( word.toString() );
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
        }
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {

        List<Word> wordList = new ArrayList<>();
        int[][] searchDirections = new int[][]{
                {0, 1},
                {1, 1},
                {1, 0},
                {1, -1},
                {0, -1},
                {-1, -1},
                {-1, 0},
                {-1, 1},
        };

        for (String word : words) {
            findWord:{
                for (int i = 0; i < crossword.length; i++) {
                    for (int j = 0; j < crossword[i].length; j++) {
                        if (word.charAt( 0 ) == crossword[i][j]) {

                            for (int directions = 0; directions < searchDirections.length; directions++) {
                                int tmp_i = i,
                                        tmp_j = j,
                                        wordPosition = 1;

                                while (wordPosition < word.length()) {
                                    tmp_i += searchDirections[directions][0];
                                    tmp_j += searchDirections[directions][1];

                                    if (tmp_i < 0 || tmp_i >= crossword.length || tmp_j < 0 || tmp_j >= crossword[tmp_i].length)
                                        break;

                                    if (word.charAt( wordPosition ) != crossword[tmp_i][tmp_j])
                                        break;

                                    else if (wordPosition == word.length() - 1) {
                                        Word dataWord = new Word( word );
                                        dataWord.setStartPoint( j, i );
                                        dataWord.setEndPoint( tmp_j, tmp_i );
                                        wordList.add( dataWord );
                                        break findWord;
                                    }
                                    wordPosition++;
                                }
                            }
                        }
                    }
                }
            }
        }
        return wordList;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format( "%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY );
        }
    }
}
