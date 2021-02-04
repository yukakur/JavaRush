package com.javarush.task.task22.task2208;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> mapp = new LinkedHashMap<>();
        mapp.put("name", "Ivanov");
        mapp.put("country", "Kiev");
        mapp.put("age", null);
        System.out.println(getQuery(mapp));

    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder stb = new StringBuilder();
        for(Map.Entry<String, String> entry: params.entrySet()) {
            if(entry.getValue() != null) {
                if(stb.length() != 0) stb.append(" and ");
                stb.append(entry.getKey() + " = '" + entry.getValue() + "'");
            }
        }
        return stb.toString();
    }
}
