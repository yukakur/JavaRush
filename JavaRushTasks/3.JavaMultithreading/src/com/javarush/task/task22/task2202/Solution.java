package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - return null hello"));
    }

    public static String getPartOfString(String string) {

        StringBuilder builder = new StringBuilder();
        try {
            if (string.isEmpty()) throw new TooShortStringException();
            String[] stringSplitted = string.split(" ");
            if (stringSplitted.length < 5) throw new TooShortStringException();
            for (int i = 1; i < 5; i++) {
                builder.append(" " + stringSplitted[i]);
            }
        } catch (RuntimeException e) {
            e.printStackTrace();

        }
        return builder.toString().trim();
    }


    public static class TooShortStringException extends RuntimeException{

    }
}
