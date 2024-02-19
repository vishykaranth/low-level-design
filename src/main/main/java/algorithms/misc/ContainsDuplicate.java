package algorithms.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsDuplicate2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int tSum = n * (n + 1) / 2;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        return tSum - sum;
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        int[] count = new int[n];
        for (int i = 0; i < n; i++) count[nums[i] - 1]++;
        for (int i = 0; i < n; i++) if (count[i] == 0) ans.add(i + 1);
        return ans;
    }

    public static void main(String[] args) {
        int num[] = {1, 2, 3, 1};
        System.out.println(containsDuplicate2(num));
        int num2[] = {1, 2, 3, 4};
        System.out.println(containsDuplicate2(num2));
    }
}
