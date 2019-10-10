package com.javarush.task.task08.task0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Модернизация ПО
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // List of addresses
//        List<String> addresses = new ArrayList<>();
        HashMap<String, String> map = new HashMap(  );
        while (true) {

            String town = reader.readLine();
            if (town.isEmpty()) break;
            String family = reader.readLine();
            map.put( town, family );
        }

        // Read the name town
        String findtown = reader.readLine();


            System.out.println(map.get(findtown  ));
        }
    }

