package arrays;

import java.util.Arrays;

class Solution {
    private int maxLength = 0;
    private int start = 0;

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        for (int i = 0; i < s.length(); i++) {
            extendPalindrome(s, i, i);     // Check for odd-length palindrome
            extendPalindrome(s, i, i + 1); // Check for even-length palindrome
            if (maxLength == s.length()) {
                return s.substring(start, start + maxLength);
            }
        }
        return s.substring(start, start + maxLength);
    }

    private void extendPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Calculate length of palindrome and update start and maxLength
        int length = right - left - 1;
        if (length > maxLength) {
            maxLength = length;
            start = left + 1;
        }
    }


    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String s1 = strs[0];
        String s2 = strs[strs.length - 1];
        int idx = 0;
        while (idx < s1.length() && idx < s2.length()) {
            if (s1.charAt(idx) == s2.charAt(idx)) {
                idx++;
            } else {
                break;
            }
        }
        return s1.substring(0, idx);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.longestPalindrome("ABCDCEF");
        System.out.println(s);
    }
}