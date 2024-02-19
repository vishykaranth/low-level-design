import java.util.HashSet;
import java.util.Set;

public class StringOperations {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {

            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                maxLength = Math.max(maxLength, right - left + 1);

            } else {
                left = removeDuplicateChars(s, set, left, right);
                set.remove(s.charAt(left));
                left++;
                set.add(s.charAt(right));
            }

        }
        return maxLength;
    }

    private int removeDuplicateChars(String s, Set<Character> set, int left, int right) {
        while (s.charAt(left) != s.charAt(right)) {
            set.remove(s.charAt(left));
            left++;
        }
        return left;
    }


    public boolean detectCapitalUse(String word) {
        return word.toLowerCase().equals(word)
                || word.toUpperCase().equals(word)
                || (Character.isUpperCase(word.charAt(0))
                && word.substring(1).toLowerCase().equals(
                word.substring(1))
        );
    }

}
