package LeetCodeExercise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RemoveInvalidParentheses {
    HashSet<String> set;
    public List<String> removeInvalidParentheses(String s) {
        set = new HashSet();
        int left = 0,right = 0;
        for (char c: s.toCharArray()) {
            if (c == '('){
                left++;
            }
            if (c == ')'){
                if (left==0){
                    right++;
                }else {
                    left--;
                }
            }
        }
        dfs(s,0,"",0,left,right);
        List<String> ans = new ArrayList<>();
        for (String ss : set) {
            ans.add(ss);
        }
        return ans;
    }

    private void dfs(String s, int index, String path, int count,int left, int right) {
        if (count<0){
            return;
        }
        if (s.length() == index){
            if (count == 0){
                set.add(path);
            }
            return;
        }
        if (s.charAt(index)!='(' && s.charAt(index)!= ')'){
            dfs(s, index+1, path+s.charAt(index), count, left, right);
        }else{
            if (s.charAt(index) == '('){
                if (left>0){
                    dfs(s, index+1, path, count, left-1, right);
                }
                dfs(s, index+1, path+"(", count+1, left, right);
            }else{
                if (right>0){
                    dfs(s, index+1, path, count, left, right-1);
                }
                dfs(s, index+1, path+")", count-1, left, right);
            }
        }
    }
}
