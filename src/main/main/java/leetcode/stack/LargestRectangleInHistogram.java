package leetcode.stack;

import java.util.Stack;

/**
 * Created by gouthamvidyapradhan on 20/06/2017. Given n non-negative integers representing the
 * histogram's bar height where the width of each bar is 1, find the area of largest rectangle in
 * the histogram.
 *
 * <p>For example, Given heights = [2,1,5,6,2,3], return 10. (min of index 2 and 3 multiplied by
 * two)
 *
 * <p>Solution O(N):
 *
 * <p>1) Create an empty leetcode.stack.
 *
 * <p>2) Start from first bar, and do following for every bar ‘hist[i]’ where ‘i’ varies from 0 to
 * n-1. a) If leetcode.stack is empty or hist[i] is higher than the bar at top of leetcode.stack, then push ‘i’ to
 * leetcode.stack. b) If this bar is smaller than the top of leetcode.stack, then keep removing the top of leetcode.stack while
 * top of the leetcode.stack is greater. Let the removed bar be hist[tp]. Calculate area of rectangle with
 * hist[tp] as smallest bar. For hist[tp], the ‘left index’ is previous (previous to tp) item in
 * leetcode.stack and ‘right index’ is ‘i’ (current index).
 *
 * <p>3) If the leetcode.stack is not empty, then one by one remove all bars from leetcode.stack and do step 2.b for
 * every removed bar.
 */
public class LargestRectangleInHistogram {
    public static void main(String[] args) throws Exception {
        int[] A = {2, 3};
        System.out.println(new LargestRectangleInHistogram().largestRectangleArea(A));
    }

    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) return 0;
        int maxArea = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                int top = stack.pop();
                int base = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, base * heights[top]);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int top = stack.pop();
            int base = stack.isEmpty() ? i : i - stack.peek() - 1;
            maxArea = Math.max(maxArea, base * heights[top]);
        }
        return maxArea;
    }
}
