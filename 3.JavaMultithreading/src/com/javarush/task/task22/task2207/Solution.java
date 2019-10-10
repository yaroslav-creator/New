package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова  C:\Users\Ярослав\Documents\Файлы JavaRush\task2207read.txt
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );

        try {
            BufferedReader fileReader = new BufferedReader( new FileReader( reader.readLine() ) );
            StringBuilder builder = new StringBuilder();
            while (fileReader.ready()) {
                builder.append( fileReader.readLine() );
                builder.append( " " );
            }
            fileReader.close();
            String[] tmp = builder.toString().trim().split( "\\s+" );
            HashSet<Integer> set = new HashSet<>(  );
            for (int i = 0; i < tmp.length; i++){
                if (set.contains( i )) continue;
                for (int j = i + 1; j < tmp.length; j++){
                    String string = new StringBuilder( tmp[j] ).reverse().toString();
                    if (string.equals( tmp[i] )){
                        Pair pair = new Pair();
                        pair.first = string;
                        pair.second = tmp[j];
                        result.add( pair );
                        set.add( j );
                        break;
                    }
                }
            }
            for (Pair pair : result){
                System.out.println(pair);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals( pair.first ) : pair.first != null) return false;
            return second != null ? second.equals( pair.second ) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null && second != null ? second :
                            second == null && first != null ? first :
                                    first.compareTo( second ) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
