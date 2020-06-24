package LeetCodeExercise;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class lengthOfLongestSubstring {
    public static void main(String[] args){
        lengthOfLongestSubstring s = new lengthOfLongestSubstring();
        System.out.println(s.lengthOfLongestSubstringText03("pwwkew"));

    }
    public int lengthOfLongestSubstringText01(String s){
        if (s.length() == 0)
            return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int length = 0;
        for (int i = 0, j = 0; i < s.length(); ++i) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            length = Math.max(length, i - j + 1);
        }
        return length;
    }
    public int lengthOfLongestSubstringText02(String s){
        int[] map = new int[128];

        int start = 0, end = 0, len = 0;
        while (end < s.length()) {
            if (map[s.charAt(end++)]++ == 0) {
                len = Math.max(len, end - start);
            } else {
                while (map[s.charAt(end - 1)] > 1) {
                    map[s.charAt(start++)]--;
                }
            }
        }
        return len;
    }
    public int lengthOfLongestSubstringText03(String s){
        if(s.length() == 0) return 0;
        int len = 0;
        int[] arrays = new int[128];
        for (int i = 0;i < arrays.length; i++){
            arrays[i] = -1;
        }
        int left = 0, right = 0;
        while(right < s.length()){
            if(arrays[s.charAt(right)]> -1){
                int pos = arrays[s.charAt(right)];
                if (pos >= left){
                    left = pos + 1;
                }
            }
            arrays[s.charAt(right)] = right;
            right++;
            if(len < right - left){
                len = right - left;
            }
        }
        return len;
    }
}
