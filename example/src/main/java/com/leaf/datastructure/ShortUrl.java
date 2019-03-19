package com.leaf.datastructure;

import java.util.ArrayList;
import java.util.List;

public class ShortUrl {

    private   String aa;
    public static String[] array = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u"
            , "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
            "U", "V", "W", "X", "Y", "Z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    public static void main(String[] args) {

        System.out.println(long2Short((long)124));

        System.out.println(to_4((long)8));
    }

    public static String long2Short(Long value) {
        String shortValue = "";
        while (value > 1) {
            long tempValue = value % 62;
            shortValue += array[(int)tempValue];
            value = value / 62;
        }

        if (shortValue.length() < 8) {
            String preValue = "";
            for (int i = 0; i < 8 - shortValue.length(); i++) {
                preValue += "a";
            }
            shortValue = preValue + shortValue;
        }
        return shortValue;
    }

    public static Long short2long(String value) {
        while (value.startsWith("a")) {
            value = value.substring(1);
        }

        return null;
    }

    public String ShortUrl() {
        return null;
    }

    public static String to_4(Long num) {
        String result = "";
        while (num > 1) {
            Long tempnum = num % 4;
            result += tempnum;
            num = num / 4;
        }
        return result;
    }
}
