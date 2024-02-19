package leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gouthamvidyapradhan on 24/06/2017. Given an unsorted integer leetcode.array, find the first
 * missing positive integer.
 *
 * <p>For example, Given [1,2,0] return 3, and [3,4,-1,1] return 2.
 *
 * <p>Your algorithm should run in O(n) time and uses constant space.
 */
public class FirstMissingPositive {
    private int L;

    public static void main(String[] args) throws Exception {
        int[] nums = {1, 3, 5, 9};
        System.out.println(new FirstMissingPositive().firstMissingPositive3(nums));
    }

    public int firstMissingPositive2(int[] nums) {
        int positiveNumber = 1;
        while (true) {
            boolean exists = false;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == positiveNumber) {
                    exists = true;
                    break;
                }
            }
            if (!exists) return positiveNumber;
            positiveNumber++;
        }
    }

    public int firstMissingPositive3(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int n : nums) {
            if (n > 0) {
                map.put(n, true);
            }
        }
        int number = 1;
        while (true) {
            if (map.get(number) == null) {
                return number;
            }
            number++;
        }
    }

    public int firstMissingPositive(int[] nums) {
        L = nums.length;
        for (int i = 0; i < L; i++) {
            if (nums[i] > 0 && nums[i] <= L && nums[i] != i + 1) {
                int v = nums[i];
                nums[i] = -1;
                replace(v, nums);
            }
        }

        for (int i = 0; i < L; i++) {
            if (nums[i] != i + 1) return i + 1;
        }

        return L + 1;
    }

    private void replace(int i, int[] nums) {
        if (i > 0 && i <= L && i != nums[i - 1]) {
            int v = nums[i - 1];
            nums[i - 1] = i;
            replace(v, nums);
        }
    }
}
