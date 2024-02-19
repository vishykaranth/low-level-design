package algorithms.leetcode.top_interview_150;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class ArrayProblems01 {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
        return i;
    }

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n / 2];
    }

    public List<Integer> majorityElement2(int[] nums) {
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) > (nums.length / 3)) {
                list.add(nums[i]);
                map.replace(nums[i], Integer.MIN_VALUE);
            }
        }
        return list;
    }

    public int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (i % 2 == 0) {
                int curr = map.getOrDefault(i, 0) + 1;
                map.put(i, curr);
            }
        }

        if (map.isEmpty()) {
            return -1;
        }

        Map<Integer, List<Integer>> sorted = new HashMap<>();
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Integer key = iterator.next();
            Integer value = map.get(key);
            if (sorted.containsKey(value)) {
                List<Integer> integers = sorted.get(value);
                integers.add(key);
            } else {
                List<Integer> integers = new ArrayList<>();
                integers.add(key);
                sorted.put(value, integers);
            }
        }

        if (sorted.isEmpty()) {
            return -1;
        }

        Set<Integer> integers = sorted.keySet();
        TreeSet sorted2 = new TreeSet<Integer>(integers);

        List<Integer> list = integers.stream().sorted(Comparator.comparing(Integer::intValue).reversed()).collect(Collectors.toList());
        ;


        List<Integer> integers1 = sorted.get(list.get(0));

        Optional<Integer> first = integers1.stream().sorted(Comparator.comparing(Integer::intValue)).findFirst();

        if (first.isPresent()) {
            return first.get();
        }

//        Map.Entry<Integer, Integer> maxEntry = sorted.entrySet().stream()
//                .max(Map.Entry.comparingByKey()).get();

        return -1;
    }

    public static int removeDuplicates(int[] arr) {
        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j];
            }
        }
        return i + 1;

    }

    public static void main(String[] args) {
//        int[] nums = {3, 2, 2, 3};
//        int val = 3;
//        System.out.println(removeElement(nums, val));
//        System.out.println();

        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        printArray(nums);
        removeDuplicates(nums);
        printArray(nums);
    }

    static void printArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public int removeDuplicates2(int[] nums) {
        if (nums.length < 3) return nums.length;
        int i = 0, j = 0;
        while (i < nums.length) {
            nums[j++] = nums[i++];
            if (i < nums.length && nums[i] == nums[j - 1])
                nums[j++] = nums[i++];
//            if (i < nums.length && nums[i] == nums[j - 1])
//                nums[j++] = nums[i++];
            while (i < nums.length && nums[i] == nums[j - 1]) i++;
        }
        return j;
    }
}
