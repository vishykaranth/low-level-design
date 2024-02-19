package algorithms;

import java.util.HashSet;
import java.util.Set;

public class LeetCode01 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {

            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                maxLength = Math.max(maxLength, right - left + 1);

            } else {
                while (s.charAt(left) != s.charAt(right)) {
                    set.remove(s.charAt(left));
                    left++;
                }
                set.remove(s.charAt(left));
                left++;
                set.add(s.charAt(right));
            }

        }
        return maxLength;
    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int length3 = length1 + length2;
        int[] new_arr = new int[length3];

        int index1 = 0, index2 = 0, index3 = 0;

        while (index1 <= length1 && index2 <= length2) {
            if (index1 == length1) {
                while (index2 < length2)
                    new_arr[index3++] = nums2[index2++];
                break;
            } else if (index2 == length2) {
                while (index1 < length1)
                    new_arr[index3++] = nums1[index1++];
                break;
            }

            if (nums1[index1] < nums2[index2]) {
                new_arr[index3++] = nums1[index1++];
            } else {
                new_arr[index3++] = nums2[index2++];
            }
        }

        if (length3 % 2 == 0)
            return (float) (new_arr[length3 / 2 - 1] + new_arr[length3 / 2]) / 2;
        else
            return new_arr[length3 / 2];
    }


    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
