package LeetCodeExercise;


public class RomanToIntDemo {

    public static void main(String[] args){
        System.out.println(romanToInt("CMXL"));
    }


    public static int romanToInt(String s) {
        int i = 0;
        int preNum = getValue(Character.toString(s.charAt(i)));
        int sum = 0;
        for (i = 1; i<s.length();i++){
            int Num = getValue(Character.toString(s.charAt(i)));
            if (preNum < Num){
                sum -= preNum;
            }else {
                sum += preNum;
            }
            preNum = Num;
        }
        sum += preNum;
        return sum;

    }

    private static int getValue(String s){
        switch (s){
            case "I" : return 1;
            case "V" : return 5;
            case "X" : return 10;
            case "L" : return 50;
            case "C" : return 100;
            case "D" : return 500;
            case "M" : return 1000;
            default:return 0;
        }
    }
}
