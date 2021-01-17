package LeetCodeExercise;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int[] newHeights = new int[len+2];
        for (int i = 0; i < len; i++) {
            newHeights[i+1] = heights[i];
        }
        int area = 0;
        Deque<Integer> stack = new ArrayDeque<Integer>();
        stack.addLast(0);
        len = len+2;
        for (int i = 1; i < len; i++) {
            while(newHeights[stack.peekLast()]>newHeights[i]){
                int height = newHeights[stack.removeLast()];
                int width = i - stack.peekLast() - 1;
                area = Math.max(area,height*width);
            }
            stack.addLast(i);
        }
        return area;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram l = new LargestRectangleInHistogram();
        int[] nums = {2,1,5,6,2,3};
        int result = l.largestRectangleArea(nums);
        System.out.println(result);
    }
}
