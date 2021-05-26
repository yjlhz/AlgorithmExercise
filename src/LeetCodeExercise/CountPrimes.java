package LeetCodeExercise;

public class CountPrimes {
    public static int countPrimes(int n) {
        int sum = 0;
        for(int i = 2;i<n;i++){
            sum+=isPrimes(i)?1:0;
        }
        return sum;
    }

    public static boolean isPrimes(int n){
        for(int i = 2;i*i<=n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }
}
