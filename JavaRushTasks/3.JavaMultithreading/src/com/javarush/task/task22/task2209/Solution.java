package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/* 
Составить цепочку слов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File fileName = new File(reader.readLine());
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        List<String> arrayList = new ArrayList<>();
        while(fileReader.ready()) {
            arrayList.addAll(Arrays.asList(fileReader.readLine().split(" ")));
        }

        //...
        StringBuilder result = getLine(arrayList.toArray(new String[arrayList.size()]));
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder stb = new StringBuilder();
        if(words.length == 0) return stb;
        List<String> list = new ArrayList<>();
        int nonQueryWords = 0;
        for (String word :
                words) {
            if (stb.length() == 0) {
                stb.append(word);
            } else list.add(word);
        }
        while(!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).substring(0, 1) + " " + stb.substring(stb.length() - 1));
                if((list.get(i).substring(0, 1)).equalsIgnoreCase(stb.substring(stb.length() - 1))) {
                    stb.append(" " + list.get(i));
                    list.remove(i);
                } else if((list.get(i).substring(list.get(i).length() - 1)).equalsIgnoreCase(stb.substring(0, 1))) {
                    stb.insert(0, list.get(i) + " ");
                    list.remove(i);
                } else {
                    list.add(list.get(i));
                    list.remove(i);
                    nonQueryWords++;
                }
            }
//            System.out.println(stb);
        }
//        if(stb.length() == 0) stb.append(words);

        return stb;
    }
}
