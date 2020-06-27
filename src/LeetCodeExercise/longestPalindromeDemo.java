package LeetCodeExercise;

import java.util.HashMap;
import java.util.Map;

public class longestPalindromeDemo {

    private static String strings = "asdfeadfhhsajsjaja";

    public static void main(String[] args){
        longestPalindromeDemo ls = new longestPalindromeDemo();
        System.out.println(ls.longestPalindrome(strings));
    }


    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2){
            return s;
        }
        int maxlen = 1, begin = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < len - 1; i++){
            for (int j = i + 1; j < len; j++){
                if (j - i + 1 > maxlen && isPalindrome(chars, i, j)){
                    maxlen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, maxlen + begin);
    }

    private boolean isPalindrome(char[] charArrays, int left, int right){
        while(left < right){
            if(charArrays[left] != charArrays[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
