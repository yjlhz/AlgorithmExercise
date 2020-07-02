package LeetCodeExercise;

import java.util.ArrayList;
import java.util.List;

public class ZConvertDemo {
    private static String string = "LEETCODEISHIRING";
    public static void main(String[] args){
        ZConvertDemo zc = new ZConvertDemo();
        System.out.println(zc.convert(string,3));
    }

    public String convert(String s, int numRows) {
        if (numRows < 2) return s;
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++){
            rows.add(new StringBuilder());
        }
        int i = 0, flag = -1;
        for (char c : s.toCharArray()){
            rows.get(i).append(c);
            if (i == 0 || i == numRows - 1){
                flag = -flag;
            }
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows){
            res.append(row);
        }
        return res.toString();
    }

    public int myAtoi(String str) {
        str = str.trim();
        int i=0,n=str.length();
        while(i<n&&str.charAt(i)==' ')i++;
        if(i==n)return 0;
        int flag=1;
        if(str.charAt(i)=='+'||str.charAt(i)=='-'){
            if(str.charAt(i)=='-')flag=-1;
            i++;
        }
        int ans=0;
        while(i<n&&Character.isDigit(str.charAt(i))) {
            int temp=str.charAt(i)-'0';
            if (flag == 1 && (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && temp > 7)))
                return Integer.MAX_VALUE ;
            //以正数为列，考虑稳大于和加temp才大于的情况
            if (flag == -1 && (ans > -(Integer.MIN_VALUE / 10) || (ans == -(Integer.MIN_VALUE / 10) && temp > 8)))
                return Integer.MIN_VALUE;
            ans=ans*10+temp;
            i++;
        }
        return ans*flag;

    }

}
