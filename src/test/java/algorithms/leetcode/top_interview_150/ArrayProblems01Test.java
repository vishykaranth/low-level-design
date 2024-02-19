package algorithms.leetcode.top_interview_150;

import org.junit.Test;
//import static org.junit.internal.matchers.IsCollectionContaining.hasItems;

public class ArrayProblems01Test {

    @Test
    public void majorityElement() {
        ArrayProblems01 arrayProblems01 = new ArrayProblems01();
        int[] nums = {3, 2, 3};
        assert arrayProblems01.majorityElement(nums) == 3 :
                "Majority element is 3";

        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        assert arrayProblems01.majorityElement(nums2) == 2 :
                "Majority element is 2";
    }


    @Test
    public void majorityElement2() {
//        ArrayProblems01 arrayProblems01 = new ArrayProblems01();
//        int[] nums = {3, 2, 3};
//        List<Integer> integers = arrayProblems01.majorityElement2(nums);
//        assertThat(integers, hasItems(3));
//
//        int[] nums2 = {1};
//        integers = arrayProblems01.majorityElement2(nums2);
//        assertThat(integers, hasItems(1));
//
//        int[] nums3 = {1, 2};
//        integers = arrayProblems01.majorityElement2(nums3);
//        assertThat(integers, hasItems(1, 2));
    }


    @Test
    public void mostFrequentEven() {
        ArrayProblems01 arrayProblems01 = new ArrayProblems01();
        int[] nums = {0, 1, 10, 10, 2, 2, 4, 4, 1, 6, 6, 8, 8};
        arrayProblems01.mostFrequentEven(nums);
    }

    @Test
    public void mostFrequentEven2() {
        ArrayProblems01 arrayProblems01 = new ArrayProblems01();
        int[] nums = {29, 47, 21, 41, 13, 37, 25, 7};
        arrayProblems01.mostFrequentEven(nums);
    }

    @Test
    public void mostFrequentEven3() {
        ArrayProblems01 arrayProblems01 = new ArrayProblems01();
        int[] nums = {0, 1, 2, 0, 0, 0, 2, 4, 4, 1};
        arrayProblems01.mostFrequentEven(nums);
    }

    @Test
    public void mostFrequentEven4() {
        ArrayProblems01 arrayProblems01 = new ArrayProblems01();
        int[] nums = {8154,9139,8194,3346,5450,9190,133,8239,4606,8671,8412,6290};
        arrayProblems01.mostFrequentEven(nums);
    }

    @Test
    public void removeDuplicates() {
        ArrayProblems01 arrayProblems01 = new ArrayProblems01();
        int[] nums = {0,0,1,1,1,1,2,3,3};
        ArrayProblems01.printArray(nums);
        int i = arrayProblems01.removeDuplicates2(nums);
        ArrayProblems01.printArray(nums);
        System.out.println(i);
    }

}