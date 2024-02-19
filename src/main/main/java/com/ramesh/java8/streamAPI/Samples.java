package com.ramesh.java8.streamAPI;

import java.util.HashSet;
import java.util.Set;

public class Samples {

    public int lengthOfLongestSubstring(String s) {


        Set set = new HashSet<Character>();
        int left = 0;
        int max = 0;

        for (int right = 0; right < s.length(); right++) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                max = Math.max(max, right - left + 1);
            } else {
                while (set.contains(s.charAt(right))) {
                    set.remove(s.charAt(left));
                    left++;
                }
                set.add(s.charAt(right));
            }
        }

        return max;
    }
}
