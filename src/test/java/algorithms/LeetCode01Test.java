package algorithms;

import junit.framework.TestCase;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LeetCode01Test extends TestCase {

    public void testLengthOfLongestSubstring(){
        LeetCode01 leetCode01 = new LeetCode01();
        int length = leetCode01.lengthOfLongestSubstring("abcabcbb");
        assertThat(length, is(3));
    }

    public void testLengthOfLongestSubstring2(){
        LeetCode01 leetCode01 = new LeetCode01();
        int length = leetCode01.lengthOfLongestSubstring("abcbbcbb");
        assertThat(length, is(3));
    }

    public void testFindMedianSortedArrays(){
        LeetCode01 leetCode01 = new LeetCode01();
        int[] array1 = {1, 2};
        int[] array2 = {3, 4};
        double medianSortedArrays = leetCode01.findMedianSortedArrays(array1, array2);
        assertThat(medianSortedArrays, is(2.5));
    }

    public void testFindMedianSortedArrays2(){
        LeetCode01 leetCode01 = new LeetCode01();
        int[] array1 = {1, 3};
        int[] array2 = {2, 4};
        double medianSortedArrays = leetCode01.findMedianSortedArrays(array1, array2);
        assertThat(medianSortedArrays, is(2.5));
    }

    public void testFindMedianSortedArrays4(){
        LeetCode01 leetCode01 = new LeetCode01();
        int[] array1 = {1, 3};
        int[] array2 = {2};
        double medianSortedArrays = leetCode01.findMedianSortedArrays(array1, array2);
        assertThat(medianSortedArrays, is(2.5));
    }

    //https://leetcode.com/problems/longest-palindromic-substring/editorial/
    public void testLongestPalindrome(){
        LeetCode01 leetCode01 = new LeetCode01();
        String s = "abc";
        String s1 = leetCode01.longestPalindrome(s);
        assertThat(s1, is("c"));
    }


    public void testLongestPalindrome2(){
        LeetCode01 leetCode01 = new LeetCode01();
        String s = "aba";
        String s1 = leetCode01.longestPalindrome(s);
        assertThat(s1, is("aba"));
    }

}