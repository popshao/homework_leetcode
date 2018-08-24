package com.homework;

import java.util.ArrayList;
import java.util.List;

public class Test17 {

    static String[] strings = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    public static void main(String[] args) {
        Test17 test = new Test17();
        System.out.println(test.letterCombinations("23"));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<String>();
        if (digits.length() == 0) {
            return list;
        }
        backtracking("", digits, 0, list);//回溯
        return list;
    }

    public static void backtracking(String s, String digits, int startIndex, List<String> list) {
        if (startIndex == digits.length()) {
            list.add(s);
            return;//返回，向上回溯
        }

        String chars = strings[digits.charAt(startIndex) - '0'];
        for (int i = 0; i < chars.length(); i++) {
            backtracking(s + chars.charAt(i), digits, startIndex + 1, list);
        }
    }
}
