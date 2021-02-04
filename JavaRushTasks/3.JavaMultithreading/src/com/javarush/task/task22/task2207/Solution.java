package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/

public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File fileName = new File(reader.readLine());
//        FileReader fileReader = new FileReader(fileName);
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        List<String> list = new ArrayList<>();
        while(fileReader.ready()) {
            String [] tempStringArray = fileReader.readLine().split(" ");
            for (String str : tempStringArray) {
                list.add(str);
            }
        }
        int [] usedPositions = new int[list.size()];
        for (int x :
                usedPositions) {
            x = 0;
        }

        for (int i = 0; i < list.size(); i++) {
            if (usedPositions[i] != 1) {
                StringBuilder reverseString = new StringBuilder(list.get(i));
                reverseString.reverse();
                for (int j = i + 1; j < list.size(); j++) {
                    if (usedPositions[j] == 1) break;
                    if (reverseString.toString().equals(list.get(j))) {
                        Pair pair = new Pair();
                        pair.first = list.get(i);
                        pair.second = list.get(j);
                        result.add(pair);
                        usedPositions[i] = 1;
                        usedPositions[j] = 1;
                        break;
                    }
                }
            }
        }
        reader.close();
        fileReader.close();
        System.out.println(result.toString());

    }

    public static class Pair {
        String first;
        String second;

        public Pair() {
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

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
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
