package LeetCodeExercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreakII {
    //"apple", "pen", "applepen", "pine", "pineapple"
    public static void main(String[] args) {
        String s = "pineapplepenapple";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");
        wordDict.add("applepen");
        wordDict.add("pine");
        wordDict.add("pineapple");
        List<String> list = wordBreak(s, wordDict);
        System.out.println(list);

    }

    // 用于存储子串的临时List
    public static List<String> temp = new ArrayList<>();
    // 用于存储结果的List
    public static List<String> res = new ArrayList<>();

    public static List<String> wordBreak(String s, List<String> wordDict) {
        //使用回溯算法
        help(s, wordDict, 0);
        return res;
    }

    // 实现回溯算法的代码，i表示当前该从哪个位置扫描字符串
    public static void help(String s, List<String> wordDict, int i){
        // 如果字符串扫描结束，那么将temp中的子串合并成一个完整的字符串，添加到结果集中返回
        if(i == s.length()){
            StringBuilder sb = new StringBuilder();
            for(String str : temp){
                sb.append(str);
            }
            res.add(sb.toString());
        }

        // 扫描剩余的字符串
        for(int j = i; j < s.length(); j++){
            // 子串出现在了字典中，那么添加到临时List中
            if(wordDict.contains(s.substring(i, j+1))){
                // 添加的时候注意空格的要求
                if(j+1 >= s.length()){
                    temp.add(s.substring(i,j+1));
                }else{
                    temp.add(s.substring(i,j+1) + " ");
                }
                // 递归寻找字符串的剩余部分
                help(s, wordDict, j+1);
                // 最重要的回溯部分
                temp.remove(temp.size()-1);
            }
        }
    }
}
