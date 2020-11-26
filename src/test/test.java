package test;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        String s = "Hello World";
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 97 && chars[i] <= 122){
                chars[i] = (char) (chars[i] - 32);
            }
        }
        System.out.println(String.valueOf(chars));
    }
}
