package test;

public class test2 {
    public static void main(String[] args) {
        String s = "Hello World";
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'o'){
                chars[i] = '*';
            }
        }
        System.out.println(String.valueOf(chars));
    }
}
