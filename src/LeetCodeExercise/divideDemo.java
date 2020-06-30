package LeetCodeExercise;

public class divideDemo {
    private static int[] arrays = new int[]{3,2,1,0,4};

    public static void main(String[] args) {
        divideDemo di = new divideDemo();

        System.out.println(di.canJump(arrays));
    }

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        int sum = 0, t = 0;//第一层累加数
        int sums = 0, ts = 0;//第二层累加数
        int sumss = 0, tss = 0;//第三层累加数
        int res = 0;//结果
        int flat = (dividend ^ divisor);//结果正负标志位
        dividend = (dividend < 0) ? dividend : -dividend;//被除数取负值
        divisor = (divisor < 0) ? divisor : -divisor;//除数取负值
        while (dividend <= divisor) {//暴力累加法
            sum += divisor;
            t--;
            sums += sum;
            ts += t;
            sumss += sums;
            tss += ts;
            if (dividend - sumss < 0 && sumss < 0) {//判断三层累加是否超出
                res += tss;
                dividend -= sumss;
            } else {//超出则普通累加
                res--;
                dividend -= divisor;
                sum = 0;
                t = 0;
                sums = 0;
                ts = 0;
                sumss = 0;
                tss = 0;
            }
        }
        return (flat < 0) ? res : -res;
    }

    public boolean canJump(int[] nums) {
        if (nums[0] == 0 && nums.length > 1) {
            return false;
        }
        int count = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                count++;
                for (int j = 0; j < i; j++) {
                    if (nums[j] >= i - j + 1) {
                        count--;
                        break;
                    }
                }
            }
        }
        if (count == 0){
            return true;
        }else {
            return false;
        }
    }


}
