package LeetCodeExercise;

public class jumpDemo {
    private static int[] arrays = new int[] {2,3,1,1,4};
    public static void main(String[] args){
        jumpDemo j = new jumpDemo();
        System.out.println(j.jump(arrays));
    }

    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
