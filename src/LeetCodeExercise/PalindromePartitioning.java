package LeetCodeExercise;

public class PalindromePartitioning {
    public static void main(String[] args) {
        String s = "abba";
        System.out.println(isPalindrome(s));
    }
    public static boolean isPalindrome(String s){
        int len = s.length();
        int left = 0,right = len-1;
        while(left<=right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
