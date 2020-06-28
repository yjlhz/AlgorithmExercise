package LeetCodeExercise;

public class resevernum {
    public static void main(String[] args){
        resevernum rs = new resevernum();
        System.out.println(rs.reserve(121));
    }

    public int reserve(int x){
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        return (int) res == res ? (int) res : 0;
    }
}
