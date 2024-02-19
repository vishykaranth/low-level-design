package algorithms.strings;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqChar {

    public static void main(String[] args) {
        System.out.println(firstUniqChar("aabbccddeefgh"));
    }

    static int firstUniqChar(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        int n = s.length();
        char[] chars = s.toCharArray();
        // build hash map : character and how often it appears
        for (int i = 0; i < n; i++) {
            char c = chars[i];

            if (freq.containsKey(c)) {
                int value = freq.get(c);
                freq.put(c, ++value);
            } else {
                freq.put(c, 1);
            }

        }
        // find the index
        for (int i = 0; i < n; i++) {
            char c = chars[i];
            if (freq.get(c) == 1)
                return i;
        }
        return -1;
    }
}
